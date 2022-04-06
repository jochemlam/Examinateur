package examinateur;

public class Student {

    private String name;
    private int number;
    private int examsPassed;

    public Student(String name, int number) {
        this.name = name;
        this.number = number;
        this.examsPassed = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public int getExamsPassed() {
        return examsPassed;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setNumber(int newNumber) {
        this.number = newNumber;
    }

    public void setExamsPassed(int examsPassed) {
        this.examsPassed = examsPassed;
    }
}
