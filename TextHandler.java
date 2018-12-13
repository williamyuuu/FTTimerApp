import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;

public class TextHandler implements MouseListener, KeyListener{

    JTextField textField;
    String placeholder, compare;
    Color BGREY = new Color(224, 224, 224); //Custom lighter gray color

    //mouse enters and creates edit display, black border and GREY background
    public void mouseEntered(MouseEvent e) {
        textField = (JTextField) e.getComponent();
        hoverText(textField);

    }
    //mouse exiting as empty will return placeholder to place
    public void mouseExited(MouseEvent e) {
        textField = (JTextField) e.getComponent();
        submitText(textField);
    }
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    //When clicked, placeholder will be emptied to start typing in black font
    public void mouseClicked(MouseEvent e) {
        textField = (JTextField) e.getComponent();
        if(textField.getText().equals(placeholder)) {
            textField.setCaretPosition(0);
        }
    }
    //KeyListeners
    //The texthandlers for listening to if user presses certain keys
    public void keyPressed(KeyEvent e){
        //8 = backspace 16=shift 37-40=arrows caps=20 space=32
        textField = (JTextField) e.getComponent();
        textField.setForeground(Color.BLACK);
        if(e.getKeyCode() == 10){
            submitText(textField);
        }
    }
    public void keyReleased(KeyEvent e){
        textField = (JTextField) e.getComponent();
        if(e.getKeyCode() == 8){
            if(textField.getText().equals("")) {
                textField.setForeground(Color.GRAY);
                textField.setText("...");
                textField.setCaretPosition(0);
            }
        }
    }
    public void keyTyped(KeyEvent e){
        textField = (JTextField) e.getComponent();
        textField.setForeground(Color.BLACK);
        if((e.getKeyCode() != 10) && (e.getKeyCode() != 8)){
            editText(textField);
        }
    }

//TextField Methods
    private void hoverText(JTextField textField) {
        textField.setOpaque(true);
        textField.setBackground(BGREY);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        compare = textField.getText();
        //if text within is one of the following, set as placeholder
        if(compare.equals("...") || compare.equals("Map Name") || compare.equals("Ch")
            || compare.equals("Paid")) {
            placeholder = compare;
        }
    }
    private void editText(JTextField textField) {
        if(textField.getText().equals(placeholder)) {
            textField.setCaretPosition(0);
            textField.setText("");
        }
    }
    private void submitText(JTextField textField) {
        textField.setOpaque(false);
        textField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        if(textField.getText().equals("")) {
            textField.setForeground(Color.GRAY);
            textField.setText(placeholder);
            textField.setCaretPosition(0);
        }
    }
}
