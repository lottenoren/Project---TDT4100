package project;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Project.FileHandler;
import Project.Student;
import Project.Subject;

public class fileHandlerTest {

    private static final String TEST_FILE_PATH = "testGrades.txt";

    @Test
    public void testSaveGradesForSubjectToFile() {
        List<Student> testGrades = new ArrayList<>();
        testGrades.add(new Student("Lotte Noren", "TTM1234", 'A'));
        testGrades.add(new Student("Kåre Per", "TDT4321", 'B'));

        FileHandler.saveGradesForSubjectToFile(testGrades);

        // Now read the file and check if the content matches the test data
        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_FILE_PATH))) {
            String line;
            List<String> linesFromFile = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                linesFromFile.add(line);
            }
            assertEquals(2, linesFromFile.size()); // Check if the correct number of lines are written

            // Check if each line corresponds to the correct student
            assertEquals("Student: Lotte Noren, Subject Code: TTM1234, Grade: A", linesFromFile.get(0));
            assertEquals("Student: Kåre Per, Subject Code: TDT4321, Grade: B", linesFromFile.get(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadGradesForSubjectFromFile() {
        List<Student> expectedGradesFromFile = new ArrayList<>();
        expectedGradesFromFile.add(new Student("Lotte Noren", "TTM1234", 'A'));
        expectedGradesFromFile.add(new Student("Kåre Per", "TDT4321", 'B'));
    
        // Write test data to the file
        try (FileWriter writer = new FileWriter(TEST_FILE_PATH)) {
            for (Student student : expectedGradesFromFile) {
                writer.write("Student: " + student.getStudentName() + ", Subject Code: " + student.getSubjectCode() + ", Grade: " + student.getGrade() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // Load data from the file
        FileHandler.loadGradesForSubjectFromFile();
    
        // Update the grades for a specific subject
        Subject.updateGradesPerSubject("TDT4321");
    
        // Retrieve the actual grades for the specific subject from the updated data
        List<Character> actualGrades = Subject.getGradesForSubject("TDT4321");
    
        // Define expected grades for the subject
        List<Character> expectedGrades = Arrays.asList('A', 'B'); // Define your expected grades here
    
        // Assert that actualGrades matches expectedGrades
        assertEquals(expectedGrades, actualGrades);
    
        // Retrieve the actual student list for the specific subject from the updated data
        List<Student> actualStudents = Subject.getStudentsForSubject("TDT4321");
    
        // Assert that actualStudents list size matches expectedGradesFromFile list size
        assertEquals(expectedGradesFromFile.size(), actualStudents.size());
    
        // Assert each student object's attributes
        for (int i = 0; i < expectedGradesFromFile.size(); i++) {
            Student expectedStudent = expectedGradesFromFile.get(i);
            Student actualStudent = actualStudents.get(i);
            assertEquals(expectedStudent.getStudentName(), actualStudent.getStudentName());
            assertEquals(expectedStudent.getSubjectCode(), actualStudent.getSubjectCode());
            assertEquals(expectedStudent.getGrade(), actualStudent.getGrade());
        }
    }
}


