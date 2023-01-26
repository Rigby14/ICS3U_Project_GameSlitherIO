import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Snake extends Base implements ActionListener{

	private final Font TITLE_FONT = new Font("Calibri", Font.BOLD, 40);
	private Color transparentcolor = new Color(0f,0f,0f,.0f );

	private JButton pauseButton;

	private int score;
	private int gameSpeed;

	public Snake(int speed) {
		this.gameSpeed = speed;//adjusting game speed
		initUI();

	}

	private void initUI() {

		score = Board.getScore();

		pauseButton = addCustomButton("||",50,50,40,40,null,Color.white,Color.cyan,TITLE_FONT);
		pauseButton.setPreferredSize(new Dimension(50, 20));
		pauseButton.addActionListener(this);


		this.add(new Board(gameSpeed),BorderLayout.CENTER);//add game
		this. setResizable(false);
		this. pack();
		this.setTitle("Snake");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//add pause button and go to difficulty screen
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(20,0));
		panel.add(pauseButton);
		panel.setBackground(Color.WHITE);
		//ingmae thumbnail
		panel.add(addCustomLabel("S", Color.black, TITLE_FONT));
		panel.add(addCustomLabel("I", transparentcolor, TITLE_FONT));//add balnk
		panel.add(addCustomLabel("N", Color.black, TITLE_FONT));
		panel.add(addCustomLabel("I", transparentcolor, TITLE_FONT));//add blank
		panel.add(addCustomLabel("A", Color.black, TITLE_FONT));
		panel.add(addCustomLabel("I", transparentcolor, TITLE_FONT));//add blank
		panel.add(addCustomLabel("K", Color.black, TITLE_FONT));
		panel.add(addCustomLabel("I", transparentcolor, TITLE_FONT));//add blank
		panel.add(addCustomLabel("E", Color.black, TITLE_FONT));
		panel.add(addCustomLabel("I", transparentcolor, TITLE_FONT));//add blank
		//highscore display
		panel.add(addCustomLabel("High Score"+score, Color.black, TITLE_FONT));
		this.add(panel, BorderLayout.WEST);


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==pauseButton) {

			this.dispose(); //get rid of current frame
			new DifficultyScreen(); //create new instance of MenuScreen with title
		}


	}

}