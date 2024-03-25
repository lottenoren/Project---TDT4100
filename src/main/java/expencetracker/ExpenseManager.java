package expencetracker;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;

/**
 * A class responsible for managing expenses
 */

public class ExpenseManager {
    
    private final List<Expense> expenses; 

    /**
     * creates a new expense manager with no added expenses
     */

    public ExpenseManager(){
        this.expenses = new ArrayList<>();
    }

    public List<Expense> getExpenses(){
        return Collections.unmodifiableList(this.expenses);
    }

    public void addExpense(Expense expense){
        this.expenses.add(Objects.requireNonNull(expense));
    }

    /**
     * Removes the gove expense from this manger
     * @param expense The expense
     * @return {@code true } if the expense was removed, {@code false } if was not
     */

    public boolean removeExpense(Expense expense){
        return this.expenses.remove(Objects.requireNonNull(expense));
    }

    public double getTotal(){
        return this.expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public double getTotalInCategory(String category){
        return this.expenses.stream()
                .filter(e -> e.getCategory().equals(category)) 
                .mapToDouble(Expense::getAmount)
                .sum();      
    }

    public double getTotalInMonth(int month, int year){
        return this.expenses.stream()
            .filter(e -> e.getDate().getMonthValue() == month && e.getDate().getYear() == year)
            .mapToDouble(Expense::getAmount)
            .sum();
    }
    


    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager();
        System.out.println(manager.getExpenses());
        manager.addExpense(new Expense(LocalDate.now(),"Test", 10, "Fritid" ));
        System.out.println(manager.getExpenses());
    }


}
