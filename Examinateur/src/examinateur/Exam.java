package examinateur;

import java.util.ArrayList;
import java.util.Scanner;

class Exam {


    protected int studentNummer;
    protected String examenOnderwerp;
    public short amountCorrect = 0;
    public ArrayList<Exercise> exercises = new ArrayList<>();

    public Exam(ArrayList<Exercise> exercises) {
        this.exercises.addAll(exercises);
    }

    public Exam(ArrayList<Exercise> exercises, int studentNummer, String examenOnderwerp) {
        this.exercises.addAll(exercises);
        this.studentNummer = studentNummer;
        this.examenOnderwerp = examenOnderwerp;
    }



    public void startExam() {
        Scanner scanner = new Scanner(System.in);

        for (Exercise exercise : exercises) {

            exercise.askQuestion();
            exercise.answerQuestion(new Answer(scanner.nextLine()));
            exercise.getResult();
        }
    }

    private boolean hasStudentPassed() {
        if (amountCorrect > (exercises.size() / 2)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void totalResults() {
        for (Exercise exercise : this.exercises) {

            if (exercise.result) {
                amountCorrect++;
            }
        }
        System.out.println("je hebt " + amountCorrect + "/" + exercises.size() + " vragen goed beantwoord.");
        System.out.println("Dit examen is gemaakt door " + studentNummer);
        showInput();
    }

    private void showInput() {
        Scanner scanner = new Scanner(System.in);

        if (hasStudentPassed()) {
            System.out.println();
            System.out.println("Je bent geslaagd!");
            System.out.println();
            //Result results = new Result();
        }
        else {
            System.out.println();
            System.out.println("Je bent gezakt.");
            System.out.println();
        }

        System.out.println("Wil je je resultaten zien? J/N");
        String s = scanner.nextLine();

        if (s.equalsIgnoreCase("j")) {
            showResults();
        }
        else if (s.equalsIgnoreCase("n")) {
            return;
        }
        // mogelijk else hier toevoegen als catch voor als er iets anders ingevuld wordt
    }

    public void showResults() {
        // print alle uitslagen onder elkaar in volgorde
        for (int i = 0; i < this.exercises.size(); i++) {

            System.out.println("Jouw antwoord was: " + toString(exercises.get(i).userAnswer) + ", het juiste antwoord is: " + toString(exercises.get(i).correctAnswer) + ".");

            exercises.get(i).getResult();
        }
    }

    public String toString(Answer answer) {
        return answer.get();
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public String getExamenOnderwerp() {
        return examenOnderwerp;
    }
}