package examinateur;

public class Exercise {
    private String question;
    private Answer correctAnswer;
    private boolean result;
    private Answer currentAnswer;

    public Exercise(String question, Answer correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        result = false;
    }

    public void checkQuestion(Answer currentAnswer) {
        this.currentAnswer = currentAnswer;

        if (this.correctAnswer == currentAnswer) {
            result = true;
        }
    }

    public boolean getResult() {
        return this.result;
    }

    public void changeQuestion(String newText) {
        this.question = newText;
    }

    public String getQuestion() {
         return this.question;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
