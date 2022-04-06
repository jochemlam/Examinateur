package examinateur;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam {


    protected int studentNummer;
    protected String examenOnderwerp;
    public short amountCorrect = 0;
    public ArrayList<Exercise> exercises = new ArrayList<>();

    public Exam(ArrayList<Exercise> exercises) {
        this.exercises.addAll(exercises);
    }

    public Exam(ArrayList<Exercise> exercises, String examenOnderwerp) {
        this.exercises.addAll(exercises);
        this.examenOnderwerp = examenOnderwerp;
    }



    public void startExam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer je studentnummer in");
        this.studentNummer = scanner.nextInt();
        scanner.nextLine();

        for (Exercise exercise : exercises) {

            exercise.askQuestion();
            exercise.answerQuestion(new Answer(scanner.nextLine()));
            exercise.getResult();
        }
        totalResults();
    }

    public boolean hasStudentPassed() {
        if (amountCorrect > (exercises.size() / 2)) {
            for (int i = 0; i < ApplicationManager.students.size(); i++){
                if (studentNummer == ApplicationManager.students.get(i).getNumber()){
                    ApplicationManager.students.get(i).setExamsPassed(+ 1);
                }
            }
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
        ApplicationManager.results.add(new Result(this, studentNummer, hasStudentPassed()));
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
            ApplicationManager.menu.nextInput();
        }
        else if (s.equalsIgnoreCase("n")) {
            ApplicationManager.menu.nextInput();
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
