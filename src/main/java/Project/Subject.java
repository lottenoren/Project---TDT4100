package Project;


import java.util.HashMap;

public class Subject {
    private String subjectCode; 
    private HashMap<String, String> studentsWithSubjectCode;


    public Subject(String subjectCode){
        this.subjectCode = subjectCode; 
        this.studentsWithSubjectCode = new HashMap<>();

    }

    public String getSubjectCode(){
        return subjectCode; 
    }

    public void addGrade(String studentName, String grade){
        studentsWithSubjectCode.put(studentName, grade);
    }

    public 


    
}
