package Project;



import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;


import java.util.Map;
import java.util.List;
import java.util.HashMap;



public class CalculatorProjectController {
    
    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;
    
    @FXML
    private TextField subjectCodeField;

    @FXML
    private TextField gradeField;

    @FXML
    private TextField selectedSubjectField;


    private Student student;
    private Map<String, List<String>> gradeMap;

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
            String selectedSubject = selectedSubjectField.getText();


            student = new Student(firstName, lastName, new HashMap<String, List<String>>());
            student.setStudentName(firstName + " " + lastName);
            student.addGrade(subjectCode, grade);
            
            Subject subject = new Subject(subjectCode, gradeMap);
            List<String> gradesForSubject = subject.getGradesForSubject(selectedSubject,new HashMap<>(gradeMap));

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

            showAlert("Average: " + average + "\nMedian: " + median + "\nFailure Rate: " + failureRate + "%");
            } catch (IllegalArgumentException e) {
            showAlert("Error: " + e.getMessage());
            }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
