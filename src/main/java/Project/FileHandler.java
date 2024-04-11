package Project;
 
import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class FileHandler{
    static List<Student> grades = new ArrayList<>();
    private static final String FILE_PATH = "grades.txt";


    //metode for å hente karakterer fra filen ved oppretting av et nytt Subject-object
    public static void loadGradesForSubjectFromFile() {
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
                //debug-uttalelse for å kontrollre at emnekoden blir riktig hentet
                System.out.println("HEi" + grade);
                System.out.println("Loaded grade for subject:" + subjectCode);
            }
            System.out.println("Grades loaded from file successfully.");
        } catch (IOException e) {
            System.out.println("Error loading grades from file: " + e.getMessage());
        }
    }

    public static void saveGradesForSubjectToFile(List<Student> grades) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Student student : grades) {
                // Skriv hver student og karakter til filen
                // Implementasjonen av denne metoden avhenger av hvordan dataene skal lagres i filen
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

    public static void writeAverageToFile(double average, String filePath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeAverageToFile'");
    }
    
}











