import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SearchMapHandler extends JFrame implements KeyListener,ActionListener{

    //DBReader will traverse through .db file
    DBReader database = new DBReader();
    private String[] mapList;
    private JTextField textfield;
    private JComboBox<String> comboBox;
    private boolean firstTime = true;

    //comboBox.setBounds(0, 20, 150, 20);
    //shows up even when it doesn't match


    //When you press enter, the field sets to seleted index in comboBox
    public void actionPerformed(ActionEvent arg0) {
        try {
            System.out.println("Action performed");
            textfield.setText(comboBox.getSelectedItem().toString());
            comboBox.removeAllItems();
            comboBox.hidePopup();
            textfield.remove(comboBox);
        }
        catch(Exception e) {
            System.out.println("Action Exception");
        }
    }

    public void keyPressed(KeyEvent e){
        System.out.println("Key Pressed");
        if(firstTime) {
            System.out.println("First time key pressed");
            textfield = (JTextField) e.getComponent();
            runOnce(textfield);
            firstTime = false;
        }

        //keycode 38 is up arrow. Moves up the combobox selection.
        if(e.getKeyCode() == 38) {
            int x = comboBox.getSelectedIndex();
            if(x > 0){
                comboBox.setSelectedIndex(x - 1);
            }
            //textfield.add(comboBox);
            //comboBox.showPopup();
        }
        //Moves down the comboBox Selection. If down at bottom, resets to top
        else if (e.getKeyCode() == 40) {
            int x = comboBox.getSelectedIndex();
            int y = comboBox.getItemCount();
            if(x + 1 < y){
                comboBox.setSelectedIndex(x + 1);
            }
            else {
                comboBox.setSelectedIndex(0);
            }
            //textfield.add(comboBox);
            //comboBox.showPopup();
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    //
    private class TextFieldCaretListener implements CaretListener {
        public void caretUpdate(CaretEvent e){
            try{
                comboBox.hidePopup();
                comboBox.removeAllItems();
                textfield.remove(comboBox);
                //Dislays depending on how many letters typed -- setting to 0 misplaces suggestion box
                if(e.getMark() > 1) {
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
            if(e.getMark() < 1) {
                //textfield.remove(comboBox);
            }
        }
    }
    //This runs the ComboBox set up and caretlistener set up
    private void runOnce (JTextField textfield){
        //DBReader code. Opens the map database and returns the array.
        if(textfield.getText().equals("Map Name ")){
            System.out.println("running mapnames.db");
            mapList = database.getArray("mapnames.db");
        }
        else if(textfield.getText().equals("Name ")){
            System.out.println("running username.db");
            mapList = database.getArray("usernames.db");
        }

        textfield.setHorizontalAlignment(textfield.LEFT);
        textfield.addCaretListener(new TextFieldCaretListener());

        comboBox = new JComboBox<String>();
        //bound is set to display under texthandler textbox
        comboBox.setBounds(6, 25, 200, 20);
        comboBox.setFocusCycleRoot(true);
        comboBox.setFocusTraversalPolicyProvider(true);
        comboBox.setAutoscrolls(true);
        comboBox.setBorder(null);
        comboBox.setOpaque(false);

        disableKeys(textfield.getInputMap());
        //textfield.add(comboBox);
        System.out.println("running once");
    }
    //Disables the usage of UP and DOWN keys within the textfield
    private void disableKeys(InputMap inputMap) {
        String[] keys = {"UP", "DOWN"};
        for (String key : keys) {
            inputMap.put(KeyStroke.getKeyStroke(key), "none");
        }
    }
}
