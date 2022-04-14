package examinateur;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam {


    private int studentNumber;
    private String examSubject;
    private short amountCorrect = 0;
    private ArrayList<Exercise> exercises = new ArrayList<>();

    public Exam(ArrayList<Exercise> exercises, String examSubject) {
        this.exercises.addAll(exercises);
        this.examSubject = examSubject;
    }



    public void startExam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voer je studentnummer in");
        this.studentNumber = scanner.nextInt();
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
            Student.addExamsPassed(studentNumber);
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
        System.out.println("Dit examen is gemaakt door " + studentNumber);
        boolean hasStudentPassed = hasStudentPassed();
        ApplicationManager.results.add(new Result(this, studentNumber, hasStudentPassed));
        showPassResults(hasStudentPassed);
    }

    private void showPassResults(boolean hasStudentPassed) {

        if (hasStudentPassed) {
            System.out.println();
            System.out.println("Je bent geslaagd!");
            System.out.println();
        }
        else {
            System.out.println();
            System.out.println("Je bent gezakt.");
            System.out.println();
        }
        showAnswers();
    }

    private void showAnswers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wil je je resultaten zien? J/N");
        String s = scanner.nextLine();

        if (s.equalsIgnoreCase("j")) {
            showResults();
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

    public String getExamSubject() {
        return examSubject;
    }

    public void setAmountCorrect(short amountCorrect) {
        this.amountCorrect = amountCorrect;
    }
}
