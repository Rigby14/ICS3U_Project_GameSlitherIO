import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DifficultyScreen extends Base implements ActionListener{

	private JButton easybutton;
	private JButton mediumbutton;
	private JButton hardbutton;
	private JButton backButton;
	public static int tries=0;

	private Color transparentcolor = new Color(0f,0f,0f,.0f );//transparent colo to create a blank cell 

	private final Font FONT = new Font("Times new Roman", Font.BOLD, 40);

	public DifficultyScreen() {
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER,800,30));
		this.add(addCustomLabel("CHOOSE YOUR DIFFICULTY",Color.black,FONT));


		//create buttons
		easybutton = addCustomButton("EASY",200,75, null, Color.white,Color.cyan,FONT);
		mediumbutton = addCustomButton("MEDIUM",200,75, null, Color.white,Color.cyan,FONT);
		hardbutton = addCustomButton("HARD",200,75, null, Color.white,Color.cyan,FONT);

		//add button and register action listener
		this.add(easybutton);
		easybutton.addActionListener(this);
		this.add(mediumbutton);
		mediumbutton.addActionListener(this);
		this.add(hardbutton);
		hardbutton.addActionListener(this);

		//create and add back button the the frame
		this.add(addCustomLabel("ICS3U Project Snake Game", transparentcolor, FONT));//add blank
		this.add(addCustomLabel("ICS3U Project Snake Game", transparentcolor, FONT));//add blank
		backButton = addCustomButton("Back to Menu",600,75, null, Color.white,Color.cyan,FONT);
		this.add(backButton);
		backButton.addActionListener(this);


		//set visible after adding all components
		this.setVisible(true);
	}
	public static int getTries() {
		return tries;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() ==easybutton) {
			this.dispose();
			tries++;
			new EasyStage();
		}
		else if (e.getSource()==mediumbutton) {
			this.dispose();
			new MediumStage();
		}
		else if (e.getSource()== hardbutton) {
			this.dispose();
			tries++;
			new HardStage();
		}
		//back to menu
		else if (e.getSource() == backButton) {
			this.dispose();
			tries++;
			new MenuScreen();
		}
	}


}
