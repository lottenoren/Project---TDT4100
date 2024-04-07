package Project; 

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert; 
import javafx.scene.control.TextField;
import javafx.stage.Stage; 



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

    @FXML
    private void initialize(){
        subject = new Subject();
        subject.loadGradesForSubjectFromFile();
        calculator = new Calculator();
    }

    @FXML
    private void calculate(){
        try{ 
            String studentName = studentNameField.getText();
            String subjectCode = subjectCodeField.getText();
            char grade = gradeField.getText().charAt(0); 

            if (subject.validateSubjectCode(subjectCode) && subject.validGrade(grade)){
                subject.addGrade(studentName, subjectCode, grade);

                // Sjekk om det valgte emnet eksisterer før vi fortsetter med beregningene
                if (!subject.gradesPerSubject.containsKey(subjectCode)) {
                    throw new IllegalArgumentException("Selected subject does not exist.");
                }


                 // Get numeric grades for the selected subject
                String selectedSubject = selectedSubjectField.getText();
                if (selectedSubject != null && !selectedSubject.isEmpty()) {
                    // Convert grades to numeric values
                    List<Double> numericGrades = subject.convertGradesToNumeric(selectedSubject);
                    
                    // Perform calculations
                    double average = calculator.calculateAverage(numericGrades);
                    double median = calculator.calculateMedian(numericGrades);
                    double failureRate = calculator.calculateFailureRate(numericGrades);
                    
                    List<Character> gradesForSubject = subject.getGradesForSubject(selectedSubject);
                    Collections.sort(gradesForSubject);
                    // Display results
                    displayResults(average, median, failureRate, gradesForSubject);
                }
            }
        }catch (IllegalArgumentException e) {
            showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
    } 

    private void displayResults(double average, double median, double failureRate, List<Character> gradesForSubject) {
        // Display results however you want
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
        // Add save to file functionality here
        // Make sure to get the average first
        //double average = 0.0; // Change this to actual calculated average
        //calculator.saveToFile(average);
    }

    @FXML
    private void saveGradesForSubjectToFile(){

    }




    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
}
