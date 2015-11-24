package Controller;

/**
 * Created by Zaboon on 11/21/2015.
 */

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import Model.Window;
import View.Button;

/**
 * {@link Number} is here to handle the operator.
 *
 * @author Nicolas Pinatel
 */

public class Operator extends JPanel{
	private Button tab_Operator[] = new Button[9];
	private Window refWin;

	/**
	 * Add the operators and put them a listener.
	 * @param win is the window.
	 */
	public Operator(Window win){
		this.refWin = win;
        this.setPreferredSize(new Dimension(10, 400));
		this.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.tab_Operator[0] = new Button("C");
		this.tab_Operator[1] = new Button("/");
		this.tab_Operator[2] = new Button("*");
		this.tab_Operator[3] = new Button("-");
		this.tab_Operator[4] = new Button("+");
        this.tab_Operator[5] = new Button("√");
        this.tab_Operator[6] = new Button("%");
        this.tab_Operator[7] = new Button("+/-");
        this.tab_Operator[8] = new Button("²");

		this.tab_Operator[0].addActionListener(new clearListener());
		this.tab_Operator[1].addActionListener(new divListener());
		this.tab_Operator[2].addActionListener(new mulListener());
		this.tab_Operator[3].addActionListener(new subListener());
		this.tab_Operator[4].addActionListener(new addListener());
        this.tab_Operator[5].addActionListener(new sqrtListener());
        this.tab_Operator[6].addActionListener(new percentListener());
        this.tab_Operator[7].addActionListener(new lessListener());
		this.tab_Operator[8].addActionListener(new squareListener());

        //Layout def
		GridLayout grid = new GridLayout(5, 2, 5, 5);
		this.setLayout(grid);

		for (int i = 0; i < tab_Operator.length; i++){
			this.add(this.tab_Operator[i]);
		}
	}

	/**
	 * 'C' Listener.
	 * Set all (2 numbers and the operator) to zero, and set 0 on the window.
	 */
	class clearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			refWin.setnb1(null);
			refWin.setnb2(null);
			refWin.setOperator(null);
			refWin.setDisplay("0");
			refWin.setErase(true);
			refWin.setDot1(false);
			refWin.setDot2(false);
		}
	}

	/**
	 * '/' Listener.
	 * Check is the operator is not null. Then get the nb2 and calcul.
	 */
	class divListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (refWin.getOperator() != null) {
				refWin.setnb2(refWin.getDisplay());
				refWin.calcul();
			}
			else {
				refWin.setnb1(refWin.getDisplay());
			}
			refWin.setDisplay("0");
			refWin.setOperator("/");
			refWin.setErase(true);
		}
	}

	/**
	 * '*' Listener.
	 * Check is the operator is not null. Then get the nb2 and calcul.
	 */
	class mulListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (refWin.getOperator() != null) {
				refWin.setnb2(refWin.getDisplay());
				refWin.calcul();
			}
			else {
				refWin.setnb1(refWin.getDisplay());
			}
			refWin.setDisplay("0");
			refWin.setOperator("*");
			refWin.setErase(true);
		}
	}

	/**
	 * '-' Listener.
	 * Check is the operator is not null. Then get the nb2 and calcul. Reinit the display to 0
	 */
	class subListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (refWin.getOperator() != null) {
				refWin.setnb2(refWin.getDisplay());
				refWin.calcul();
			}
			else {
				refWin.setnb1(refWin.getDisplay());
			}
			refWin.setDisplay("0");
			refWin.setOperator("-");
			refWin.setErase(true);
		}
	}

	/**
	 * '+' Listener.
	 * Check is the operator is not null. Then get the nb2 and calcul. Reinit the display to 0
	 */
	class addListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (refWin.getOperator() != null) {
				refWin.setnb2(refWin.getDisplay());
				refWin.calcul();
			}
			else {
				refWin.setnb1(refWin.getDisplay());
			}
			refWin.setDisplay("0");
			refWin.setOperator("+");
			refWin.setErase(true);
		}
	}

	/**
	 * 'V' Listener.
	 * Check is the operator is not null then calcul. Reinit the display to 0
	 */
    class sqrtListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (refWin.getOperator() != null) {
                refWin.calcul();
            }
            else {
                refWin.setnb1(refWin.getDisplay());
            }
            refWin.setDisplay("0");
            refWin.setOperator("√");
            refWin.setErase(true);
        }
    }

	/**
	 * '%' Listener.
	 * Check is the operator is not null then calcul. Reinit the display to 0
	 */
	class percentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (refWin.getOperator() != null) {
                refWin.setnb2(refWin.getDisplay());
                refWin.calcul();
            }
            else {
                refWin.setnb1(refWin.getDisplay());
            }
            refWin.setDisplay("0");
            refWin.setOperator("%");
            refWin.setErase(true);
        }
    }

	/**
	 * '+/-' Listener.
	 * Check is the operator is not null then calcul. Reinit the display to 0
	 */
    class lessListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (refWin.getOperator() != null) {
                refWin.calcul();
            }
            else {
                refWin.setnb1(refWin.getDisplay());
            }
            refWin.setDisplay("0");
            refWin.setOperator("+/-");
            refWin.setErase(true);
        }
    }

	/**
	 * '²' Listener.
	 * Check is the operator is not null then calcul. Reinit the display to 0
	 */
	class squareListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (refWin.getOperator() != null) {
				refWin.calcul();
			}
			else {
				refWin.setnb1(refWin.getDisplay());
			}
			refWin.setDisplay("0");
			refWin.setOperator("²");
			refWin.setErase(true);
		}
	}
}