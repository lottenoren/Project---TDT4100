package Project;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {

    private String subjectCode; 
    /*private String grade; 
    private static HashMap<String, String> gradeCalculator;*/

    @SuppressWarnings("unused")
    private Map<String, List<String>> gradeMap;

    private static final List<String> lettersCombination = Arrays.asList("TDT", "TET", "TFE", "TMA", "TTK", "TTM", "TTT", "TBA", "TEP", "TGB", 
    "TKT", "TME", "TMM", "TMR", "TPD", "TPG", "TPK", "TVM", "TBT", "TFY", "TKJ", "TKP", "TMT", "TIØ", "BK", "AAR", "EXPH", "EXFAC", "HFEL", "AFR", "ALIT", 
    "ANT", "ARK", "AVS", "DANS", "DRA", "ENG", "FI", "FFV", "FILM", "FON", "FRA", "GRE", "HIST", "ITA", "KULT", "KRL", "KUH", "LAT", "LING", "MUSP", "MUST", 
    "MUSV", "MVIT", "NFU", "NORD", "RVI", "SAM", "SWA", "TYSK", "RFEL", "IT", "MA", "ST", "GEOL", "AK", "BI", "BO", "FY", "KJ", "ZO", "SFEL", "GEOG", "HLS", 
    "IDR", "PED", "POL", "PPU", "PSY", "PSYPRO", "SARB", "SANT", "SOS", "SPED", "SØK", "ØKAD", "MD"
    );


    public Subject(String subjectCode, Map<String, List<String>> gradeMap){
        this.subjectCode = subjectCode; 
        this.gradeMap = new HashMap<>();
    }

    public String getSubjectCode(){
        return subjectCode; 
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

    //henter ut karakterene fra et bestemt emnet og lagrer de i listen gradesForSubject. 
    public List<String> getGradesForSubject(String selectedSubject, Map<String, List<String>> gradeMap){
        List<String> gradesForSubject = new ArrayList<>();      //oppretter en arraylist for å lagre karakterene for det valgte emne. 

        for (String key : gradeMap.keySet()){
            if (key.endsWith(selectedSubject)){     //går gjennom hver nøkkel i gradeList. dersom nøkkelen stemmer med selectedSubject
                List<String> studentGrades = gradeMap.get(key);    //henter vi ut verdien til denne nøkkelen ved å bruke gradeList.get(key), karakterene lagres midlertidig i listen studentGrades. 
                gradesForSubject.addAll(studentGrades);     //legger alle karakteren fra studentgrades inn i gradesForSubject-listen. 
            }
        }
        return gradesForSubject;
    }

    //metode for å konvertere gradesForSubject fra Streng til en liste av tegn, da den nå bare består av bokstavkarakterer. 
    public List<Character> convertStringToCharacters(List<String> gradesForSubject){
        List<Character> charactersGrades = new ArrayList<>();
        for (String grade : gradesForSubject){
            for(char character : grade.toCharArray()){
                charactersGrades.add(character);
            }
        }
        return charactersGrades;
    }

    //konverterer fra bokstav karakter til nummerisk verdi.
    //bruker switch-case-struktur fremfor mange if else utsagn. 
    public List<Double> convertGradesToNumeric(List<Character> charactersGrades) {
        List<Double> numericGrades = new ArrayList<>();     //oppretter en ny liste hvor de nummeriske karakterene skal lagres
        for (Character grade : charactersGrades) {          //itererer gjennom hver karakter i listen
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


     

}
