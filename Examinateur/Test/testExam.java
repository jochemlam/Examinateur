import examinateur.Answer;
import examinateur.Exam;
import examinateur.Exercise;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testExam {

    @Test
    public void testHasStudentPassed() { // Deze test checkt of de berekening in hasStudentPassed klopt en dat het correct wordt ingevoerd.
        //Arrange
        ArrayList<Exercise> questions = new ArrayList<>();
        questions.add(new Exercise("Over welke poort worden https-websites geladen?", new Answer("443")));
        questions.add(new Exercise("Welke is GEEN naam van malware?", new Answer("Achilles")));
        questions.add(new Exercise("Hoe heet het programma waarmee de CIA smart-tv’s afluisterde?", new Answer("Ransomware")));
        questions.add(new Exercise("Welke computer worm verspreidde zich het snelst?", new Answer("MyDoom")));
        questions.add(new Exercise("welke vraag is dit?", new Answer("5")));

        Exam exam = new Exam(questions, "Cyber-Security");

        //Act
        exam.setAmountCorrect((short) 3);

        //Assert
        assertEquals(true, exam.hasStudentPassed());

    }
}

//