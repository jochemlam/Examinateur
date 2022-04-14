import examinateur.ApplicationManager;
import examinateur.Student;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testStudent {

    @Test
    public void testAddExamsPassed(){ // Test of AddExamsPassed bij de meegegeven student, 1 toevoegt bijExamsPassed.
        //Arrange
        int expectedResult = 1;
        ApplicationManager.students.add(new Student("Maikel Bazuin", 21032246));

        //Act
        Student.addExamsPassed(21032246);
        int actualResult = ApplicationManager.students.get(0).getExamsPassed();
        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testDeleteStudent() {
        //Arrange
        int expectedResult = ApplicationManager.students.size();
        Student testStudent = new Student("Sebastian M", 123);
        ApplicationManager.students.add(testStudent);
        //Act
        ApplicationManager.students.remove(testStudent);
        int actualResult = ApplicationManager.students.size();
        //Assert
        assertEquals(expectedResult, actualResult);
    }
}
