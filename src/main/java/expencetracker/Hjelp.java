package expencetracker;

public class Hjelp {
    
    // private static final String FILE_PATH = "grades.txt";

    // /**
    //  * Leser inn og returnerer liste med Student-objekter.
    //  * @return Liste med Student-objekter
    //  */
    // public static List<Student> loadStudentsFromFile() {

    //     try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
    //         List<Student> students = new ArrayList<>();
    //         String line;

    //         while ((line = reader.readLine()) != null) {
    //             String[] parts = line.split(",");
    //             String studentInfo = parts[0];
    //             String studentName = studentInfo.split(": ")[1];
    //             String subjectInfo = parts[1];
    //             String subjectCode = subjectInfo.split(": ")[1];
    //             String gradeInfo = parts[2];
    //             char grade = gradeInfo.charAt(gradeInfo.length() - 1);
    //             students.add(new Student(studentName, subjectCode, grade));
    //             //Subject.updateGradesPerSubject(subjectCode);
    //             System.out.println("Loaded grade for subject: " + subjectCode);
    //         }

    //         System.out.println("Grades loaded from file successfully.");
    //         return students;

    //     } catch (IOException e) {
    //         System.out.println("Error loading grades from file: " + e.getMessage());
    //         return null;
    //     }

    // }

    // public static List<Student> saveGradesForSubjectToFile(List<Student> students) {
    //     try (FileWriter writer = new FileWriter(FILE_PATH)) {
    //         writer.write(""); // Tømmer fil før den skrives til
    //         for (Student student : students) {
    //             writer.write("Student: " + student.studentName + ", Subject Code: " + student.subjectCode + ", Grade: " + student.grade + "\n");
    //         }
            
    //         System.out.println("Data written to file: " + FILE_PATH);
    //         return students;
            
    //     } catch (IOException e) {
    //         System.out.println("Error writing list to file: " + e.getMessage());
    //         return null;
    //     }
    // }

    // public static void main(String[] args) {
    //     System.out.println(FileHandler.loadStudentsFromFile());
        
    // }

// subject-klassen. 
    // List<Student> loadStudentsWithSubject(String subjectCode) {
    //     List<Student> allStudents = FileHandler.loadStudentsFromFile();
    //     List<Student> studentsWithSubject = new ArrayList<>();

    //     for (Student s : allStudents) {

    //     }

    //     return studentsWithSubject;
    // }
}
