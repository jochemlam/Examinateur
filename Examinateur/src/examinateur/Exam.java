package examinateur;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Exam {
    private ArrayList<Exercise> exercises;
    private String examName;

    public Exam(ArrayList<Exercise> exercises, String examName){ // Maakt een nieuw examen aan
        this.exercises = exercises;
        this.examName = examName;
    }

    public ArrayList<Exercise> ExamShuffle(ArrayList<Exercise> exercises){ // Shuffled de exercises en returns ze
        Collections.shuffle(exercises);
        this.exercises = exercises;
        return this.exercises;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public String getExamName() {
        return examName;
    }

}
