package Project;

import java.util.HashMap;
import java.util.Scanner;



public class Student {
    private String studentName; 
    //private List<String> studentNameList = new ArrayList<>();
    


    public Student(String firstName, String lastName){
        //studentNameList = new ArrayList<>();
        this.studentName = firstName + " " + lastName; 

    }

    public void addGrade(String subjectCode, String grade, HashMap<String, String> gradeCalculator){
        String key = studentName + "-" + subjectCode;
        if(gradeCalculator.containsKey(key)){
            System.out.println("Student have already added grade.");
        } else {
            gradeCalculator.put(key, grade);
            System.out.println("Grade added for" + studentName + "in subject" + subjectCode);
            
        }
    }

   
    public void setStudentName(String StudentName){
        if (StudentName.isBlank() || StudentName == null){
            throw new IllegalArgumentException("Name can`t be empty.");
        }
        String[] name = StudentName.split(" ");

        if(name.length < 2){ //sjekker at det er 3 ledd i det som er blitt skrevet. Enderer dette dersom det er mulig å lage "bokser en for fornavn og en for etternavn, deretter en for emnekoden."
            throw new IllegalArgumentException("Write both first name and last name, excluding any middle names and additional last names. ");
        }
        if(name[0].length() < 2 || name[1].length() < 2){
            throw new IllegalArgumentException("First name and last name must be atleast two letters long.");
        }
        if(!name[0].matches("^[ÆØÅæøåa-zA-Z]") || !name[1].matches("^[ÆØÅæøåa-zA-Z]")){
            throw new IllegalArgumentException("Studentname can only contains letters.");
        } 
        
        /*if(studentNameList.contains(studentName)){
            throw new IllegalArgumentException("You have alredy added your grade in this subject.");
        } else{
            studentNameList.add(studentName);
        }*/
    } 

    public String getStudenName(){
        return studentName;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 


        System.out.println("Velkommen til karakterkalkulatoren");
        System.out.println("Venligst skriv inn fornavn og etternavn:"); //samt emnekoden? 

        //emnekode?
        System.out.println("Fornavn;");
        String firstName = scanner.next();
        System.out.println("Etternavn;");
        String lastName = scanner.next(); 

        System.out.println("Emnekode;");
        String subjectCode = scanner.next();

        System.out.println("Karakter;");
        String grade = scanner.next();

        //oppretter en student med det innskrevne navnet; 
        Student studentName = new Student(firstName, lastName);
        studentName.setStudentName(firstName + " " + lastName);

        scanner.close();

    }
}

