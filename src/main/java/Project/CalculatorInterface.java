package Project;

import java.util.List;

public interface CalculatorInterface {
    double calculateAverage(List<Double> grades);
    double calculateMedian(List<Double> grades);
    double calculateFailureRate(List<Double> grades);
}
