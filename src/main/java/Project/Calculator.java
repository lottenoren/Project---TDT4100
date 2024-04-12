package Project;

import java.util.Collections;
import java.util.List;

public class Calculator implements CalculatorInterface {

    
    /**
     * Metode som regner ut gjennomsnittet
     */
    public double calculateAverage(List<Double> numericGrades){
        double sum = 0; 

        for (Double grade : numericGrades){
            
            sum += grade;
        }

        double average = sum / numericGrades.size();
        return Math.round(average * 100) / 100;
    }


    /**
     * Metode som regner ut median
     */
    public double calculateMedian(List<Double> numericGrades){
        Collections.sort(numericGrades);       
        int numberOfGrades = numericGrades.size();
        
        if (numberOfGrades % 2 == 0){

            int midtIndex1 = numberOfGrades / 2 - 1;         
            int midtIndex2 = numberOfGrades / 2;
            double median = (numericGrades.get(midtIndex1) + numericGrades.get(midtIndex2)) / 2.0;
            return Math.round(median * 100) / 100; 

        } else { 

            int midtIndex = numberOfGrades / 2; 
            double median = numericGrades.get(midtIndex);
            return Math.round(median * 100) / 100; 
        }
    }

    /**
     * Metode som regner ut strykprosent 
     * */
    public double calculateFailureRate(List<Double> numericGrades){
        int failCount = 0; 

        for (Double grade : numericGrades) {

            if (grade == 0) {       
                failCount++;
            }
        }

        double failureRate = (double) failCount / numericGrades.size() * 100; 
        return Math.round(failureRate * 100.0) / 100.0; 
    }

   

    

}
