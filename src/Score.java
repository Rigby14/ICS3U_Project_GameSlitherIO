import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Score extends Base implements ActionListener{
	private ImageIcon bg; //background image
	private JButton jbtMenu; //button to return to menu
	private ImageIcon instruction;
	private JTable table;
	private int maxRows =DifficultyScreen.getTries();
	private final int MAXCOLS = 2;
	private int[] scores;
	private Object[][] data= new Object[maxRows][MAXCOLS];
	private String[] columm={"Tries ","High Score"};
	private int row=0;
	private int cols=0;
	private int recentTries;
	private boolean triesIncreased;
	private int highscore;
	
	public Score() {
		super();
		
		//add a Menu button
		this.add(jbtMenu = addCustomButton("Back To Menu", 1000, 650, 200, 80, null,Color.white, Color.cyan, new Font("Comic Sans MS", Font.PLAIN, 25)));
		//register Action Listener for menu button
		jbtMenu.addActionListener(this);
		
		if (recentTries!=DifficultyScreen.getTries())
		{
			recentTries = DifficultyScreen.getTries();
			triesIncreased = true;
		}
		if(triesIncreased) {
			data[row][cols]=DifficultyScreen.getTries();
			cols++;
			data[row][cols]=Board.getScore();
			row++;
		}//get tries and score to add to table
		
		table = new JTable(data,columm);
		table.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(table);
		
		
        
		//add canvas to JFrame
		this.add(sp);
		this.setVisible(true);
	}
	
	/**
	 * This method is implemented from the ActionListener interface. Each action performed leads to a different scenario.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtMenu) {
			new MenuScreen();
			this.dispose();
		}
	}//end of actionPerformed method
}