import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;

public class SearchHandler implements KeyListener{

    JTextField textField;
    JComboBox comboBox;

    //read a .db file
    //store .db data into an array
    //if data within array matches the data that the user types, send out combobox
    //suggestions will be displayed

    //** how do I make this textfield specific?
    public void keyPressed(KeyEvent e){
        //System.out.println(e.getKeyCode()); //prints keycode cmd
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

}
