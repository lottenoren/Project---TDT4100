package project;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Project.FileHandler;
import Project.Student;

/**
 * Tester skriving til fil. Oppretter egen .txt fil. Lagrer til fil deretter sjekker om innhold matcher test dataen. 
 * Sjekker deretter om riktig antall linjer er skrevet, og deretter om det er riktig data. 
 */

public class fileHandlerTest {

    private static final String TEST_FILE_PATH = "testGrades.txt";

    @Test
    public void testSaveGradesForSubjectToFile() {

        List<Student> testGrades = new ArrayList<>();

        testGrades.add(new Student("Lotte Noren", "TTM1234", 'A'));
        testGrades.add(new Student("Kåre Per", "TDT4321", 'B'));

        FileHandler.saveGradesForSubjectToFile(testGrades);


        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_FILE_PATH))) {

            String line;

            List<String> linesFromFile = new ArrayList<>();
            while ((line = reader.readLine()) != null) {

                linesFromFile.add(line);

            }

            assertEquals(2, linesFromFile.size()); 

            assertEquals("Student: Lotte Noren, Subject Code: TTM1234, Grade: A", linesFromFile.get(0));
            assertEquals("Student: Kåre Per, Subject Code: TDT4321, Grade: B", linesFromFile.get(1));

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}


