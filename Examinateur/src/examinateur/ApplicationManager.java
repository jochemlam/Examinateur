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

        vragen = new ArrayList<>();
        vragen.add(new Exercise("Geef de reactievergelijking van de volledige verbranding van PEO.\n" +
                                              "De formule van PEO is (CH2CH2O)n.", new Answer("4n CO2 + 4n H2O")));
        vragen.add(new Exercise("Waar staat Ne voor?", new Answer("Neon")));
        vragen.add(new Exercise("Hoe heet het tabel met alle elementen?", new Answer("periodiek systeem")));
        vragen.add(new Exercise("Wie is de leukste scheikunde docent?", new Answer("Vashy")));
        vragen.add(new Exercise("Waar staat Sk voor?", new Answer("Scheikunde")));

        exam = new Exam(vragen, "Scheikunde");
        exams.add(exam);

        vragen = new ArrayList<>();
        vragen.add(new Exercise("Wie is de grondlegger van karate?", new Answer("Funakoshi Gichin")));
        vragen.add(new Exercise("Wat betekend karate?", new Answer("Lege hand")));
        vragen.add(new Exercise("Welke karate stijl is het meest praktisch?", new Answer("Wado")));
        vragen.add(new Exercise("Waar komt muay thai vandaan?", new Answer("Thailand")));
        vragen.add(new Exercise("Waar kwam muay thai uit voort?", new Answer("krabi krabong")));

        exam = new Exam(vragen, "Martial arts");
        exams.add(exam);

        vragen = new ArrayList<>();
        vragen.add(new Exercise("Wat is de best anime?", new Answer("Naruto")));
        vragen.add(new Exercise("Wie is de meest sophisticated Naruto character?", new Answer("Itachi")));
        vragen.add(new Exercise("Hoe heette de groep met rogue ninjas?", new Answer("Akatsuki")));
        vragen.add(new Exercise("Hoe heette het zwaard van Kisame?", new Answer("Samehada")));
        vragen.add(new Exercise("Best waifu?", new Answer("Hyuuga Hanabi")));

        exam = new Exam(vragen, "Anime");
        exams.add(exam);

        menu.showList();
        menu.selectOption();
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
        scanner.nextLine();
        menu.nextInput();
    }

    public static void isStudentGeslaagd(int studentNumber) {

        boolean notfound = true;

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
                notfound = false;
            }
        }
        if (notfound) {
        System.out.println("De student met leerlingnummer " + studentNumber + " heeft nog geen resultaten");
        }
    menu.nextInput();
    }



    public static void hasStudentPassedSpecificExam(){
        System.out.println("Vul het studentenummer in van de student waarvan je het resultaat van wilt zien:");
        int studentnumber = scanner.nextInt();
        System.out.println("Vul de toetsnaam in van de toets waarvan je het resultaat wilt zien:");
        scanner.nextLine();
        String TestName = scanner.nextLine();

        for (Result result : results) {
            if (studentnumber == result.getStudentNummer()) {
                if (TestName.equalsIgnoreCase(result.getExam().getExamenOnderwerp())) {
                    if (result.isGraduated()) {
                        System.out.println("De student met leerlingnummer " + studentnumber + " is geslaagd voor het examen: " + result.getExam().getExamenOnderwerp());
                    } else {
                        System.out.println("De student met leerlingnummer " + studentnumber + " is niet geslaagd voor het exmamen: " + result.getExam().getExamenOnderwerp());
                    }
                }       //add boolean
            }
        }

        menu.nextInput();
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

    public static void askExams(){ //vraagt alle examen onderwerpen op en print die uit.
        System.out.println("Dit zijn alle examens: ");
        for (int i = 0; i < exams.size(); i++){
            System.out.println(i+1+" "+exams.get(i).getExamenOnderwerp());
        }

        Short answer = scanner.nextShort();
        switch(answer) {
            case 1:
                ApplicationManager.exams.get(0).startExam();
                break;
            case 2:
                ApplicationManager.exams.get(1).startExam();
                break;
            case 3:
                ApplicationManager.exams.get(2).startExam();
                break;
            case 4:
                ApplicationManager.exams.get(3).startExam();
                break;
        }
    }

    public static void hasPassedMost(){
        int amount = 0;
        String name = "";
        int number = 0;

        for (int i = 0; i < students.size(); i ++){
            if (students.get(i).getExamsPassed() > amount){
                amount = students.get(i).getExamsPassed();
                name = students.get(i).getName();
                number = students.get(i).getNumber();

            }
        }
        System.out.println("Student: " + name + " (" + number + ") " + " Heeft de meeste examens gehaald dit zijn er: " + amount);
        menu.nextInput();
    }
}
