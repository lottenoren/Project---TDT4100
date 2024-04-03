package expencetracker;

public class G_CalculatorProjectController {
    package Project;



import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;


import java.util.Map;
import java.util.List;
import java.util.HashMap;



public class CalculatorProjectController {
    
    @FXML
    private TextField studentNameField;
    
    @FXML
    private TextField subjectCodeField;

    @FXML
    private TextField gradeField;

    @FXML
    private TextField selectedSubjectField;



    private Student student;
    //private Map<String, List<String>> gradeMap;
    private Map<String, List<String>> gradeMap = new HashMap<>();
    private double average;


    /*@FXML 
    public void initialize(){
        gradeMap = new HashMap<>();
    }*/

    @FXML
    public void calculate(){
        try {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String subjectCode = subjectCodeField.getText();
            char grade = gradeField.getText().charAt(0);
            //String selectedSubject = selectedSubjectField.getText();

            //oppretter en student og legger til karakteren
            student = new Student(firstName, lastName, gradeMap);
            student.addGrade(subjectCode, grade);

            //henter karakter for valgt emne 
            Subject subject = new Subject(subjectCode, gradeMap);
            List<String> gradesForSubject = subject.getGradesForSubject(subjectCode, gradeMap);

            // Konverter karakterene til numeriske verdier
            List<Character> charactersGrades = subject.convertStringToCharacters(gradesForSubject);
            List<Double> numericGrades = subject.convertGradesToNumeric(charactersGrades);
    
            // Beregn gjennomsnitt, median og strykprosent
            Calculator calculator = new Calculator();
            double average = calculator.calculateAverage(numericGrades);
            double median = calculator.calculateMedian(numericGrades);
            double failureRate = calculator.calculateFailureRate(numericGrades);
    
            // Vis resultater i popupvindu
            showResultPopup(average, median, failureRate);
            } catch (IllegalArgumentException e) {
            showAlert("Error: " + e.getMessage());
            }


            /* 
            Subject subject = new Subject(subjectCode, gradeMap);
            System.out.println("Selected Subject: " + selectedSubject);
            System.out.println("Grade Map: " + gradeMap);
            List<String> gradesForSubject = subject.getGradesForSubject(selectedSubject,gradeMap);
            if (!gradeMap.containsKey(selectedSubject)) {
                showAlert("Selected subject not found in grade map.");
                return;
            }
            if (gradesForSubject.isEmpty()){
                showAlert("No grades found for the selected subject.");
                return;
            }

            List<Character> charactersGrades = subject.convertStringToCharacters(gradesForSubject);
            List<Double> numericGrades = subject.convertGradesToNumeric(charactersGrades);

            Calculator calculator = new Calculator();
            double average = calculator.calculateAverage(numericGrades);
            double median = calculator.calculateMedian(numericGrades);
            double failureRate = calculator.calculateFailureRate(numericGrades);

            showResultPopup(average, median, failureRate);         //("Average: " + average + "\nMedian: " + median + "\nFailure Rate: " + failureRate + "%");
            } catch (IllegalArgumentException e) {
            showAlert("Error: " + e.getMessage());
            }*/
    }

   

    // Opprett en ny metode for å vise resultatene i et popup-vindu
    private void showResultPopup(double average, double median, double failureRate) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText(null);
        alert.setContentText("Average: " + average + "\nMedian: " + median + "\nFailure Rate: " + failureRate + "%");
        alert.showAndWait();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void saveToFile() {
    Calculator calculator = new Calculator();
    calculator.saveToFile(average);
    }

  
}

}


import Project.Student;

