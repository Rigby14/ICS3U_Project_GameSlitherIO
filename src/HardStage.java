import java.awt.EventQueue;

import javax.swing.JFrame;

public class HardStage {

	public HardStage() {
		super();
		newGame();
	}
	//this medthod create new game
	public void newGame() {
		EventQueue.invokeLater(() -> {
			JFrame ex = new Snake(70);
			ex.setVisible(true);
		});
	}
}
