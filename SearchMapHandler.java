import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;

public class SearchMapHandler implements KeyListener{

    //List of names
    //** Get a Reader to read a database file of all map
    //** input the names into the mapList
    private static String[] mapList = {"Cavern Lower Path", "CLP", "Chicken Festival 1",
                                        "Chicken Festival 2", "Chicken Festival 3"};

    private JTextField textfield;
    private JComboBox<String> comboBox;

    //When a key is typed, it will open up combobox with maplist suggestions
    // ** still need to get the position to display properly
    // ** possibly only start suggestion after 2 letters?
    public void keyPressed(KeyEvent e){
     textfield = (JTextField) e.getComponent();
        comboBox = new JComboBox<String>();
        comboBox.setFocusCycleRoot(true);
        comboBox.setFocusTraversalPolicyProvider(true);
        comboBox.setAutoscrolls(true);
        comboBox.setBorder(null);
        comboBox.setOpaque(false);
        comboBox.setBounds(25, 19, 268, 37);
        for(String string : mapList) {
            textfield.add(comboBox);
            comboBox.addItem(string);
            comboBox.showPopup();
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

}
