package View;

/**
 * Created by Zaboon on 11/22/2015.
 */

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * {@link Button} is used for create the button.
 *
 * @author Nicolas Pinatel
 */

public class Button extends JButton {
	private String name;
	private Font police = new Font("Arial", Font.BOLD, 20);

	/**
	 *  Just call the constructor of JButton, set the name and the font.
	 */
	public Button(String str) {
		super(str);
		this.name = str;
		this.setFont(police);
	}
}
