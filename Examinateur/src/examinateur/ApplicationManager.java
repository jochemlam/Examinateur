package examinateur;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationManager {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Exam> exams = new ArrayList<Exam>();
    public static ArrayList<Result> results = new ArrayList<Result>();
    public static Menu menu = new Menu();
    private static Scanner scanner = new Scanner(System.in);

    public static void initialize() {

        ArrayList<Exercise> vragen = new ArrayList<>();
        vragen.add(new Exercise("Over welke poort worden https-websites geladen?", new Answer("443")));
        vragen.add(new Exercise("Welke is GEEN naam van malware?", new Answer("Achilles")));
        vragen.add(new Exercise("Hoe heet het programma waarmee de CIA smart-tv’s afluisterde?", new Answer("Ransomware")));
        vragen.add(new Exercise("Welke computer worm verspreidde zich het snelst?", new Answer("MyDoom")));
        vragen.add(new Exercise("welke vraag is dit?", new Answer("5")));

        Exam exam = new Exam(vragen, "Cyber-Security");
        exams.add(exam);

        menu.showList();
        menu.selectOption();
    }

    public static void addStudent() {
        System.out.println("Voer de student <naam> in: ");
        String studentName = scanner.nextLine();
        System.out.println("Voer het student <nummer> in: ");
        int studentNumber = scanner.nextInt();
        Student student = new Student(studentName, studentNumber);

        if (ApplicationManager.students.size() == 0)
            students.add(student);
        else {
            for (int i = 0; i < ApplicationManager.students.size(); i++) {
                if (student.getNumber() == ApplicationManager.students.get(i).getNumber()) {
                    System.out.println("Dit studentnummber is al toegewezen aan een student");
                } else {
                    students.add(student);
                }
                break;
            }
        }
        menu.nextInput();
    }

    public static void isStudentGeslaagd(int studentNumber) {

        for (Result result : results) {
            // pak een studentnummer uit results waarbij het studentnummer gelijk is aan die van het resultaat
            if (studentNumber == result.getStudentNummer()) {
                // is de student geslaagd
                if (result.isGraduated()) {
                    System.out.println("De student met leerlingnummer " + studentNumber + " is geslaagd voor het volgende examen: " + result.getExam().getExamenOnderwerp());
                }
                else {
                    System.out.println("De student met leerlingnummer " + studentNumber + " is niet geslaagd voor het volgende examen: " + result.getExam().getExamenOnderwerp());
                }
            }
            else {
                System.out.println("De student met leerlingnummer " + studentNumber + " heeft geen resultaten voor het volgende examen: " + result.getExam().getExamenOnderwerp());
            }
        }
    }

    public static void deleteStudent() {
        if (ApplicationManager.students.size() == 0) {
            System.out.println("There are no students enlisted");
        }
        else {
            System.out.println("Vul het student nummer in van de student die je wilt verwijderen");
            int student = scanner.nextInt();
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getNumber() == student) {
                    System.out.println("Student " + students.get(i).getName() + " Verwijderd");
                    students.remove(i);
                }
                else
                    System.out.println("Dit student nummber is niet toegewezen aan een student");
            }
        }
        menu.nextInput();
    }


    public static void showStudents(ArrayList<Student> list) { // vraagt alle studentnamen en nummers op en print deze uit
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " - " + list.get(i).getNumber());
        }
        menu.nextInput();
    }

    public static void showExams(){ //vraagt alle examen onderwerpen op en print die uit.
        System.out.println("Dit zijn alle examens: ");
        for (int i = 0; i < exams.size(); i++){
            System.out.println(exams.get(i).getExamenOnderwerp());
        }

        menu.nextInput();
    }
}
