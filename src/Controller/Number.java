package Controller;

/**
 * Created by Zaboon on 11/21/2015.
 */
import Model.Window;
import View.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * {@link Number} is here to handle the numbers, equal and dot.
 *
 * @author Nicolas Pinatel
 */

public class Number extends JPanel{
    private Button tab_Number[] = new Button[12];
    private Window refWin;

    /**
     * Add the numbers and set thems.
     * @param win is the window.
     */
    public Number(Window win){
        this.refWin = win;
        this.setPreferredSize(new Dimension(300, 400));
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        this.tab_Number[0] = new Button("7");
        this.tab_Number[1] = new Button("8");
        this.tab_Number[2] = new Button("9");
        this.tab_Number[3] = new Button("4");
        this.tab_Number[4] = new Button("5");
        this.tab_Number[5] = new Button("6");
        this.tab_Number[6] = new Button("1");
        this.tab_Number[7] = new Button("2");
        this.tab_Number[8] = new Button("3");
        this.tab_Number[9] = new Button("0");
        this.tab_Number[10] = new Button(".");
        this.tab_Number[11] = new Button("=");

        for (int i = 0; i < 11; i++){
            this.tab_Number[i].addActionListener(new NumberListener());
        }
        this.tab_Number[11].addActionListener(new equalListener());
        GridLayout grid = new GridLayout(4, 3, 5, 5);
        this.setLayout(grid);
        for (int i = 0; i < tab_Number.length; i++){
            this.add(this.tab_Number[i]);
        }
    }

    /**
     * Get if there is a need to put a dot. If not simply put the number with setDisplay.
     */
    class NumberListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (((Button)e.getSource()).getText() == "."){
                if (refWin.getnb1() == null){
                    if (!refWin.getDot1()){
                        refWin.setDisplay(refWin.getDisplay() + ((Button)e.getSource()).getText());
                        refWin.setDot1(true);
                    }
                }
                else if (refWin.getnb2() == null){
                    if (!refWin.getDot2()){
                        refWin.setDisplay(refWin.getDisplay() + ((Button)e.getSource()).getText());
                        refWin.setDot2(true);
                    }
                }
                refWin.setErase(false);
            }
            else {
                if (refWin.getErase()){
                    refWin.setDisplay(((Button)e.getSource()).getText());
                    refWin.setErase(false);
                }
                else {
                    refWin.setDisplay(refWin.getDisplay() + ((Button)e.getSource()).getText());
                }
            }
        }
    }

    /**
     * Interract when the user click on the equal
     */
    class equalListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (refWin.doIt()){
                refWin.setnb2(refWin.getDisplay());
                refWin.calcul();
            }
        }
    }

}