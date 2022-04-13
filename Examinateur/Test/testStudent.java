import examinateur.ApplicationManager;
import examinateur.Student;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testStudent {

    @Test
    public void testAddExamsPassed(){
        //Arrange
        ApplicationManager.students.add(new Student("Maikel Bazuin", 21032246));
        //Act
        Student.addExamsPassed(21032246);
        //Assert
        assertEquals(1, ApplicationManager.students.get(0).getExamsPassed());
    }
}
