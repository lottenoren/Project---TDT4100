package expencetracker.storage;

import java.io.IOException;
import java.util.List;

import expencetracker.Expense;

/**
 * An interface representing some way to persist {@link Expense}.
 * @return
 */

public interface ExpenseStorage {
    /**
     * Saves the given expenses
     * @param expense The list of {@link Expense expenses}
     * @throws IOException
     */
    void saveExpenses(List<Expense> expense) throws IOException;

    /**
     * Loads the storad expenses
     * @returnThe list of loaded {@link Expense expenses}
     * @throws IOException
     */
    List<Expense> loadExpenses() throws IOException;
}
