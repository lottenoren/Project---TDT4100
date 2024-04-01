package Project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Scanner;



public class Student {
    private String studentName; 
    //private static HashMap<String, String> gradeMap;
    private static Map<String, List<String>> gradeMap;
    


    public Student(String firstName, String lastName, HashMap<String, List<String>> gradeMap){
        this.studentName = firstName + " " + lastName; 
        Student.gradeMap = gradeMap;

    }

    public void addGrade(String subjectCode, char grade){
        //validerer først emnekoden

        Subject subject = new Subject(subjectCode, gradeMap);
        subject.validateSubjectCode(subjectCode);

        //validerer grade
        subject.validGrade(grade);

        //kontrollerer om student har lagt inn karakter til dette emnet tidligere. 
        String key = studentName + "-" + subjectCode;
        if(gradeMap.containsKey(key)){
            System.out.println("Student have already added grade.");
        } else {
            /*gradeMap.put(key, String.valueOf(grade));
            System.out.println("Grade added for" + studentName + "in subject" + subjectCode);*/
            List<String> gradesList = new ArrayList<>(); // Opprett en ny liste
            gradesList.add(String.valueOf(grade)); // Legg til enkeltkarakteren i den nye listen
            gradeMap.put(key, gradesList); // Legg til den nye listen i gradeMap
            System.out.println("Grade added for " + studentName + " in subject " + subjectCode);
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
        /*if(!name[0].matches("^[ÆØÅæøåa-zA-Z]+$")||!name[1].matches("^[ÆØÅæøåa-zA-Z]+$")){
            throw new IllegalArgumentException("Studentname can only contains letters.");
        } 
        if(name[0].length() < 2 || name[1].length() < 2){
            throw new IllegalArgumentException("First name and last name must be atleast two letters long.");
        }*/
        
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

    public String getStudenName(){
        return studentName;
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  


        System.out.println("Velkommen til karakterkalkulatoren");
        System.out.println("Venligst skriv inn fornavn og etternavn:"); //samt emnekoden? 

        System.out.println("Fornavn;");
        String firstName = scanner.nextLine();
        System.out.println("Etternavn;");
        String lastName = scanner.nextLine(); 

        //oppretter en student med det innskrevne navnet; 
        Student studentName = new Student(firstName, lastName, gradeMap);
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
    }*/
}

