package Project;


public class Student {
    String studentName; 
    String subjectCode;
    char grade;



    public Student(String studentName, String subjectCode, char grade){
        this.studentName = studentName;
        this.subjectCode = subjectCode;
        this.grade = grade;
    }

    /**
     * Validerer studentnavn
     * @param StudentName
     */

    public void validateStudentName(String StudentName){
        if (StudentName.isBlank() || StudentName == null){
            throw new IllegalArgumentException("Name can`t be empty.");
        }
        String[] name = StudentName.split(" ");

        if(name.length < 2){ 
            throw new IllegalArgumentException("Write both first name and last name, excluding any middle names and additional last names. ");
        }
        
        for (String part : name) {
            if (!part.matches("^[ÆØÅæøåa-zA-Z]+$")) {
                System.out.println("Ugyldig del av navnet: " + part);
                throw new IllegalArgumentException("Studentname can only contains letters.");
            } 
            if (part.length() < 2) {
                throw new IllegalArgumentException("First name and last name must be atleast two letters long.");
            }
        }
    } 

    public String getStudentName(){
        return studentName;
    }

    public char getGrade(){
        return grade;
    }

    public String getSubjectCode(){
        return subjectCode;
    }

}

