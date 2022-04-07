package examinateur;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationManager {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Exam> exams = new ArrayList<Exam>();
    public static ArrayList<Result> results = new ArrayList<Result>();
    private static Scanner scanner = new Scanner(System.in);

    public static void initialize() {

        ArrayList<Exercise> questions = new ArrayList<>();
        questions.add(new Exercise("Over welke poort worden https-websites geladen?", new Answer("443")));
        questions.add(new Exercise("Welke is GEEN naam van malware?", new Answer("Achilles")));
        questions.add(new Exercise("Hoe heet het programma waarmee de CIA smart-tv’s afluisterde?", new Answer("Ransomware")));
        questions.add(new Exercise("Welke computer worm verspreidde zich het snelst?", new Answer("MyDoom")));
        questions.add(new Exercise("welke vraag is dit?", new Answer("5")));

        Exam exam = new Exam(questions, "Cyber-Security");
        exams.add(exam);

        questions = new ArrayList<>();
        questions.add(new Exercise("Geef de reactievergelijking van de volledige verbranding van PEO.\n" +
                                              "De formule van PEO is (CH2CH2O)n.", new Answer("4n CO2 + 4n H2O")));
        questions.add(new Exercise("Waar staat Ne voor?", new Answer("Neon")));
        questions.add(new Exercise("Hoe heet het tabel met alle elementen?", new Answer("periodiek systeem")));
        questions.add(new Exercise("Wie is de leukste scheikunde docent?", new Answer("Vashy")));
        questions.add(new Exercise("Waar staat Sk voor?", new Answer("Scheikunde")));

        exam = new Exam(questions, "Scheikunde");
        exams.add(exam);

        questions = new ArrayList<>();
        questions.add(new Exercise("Wie is de grondlegger van karate?", new Answer("Funakoshi Gichin")));
        questions.add(new Exercise("Wat betekend karate?", new Answer("Lege hand")));
        questions.add(new Exercise("Welke karate stijl is het meest praktisch?", new Answer("Wado")));
        questions.add(new Exercise("Waar komt muay thai vandaan?", new Answer("Thailand")));
        questions.add(new Exercise("Waar kwam muay thai uit voort?", new Answer("krabi krabong")));

        exam = new Exam(questions, "Martial arts");
        exams.add(exam);

        questions = new ArrayList<>();
        questions.add(new Exercise("Wat is de beste anime?", new Answer("Naruto")));
        questions.add(new Exercise("Wie is de meest sophisticated Naruto character?", new Answer("Itachi")));
        questions.add(new Exercise("Hoe heette de groep met rogue ninjas?", new Answer("Akatsuki")));
        questions.add(new Exercise("Hoe heette het zwaard van Kisame?", new Answer("Samehada")));
        questions.add(new Exercise("Best waifu?", new Answer("Hyuuga Hanabi")));

        exam = new Exam(questions, "Anime");
        exams.add(exam);

        Main.isRunning = true;
    }

    public static void addStudent() {
        System.out.println("Voer de student <naam> in: ");
        String studentName = scanner.nextLine();
        System.out.println("Voer het student <nummer> in: ");

        int studentNumber = 0;
        try{
            studentNumber = scanner.nextInt();}
        catch(Exception e){
            System.out.println("Je hebt een fout gemaakt, probeer opnieuw");
            scanner.nextLine();
            addStudent();
        }

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
    }

    public static void hasStudentPassed(int studentNumber) {

        boolean notfound = true;

        for (Result result : results) {
            // pak een studentnummer uit results waarbij het studentnummer gelijk is aan die van het resultaat
            if (studentNumber == result.getStudentNumber()) {
                // is de student geslaagd
                if (result.isGraduated()) {
                    System.out.println("De student met leerlingnummer " + studentNumber + " is geslaagd voor het volgende examen: " + result.getExam().getExamSubject());
                }
                else {
                    System.out.println("De student met leerlingnummer " + studentNumber + " is niet geslaagd voor het volgende examen: " + result.getExam().getExamSubject());
                }
                notfound = false;
            }
        }
        if (notfound) {
        System.out.println("De student met leerlingnummer " + studentNumber + " heeft nog geen resultaten");
        }
    }



    public static void hasStudentPassedSpecificExam(){
        System.out.println("Vul het studentenummer in van de student waarvan je het resultaat van wilt zien:");
        int studentNumber = scanner.nextInt();
        System.out.println("Vul de toetsnaam in van de toets waarvan je het resultaat wilt zien:");
        scanner.nextLine();
        String TestName = scanner.nextLine();

        for (Result result : results) {
            if (studentNumber == result.getStudentNumber()) {
                if (TestName.equalsIgnoreCase(result.getExam().getExamSubject())) {
                    if (result.isGraduated()) {
                        System.out.println("De student met leerlingnummer " + studentNumber + " is geslaagd voor het examen: " + result.getExam().getExamSubject());
                    } else {
                        System.out.println("De student met leerlingnummer " + studentNumber + " is niet geslaagd voor het exmamen: " + result.getExam().getExamSubject());
                    }
                }       //add boolean
            }
        }
    }

    public static void deleteStudent() {
        if (ApplicationManager.students.size() == 0) {
            System.out.println("There are no students enlisted");
        }
        else {
            System.out.println("Vul het student nummer in van de student die je wilt verwijderen");

            int student = 0;
            try{
                student = scanner.nextInt();}
            catch(Exception e){
                System.out.println("Je hebt een fout gemaakt, probeer opnieuw");
                scanner.nextLine();
                deleteStudent();
            }

            boolean notfound = true;

            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getNumber() == student) {
                    System.out.println("Student " + students.get(i).getName() + " Verwijderd");
                    students.remove(i);
                    notfound = false;
                }
            }
            if(notfound){
                System.out.println("Dit student nummer is niet toegewezen aan een student");

            }
        }
    }


    public static void showStudents(ArrayList<Student> list) { // vraagt alle studentnamen en nummers op en print deze uit
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " - " + list.get(i).getNumber());
        }
    }

    public static void showExams(){ //vraagt alle examen onderwerpen op en print die uit.
        System.out.println("Dit zijn alle examens: ");
        for (int i = 0; i < exams.size(); i++){
            System.out.println(exams.get(i).getExamSubject());
        }
    }

    public static void askExams(){ //vraagt alle examen onderwerpen op en print die uit.
        System.out.println("Maak een keuze uit de volgende examens: ");
        for (int i = 0; i < exams.size(); i++){
            System.out.println(i + 1 + ") " + exams.get(i).getExamSubject());
        }

        Short choice = scanner.nextShort();

        if (choice <= exams.size()) {
            exams.get(choice - 1).startExam();
        }
        else {
            System.out.println("Dit examen bestaat niet, kies een van de beschikbare opties.");
            askExams();
        }

    }

    public static void hasPassedMost(){
        int amount = 0;

        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getExamsPassed() > amount){
                amount = students.get(i).getExamsPassed();
            }
        }

        for (int a = 0; a < students.size(); a++){
            if (students.get(a).getExamsPassed() == amount){
                System.out.println("Student: " + students.get(a).getName() + " (" + students.get(a).getNumber() + ") " + " Heeft de meeste examens gehaald dit zijn er: " + amount);
            }
        }
    }
}
