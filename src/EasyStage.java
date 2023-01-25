import java.awt.EventQueue;

import javax.swing.JFrame;

public class EasyStage {

	public EasyStage() {
		super();
		newGame();
	}
	public void newGame() {
		EventQueue.invokeLater(() -> {
            JFrame ex = new Snake(140);
            ex.setVisible(true);
        });
	}
}
