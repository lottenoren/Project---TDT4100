package Project;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Subject {

    private static List<Student> grades;
    static Map<String, List<Character>> gradesPerSubject = new HashMap<>();
    String selectedSubject;
    
    


    private static final List<String> lettersCombination = Arrays.asList("TDT", "TET", "TFE", "TMA", "TTK", "TTM", "TTT", "TBA", "TEP", "TGB", 
    "TKT", "TME", "TMM", "TMR", "TPD", "TPG", "TPK", "TVM", "TBT", "TFY", "TKJ", "TKP", "TMT", "TIØ", "BK", "AAR", "EXPH", "EXFAC", "HFEL", "AFR", "ALIT", 
    "ANT", "ARK", "AVS", "DANS", "DRA", "ENG", "FI", "FFV", "FILM", "FON", "FRA", "GRE", "HIST", "ITA", "KULT", "KRL", "KUH", "LAT", "LING", "MUSP", "MUST", 
    "MUSV", "MVIT", "NFU", "NORD", "RVI", "SAM", "SWA", "TYSK", "RFEL", "IT", "MA", "ST", "GEOL", "AK", "BI", "BO", "FY", "KJ", "ZO", "SFEL", "GEOG", "HLS", 
    "IDR", "PED", "POL", "PPU", "PSY", "PSYPRO", "SARB", "SANT", "SOS", "SPED", "SØK", "ØKAD", "MD"
    );
    
    
    public void addGrade(String studentName, String subjectCode, char grade){
       
        FileHandler.loadGradesForSubjectFromFile();

        //sjekker om studentName har lagt til grade for det spesifikke subjectCode
        for (Student existingStudent : grades){
            if(existingStudent.studentName.equals(studentName) && existingStudent.subjectCode.equals(subjectCode)){
                //Person har allerede lagt til grade for emnet, erstatter grade
                existingStudent.grade = grade;
                //oppdaterer gradesPerSubject
                updateGradesPerSubject(subjectCode);
                //lagrer karakterer for emnet til fil; 
                FileHandler.saveGradesForSubjectToFile(grades);
                return;
            }
        }
        //personen har ikke lagt til karakter for emnet tidligere, legger til ny karakter 
        Student newStudent = new Student(studentName, subjectCode, grade);
        grades.add(newStudent);
        //oppdaterer gradesPerSubject
        updateGradesPerSubject(subjectCode);
        // Lagrer karakterer for emnet til fil
        FileHandler.saveGradesForSubjectToFile(grades);
        // Debug-uttalelse for å kontrollere at emnekoden blir lagt til riktig
        System.out.println("Added grade for subject: " + subjectCode);

    }

    public static void updateGradesPerSubject(String subjectCode){
        if (grades == null){
            grades = new ArrayList<>();
        }
        //sletter karakter for emnet fra gradesPerSubject
        gradesPerSubject.remove(subjectCode);
        //legger til oppdatert karakterer for emnet
        List<Character> gradeList = new ArrayList<>();
        for (Student grade : grades){
            if(grade.subjectCode.equals(subjectCode)){
                gradeList.add(grade.grade);
            }
        }
        gradesPerSubject.put(subjectCode, gradeList);
    }

    


    public List<Character> getGradesForSubject(String selectedSubject){
        //henter karakterliste for valgt emnekode
        List<Character> gradesForSubject = gradesPerSubject.get(selectedSubject);

        //sjekker om emnekoden eksisterer
        if(gradesForSubject != null){
            return gradesForSubject;
        } else {
            throw new IllegalArgumentException("Emnekoden eksisterer ikke");
        }
    }
    public List<Student> getGrades() {
        return grades;
    }

    //konverterer fra bokstav karakter til nummerisk verdi.
    //bruker switch-case-struktur fremfor mange if else utsagn. 
    public List<Double> convertGradesToNumeric(String selectedSubject) {
        //Hent karakterlisten for det valgte emnet
        List<Character> gradesForSubject = getGradesForSubject(selectedSubject);
    
        //konverterer karakterene til nummeriske verdier
        List<Double> numericGrades = new ArrayList<>();     //oppretter en ny liste hvor de nummeriske karakterene skal lagres
        for (Character grade : gradesForSubject) {          //itererer gjennom hver karakter i listen
            char uppercaseGrade = Character.toUpperCase(grade);     //konverterer karakterene til store bokstaver
            double numericGrade;                                    //oppretter en variabel hvor den numeriske karakterverdien kan lagres
            switch (uppercaseGrade) {                               //sjekker hvilken karakter vi har og tildeler den numeriske verdien
                case 'A':
                    numericGrade = 5.0;
                    break;
                case 'B':
                    numericGrade = 4.0;
                    break;
                case 'C':
                    numericGrade = 3.0;
                    break;
                case 'D':
                    numericGrade = 2.0;
                    break;
                case 'E':
                    numericGrade = 1.0;
                    break;
                case 'F':
                    numericGrade = 0.0;
                    break;
                case 'P':
                    numericGrade = 1.0;
                    break;
                case 'O':
                    numericGrade = 0.0;
                    break;
                default:
                    throw new IllegalArgumentException("Ugyldig karakter" + grade);
            }
            numericGrades.add(numericGrade); //legger til den numeriske verdien av karakteren i listen numericGrades.
        }
        return numericGrades;
    } 



    public boolean validateSubjectCode(String subjectCode){
        if (subjectCode == null || subjectCode.isBlank()){
            throw new IllegalArgumentException("Subjectcode can`t be empty");
        }
        String[] code = subjectCode.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        //sjekker om subjectCode stemmer med listen lettersCombination 
        if (!lettersCombination.contains(code[0])){
            throw new IllegalArgumentException("Invalid subjectcode");
        }
        // sjekker om sisten delen av subjectCode består av fire tall
        if(code[1].length() != 4 && !code[1].matches("\\d{4}")){
            throw new IllegalArgumentException("The numeric part of subject code must contain exactly four digits");
        }
        return true; 
    }

    //kontrollerer at grade består av A-F, godkjent ikke godkjent er P/0 ("P-godkjent" / "O-ikke godkjent")
    public boolean validGrade(char grade){
        List<Character> validGrades = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'P', 'O');
        grade = Character.toUpperCase(grade); //gjør om til store bokstaver
        if (!validGrades.contains(grade)){
            throw new IllegalArgumentException("Grade has to be a charachter from A-F, if the subject is passed use P");
        }
        return true;
    }

    

    

}
