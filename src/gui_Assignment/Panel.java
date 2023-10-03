package gui_Assignment;

import java.awt.Dimension;
import java.awt.Graphics;
import static gui_Assignment.Game.framewidth;
import static gui_Assignment.Game.framehight;
//import static gui_Assignment.game.UNIT_SIZE;
import javax.swing.JPanel;

public class Panel extends JPanel {

	private MouseInput mouseInputs;
	private Game game;

	public Panel(Game game) {
		this.game = game;
		this.setPreferredSize(new Dimension(framewidth, framehight));
		this.mouseInputs = new MouseInput(this);
		addMouseListener(mouseInputs);
	}

	public Game getGame() {
		return game;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// for(int i=0;i<framehight/UNIT_SIZE;i++) {
		// g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, framehight);
		// g.drawLine(0, i*UNIT_SIZE, framewidth, i*UNIT_SIZE);
		// }
		// System.out.print(1);
		game.draw(g);

	}

}
