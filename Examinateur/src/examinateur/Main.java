package examinateur;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
/*
        Exercise exercise1 = new Exercise("wat is 3 + 2", 1, new Answer(5));

        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();

        if (answer == 5) {
            System.out.println("goed");
        }
        else {
            System.out.println("false");
        }*/

        ApplicationManager.initialize();

        ApplicationManager.showStudents(ApplicationManager.students);
    }
}
//test file update