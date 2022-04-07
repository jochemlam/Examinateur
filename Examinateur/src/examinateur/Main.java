package examinateur;

import static examinateur.ApplicationManager.menu;

public class Main {

    public static boolean isRunning;

    public static void main(String[] args) {
        ApplicationManager.initialize();
        update();
    }

    private static void update() {
        Menu menu = new Menu();

        while (isRunning) {
            menu.showMenu();
        }
    }

    private static void createTempQuestions() {

        //System.out.println("Student " + ApplicationManager.results.get(0).getStudentNummer() + " heeft "+ ApplicationManager.results.get(0).getExam().getExamenOnderwerp() + " Gemaakt");

    }
}
