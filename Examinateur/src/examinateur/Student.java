package examinateur;

public class Student {

    private String name;
    private int number;

    public Student(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setNumber(int newNumber) {
        this.number = newNumber;
    }
}
