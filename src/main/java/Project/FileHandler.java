package Project;
 
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class FileHandler{
    // private static final String FILE_PATH = "grades.txt";
    // static List<Student> grades;

    // //metode for å hente karakterer fra filen ved oppretting av et nytt Subject-object
    // public static void loadGradesForSubjectFromFile() {
    //     try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             String[] parts = line.split(",");
    //             String studentInfo = parts[0];
    //             String studentName = studentInfo.split(": ")[1];
    //             String subjectInfo = parts[1];
    //             String subjectCode = subjectInfo.split(": ")[1];
    //             String gradeInfo = parts[2];
    //             char grade = gradeInfo.charAt(gradeInfo.length() - 1);
    //             //Legg til karakteren i den interne listen over karakterer
    //             grades.add(new Student(studentName, subjectCode, grade));
    //             //Oppdater gradesPerSubject
    //             updateGradesPerSubject(subjectCode);
    //             //debug-uttalelse for å kontrollre at emnekoden blir riktig hentet
    //             System.out.println("HEi" + grade);
    //             System.out.println("Loaded grade for subject:" + subjectCode);
    //         }
    //         System.out.println("Grades loaded from file successfully.");
    //     } catch (IOException e) {
    //         System.out.println("Error loading grades from file: " + e.getMessage());
    //     }
    // }

    // private static void updateGradesPerSubject(String subjectCode) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'updateGradesPerSubject'");
    // }

    // //metode for å lagre karakterer til filen
    // public static void saveGradesForSubjectToFile(List<Student> grades) {
    
    //     try (FileWriter writer = new FileWriter(FILE_PATH)){
    //         writer.write("");           //tømmer filen før den skrives til
    //         Set<String> uniqueStudents = new HashSet<>();
    //         for (Student student : grades) {
    //             //System.out.println("Student: " + student.studentName + ", Subject Code: " + student.subjectCode + ", Grade: " + student.grade);
    //             writer.write("Student: " + student.studentName + ", Subject Code: " + student.subjectCode + ", Grade: " + student.grade + "\n");
    //             //writer.write(student.studentName + "," + student.subjectCode + "," + student.grade + "\n");
    //             uniqueStudents.add(student.studentName);
    //         }
    //         writer.close();
    //         System.out.println("Data written to file: " + FILE_PATH);
    //     } catch (IOException e) {
    //         System.out.println("Error writing list to file: " + e.getMessage());
    //     }
    
    // }
}











