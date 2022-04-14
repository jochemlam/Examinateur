import examinateur.ApplicationManager;
import examinateur.Student;
//import examinateur.
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testMostExamsPassed {

    @Test
    public void testStudentWithMostExamsPassed() { // Test of MostExamsPassed werkt door 1 passed exam toe te voegen bij een van de aangemaakte studenten
        //Arrange
        ApplicationManager.students.add(new Student("Vashy", 1234));
        ApplicationManager.students.add(new Student("Gau", 12345));

        //Act
        Student.addExamsPassed(1234);

        //Assert
       Student s = ApplicationManager.hasPassedMost();

        assertEquals(1234, s.getNumber());

    }
}