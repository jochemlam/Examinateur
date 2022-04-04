package examinateur;

import java.util.ArrayList;

public class Result {
    protected Exam exam;
    protected int studentNummer;
    protected boolean isGeslaagd;

    Result(Exam exam, int studentNummer, boolean isGraduated) {
        this.exam = exam;
        this.studentNummer = studentNummer;
        this.isGeslaagd = isGraduated;
    }

    public int getStudentNummer() {
        return this.studentNummer;
    }

    public Exam getExam() {
        return this.exam;
    }

    public boolean isGraduated() {
        return this.isGeslaagd;
    }
}
