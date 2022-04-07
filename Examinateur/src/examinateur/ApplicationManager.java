package examinateur;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationManager {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Exam> exams = new ArrayList<Exam>();
    public static ArrayList<Result> results = new ArrayList<Result>();
    private static Scanner scanner = new Scanner(System.in);

    // stel je hebt een methode M die returnt of het lukt,
    // roep dan repeatMethod(methodenaam) aan om het eindeloos te proberen totdat het lukt
    // als je een method zichzelf opnieuw wilt laten uitvoeren geef deze dan een return value van false, zo niet doe dan true

    /*private interface F {
        boolean apply();
    }

    public static void repeatMethod(F f) {
        while (!f.apply()) {
            System.out.println("opnieuw");
        }
    }*/

    // dit stukje heeft pascal uitgelegd en geschreven, maar het werkt niet en wij hebben geen idee hoe we het op moeten lossen omdat we hier nooit iets over geleerd hebben

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
        System.out.println("Vul het studentnummer in van de student waarvan je het resultaat van wilt zien:");
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
                    System.out.println("Student " + students.get(i).getName() + " is verwijderd.");
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
