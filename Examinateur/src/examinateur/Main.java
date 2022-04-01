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
        Scanner scanner = new Scanner(System.in);

        Exercise vraag1 = new Exercise("Over welke poort worden https-websites geladen?", new Answer("443"));
        vraag1.askQuestion();
        vraag1.answerQuestion(new Answer(scanner.nextLine()));
        vraag1.getResult();

        Exercise vraag2 = new Exercise("Welke is GEEN naam van malware?", new Answer("Achilles"));
        vraag2.askQuestion();
        vraag2.answerQuestion(new Answer(scanner.nextLine()));
        vraag2.getResult();

        Exercise vraag3 = new Exercise("Hoe heet het programma waarmee de CIA smart-tv’s afluisterde?", new Answer("Ransomware"));
        vraag3.askQuestion();
        vraag3.answerQuestion(new Answer(scanner.nextLine()));
        vraag3.getResult();

        Exercise vraag4 = new Exercise("Welke computer worm verspreidde zich het snelst?", new Answer("MyDoom"));
        vraag4.askQuestion();
        vraag4.answerQuestion(new Answer(scanner.nextLine()));
        vraag4.getResult();

        ArrayList<Exercise> vragen = new ArrayList<>();
        vragen.add(vraag1);
        vragen.add(vraag2);
        vragen.add(vraag3);
        vragen.add(vraag4);
        Exam examen = new Exam(vragen);

        examen.totalResults();
    }

    private static boolean compareStrings(String userAnswer, String correctAnswer) {
        if (userAnswer == correctAnswer) {
            return true;
        }
        return false;
    }
}
