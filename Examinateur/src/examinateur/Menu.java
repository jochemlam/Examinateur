package examinateur;

import java.util.Scanner;

public class Menu {

    private short answer;
    Scanner scanner = new Scanner(System.in);

    public void ShowList() {
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

    public void SelectOption() {

        System.out.println();
        System.out.println("Maak een keuze tussen 0 en 8:");
        answer = scanner.nextShort();

        switch(answer) {
            case 1:
                // code
                break;
            case 2:
                ApplicationManager.showStudents(ApplicationManager.students);
                break;
            case 3:
                ApplicationManager.initialize();
                break;
            case 4:
                // code
                break;
            case 5:
                // code
                break;
            case 6:
                // code
                break;
            case 7:
                // code
                break;
            case 8:
                // code
                break;
            case 0:
                // exit programma
                System.exit(0);
                break;
            default: return;
        }
    }
}
