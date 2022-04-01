package examinateur;

import java.util.ArrayList;

public class Result {
    protected Exam exam;
    protected int studentNummer;

    Result(Exam exam, int studentNummer) {
        this.exam = exam;
        this.studentNummer = studentNummer;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public Exam getExam() {
        return exam;
    }
}
