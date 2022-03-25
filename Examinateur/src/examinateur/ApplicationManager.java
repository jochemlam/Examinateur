package examinateur;

import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationManager {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Exam> exams = new ArrayList<Exam>();

    // studenten in de lijst:
    public static void initialize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Voer de student <naam> in: ");
        String studentName = scanner.nextLine();
        System.out.print("Voer de student <nummer> in: ");
        int studentNumber = scanner.nextInt();

        // voeg studenten toe aan de lijst van studenten

        Menu menu1 = new Menu();

        addStudent(new Student(studentName, studentNumber));

        menu1.ShowList();
        menu1.SelectOption();

        // voeg examens toe aan de lijst van examens

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


        public static void showStudents(ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " - " + list.get(i).getNumber());
        }

            Menu menu1 = new Menu();
            menu1.ShowList();
            menu1.SelectOption();

    }
}
