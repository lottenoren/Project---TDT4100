package Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {

    private static List<Student> grades;
    static Map<String, List<Character>> gradesPerSubject = new HashMap<>();
    String selectedSubject;
    
    
/**
 * Metode som legger til nye student objeter i listen grades. Kontrollerer om student har lagt til tidligere karakterer i emnet. 
 * @param studentName
 * @param subjectCode
 * @param grade
 */
    public void addGrade(String studentName, String subjectCode, char grade){
        loadGradesFromFile();
        boolean studentExists = false;
    
        for (Student existingStudent : grades){

            if (existingStudent.getStudentName().equals(studentName) && existingStudent.getSubjectCode().equals(subjectCode)){

                existingStudent.setGrade(grade);
                studentExists = true;
                break;
            }
        }
    
        
        if (!studentExists) {

            Student newStudent = new Student(studentName, subjectCode, grade);
            grades.add(newStudent);
        }
    
    
        updateGradesPerSubject(subjectCode);
        FileHandler.saveGradesForSubjectToFile(grades);
    
        System.out.println("Added grade for subject: " + subjectCode);
    }
    

    /**
     * Oppdaterer karakter til emnet dersom student har lagt til karakter tidligere
     * @param subjectCode
     */
    public static void updateGradesPerSubject(String subjectCode){

        if (grades == null){
            grades = new ArrayList<>();
        }
        
        gradesPerSubject.remove(subjectCode);
       
        List<Character> gradeList = new ArrayList<>();
        for (Student grade : grades){

            if(grade.subjectCode.equals(subjectCode)){

                gradeList.add(grade.grade);
            }
        }

        gradesPerSubject.put(subjectCode, gradeList);
        FileHandler.saveGradesForSubjectToFile(grades);
    }

    
    /**
     * Henter ut en liste med karakter for valgt emnekode. Listen heter gradesForSubject
     * @param selectedSubject
     * @return gradesForSubejct
    */
    public List<Character> getGradesForSubject(String selectedSubject){
    
        List<Character> gradesForSubject = gradesPerSubject.get(selectedSubject);

        
        if(gradesForSubject != null){
            return gradesForSubject;
        } else {
            throw new IllegalArgumentException("SubjectCode does not exist");
        }
    }

    public static void loadGradesFromFile() {
        grades = FileHandler.loadGradesForSubjectFromFile();
    }

    public List<Student> getGrades() {
        return grades;
    }



}
