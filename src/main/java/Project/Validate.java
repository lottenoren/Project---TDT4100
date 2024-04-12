package Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Validate {


    static Map<String, List<Character>> gradesPerSubject = new HashMap<>();
    Subject subject = new Subject();
    


    private static final List<String> lettersCombination = Arrays.asList("TDT", "TET", "TFE", "TMA", "TTK", "TTM", "TTT", "TBA", "TEP", "TGB", 
    "TKT", "TME", "TMM", "TMR", "TPD", "TPG", "TPK", "TVM", "TBT", "TFY", "TKJ", "TKP", "TMT", "TIØ", "BK", "AAR", "EXPH", "EXFAC", "HFEL", "AFR", "ALIT", 
    "ANT", "ARK", "AVS", "DANS", "DRA", "ENG", "FI", "FFV", "FILM", "FON", "FRA", "GRE", "HIST", "ITA", "KULT", "KRL", "KUH", "LAT", "LING", "MUSP", "MUST", 
    "MUSV", "MVIT", "NFU", "NORD", "RVI", "SAM", "SWA", "TYSK", "RFEL", "IT", "MA", "ST", "GEOL", "AK", "BI", "BO", "FY", "KJ", "ZO", "SFEL", "GEOG", "HLS", 
    "IDR", "PED", "POL", "PPU", "PSY", "PSYPRO", "SARB", "SANT", "SOS", "SPED", "SØK", "ØKAD", "MD"
    );

    /**
     * Validerer studentname
     * @param StudentName
     */

    public boolean validateStudentName(String StudentName){
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
        return true;
    } 

    /**
     * Metode for å validere karakterer. Gyldige karakterer er A-F, dersom faget er godkjent/ikke godkjent er P/0 ("P-godkjent" / "O-ikke godkjent")
     * @param grade
     * @return
     */
    
    public boolean validGrade(char grade){
        List<Character> validGrades = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'P', 'O');
        grade = Character.toUpperCase(grade); //gjør om til store bokstaver
        if (!validGrades.contains(grade)){
            throw new IllegalArgumentException("Grade has to be a charachter from A-F, if the subject is passed use P");
        }
        return true;
    }

    /**
     * Validerer subjectCode
     * @param subjectCode
     * @return
     */

    public boolean validateSubjectCode(String subjectCode){
            if (subjectCode == null || subjectCode.isBlank()){
                throw new IllegalArgumentException("Subjectcode can`t be empty");
            }
            String[] code = subjectCode.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            
            if (!lettersCombination.contains(code[0])){
                throw new IllegalArgumentException("Invalid subjectcode");
            }
            
            if(code[1].length() != 4 && !code[1].matches("\\d{4}")){
                throw new IllegalArgumentException("The numeric part of subject code must contain exactly four digits");
            }
            return true; 
        }

   
    /**
     * Metode for å konvertere bokstav karakter til nummerisk verdi.
     * @param selectedSubject
     * @return
     */

    public List<Double> convertGradesToNumeric(String selectedSubject) {
        
        List<Character> gradesForSubject = getGradesForSubject(selectedSubject);
    
        
        List<Double> numericGrades = new ArrayList<>(); 

        for (Character grade : gradesForSubject) {  

            char uppercaseGrade = Character.toUpperCase(grade);     
            double numericGrade;   

            switch (uppercaseGrade) {                               
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

            numericGrades.add(numericGrade); 

        }

        return numericGrades;
    } 


    public List<Character> getGradesForSubject(String selectedSubject){

        return subject.getGradesForSubject(selectedSubject);

    }
}
