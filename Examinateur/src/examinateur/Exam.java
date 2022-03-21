package examinateur;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Exam {
    private ArrayList<Exercise> exercises;
    private String examName;

    public Exam(ArrayList<Exercise> exercises, String examName){ // Maakt een nieuw examen aan en de vragen worden geshuffeld

        Collections.shuffle(exercises);

        this.exercises = exercises;
        this.examName = examName;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public String getExamName() {
        return examName;
    }
}
