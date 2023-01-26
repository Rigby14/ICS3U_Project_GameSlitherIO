import java.awt.EventQueue;

import javax.swing.JFrame;

public class MediumStage {

	public MediumStage() {
		super();
		newGame();
	}
	//this medthod create new game
	public void newGame() {
		EventQueue.invokeLater(() -> {
			JFrame ex = new Snake(110);
			ex.setVisible(true);
		});
	}
}
