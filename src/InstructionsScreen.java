import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class InstructionsScreen extends Base implements ActionListener{
	private ImageIcon bg; //background image
	private PaintPanel canvas; //PaintPanel that the background image will be drawn on
	private JButton jbtMenu; //button to return to menu
	
	public InstructionsScreen() {
		super();
		bg = new ImageIcon("Instruction.png"); //set background image
		canvas = new PaintPanel();
		canvas.setLayout(null); //set layout of canvas to null so we can manually set buttons
		//add a Menu button
		canvas.add(jbtMenu = addCustomButton("Back To Menu", 1000, 650, 200, 80, null,Color.black, Color.pink, new Font("Comic Sans MS", Font.PLAIN, 25)));
		//register Action Listener for menu button
		jbtMenu.addActionListener(this);
		//add canvas to JFrame
		this.add(canvas);
	}//end of InstructionsScreen contructor
	
	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtMenu) {
			new MenuScreen();
			this.dispose();
		}
	}//end of actionPerformed method
	
	/*
	 * This class is a canvas that draws the background image. All components are added to this Panel, then the
	 * PaintPanel is added to the JFrame.
	 */
	class PaintPanel extends JPanel{
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			//draw the background image
			g.drawImage(bg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
		}//end of paintComponent method
	}
}