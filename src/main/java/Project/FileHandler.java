package Project;
 
import java.io.*;




/* 

public class FileHandler {
    
   //skrive til fil
    public static void saveToFile(Map<String, List<String>> gradeMap, String fileName){
        System.out.println("Saving data to file...");
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            outputStream.writeObject(gradeMap);
            System.out.println("Data successfully saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //skrive fra fil
    @SuppressWarnings("unchecked")
    public static void loadFromFile(Map<String, List<String>> gradeMap, String fileName){
        System.out.println("Loading data from file...");
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))){
            Object obj = inputStream.readObject();
            if (obj instanceof Map){
                gradeMap = (Map<String, List<String>>) obj;
                System.out.println("Data successfully loades from file.");
            } else {
                System.out.println("Error: Data in file is not expected type.");
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Error loading data from file");
        }
    } 
}*/




public class FileHandler{
    public static void writeAverageToFile(double average, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write("Average Grade: " + average);
            writer.close();
            System.out.println("Average written to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing average to file: " + e.getMessage());
        }
    }

    public static void writegradesForSubjectToFile(String studentName, String subjectCode, char grade, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write("Student: " + studentName + ", Subject Code: " + subjectCode + ", Grade: " + grade + "\n");
            writer.close();
            System.out.println("Data written to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing list to file: " + e.getMessage());
        }
    }
}











