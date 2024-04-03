package expencetracker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
 
class ReadingAFile {
    public static void main(String[] args){
        Scanner in;
        try{
            in = new Scanner(new FileReader("hello.txt"));
             
            while(in.hasNext()){
                String line = in.nextLine();
                System.out.println(line);
            }
             
            in.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Error: file 'test.txt' could not be opened. Does it exist?");
            System.exit(1);
        }
    }
}
