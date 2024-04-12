package Project; 


import java.util.List;
import java.util.Collections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert; 
import javafx.scene.control.TextField;




public class CalculatorProjectController {

    @FXML
    private TextField studentNameField;

    @FXML
    private TextField subjectCodeField;

    @FXML
    private TextField gradeField;

    @FXML
    private TextField selectedSubjectField;

    private Subject subject;
    private Calculator calculator;
    private Validate validate;

    @FXML
    private void initialize(){
        subject = new Subject();
        calculator = new Calculator();
        validate = new Validate();
        
        FileHandler.loadGradesForSubjectFromFile();

    }



    @FXML 
    private void loadGradesForSubjectFromFile(){
        FileHandler.loadGradesForSubjectFromFile();
    }

    @FXML
    private void calculate(){
        
        
        try{ 
            String studentName = studentNameField.getText();
            String subjectCode = subjectCodeField.getText();
            char grade = gradeField.getText().charAt(0); 
            
            if(validate.validateStudentName(studentName))
        
            if (validate.validateSubjectCode(subjectCode) && validate.validGrade(grade)){
                subject.addGrade(studentName, subjectCode, grade);

                // Sjekk om det valgte emnet eksisterer før vi fortsetter med beregningene
                if (!Subject.gradesPerSubject.containsKey(subjectCode)) {
                    throw new IllegalArgumentException("Selected subject does not exist.");
                }

                String selectedSubject = selectedSubjectField.getText();
                if (selectedSubject != null && !selectedSubject.isEmpty()) {
                    
                    List<Double> numericGrades = validate.convertGradesToNumeric(selectedSubject);
                    
                    
                    double average = calculator.calculateAverage(numericGrades);
                    double median = calculator.calculateMedian(numericGrades);
                    double failureRate = calculator.calculateFailureRate(numericGrades);
                    
                    List<Character> gradesForSubject = subject.getGradesForSubject(selectedSubject);
                    Collections.sort(gradesForSubject);
                    
                    displayResults(average, median, failureRate, gradesForSubject);
                }
            }
        }catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    } 

    private void displayResults(double average, double median, double failureRate, List<Character> gradesForSubject) {
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Calculation Results");
        alert.setHeaderText(null);
        alert.setContentText("Average: " + average + "\n" +
                         "Median: " + median + "\n" +
                         "Failure Rate: " + failureRate + "\n" +
                         "Karakterer: " + gradesForSubject);
        alert.showAndWait();
        
    }

    @FXML
    private void saveToFile() {
        subject.getGrades();
    }


    @FXML
    private void saveGradesForSubjectToFile(){
        FileHandler.saveGradesForSubjectToFile(subject.getGrades());
    }


    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
}
