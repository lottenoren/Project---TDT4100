package Project;

import java.util.Collections;
import java.util.List;

public class Calculator implements CalculatorInterface {
    
    @Override
    public double calculateAverage(List<Double> numericGrades){
        double sum = 0; 
        for (Double grade : numericGrades){
            sum += grade;
        }
        return sum / numericGrades.size();
    }

    @Override
    public double calculateMedian(List<Double> numericGrades){
        Collections.sort(numericGrades);        //listen sorteres i stigende rekkefølge. 
        int numberOfGrades = numericGrades.size();
        //sjekker om antall karakterer er oddetall eller partall for å finne medianen
        if (numberOfGrades % 2 == 0){
            int midtIndex1 = numberOfGrades / 2 + 1;         //finner index til de to midterste tallene. 
            int midtIndex2 = numberOfGrades / 2;
            double median = (numericGrades.get(midtIndex1) + numericGrades.get(midtIndex2)) / 2.0;
            return median;
        } else {        //oddetall liste
            int midtIndex = numberOfGrades / 2; 
            double median = numericGrades.get(midtIndex);
            return median; 
        }
    }

    @Override
    public double calculateFailureRate(List<Double> numericGrades){
        int failCount = 0; 
        for (Double grade : numericGrades) {
            if (grade == 0) {       //finner alle karakterer som tilsvarer F
                failCount++;
            }
        }
        return (double) failCount / numericGrades.size() * 100; // finne antall studenter som har fått F, dele på totalt antall studenter og gange med 100. 
    }
}
