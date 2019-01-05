import java.io.*;
import java.util.*;

public class DBReader {
    private Scanner input;

    public void openFile() {
        try{
            input = new Scanner(new File("mapenames.db"));
        }
        catch (Exception e){
            System.out.println("Could not find Maps Database");
        }
    }

    public void readFile() {
        while(input.hasNext()){
            String a = input.nextLine();
            if(a.contains("----")||a.contains("====")||a.contains("/**")){
                continue;
            }
            System.out.println(a);
        }
    }
    public void closeFile(){
        input.close();
    }
}
