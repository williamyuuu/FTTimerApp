import java.io.*;
import java.util.*;

public class DBReader {

    //The database max size
    private final int LIST_SIZE = 200;

    private Scanner input;
    private String[] maps = new String[LIST_SIZE];
    private int count = 0;

    //opening a file. If not found, it will send out exception
    public void openFile() {
        try{
            input = new Scanner(new File("mapnames.db")); //opens mapnames.db
        }
        catch (Exception e){
            System.out.println("Could not find mapnames.db");
        }
    }

    //reading file. Traverses through file. Adds onto maps array.
    public void readFile() {
        while(input.hasNext()){
            String a = input.nextLine();
            //if it contains these, it will skip adding it into array
            if(a.contains("----")||a.contains("====")||a.contains("/**")){
                continue;
            }
            else {
                maps[count] = a;
                count++;
            }
        }
    }
    //returns array of the database
    public String[] getArray(){
        return maps;
    }
    public void closeFile(){
        input.close();
    }
    /*//debugger to print out all of the maps
    public void readList(){
        for(int x = 0; x < LIST_SIZE; x++){
            if(maps[x] == null){ //upon reaching the end, it will stop
                break;
            }else{
                System.out.println(maps[x]);
            }
        }
    }
    */
}
