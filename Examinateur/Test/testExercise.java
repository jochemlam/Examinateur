import examinateur.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testExercise {

    @Test
    public void testCheckAnswer() { // Deze test checkt of checkAnswer het userAnswer goed vergelijkt met correctAnswer en dit resultaat goed doorvoert.
        // Arrange
        Boolean expectedResult = true;
        Exercise exercise = new Exercise("Werkt deze test naar behoren?", new Answer("ja"));

        // Act
        exercise.userAnswer = new Answer("ja");
        exercise.checkAnswer();
        Boolean actualResult = exercise.result;
        // Assert
        assertEquals(expectedResult, actualResult);
    }

}
