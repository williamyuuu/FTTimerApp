import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SearchMapHandler extends JFrame implements KeyListener,ActionListener{

    //List of names
    //** Get a Reader to read a database file of all map
    //** input the names into the mapList
    private static String[] mapList = {"Above the Cave","Arma's Hideout","Below the Cave","Cave Depths",
    "Cave Entrance (Vanishing Journey)","Cave's End","Damp Falls","Eastern Cave Path 1","Eastern Cave Path 2","Fire Rock Zone",
    "Fire Spirit Zone","Fire Zone","Fire Zone Cliff","Forked Road 1","Forked Road 2","Hidden Cave (Vanishing Journey)","Hidden Fire Zone",
    "Hidden Lakeshore","Lake of Oblivion","Lakeshore","Lakeshore (2)","Mirage Cliff","Nameless Town","Rock Zone","Spirit Zone",
    "Split Road of Destiny (Vanishing Journey)","Vanishing Journey Entrance","Weathered Land of Happiness","Weathered Land of Happiness and Rage",
    "Weathered Land of Joy","Weathered Land of Rage","Weathered Land of Rage and Sorrow","Weathered Land of Sorrow","Weathered Land of Sorrow and Joy",
    "Western Cave Path 1","Western Cave Path 2"};

    private JTextField textfield;
    private JComboBox<String> comboBox;
    private boolean firstTime = true;

    //When a key is typed, it will open up combobox with maplist suggestions
    // ** still need to get the position to display properly
    // ** possibly only start suggestion after 2 letters?

    //comboBox.setBounds(25, 19, 268, 37);
    //shows up even when it doesn't match

    public void actionPerformed(ActionEvent arg0) {
        try {
            textfield.setText(comboBox.getSelectedItem().toString());
            comboBox.removeAllItems();
            comboBox.hidePopup();
            textfield.remove(comboBox);
        }
        catch(Exception e) {}
        }

    public void keyPressed(KeyEvent e){
        if(firstTime) {
            textfield = (JTextField) e.getComponent();
            runOnce(textfield);
            firstTime = false;
        }

        if(e.getKeyCode() == 38) {
            System.out.println("Keycode 38");
        }
        else if (e.getKeyCode() == 40) {
            System.out.println("Keycode 40");
        }

    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    private class TextFieldCaretListener implements CaretListener {
        public void caretUpdate(CaretEvent e){
            try{
                comboBox.hidePopup();
                comboBox.removeAllItems();
                textfield.remove(comboBox);
                if(e.getMark() > 0) {
                    for(String string : mapList){
                        if(string.toLowerCase().startsWith(textfield.getText().toLowerCase())){
                            textfield.add(comboBox);
                            comboBox.addItem(string);
                            comboBox.showPopup();
                        }
                    }
                }
            }
            catch(Exception e1) {}
            if(e.getMark() < 2) {
                //textfield.remove(comboBox);
            }
        }
    }
    private void runOnce (JTextField textfield){
            textfield.setHorizontalAlignment(textfield.LEFT);
            textfield.addCaretListener(new TextFieldCaretListener());
            textfield.setColumns(10);

            comboBox = new JComboBox<String>();
            comboBox.setFocusCycleRoot(true);
            comboBox.setFocusTraversalPolicyProvider(true);
            comboBox.setAutoscrolls(true);
            comboBox.setBorder(null);
            comboBox.setOpaque(false);
            comboBox.setBounds(25, 19, 268, 37);
            //textfield.add(comboBox);
    }
}
