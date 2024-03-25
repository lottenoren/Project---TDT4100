package expencetracker.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import expencetracker.Expense;

public class CSVEExpenseStorage implements ExpenseStorage {
    
    private final Path path;

    public CSVEExpenseStorage(Path path) {
        this.path = Objects.requireNonNull(path);
    }

    @Override
    public List<Expense> loadExpenses() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(this.path)){
            return reader.lines().map(line ->{
                String[] parts = line.split(",");

                LocalDate date = LocalDate.parse(parts[0]);
                String description = parts[1];
                double amount = Double.parseDouble(parts[2]);
                String category = parts[3];

                return new Expense(date, description, amount, category);
            }).toList();
        }
    }

    @Override
    public void saveExpenses(List<Expense> expenses) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(this.path, StandardOpenOption.CREATE_NEW, 
                StandardOpenOption.TRUNCATE_EXISTING)){
            for (Expense expense : expenses){
                String line = expense.getDate() + "," + expense.getDescription() + "," + expense.getAmount() + "," + expense.getCategory() + "\n";
                writer.write(line);
            }
        }
        
    }

    public static void main(String[] args) {
        ExpenseStorage storage = new CSVEExpenseStorage(Path.of("test.csv"));
        try {
            storage.loadExpenses();
        } catch (IOException e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    
}
