package Project;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Subject {

    private String subjectCode; 
    /*private String grade; 
    private static HashMap<String, String> gradeCalculator;*/

    private static final List<String> lettersCombination = Arrays.asList("TDT", "TET", "TFE", "TMA", "TTK", "TTM", "TTT", "TBA", "TEP", "TGB", 
    "TKT", "TME", "TMM", "TMR", "TPD", "TPG", "TPK", "TVM", "TBT", "TFY", "TKJ", "TKP", "TMT", "TIØ", "BK", "AAR", "EXPH", "EXFAC", "HFEL", "AFR", "ALIT", 
    "ANT", "ARK", "AVS", "DANS", "DRA", "ENG", "FI", "FFV", "FILM", "FON", "FRA", "GRE", "HIST", "ITA", "KULT", "KRL", "KUH", "LAT", "LING", "MUSP", "MUST", 
    "MUSV", "MVIT", "NFU", "NORD", "RVI", "SAM", "SWA", "TYSK", "RFEL", "IT", "MA", "ST", "GEOL", "AK", "BI", "BO", "FY", "KJ", "ZO", "SFEL", "GEOG", "HLS", 
    "IDR", "PED", "POL", "PPU", "PSY", "PSYPRO", "SARB", "SANT", "SOS", "SPED", "SØK", "ØKAD", "MD"
    );


    public Subject(String subjectCode, HashMap<String, String> gradeCalculator){
        this.subjectCode = subjectCode; 
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

    //kontrollerer at grade består av A-F, godkjent ikke godkjent er P/0 ("P-godkjent" / "0-ikke godkjent")

    public boolean validGrade(char grade){
        List<Character> validGrades = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'P', '0');
        grade = Character.toUpperCase(grade); //gjør om til store bokstaver
        if (!validGrades.contains(grade)){
            throw new IllegalArgumentException("Grade has to be a charachter from A-F, if the subject is passed use P");
        }
        return true;
    }

    public 

}
