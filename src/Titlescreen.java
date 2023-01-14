import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Titlescreen extends Base implements ActionListener{
	//instance variables
	private JButton jbtnext; //Next button
	//Constants for the title font and color so we can change them easily if needed
	private final Font TITLE_FONT = new Font("Times new Roman", Font.BOLD, 40);
	private final Color TITLE_COLOR = Color.black;
	private Color transparentcolor = new Color(0f,0f,0f,.0f );
	private Color transparentRed = new Color(0f,0f,.1f,.5f);
	Border border = BorderFactory.createLineBorder(transparentRed, 5);
	


	public Titlescreen() throws IOException
	{
		//create frame and drawbackground
		super();
		this.setContentPane(new JLabel(new ImageIcon(newImage)));
		JPanel[][] panelHolder = new JPanel[8][15];
		this.setLayout(new GridLayout(15,16));
	
		//add introduction about project
		this.add(addCustomLabel("ICS3U Project Snake Game", Color.black, TITLE_FONT));
		this.add(addCustomLabel("ICS3U Project Snake Game", transparentcolor, TITLE_FONT));
		this.add(addCustomLabel("-------------------------------------", Color.black, TITLE_FONT));
		this.add(addCustomLabel("ICS3U Project Snake Game", transparentcolor, TITLE_FONT));
		this.add(addCustomLabel("Orjouan and Rigby", Color.black, TITLE_FONT));
		for (int i =0;i<20;i++) {
			this.add(addCustomLabel("", Color.black, TITLE_FONT));
		}
		
		jbtnext = addCustomButton("Next",200, 75,null, Color.white, Color.cyan, new Font("Comic Sans MS", Font.BOLD, 20));
		jbtnext.addActionListener(this); //register action listener so actions can be performed when pressed
		this.add(jbtnext); //add Next button to the frame

		//Set Visible again because FlowLayout needs it to be set last
		this.setVisible(true);


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jbtnext) {
			this.dispose(); //get rid of current frame
			new MenuScreen(); //create new instance of MenuScreen with title
		}
		
	}
	

}
