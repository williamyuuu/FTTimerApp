import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;

public class TextHandler implements MouseListener, KeyListener{

    JTextField textfield;
    String placeholder, compare;
    Color BGREY = new Color(224, 224, 224); //Custom lighter gray color
    int[] oKeys = {16, 37, 38, 39, 40, 20, 10};

    //mouse enters and creates edit display, black border and GREY background
    public void mouseEntered(MouseEvent e) {
        textfield = (JTextField) e.getComponent();
        hoverText(textfield);

    }
    //mouse exiting as empty will return placeholder to place
    public void mouseExited(MouseEvent e) {
        textfield = (JTextField) e.getComponent();
        submitText(textfield);
    }
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    //When clicked, placeholder will be emptied to start typing in black font
    public void mouseClicked(MouseEvent e) {
        textfield = (JTextField) e.getComponent();
        if(textfield.getText().equals(placeholder)) {
            textfield.setCaretPosition(0);
        }
    }
    //KeyListeners
    //The texthandlers for listening to if user presses certain keys
    public void keyPressed(KeyEvent e){
        //8 = backspace 16=shift 37-40=arrows caps=20 space=32
        textfield = (JTextField) e.getComponent();
        if((e.getKeyCode() != oKeys[0]) && (e.getKeyCode() != oKeys[1]) && (e.getKeyCode() != oKeys[2])
                && (e.getKeyCode() != oKeys[3]) && (e.getKeyCode() != oKeys[4]) && (e.getKeyCode() != oKeys[5])){
            textfield.setForeground(Color.BLACK);
        }
        if(e.getKeyCode() == 10){
            submitText(textfield);
        }
    }
    public void keyReleased(KeyEvent e){
        textfield = (JTextField) e.getComponent();
        if((e.getKeyCode() == 8) || e.getKeyCode() == 10){
            if(textfield.getText().equals("")) {
                textfield.setForeground(Color.GRAY);
                textfield.setText(placeholder);
                textfield.setCaretPosition(0);
            }
        }
    }
    public void keyTyped(KeyEvent e){
        textfield = (JTextField) e.getComponent();
        textfield.setForeground(Color.BLACK);
        if((e.getKeyCode() != 10) && (e.getKeyCode() != 8)){
            editText(textfield);
        }
    }

//TextField Methods
    private void hoverText(JTextField textfield) {
        textfield.setOpaque(true);
        textfield.setBackground(BGREY);
        textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        compare = textfield.getText();
        //if text within is one of the following, set as placeholder
        if(compare.equals("Name ") || compare.equals("Map Name ") || compare.equals("Ch ")
            || compare.equals("Paid ")) {
            placeholder = compare;
        }
    }
    private void editText(JTextField textfield) {
        if(textfield.getText().equals(placeholder)) {
            textfield.setCaretPosition(0);
            textfield.setText("");
        }
    }
    private void submitText(JTextField textfield) {
        textfield.setOpaque(false);
        textfield.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        if(textfield.getText().equals("")) {
            textfield.setForeground(Color.GRAY);
            textfield.setText(placeholder);
            textfield.setCaretPosition(0);
        }
    }
}
