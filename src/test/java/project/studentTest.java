package project;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import Project.Student;

public class studentTest {
    
    @Test
    public void testConstructor() {

        String studentName = "Lotte Noren";
        String subjectCode = "TDT4100";
        char grade = 'A';

  
        Student student = new Student(studentName, subjectCode, grade);

      
        assertEquals(studentName, student.getStudentName());
        assertEquals(subjectCode, student.getSubjectCode());
        assertEquals(grade, student.getGrade());
    }
}
