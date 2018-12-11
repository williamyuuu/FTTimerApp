import java.awt.event.*; //allows for ActionListener
import java.awt.*;
import javax.swing.*;

public class TextHandler implements MouseListener, KeyListener{

    JTextField textField;
    String placeholder, compare;
    Color GREY = new Color(224, 224, 224); //Custom lighter gray color

    //mouse enters and creates edit display, black border and GREY background
    public void mouseEntered(MouseEvent e) {
        textField = (JTextField) e.getComponent();
        textField.setOpaque(true);
        textField.setBackground(GREY);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        compare = textField.getText();
        //if text within is one of the following, set as placeholder
        if(compare.equals("Name") || compare.equals("Map Name") || compare.equals("Ch")
            || compare.equals("Paid")) {
            placeholder = compare;
        }

    }
    //mouse exiting as empty will return placeholder to place
    public void mouseExited(MouseEvent e) {
        textField = (JTextField) e.getComponent();
        textField.setOpaque(false);
        textField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
        if(textField.getText().equals("")) {
            textField.setForeground(Color.GRAY);
            textField.setText(placeholder);
        }
    }
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    //When clicked, placeholder will be emptied to start typing in black font
    public void mouseClicked(MouseEvent e) {
        textField = (JTextField) e.getComponent();
        if(textField.getText().equals(placeholder)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }
    public void keyPressed(KeyEvent e){
        System.out.println(e.getKeyCode());
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}
