package Model;

/**
 * Created by Zaboon on 11/21/2015.
 */

import java.awt.*;
import Controller.Number;
import Controller.Operator;
import View.Screen;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * {@link Window} is used for initiallazing the window, numbers, and OP.
 *
 * @author Nicolas Pinatel
 */

public class Window extends JFrame {
	private Screen Screen;
	private String nb1 = null;
	private String nb2 = null;
	private String opp = null;
	private boolean toErase = true;
	private boolean isDot1 = false;
	private boolean isDot2 = false;

    /**
     *  Init the window, set the Title, the Size and not resizable. Then initialize the numbers and the operator and the Screen
     *  Set the Layout and set the positionss of the three parts.
     *  Calcul with two double
     */
	public Window() {

		this.setTitle("SimpleCount by Zabo0n Hacking xx");
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		JPanel opp = new Operator(this);
		JPanel Number = new Number(this);
		this.Screen = new Screen();


		this.setLayout(new BorderLayout());
		this.getContentPane().add(Screen, BorderLayout.NORTH);
		this.getContentPane().add(Number, BorderLayout.WEST);
		this.getContentPane().add(opp, BorderLayout.CENTER);

		this.setVisible(true);
	}

	/**
	 *  Used in order to calcul the expression
	 *  Calcul with two double
	 */

	public void calcul(){
		Double res1;
		Double res2;
		Double res;

		res1 = Double.valueOf(this.nb1).doubleValue();
		res2 = Double.valueOf(this.nb2).doubleValue();

		if (this.opp == "+"){
			res = res1 + res2;
			this.setDisplay(String.valueOf(res));
		}
		else if (this.opp == "-") {
			res = res1 - res2;
			this.setDisplay(String.valueOf(res));
		}
		else if (this.opp == "*") {
			res = res1 * res2;
			this.setDisplay(String.valueOf(res));
		}
		else if (this.opp == "/") {
			if (res2 != 0 || res1 != 0){
				res = res1 / res2;
				this.setDisplay(String.valueOf(res));
			}
			else{
				this.setDisplay("Math Error !");
			}

		}
        else if (this.opp == "%") {
            res = res1 % res2;
            this.setDisplay(String.valueOf(res));
        }
        else if (this.opp == "√") {
            res = java.lang.Math.sqrt(res1);
            this.setDisplay(String.valueOf(res));
        }
        else if (this.opp == "+/-") {
            res = res1 * -1;
            this.setDisplay(String.valueOf(res));
        }
		else if (this.opp == "²") {
			res = res1 * res1;
			this.setDisplay(String.valueOf(res));
		}
		if (getDisplay() == "Math Error !")
			this.nb1 = null;
		else
			this.nb1 = getDisplay();
		this.opp = null;
		this.nb1 = null;
		this.nb2 = null;
		this.isDot2 = false;
		this.isDot1 = false;
		this.toErase = true;
	}

	/**
	 *  Setters and getters.
	 */
	public void setDisplay(String str){
        this.Screen.setDisplay(str);
	}

	public String getDisplay(){
        return (this.Screen.getDisplay());
	}

	public String getnb1() {
        return (this.nb1);
	}

	public String getnb2() {
        return (this.nb2);
	}

	public void setnb1(String str){
		this.nb1 = str;
	}

	public void setnb2(String str){
		this.nb2 = str;
	}

	public String getOperator() {
        return (this.opp);
	}

	public void setOperator(String str){
		this.opp = str;
	}

	public boolean getErase() {
        return (this.toErase);
	}

	public boolean getDot1(){
        return (this.isDot1);
	}

	public boolean getDot2(){
		return (this.isDot2);
	}

	public void setDot1(boolean b){
		this.isDot1 = b;
	}

	public void setDot2(boolean b){
		this.isDot2 = b;
	}

	public void setErase(boolean b){
        this.toErase = b;
	}

	public boolean doIt(){
		if (this.nb1 != null && this.opp != null) {
			return (true);
		}
		return (false);
	}
}
