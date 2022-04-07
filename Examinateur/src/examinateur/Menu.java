package examinateur;

import java.util.Scanner;

public class Menu {

    private short answer;
    Scanner scanner = new Scanner(System.in);

    public void showMenu() {

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
        selectOption();
    }

    private void selectOption() {
        System.out.println();
        System.out.println("Maak een keuze tussen 0 en 8:");

        try {
            answer = scanner.nextShort();
        }
        catch (Exception e) {
        scanner.nextLine();
        selectOption();
        }

        scanner.nextLine();

        switch(answer) {
            case 1:
                ApplicationManager.showExams();
                break;
            case 2:
                ApplicationManager.showStudents(ApplicationManager.students);
                break;
            case 3:
                // zet de gegeven naam en nummer om naar een nieuwe student die in de arraylist students gezet wordt
                try {
                    System.out.println("Voer de student <naam> in: ");
                    String newName = scanner.nextLine();
                    System.out.println("Voer het student <nummer> in: ");
                    int newNumber = scanner.nextInt();
                    scanner.nextLine();
                    new Student(newName, newNumber).addStudentToList();
                }
                catch (Exception e) {
                    System.out.println("Voer een studentnummer in.");
            }

                break;
            case 4:
                //ApplicationManager.deleteStudent();

                if (ApplicationManager.students.size() == 0) {
                    System.out.println("Er zijn geen studenten geregistreerd.");
                    return;
                }

                int number;

                try {
                    System.out.println("Vul het leerlingnummer in van de student die je wilt verwijderen.");
                    number = scanner.nextInt();
                    scanner.nextLine();
                }
                catch (Exception e) {
                    System.out.println("Er is iets fout gegaan bij het invoeren van het studentnummer.");
                    System.out.println("Probeer het opnieuw.");
                    return;
                }

                for (int i = 0; i < ApplicationManager.students.size(); i++) {
                    // wanneer het opgeslagen studentnummer overeen komt met het ingevoerde studentnummer
                    if (ApplicationManager.students.get(i).getNumber() == number) {

                        System.out.println("Weet je zeker dat je deze student wilt verwijderen? J/N");
                        if (!scanner.nextLine().equalsIgnoreCase("j")) {
                            return;
                        }
                    }
                    else {
                        System.out.println("Dit studentnummer is niet toegewezen aan een student.");
                        return;
                    }
                    System.out.println("Student " + ApplicationManager.students.get(i).getName() + " (" + ApplicationManager.students.get(i).getNumber() + ") is verwijderd.");
                    ApplicationManager.students.get(i).deleteStudent();
                }

                break;
            case 5:
                ApplicationManager.askExams();
                break;
            case 6:
                ApplicationManager.hasStudentPassedSpecificExam();
                break;
            case 7:
                System.out.println("Vul het studentnummer in van de student waarvan je de resultaten in wilt zien: ");
                int checkNumber = scanner.nextInt();
                scanner.nextLine();
                ApplicationManager.hasStudentPassed(checkNumber);
                break;
            case 8:
                ApplicationManager.hasPassedMost();
                break;
            case 0:
                Main.isRunning = false;
                break;
            default:
                System.out.println("Dit is niet een van de opties, probeer het opnieuw.");
                selectOption();
            }
            if (Main.isRunning) {
                nextInput();
            }
        }

    private void nextInput() {
        scanner.reset();
        System.out.println();
        System.out.println("Klik op enter om door te gaan.");
        scanner.nextLine();
    }
}
