package examinateur;

public class Exercise {
    private String question;
    private int exerciseNumber;
    private Answer correctAnswer;


    public Exercise(String question, int exerciseNumber, Answer correctAnswer) {
        this.question = question;
        this.exerciseNumber = exerciseNumber;
        this.correctAnswer = correctAnswer;
    }

    public void changeQuestion(String newText) {
        this.question = newText;
    }

    public String getQuestion() {
         return this.question;
    }

    public int getExerciseNumber() {
        return this.exerciseNumber;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setexerciseNumber(int exerciseNumber) {
        this.exerciseNumber = exerciseNumber;
    }
}
