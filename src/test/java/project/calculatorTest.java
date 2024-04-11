package project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import Project.Calculator;

public class calculatorTest {


    @Test
    public void testCalculateAverage() {
        Calculator calculator = new Calculator();
        List<Double> grades = Arrays.asList(4.0, 4.0, 2.0, 2.0);
        double expectedAverage = 3.0;
        double actualAverage = calculator.calculateAverage(grades);
        assertEquals(expectedAverage, actualAverage);
    }

    @Test
    public void testCalculateMedianEvenNumberOfGrades() {
        Calculator calculator = new Calculator();
        List<Double> grades = Arrays.asList(4.0, 4.0, 2.0, 2.0);
        double expectedMedian = 3.0;
        double actualMedian = calculator.calculateMedian(grades);
        assertEquals(expectedMedian, actualMedian);
    }

    @Test
    public void testCalculateMedianOddNumberOfGrades() {
        Calculator calculator = new Calculator();
        List<Double> grades = Arrays.asList(5.0, 4.0, 2.0, 3.0, 1.0);
        double expectedMedian = 3.0;
        double actualMedian = calculator.calculateMedian(grades);
        assertEquals(expectedMedian, actualMedian);
    }

    @Test
    public void testCalculateFailureRate() {
        Calculator calculator = new Calculator();
        List<Double> grades = Arrays.asList(5.0, 4.0, 2.0, 3.0, 0.0, 0.0);
        double expectedFailureRate = 2 / 6.0 * 100;
        double actualFailureRate = calculator.calculateFailureRate(grades);
        double tolerance = 0.001; 
        assertEquals(Math.round(expectedFailureRate), Math.round(actualFailureRate), tolerance);
    }
}
