package examinateur;

import java.util.Scanner;

public class Menu {

    private short answer;
    Scanner scanner = new Scanner(System.in);

    public void showList() {
        System.out.println("Menu");
        System.out.println();
        System.out.println("1) Lijst met examens");
        System.out.println("2) Lijst met studenten");
        System.out.println("3) Nieuwe student inschrijven");
        System.out.println("4) Student verwijderen");
        System.out.println("5) Examen afnemen");
        System.out.println("6) Is student geslaagd voor de test?");
        System.out.println("7) Welke examens heeft de student gehaald?");
        System.out.println("8) Welke student heeft de meeste examens gehaald?");
        System.out.println("0) Afsluiten");
    }

    public void selectOption() {

        System.out.println();
        System.out.println("Maak een keuze tussen 0 en 8:");
        answer = scanner.nextShort();

        switch(answer) {
            case 1:
                ApplicationManager.showExams();
                break;
            case 2:
                ApplicationManager.showStudents(ApplicationManager.students);
                break;
            case 3:
                ApplicationManager.addStudent();
                break;
            case 4:
                ApplicationManager.deleteStudent();
                break;
            case 5:
                ApplicationManager.exams.get(0).startExam();
                break;
            case 6:
                ApplicationManager.hasStudentPassedSpecificExam();
                break;
            case 7:
                System.out.println("Vul het studentnummer in van de student waarvan je de resultaten in wilt zien: ");
                ApplicationManager.isStudentGeslaagd(scanner.nextInt());
                break;
            case 8:
                // code
                break;
            case 0:
                // exit programma
                System.exit(0);
                break;
            default:
                System.out.println("Dit is niet een van de opties, probeer het opnieuw.");
        }
    }

    public void nextInput() {
        System.out.println();
        System.out.println("Klik op enter om door te gaan.");
        scanner.reset();
        scanner.nextLine();

        showList();
        selectOption();
    }
}
