// Implement all the different Menu entries.
// To add a new menu entry just create a new class which extends TextMenuItem

package examinateur;

import java.util.Scanner;

class OptionExamList extends TextMenuItem {

    public OptionExamList() {
        super("1", "Lijst met examens");
    }

    @Override
    public void execute() {
        ApplicationManager.showExams();
        pressEnterToContinue();
    }
}

class OptionStudentList extends TextMenuItem {

    public OptionStudentList() {
        super("2", "Lijst met studenten");
    }

    @Override
    public void execute() {
        ApplicationManager.showStudents(ApplicationManager.students);
        pressEnterToContinue();
    }
}

class OptionEnlistStudent extends TextMenuItem {

    public OptionEnlistStudent() {
        super("3", "Nieuwe student inschrijven");
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
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

        pressEnterToContinue();
    }
}

class OptionDeleteStudent extends TextMenuItem {

    public OptionDeleteStudent() {
        super("4", "Student verwijderen");
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
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
        pressEnterToContinue();
    }
}

class OptionTakeExam extends TextMenuItem {

    public OptionTakeExam() {
        super("5", "Examen afnemen");
    }

    @Override
    public void execute() {
        ApplicationManager.askExams();
        pressEnterToContinue();
    }
}

class OptionDidStudentPass extends TextMenuItem {

    public OptionDidStudentPass() {
        super("6", "Is de student geslaagd voor de test");
    }

    @Override
    public void execute() {
        ApplicationManager.hasStudentPassedSpecificExam();
        pressEnterToContinue();
    }
}

class OptionShowExamsPassedByStudent extends TextMenuItem {
    public OptionShowExamsPassedByStudent() {
        super("7", "Welke examens heeft de student gehaald?");
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vul het studentnummer in van de student waarvan je de resultaten in wilt zien: ");
        int checkNumber = scanner.nextInt();
        scanner.nextLine();
        ApplicationManager.hasStudentPassed(checkNumber);
        pressEnterToContinue();
    }
}

class OptionStudentWithMostExamsPassed extends TextMenuItem {
    public OptionStudentWithMostExamsPassed() {
        super("8", "Welke student heeft de meeste examens gehaald?");
    }

    @Override
    public void execute() {
        ApplicationManager.hasPassedMost();
    }
}

class OptionFinish extends TextMenuItem {

    public OptionFinish() {
        super("X", "Afluisten");
    }

    @Override
    public void execute() {
        Main.isRunning = false;
    }
}

