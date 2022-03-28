package examinateur;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationManager {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Exam> exams = new ArrayList<Exam>();
    private static Scanner scanner = new Scanner(System.in);

    // studenten in de lijst:
    public static void initialize() {
        System.out.print("Voer de student <naam> in: ");
        String studentName = scanner.nextLine();
        System.out.print("Voer het student <nummer> in: ");
        int studentNumber = scanner.nextInt();

        // voeg studenten toe aan de lijst van studenten

        Menu menu1 = new Menu();

        addStudent(new Student(studentName, studentNumber));

        menu1.ShowList();
        menu1.SelectOption();

        // voeg examens toe aan de lijst van examens

    }

    public static void nextInput() {
        System.out.println();
        System.out.println("Klik op enter om door te gaan.");
        scanner.nextLine();
    }

    public static void addStudent(Student student) {
        if (ApplicationManager.students.size() == 0)
            students.add(student);
        else {
            for (int i = 0; i < ApplicationManager.students.size(); i++) {
                if (student.getNumber() == ApplicationManager.students.get(i).getNumber()) {
                    System.out.println("Deze studentnummber is al toegewezen aan een student");
                } else {
                    students.add(student);
                }
                break;
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
        Menu menu1 = new Menu();

        menu1.ShowList();
        menu1.SelectOption();
    }


    public static void showStudents(ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " - " + list.get(i).getNumber());
        }

        nextInput();

        Menu menu1 = new Menu();
        menu1.ShowList();
        menu1.SelectOption();

    }
}
