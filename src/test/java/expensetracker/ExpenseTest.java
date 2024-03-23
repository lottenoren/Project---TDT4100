package expensetracker;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import expencetracker.Expense;

/**
 * An expense
 */

public class ExpenseTest {
    
    @Test
    public void testValidConstructor(){
        new Expense(LocalDate.now(), "Test", 10, "Mat");
    }

    @Test
    public void testInvalidDate(){
        assertThrows(NullPointerException.class,() -> new Expense(null, "Test", 10, "Mat") );
    }

    @Test
    public void testInvalidCategory(){
        assertThrows(IllegalArgumentException.class,() -> new Expense(LocalDate.now(), "Test", 10, "Inavlid") );
    }

    //kan kopier og gjøre det samme på alle de ulike testene. 



}
