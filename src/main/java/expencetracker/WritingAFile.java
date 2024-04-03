package expencetracker;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
 
class WritingAFile {
    public static void main(String[] args)
    {
        try
        {
            PrintWriter outFile = new PrintWriter("hello.txt");
            outFile.println("hello world, skrive til fil!");
            outFile.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: file 'test.txt' could not be opened for writing.");
            System.exit(1);
        }
         
    }
}

