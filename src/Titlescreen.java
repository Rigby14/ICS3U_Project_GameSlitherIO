import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.border.Border;

public class Titlescreen {
	//instance variables
	private JButton jbtnext; //Next button
	//Constants for the title font and color so we can change them easily if needed
	private final Font TITLE_FONT = new Font("Times new Roman", Font.BOLD, 40);
	private final Color TITLE_COLOR = Color.black;
	Image img = Toolkit.getDefaultToolkit().getImage("pixel-art.gif");
	Image newImage = img.getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
	JFrame titleframe;

	//this medthod create a custom Jlabel
	private JLabel addCustomLabel(String text, Color fg, Font font) {
		JLabel label = new JLabel(text);
		label.setForeground(fg);
		label.setFont(font);
		return label;
	}//end of create label method
	
	
	//this method create a Frame
	private JFrame screenFrame() throws IOException 
	{
		JFrame titleframe = new JFrame();
		titleframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleframe.setContentPane(new JLabel(new ImageIcon(newImage)));

		titleframe.setSize(1500, 800); //setting size of all game screens
		titleframe.setResizable(false); //user cannot resize frame
		titleframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set default close operation
		
		return titleframe;
	}//end of create frame method
	

	public Titlescreen() throws IOException
	{
		//create frame and drawbackground
		screenFrame();
		titleframe = screenFrame();
		titleframe.setLayout(new FlowLayout(FlowLayout.CENTER+(-1000), 800, 30));
		titleframe.add(addCustomLabel("ICS3U Project Snake Game", Color.black, TITLE_FONT));
		titleframe.add(addCustomLabel("Orjouan and Rigby", Color.black, TITLE_FONT));
		titleframe.add(addCustomLabel("", Color.black, TITLE_FONT));
		titleframe.add(addCustomLabel("", Color.black, TITLE_FONT));
		
		JButton button = new JButton("NEXT");
		button.setBounds(200,75,100,50);
		button.setForeground(Color.white);
		button.setBackground(Color.black);
		button.setFont(TITLE_FONT);
		
		titleframe.add(button);

		//Set Visible again because FlowLayout needs it to be set last
		titleframe.setVisible(true);


	}
	

}
