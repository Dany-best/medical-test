import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    static boolean wasInQuestion = false;
    static boolean wasInAnswer = false;
    static int numberOfRightAnswers = 0;
    static int numberOfIncorrectAnswers = 0;

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("pediatry.txt");
        Scanner scanner = new Scanner(file);
        Exercise exercise = new Exercise();
        StringBuilder questionBuilder = new StringBuilder();
        StringBuilder answerBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String output = scanner.nextLine();

            //check first question line
            if (output.startsWith("#")) {
                if (wasInAnswer) {
                    exercise.task.put(questionBuilder.toString(), answerBuilder.toString());
                    questionBuilder = new StringBuilder();
                    answerBuilder = new StringBuilder();
                    wasInAnswer = false;
                }
                wasInQuestion = true;
                questionBuilder.append('\n');
                questionBuilder.append(output);
                continue;
            }
            //check next question lines
            if (!Answer.isItAnswer(output) && wasInQuestion) {
                questionBuilder.append('\n');
                questionBuilder.append(output);
            }
            //check answer lines
            if (Answer.isItAnswer(output)) {
                answerBuilder.append(output);
                answerBuilder.append('\n');
                wasInQuestion = false;
                wasInAnswer = true;
            }
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("Enter 0 if you would like to complete test and count answers");
        System.out.println("------------------------------------------------------------");
        List <String> keys = new ArrayList(exercise.task.keySet());
        Collections.shuffle(keys);
        for (String objectName : keys) {
            boolean isItRightAnswer = false;
            int rightAnswer = 1;

            List <String> answers = new ArrayList<>();

            System.out.println(objectName + ":");
            Scanner answerScan = new Scanner(exercise.task.get(objectName));
            while (answerScan.hasNextLine()) {
                String output = answerScan.nextLine();
                answers.add(output);
            }

            //to change order of answers for fair and strong education
            Collections.shuffle(answers);
            for (int i = 0; i < answers.size(); i++) {
                if (answers.get(i).startsWith("+")) {
                    rightAnswer = i + 1;
                }
                //substring to remove + and - sign
                System.out.println(i + 1 + ") " + answers.get(i).substring(2));
            }
            while (!isItRightAnswer) {
                Scanner answerChecker = new Scanner(System.in);
                try {
                    int studentAnswer = answerChecker.nextInt();
                    if (studentAnswer == 0) {
                        System.out.println("Number of RIGHT answers is: " + numberOfRightAnswers);
                        System.out.println("Number of INCORRECT answers is: " + numberOfIncorrectAnswers);
                        System.exit(0);
                    }
                    if (studentAnswer == rightAnswer) {
                        System.out.println("Right!");
                        numberOfRightAnswers++;
                    } else {
                        System.out.println("Incorrect!");
                        System.out.println("Right answer is " + rightAnswer);
                        numberOfIncorrectAnswers++;
                    }
                    isItRightAnswer = true;

                } catch (InputMismatchException e) {
                    System.out.println("Please, enter correct number");
                    isItRightAnswer = false;
                }
            }
        }
    }
}
