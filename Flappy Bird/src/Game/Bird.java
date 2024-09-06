package Game;

import javax.swing.JPanel;

import java.awt.Graphics;

import java.awt.Color;

@SuppressWarnings("serial")
public class Bird extends JPanel {

	private int y;
	private int x=80;


	public void setY(int y)
	{
		this.y=y;
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(Color.black);
		g.fillOval(x-1, y-1, 25, 25);
		g.fillOval(x+18, y+5, 12, 7);

		g.setColor(new Color(255,80,80));
		g.fillOval(x, y, 23, 23);
		g.setColor(Color.yellow);
		g.fillOval(x+18, y+5, 11, 6);
		g.setColor(new Color(155,0,0));
		g.fillOval(x, y+7, 18, 13);
		g.setColor(Color.black);
		g.fillOval(x+11, y+2, 5, 5);
	}

}
