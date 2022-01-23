public class Answer {

    private String rightAnswer;
    private String incorrectAnswer;
    private String answerLine;

    public String getAnswerLine() {
        return answerLine;
    }

    public void setAnswerLine(String answerLine) {
        this.answerLine = answerLine;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getIncorrectAnswer() {
        return incorrectAnswer;
    }

    public void setIncorrectAnswer(String incorrectAnswer) {
        this.incorrectAnswer = incorrectAnswer;
    }

    public static boolean isItAnswer(String output) {
        return  (output.startsWith("-") || output.startsWith("+"));
    }
}
