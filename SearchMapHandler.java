import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class SearchMapHandler extends JFrame implements KeyListener,ActionListener{

    //List of names
    //** Get a Reader to read a database file of all map
    //** input the names into the mapList
    //MAP LIST WILL BE READ FROM A DATABASE IN FUTURE VERSION!!!
    private static String[] mapList = {"Above the Cave","Arma's Hideout","Below the Cave","Cave Depths",
    "Cave Entrance (Vanishing Journey)","Cave's End","Damp Falls","Eastern Cave Path 1","Eastern Cave Path 2","Fire Rock Zone",
    "Fire Spirit Zone","Fire Zone","Fire Zone Cliff","Forked Road 1","Forked Road 2","Hidden Cave (Vanishing Journey)","Hidden Fire Zone",
    "Hidden Lakeshore","Lake of Oblivion","Lakeshore","Lakeshore (2)","Mirage Cliff","Nameless Town","Rock Zone","Spirit Zone",
    "Split Road of Destiny (Vanishing Journey)","Vanishing Journey Entrance","Weathered Land of Happiness","Weathered Land of Happiness and Rage",
    "Weathered Land of Joy","Weathered Land of Rage","Weathered Land of Rage and Sorrow","Weathered Land of Sorrow","Weathered Land of Sorrow and Joy",
    "Western Cave Path 1","Western Cave Path 2","Below the Falls","Bitty-Bobble Forest 1","Bitty-Bobble Forest 2","Chu Chu Village","Chu Chu Village Entrance",
    "Colossal Tail","Dealie-Bobber Forest 1","Dealie-Bobber Forest 2","Hill Path","Mottled Forest 1","Mottled Forest 2","Mottled Forest 3","Mountain's Mouth",
    "Muto's Descent","Quiet Village Path","Skywhale Mountainside 1","Skywhale Mountainside 2","Skywhale Peak","Slurpy Forest Depths","Slurpy Tree Habitat",
    "Torrent Zone 1","Torrent Zone 2","Torrent Zone 3","Within Five-Color Hill","Bright Ballroom","Chicken Festival 1","Chicken Festival 2","Chicken Festival 3",
    "Circus Mask","Crumbling Clocktower","Dreaming Forest","Hideout (Lachelein)","Lachelein Canal","Lachelein Main Street","Nightmare Clocktower",
    "Nightmare Clocktower 1F","Nightmare Clocktower 2F","Nightmare Clocktower 3F","Nightmare Clocktower 4F","Nightmare Clocktower 5F","Noisy Market",
    "Occupied Dance Floor 1","Occupied Dance Floor 2","Outlaw's Street 1","Outlaw's Street 2","Outlaw's Street 3","Revelation Place 1","Revelation Place 2",
    "Revelation Place 3","Victory Plate Street 1","Victory Plate Street 2","Beneath the Spirit Tree","Between Frost and Thunder 1","Between Frost and Thunder 2",
    "Cavern Lower Path","Cavern Upper Path","Cavernous Cavern","Deep in the Cavern - Lower Path 1","Deep in the Cavern - Lower Path 2",
    "Deep in the Cavern - Upper Path 1","Deep in the Cavern - Upper Path 2","Forest Entrance (Arcana)","Forest of Toxins","Grove of the Spirit Tree",
    "Heart of the Forest","Labyrinthine Cavern","Labyrinthine Cavern - Lower Path","Labyrinthine Cavern - Side Path","Labyrinthine Cavern - Upper Path",
    "Marimba Lagoon","Near the Bramble Harp","Near the Floral Flute","Snow Cloud Clearing","Spirit Tree Vantage","The Deepest Part of the Cavern - Lower Path",
    "The Deepest Part of the Cavern - Upper Path","The Forest of Earth","The Forest of Sunlight","The Forest of Water","The Volatile and Toxic Forest 1",
    "The Volatile and Toxic Forest 2","The Volatile Forest","Thunder Cloud Clearing","Where Earth and Sunlight Meet","Where Water and Sunlight Meet",
    "Abandoned Area","Abandoned Area 2","Abandoned Area 3","Abandoned Area 4","Bully Blvd.","Bully Blvd. 2","Bully Blvd. 3","Leaning Tower",
    "Path to the Coral Forest","Path to the Coral Forest 2","Path to the Coral Forest 3","Path to the Coral Forest 4","Path to the Coral Forest 5",
    "Research Lab","Shadowdance Hall","Shadowdance Hall 2","Shadowdance Hall 3","Shadowdance Hall 4","Street Cat Area","Street Cat Area 2",
    "That Day in Trueffet","That Day in Trueffet 2","That Day in Trueffet 3","That Day in Trueffet 4","Trueffet Square",
    "Base Camp","Diffraction Hall","Fading Light","Living Spring","Living Spring 2","Living Spring 3","Living Spring 4","Living Spring 5",
    "Living Spring 6","Living Spring 7","Mirror-touched Sea","Mirror-touched Sea 2","Mirror-touched Sea 3","Mirror-touched Sea 4",
    "Mirror-touched Sea 5","Mirror-touched Sea 6","Mirror-touched Sea 7","Radiant Temple","Radiant Temple 2","Radiant Temple 3","Radiant Temple 4",
    "Radiant Throne","Slumbering Deep","The Deep Mirror"};

    private JTextField textfield;
    private JComboBox<String> comboBox;
    private boolean firstTime = true;

    //When a key is typed, it will open up combobox with maplist suggestions
    // ** still need to get the position to display properly
    // ** possibly only start suggestion after 2 letters?

    //comboBox.setBounds(25, 19, 268, 37);
    //shows up even when it doesn't match


    //When you press enter, the field sets to seleted index in comboBox
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
    //This runs the ComboBox set up and caretlistener set up
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

            disableKeys(textfield.getInputMap());
            //textfield.add(comboBox);
    }
    //Disables the usage of UP and DOWN keys within the textfield
    private void disableKeys(InputMap inputMap) {
        String[] keys = {"UP", "DOWN"};
        for (String key : keys) {
            inputMap.put(KeyStroke.getKeyStroke(key), "none");
        }
    }
}
