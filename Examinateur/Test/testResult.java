import examinateur.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class testResult {

    @Test
    public void testGetSpecificExamResult(){
        ArrayList<Exercise> questions = new ArrayList<>();
        questions.add(new Exercise("Over welke poort worden https-websites geladen?", new Answer("443")));
        questions.add(new Exercise("Welke is GEEN naam van malware?", new Answer("Achilles")));
        questions.add(new Exercise("Hoe heet het programma waarmee de CIA smart-tv’s afluisterde?", new Answer("Ransomware")));
        questions.add(new Exercise("Welke computer worm verspreidde zich het snelst?", new Answer("MyDoom")));
        questions.add(new Exercise("welke vraag is dit?", new Answer("5")));

        Exam exam = new Exam(questions, "Cyber-Security");
        ApplicationManager.results.add(new Result(exam, 1, true));

        Assert.assertEquals(true, Result.getSpecificExamResult(1,"Cyber-Security"));
    }
}
