package Project;
 
import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class FileHandler{
    
    private static final String FILE_PATH = "grades.txt";


    /**
     * Metode for å hente karakterer fra filen ved oppretting et et nytt Subject-objekt
     */
    public static void loadGradesForSubjectFromFile() {
        List<Student> grades = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String studentInfo = parts[0];
                String studentName = studentInfo.split(": ")[1];
                String subjectInfo = parts[1];
                String subjectCode = subjectInfo.split(": ")[1];
                String gradeInfo = parts[2];
                char grade = gradeInfo.charAt(gradeInfo.length() - 1);
                //Legg til karakteren i den interne listen over karakterer
                grades.add(new Student(studentName, subjectCode, grade));
                //Oppdater gradesPerSubject
                updateGradesPerSubject(subjectCode);
            }
            System.out.println("Grades loaded from file successfully.");
        } catch (IOException e) {
            System.out.println("Error loading grades from file: " + e.getMessage());
        }
    }

    /**
     * Lagrer informasjon til fil. 
     * @param grades
     */
    public static void saveGradesForSubjectToFile(List<Student> grades) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Student student : grades) {
                writer.write("Student: " + student.getStudentName() + ", Subject Code: " + student.getSubjectCode() + ", Grade: " + student.getGrade() + "\n");
            }
            System.out.println("Data written to file: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error writing list to file: " + e.getMessage());
        }
    }
    private static void updateGradesPerSubject(String subjectCode) {
        Subject.updateGradesPerSubject(subjectCode);
    }

    
    
}
