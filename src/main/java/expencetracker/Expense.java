package expencetracker;

import java.time.LocalDate;
import java.util.Objects;
import java.util.List;

/**
 * creates a new expense 
 * 
 * @param date The date the expense was icures on 
 * @param description A brief description of the expense
 * @param amount The amount of the epense, may not be less than 0
 * @param category The category og the expense, Valid category can be found in {@link #category}
 */

public class Expense {

    public static final List<String> CATEGORIES = List.of("Mat", "Transport", "bolig", "Fritid", "Annet");
    // har opprettet en liste som innehodler alle lovlige kategorier, vi kan da
    // sjekke om kategoiren er gyldig senre da.
    private final LocalDate date;
    private final String description;
    private final double amount;
    private final String category;

    // grunnen tila t vi bruker final er fordi det forenkelr en del ting.
    // inkapsing - kan ikke endre på tilstanden til en del ting
    // dersom de ikke hadde vært final kunnene ha endret tilstanden på disse deltene
    // etter at det feltene r blitt sendt gjennom expense.
    // kan ikke endre dette senere i etterkant, derfor gir det mening.
    public Expense(LocalDate date, String description, double amount, String category) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount can not be less than zero.");
        }

        if (!CATEGORIES.contains(category)) {
            throw new IllegalArgumentException("Invalid category");
        }

        this.date = Objects.requireNonNull(date);
        this.description = Objects.requireNonNull(description);
        this.amount = amount;
        this.category = Objects.requireNonNull(category);
    }
    // viktig med innkapsling og validering! legger til Objects.requireNonNull() på
    // alle feltene
    
    /**
     * 
     * @return The date of the expense
     */

    public LocalDate getDate() {
        return date;
    }

    /**
     * @return The desprction of the expense
     */
    public String getDescription() {
        return description;
    }
    /**
     * @return The amount og the expense
     */

    public double getAmount() {
        return amount;
    }

    /**
     * @return The category of the expense
     */

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Expense [date=" + date + ", description=" + description + ", amount=" + amount + ", category="
                + category + "]";
    }

    public static void main(String[] args) {
        Expense expense = new Expense(LocalDate.now(), "Test", 10, "Mat");
        System.out.println(expense);
    }

}
