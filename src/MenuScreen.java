import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuScreen extends Base implements ActionListener{
	//Instance variables
	private ImageIcon bg, bgGif; //background image of menu screen and the background gif that will be put on labelGif
	private JButton jbtPlay ,jbtInstructions, jbtScores, jbtExit; //action buttons
	private PaintPanel canvas; //all components are put on a PaintPanel which holds the background image
	private JLabel heading, labelGif; //the heading label of the Main Menu and the label that will hold bgGif
	private final Color MENU_COLOR_FG = Color.white, MENU_COLOR_BG = Color.cyan; //constant colors of menu button foreground and background respectively
	private final Font MENU_FONT = new Font("Comic Sans MS", Font.PLAIN, 25); //constant font of menu buttons
	
	//Constructor for MenuScreen
	MenuScreen(){
		super(); //calls ScreenFrame constructor creating a new ScreenFrame
		
		//set a background image
		bg = new ImageIcon(newImage);
		//instantiate canvas and set null layout manager of canvas so we can manually place components
		canvas = new PaintPanel();
		canvas.setLayout(null);
		this.add(canvas); //add canvas to frame
		
		bgGif = new ImageIcon("image/de5ksot-446db78d-9414-4674-9a99-4925135cfbde.gif");
		labelGif = new JLabel(bgGif);
		canvas.add(labelGif);
		labelGif.setBounds(130, 250, 500, 400);
		
		//add a custom label for the heading
		canvas.add(heading = addCustomLabel("Snake 3imu14t0R", Color.cyan, new Font("Comic Sans MS", Font.BOLD, 60)));
		heading.setBounds(50, 25, 900, 150); //set bounds for the heading on the canvas
		
		//add the Play button
		jbtPlay = addCustomButton("Play", 750, 180, 200, 80,null, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		canvas.add(jbtPlay); //add to canvas
		jbtPlay.addActionListener(this); //register action listener
		
		
		//add the Instructions button
		jbtInstructions = addCustomButton("Instructions", 750, 300, 200, 80,null, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		canvas.add(jbtInstructions); //add to canvas
		jbtInstructions.addActionListener(this); //register action listener
		

		//add the Scores button
		jbtScores = addCustomButton("Scores", 750, 420, 200, 80,null, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		canvas.add(jbtScores); //add to canvas
		jbtScores.addActionListener(this); //register action listener


		//add the Exit button
		jbtExit = addCustomButton("Exit", 750, 540, 200, 80,null, MENU_COLOR_FG, MENU_COLOR_BG, MENU_FONT);
		canvas.add(jbtExit); //add to canvas
		jbtExit.addActionListener(this); //register action listener

		
	}//end of MenuScreen constructor

	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//different scenarios for each button
		if(e.getSource() == jbtPlay) {
			//create new instance of DifficultyScreen
			new DifficultyScreen();
			this.dispose(); //get rid of current frame
		}
		else if(e.getSource() == jbtInstructions) {
			//create new instance of InstructionsScreen
			new InstructionsScreen();
			this.dispose();//get rid of current frame
		}
		else if(e.getSource() == jbtScores) {
			//create new instance of ScoreScreen
			new Score();
			this.dispose(); //get rid of current frame
		}
		//exit button exits the program
		else if(e.getSource() == jbtExit) {
			//exit the program
			System.exit(0);
		}
	}//end of actionPerformed method
	
	/*
	 * This class is a canvas that draws the background image. All components are added to this Panel, then the
	 * PaintPanel is added to the JFrame.
	 */
	class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g); //override the paintComponent method
			//draw the background image to fill the entire panel
			g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}//end of paintComponent method
	}

}