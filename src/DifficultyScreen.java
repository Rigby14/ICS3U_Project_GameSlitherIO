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
	
	private Color transparentcolor = new Color(0f,0f,0f,.0f );
	
	private final Font TITLE_FONT = new Font("Times new Roman", Font.BOLD, 40);
	
	public DifficultyScreen() {
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER,800,30));
		this.add(addCustomLabel("CHOOSE YOUR DIFFICULTY",Color.black,TITLE_FONT));
		//this.setContentPane(new JLabel(new ImageIcon("addimage here")));//add image
		
		easybutton = addCustomButton("EASY",200,75, null, Color.white,Color.black,TITLE_FONT);
		mediumbutton = addCustomButton("MEDIUM",200,75, null, Color.white,Color.black,TITLE_FONT);
		hardbutton = addCustomButton("HARD",200,75, null, Color.white,Color.black,TITLE_FONT);
		
		
		this.add(easybutton);
		easybutton.addActionListener(this);
		this.add(mediumbutton);
		mediumbutton.addActionListener(this);
		this.add(hardbutton);
		hardbutton.addActionListener(this);
		
		this.add(addCustomLabel("ICS3U Project Snake Game", transparentcolor, TITLE_FONT));
		this.add(addCustomLabel("ICS3U Project Snake Game", transparentcolor, TITLE_FONT));
		backButton = addCustomButton("Back to Menu",600,75, null, Color.white,Color.black,TITLE_FONT);
		this.add(backButton);
		backButton.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() ==easybutton) {
			this.dispose();
			new EasyStage();
		}
		else if (e.getSource()==mediumbutton) {
			this.dispose();
			new MediumStage();
		}
		else if (e.getSource()== hardbutton) {
			this.dispose();
			new HardStage();
		}
		//back to menu
		else if (e.getSource() == backButton) {
			this.dispose();
			new MenuScreen();
		}
	}
	
	
}
