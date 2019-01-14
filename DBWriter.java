import java.io.*;
import java.lang.*;
import java.util.*;

public class DBWriter {

    private FileWriter writer;

	//Creates a file from parameter of a string
    public void openFile(String file) {
        try{
            writer = new FileWriter(file, true);
        }
        catch (Exception e) {
            System.out.println("You already have file named " + file);
        }
    }
    //Adds records to the input file that was given
    public void addRecords(String x) {
        try{
            writer.write(x + "\n");
            writer.flush();
        }
        catch (Exception e){}
    }

    //Exits out and closes the file. Prevents errors on certain platforms
    public void closeFile() {
        try{
            writer.close();
        }
        catch (Exception e){}
    }

}
