import examinateur.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testExercise {

    @Test
    public void testCheckAnswer() {
        // Arrange
        String expectedResult = "ja";
        Exercise exercise = new Exercise("Werkt deze test naar behoren?", new Answer("ja"));

        // Act
        exercise.userAnswer = new Answer("ja");
        exercise.checkAnswer();
        String actualResult = exercise.userAnswer.get();
        // Assert
        assertEquals(expectedResult, actualResult);
    }

}
