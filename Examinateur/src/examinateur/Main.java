package examinateur;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {




        Menu menu1 = new Menu();

        //menu1.ShowList();
        //menu1.SelectOption();
        createTempQuestions();
    }

    private static void createTempQuestions() {
        ArrayList<Result> resultaten = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Exercise vraag1 = new Exercise("Over welke poort worden https-websites geladen?", new Answer("443"));
        Exercise vraag2 = new Exercise("Welke is GEEN naam van malware?", new Answer("Achilles"));
        Exercise vraag3 = new Exercise("Hoe heet het programma waarmee de CIA smart-tv’s afluisterde?", new Answer("Ransomware"));
        Exercise vraag4 = new Exercise("Welke computer worm verspreidde zich het snelst?", new Answer("MyDoom"));
        Exercise vraag5 = new Exercise("welke vraag is dit?", new Answer("5"));


        ArrayList<Exercise> vragen = new ArrayList<>();
        vragen.add(vraag1);
        vragen.add(vraag2);
        vragen.add(vraag3);
        vragen.add(vraag4);
        vragen.add(vraag5);

        System.out.println("Voer je studentNummer in");
        int studentNummer = scanner.nextInt();


        Exam examen = new Exam(vragen, studentNummer, "Cyber security");

        examen.startExam();
        examen.totalResults();
        Result result1 = new Result(examen, examen.getStudentNummer());

        resultaten.add(result1);

        System.out.println("Student " + resultaten.get(0).getStudentNummer() + " heeft "+ resultaten.get(0).getExam().getExamenOnderwerp() + " Gemaakt");

    }

    private static boolean compareStrings(String userAnswer, String correctAnswer) {
        if (userAnswer == correctAnswer) {
            return true;
        }
        return false;
    }
}
