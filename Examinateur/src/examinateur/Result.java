package examinateur;

public class Result {
    private Exam exam;
    private int studentNumber;
    private boolean hasPassed;

    public Result(Exam exam, int studentNumber, boolean isGraduated) {
        this.exam = exam;
        this.studentNumber = studentNumber;
        this.hasPassed = isGraduated;
    }

    public int getStudentNumber() {
        return this.studentNumber;
    }

    public Exam getExam() {
        return this.exam;
    }

    public boolean isGraduated() {
        return this.hasPassed;
    }
}
