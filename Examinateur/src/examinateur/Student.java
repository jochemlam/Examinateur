package examinateur;

import java.util.Scanner;

public class Student {

    private String name;
    private int number;
    private int examsPassed;

    public Student(String name, int number) {
        this.name = name;
        this.number = number;
        this.examsPassed = 0;
    }

    public void deleteStudent() {
        ApplicationManager.students.remove(this);
    }

    public void addStudentToList() {
        if (isNumberAvailable(this.number))
            ApplicationManager.students.add(this);
        else
            System.out.println("Dit studentnummer is al toegewezen aan een student");
    }

    private boolean isNumberAvailable(int number) {
        if (ApplicationManager.students.size() == 0) {
            return true;
        }
        else {
            for (int i = 0; i < ApplicationManager.students.size(); i++) {
                if (number == ApplicationManager.students.get(i).getNumber()) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getExamsPassed() {
        return examsPassed;
    }

    public void setExamsPassed(int examsPassed) {
        this.examsPassed = examsPassed;
    }
}
