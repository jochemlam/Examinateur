package examinateur;

class Exercise {

    public Answer correctAnswer;
    public String question;

    // ingevoerde antwoord door leerling
    public Answer userAnswer;

    // resultaat van vergelijking tussen ingevulde en correcte antwoord
    public boolean result = false;

    public Exercise(String question, Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
        this.question = question;
    }

    public void getResult() {
        if (result) {
            System.out.println("Juist!");
        }
        else {
            System.out.println("Onjuist!");
        }
    }

    // hier wordt het ingevulde antwoord opgeslagen
    public void answerQuestion(Answer userAnswer) {
        this.userAnswer = userAnswer;

        checkAnswer();
    }
    // controleert het antwoord en zet het resultaat naar goed als het gegeven antwoord gelijk is aan het opgeslagen correcte antwoord
    public void checkAnswer() {
        if (toString(this.correctAnswer).equalsIgnoreCase(toString(this.userAnswer))) {
            this.result = true;
        }
    }

    public String toString(Answer answer) {
        return answer.get();
    }
}