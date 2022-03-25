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
        addStudent(new Student("Pietje", 3434));
        addStudent(new Student("Jan", 34343));

        menu1.ShowList();
        menu1.SelectOption();

        // voeg examens toe aan de lijst van examens

    }

    public static void addStudent(Student student) {
            students.add(student);
    }

    public static void showStudents(ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " - " + list.get(i).getNumber());
        }
    }
}
