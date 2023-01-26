import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

public class Board extends JPanel implements ActionListener {

	//board width
	private final int B_WIDTH = 1500;
	//board height
	private final int B_HEIGHT = 800;
	//1 dot size (1 apple = 1 dot; 1 snake body =1 dot)
	private final int DOT_SIZE = 10;
	//all possible dot in the baord
	private final int ALL_DOTS = 12000;
	//random position of the apple
	private final int RAND_POS = 29;
	//game speed
	private final int DELAY;
	//count score
	private static int finalScore=0;
	private static int highScore;


	//two arrays store the x and y coordinates of all joints of a snake
	private final int x[] = new int[ALL_DOTS];
	private final int y[] = new int[ALL_DOTS];

	private int dots;
	private int apple_x;
	private int apple_y;
	public static boolean over=false;

	private boolean leftDirection = false;
	private boolean rightDirection = true;
	private boolean upDirection = false;
	private boolean downDirection = false;
	private boolean inGame = true;

	private Timer timer;
	private Image ball;
	private Image apple;
	private Image head;
	private JButton jbtMenu; //button to return to menu

	//constructor
	public Board(int speed) {
		this.DELAY=speed;
		initBoard();
		finalScore=0;
	}

	//this method return high score of the game
	public static int getScore() {
		return highScore;
	}

	//contruct board
	private void initBoard() {

		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);

		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		loadImages();
		initGame();
	}
	//load images of head dots and apple
	private void loadImages() {

		ImageIcon iid = new ImageIcon("image/dot.png");
		ball = iid.getImage();

		ImageIcon iia = new ImageIcon("image/apple.png");
		apple = iia.getImage();

		ImageIcon iih = new ImageIcon("image/head.png");
		head = iih.getImage();
	}

	//game constructor
	private void initGame() {

		dots = 3;

		for (int z = 0; z < dots; z++) {
			x[z] = 50 - z * 10;
			y[z] = 50;
		}

		locateApple();

		timer = new Timer(DELAY, this);
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		doDrawing(g);
	}

	//this method draw snake and apple
	private void doDrawing(Graphics g) {

		if (inGame) {

			g.drawImage(apple, apple_x, apple_y, this);

			for (int z = 0; z < dots; z++) {
				if (z == 0) {
					g.drawImage(head, x[z], y[z], this);
				} else {
					g.drawImage(ball, x[z], y[z], this);
				}
			}

			Toolkit.getDefaultToolkit().sync();

		} else {

			gameOver(g);
			//add a Menu button
			this.add(jbtMenu = addCustomButton("Back To Menu", 1000, 650, 200, 80, null,Color.white, Color.cyan, new Font("Comic Sans MS", Font.PLAIN, 25)));
			//register Action Listener for menu button
			jbtMenu.addActionListener(this);
			if(highScore<finalScore) {
				highScore=finalScore;
			}
		}        
	}

	private void gameOver(Graphics g) {
		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics metr = getFontMetrics(small);

		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
	}//game over 

	public JButton addCustomButton(String text, int x, int y, int width, int height,Border bd, Color fg, Color bg, Font font) {
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		button.setForeground(fg);
		button.setBackground(bg);
		button.setFont(font);
		button.setFocusable(false);
		button.setBorder(bd);
		return button;
	}//end of addCustomButton method

	private void checkApple() {

		if ((x[0] == apple_x) && (y[0] == apple_y)) {

			dots++;
			finalScore++;
			locateApple();
		}
	}//this method check collision with apple 


	//this method do movement mechanism
	private void move() {

		for (int z = dots; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (leftDirection) {
			x[0] -= DOT_SIZE;
		}

		if (rightDirection) {
			x[0] += DOT_SIZE;
		}

		if (upDirection) {
			y[0] -= DOT_SIZE;
		}

		if (downDirection) {
			y[0] += DOT_SIZE;
		}
	}

	//this method check collision with the wall and body 
	private void checkCollision() {

		for (int z = dots; z > 0; z--) {

			if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
				inGame = false;
			}
		}

		if (y[0] >= B_HEIGHT) {
			inGame = false;
		}

		if (y[0] < 0) {
			inGame = false;
		}

		if (x[0] >= B_WIDTH) {
			inGame = false;
		}

		if (x[0] < 0) {
			inGame = false;
		}

		if (!inGame) {
			timer.stop();
		}
	}

	//this method create apple
	private void locateApple() {

		int r = (int) (Math.random() * RAND_POS);
		apple_x = ((r * DOT_SIZE));

		r = (int) (Math.random() * RAND_POS);
		apple_y = ((r * DOT_SIZE));
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()==jbtMenu) {
			new MenuScreen(); //create new instance of MenuScreen with title
		}
		if (inGame) {

			checkApple();
			checkCollision();
			move();

		}

		repaint();
	}

	//input key to perform motion
	private class TAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
				leftDirection = true;
				upDirection = false;
				downDirection = false;
			}

			if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
				rightDirection = true;
				upDirection = false;
				downDirection = false;
			}

			if ((key == KeyEvent.VK_UP) && (!downDirection)) {
				upDirection = true;
				rightDirection = false;
				leftDirection = false;
			}

			if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
				downDirection = true;
				rightDirection = false;
				leftDirection = false;
			}
		}
	}
}