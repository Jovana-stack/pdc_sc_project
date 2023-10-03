package gamestates;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import gui_Assignment.Game;

public class continueoption extends state implements statemethods {

	Font Moneyfont; 
	Font otherfont;
	
	public continueoption(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		
		this.Moneyfont = new Font("Monospaced", Font.BOLD, 70);
		this.otherfont = new Font("Monospaced", Font.BOLD, 40);
		
	}

	@Override
	public void update() {
		
		
	}

	@Override
	public void draw(Graphics g) {
		int offsetx;
		
		offsetx = centertext(g,otherfont,"you can save this money or risk it for more",900);
		g.drawString("you can save this money or risk it for more", offsetx, 220);
		offsetx = centertext(g,Moneyfont,""+game.getUser().getMoney(),900);
		g.drawString(""+game.getUser().getMoney(), offsetx, 300);
		
		
		
		
		
		
	}
	
	
	
	public int centertext(Graphics g, Font f, String text, int sizeX) {
		g.setFont(f);
		int width = g.getFontMetrics().stringWidth(text);
		int offset = (sizeX - width) / 2;

		return offset;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
