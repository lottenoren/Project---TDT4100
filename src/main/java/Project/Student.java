package Project;

import java.util.HashMap;
import java.util.Scanner;



public class Student {
    private String studentName; 
    private static HashMap<String, String> gradeCalculator;
    


    public Student(String firstName, String lastName, HashMap<String, String> gradeCalculator){
        this.studentName = firstName + " " + lastName; 
        Student.gradeCalculator = gradeCalculator;

    }

    public void addGrade(String subjectCode, char grade /*HashMap<String, String> gradeCalculator*/){
        //validerer først emnekoden

        Subject subject = new Subject(subjectCode, gradeCalculator);
        subject.validateSubjectCode(subjectCode);

        //validerer grade
        subject.validGrade(grade);

        //kontrollerer om student har lagt inn karakter til dette emnet tidligere. 
        String key = studentName + "-" + subjectCode;
        if(gradeCalculator.containsKey(key)){
            System.out.println("Student have already added grade.");
        } else {
            gradeCalculator.put(key, String.valueOf(grade));
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
    } 

    public String getStudenName(){
        return studentName;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  


        System.out.println("Velkommen til karakterkalkulatoren");
        System.out.println("Venligst skriv inn fornavn og etternavn:"); //samt emnekoden? 

        System.out.println("Fornavn;");
        String firstName = scanner.nextLine();
        System.out.println("Etternavn;");
        String lastName = scanner.nextLine(); 

        //oppretter en student med det innskrevne navnet; 
        Student studentName = new Student(firstName, lastName, gradeCalculator);
        studentName.setStudentName(firstName + " " + lastName);

        System.out.println("Skriv emnekode og karakter:");

        System.out.println("Emnekode;");
        String subjectCode = scanner.next();
        System.out.println("Karakter;");
        char grade = scanner.next().charAt(0); //gjør at bokstaven blir til en char
        studentName.addGrade(subjectCode, grade);
        
        //Input felt for bruker for å velge emnekode
        System.out.println("Skriv inn emnekode for å se gjennomsnitt, median og strykprosent:");
        String selectedSubject = scanner.next();

        scanner.close();

    }
}

