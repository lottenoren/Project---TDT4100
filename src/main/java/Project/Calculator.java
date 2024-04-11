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
        Collections.sort(numericGrades);        //listen sorteres i stigende rekkefølge. 
        int numberOfGrades = numericGrades.size();
        //sjekker om antall karakterer er oddetall eller partall for å finne medianen
        if (numberOfGrades % 2 == 0){
            int midtIndex1 = numberOfGrades / 2 - 1;         //finner index til de to midterste tallene. 
            int midtIndex2 = numberOfGrades / 2;
            double median = (numericGrades.get(midtIndex1) + numericGrades.get(midtIndex2)) / 2.0;
            return Math.round(median * 100) / 100; //runder av til to desimaler
        } else {        //oddetall liste
            int midtIndex = numberOfGrades / 2; 
            double median = numericGrades.get(midtIndex);
            return Math.round(median * 100) / 100; //runder av til to desimaler
        }
    }

    /**
     * Metode som regner ut strykprosent 
     * */
    public double calculateFailureRate(List<Double> numericGrades){
        int failCount = 0; 
        for (Double grade : numericGrades) {
            if (grade == 0) {       //finner alle karakterer som tilsvarer F
                failCount++;
            }
        }
        double failureRate = (double) failCount / numericGrades.size() * 100; // finne antall studenter som har fått F, dele på totalt antall studenter og gange med 100. 
        return Math.round(failureRate * 100.0) / 100.0; // Rund av til to desimaler
    }

   

    

}
