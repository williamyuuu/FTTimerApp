import java.io.*;
import java.util.*;

public class DBReader {

    //The database max size
    private final int LIST_SIZE = 200;

    private Scanner input;
    private String[] maps = new String[LIST_SIZE];
    private int count = 0;

    //opening a file. If not found, it will send out exception
    private void openFile(String databaseFile) {
        try{
            input = new Scanner(new File(databaseFile)); //opens mapnames.db
        }
        catch (Exception e){
            System.out.println("Could not find " + databaseFile);
        }
    }

    //reading file. Traverses through file. Adds onto maps array.
    private void readFile() {
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
    private void closeFile(){
        input.close();
    }
    //Traverses through database and returns the database array
    public String[] getArray(String database){
        openFile(database);
        System.out.println("File opened");
        readFile();
        System.out.println("File read");
        closeFile();
        System.out.println("File closed");
        return maps;

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
