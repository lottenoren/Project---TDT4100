package expencetracker;

import java.io.*;

public class FileReadWriteExample {
    public static void main(String[] args) {
        // Skrive til fil
        try {
            FileWriter writer = new FileWriter("hello.txt");
            writer.write("Dette er en linje som skal skrives til filen.");
            writer.close();
            System.out.println("Dataene ble skrevet til filen.");
        } catch (IOException e) {
            System.out.println("Feil ved skriving til fil: " + e.getMessage());
        }

        // Les fra fil
        try {
            FileReader reader = new FileReader("hello.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            System.out.println("Dataene fra filen:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Feil ved lesing fra fil: " + e.getMessage());
        }
    }
}

