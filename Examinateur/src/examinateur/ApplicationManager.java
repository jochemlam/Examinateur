package examinateur;

import java.util.ArrayList;

public class ApplicationManager {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Exam> exams = new ArrayList<Exam>();

    // studenten in de lijst:
    public static void initialize() {
        // voeg studenten toe aan de lijst van studenten
        addStudent(new Student("Sebastian Metzger", 21081840));
        addStudent(new Student("Jochem Lammertsma", 21094187));
        addStudent(new Student("Vashisjt Sitaldin", 20167474));
        addStudent(new Student("Bodhi Simmons", 21131945));
        addStudent(new Student("Sebastian Metzger", 21081840));

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
