package examinateur;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        /*Menu menu1 = new Menu();

        menu1.ShowList();
        menu1.SelectOption();*/
        createTempQuestions();
    }

    private static void createTempQuestions() {

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
        Exam examen = new Exam(vragen);

        examen.startExam();
        examen.totalResults();
    }

    private static boolean compareStrings(String userAnswer, String correctAnswer) {
        if (userAnswer == correctAnswer) {
            return true;
        }
        return false;
    }
}
