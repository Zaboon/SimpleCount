package View;

/**
 * Created by Zaboon on 11/22/2015.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * {@link Window} Create the screen.
 *
 * @author Nicolas Pinatel
 */

public class Screen extends JPanel {
    private Font police = new Font("Arial", Font.BOLD, 40);
    private Dimension dim = new Dimension(400, 100);
    private JLabel Screen;

    /**
     *  Set the dimensions, then create the zero.
     */
    public Screen(){
        this.setPreferredSize(dim);

        Screen = new JLabel("0");
        Screen.setPreferredSize(new Dimension(380, 90));
        Screen.setFont(police);
        Screen.setHorizontalAlignment(JLabel.RIGHT);
        this.add(Screen);
    }

    public void setDisplay(String str){
        Screen.setText(str);
    }

    public String getDisplay(){
        return (Screen.getText());
    }
}