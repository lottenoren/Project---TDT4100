package Project;


public class Student {
    String studentName; 
    String subjectCode;
    char grade;

    /**
     * Konstruktør til student-klassen 
     * @param studentName
     * @param subjectCode
     * @param grade
     */

    public Student(String studentName, String subjectCode, char grade){
        this.studentName = studentName;
        this.subjectCode = subjectCode;
        this.grade = grade;
    }

   /**
    * Henter studentName
    * @return studentName
    */

    public String getStudentName(){
        return studentName;
    }

    /**
     * Henter karakter
     * @return grade
     */

    public char getGrade(){
        return grade;
    }

    /**
     * Henter subjectCode
     * @return subjectCode
     */

    public String getSubjectCode(){
        return subjectCode;
    }

    /**
     * Setter for grade 
     * @param grade
     */
    public void setGrade(char grade){
        this.grade = grade;
    }

}

