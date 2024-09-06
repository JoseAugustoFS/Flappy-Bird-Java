package Game;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JPanel;

import java.util.Random;

@SuppressWarnings("serial")
public class Cenario extends JPanel {




	private final int QUANTIDADE=5;


	private int x0;
	private int[] y = new int[QUANTIDADE];

	Random aleatorio = new Random();

	public void setX(int x0)
	{
		this.x0=x0;
	}

	public int getY0()
	{
		return y[0];
	}
	public int getX0()
	{
		return x0;
	}

	public void arrumarAlturas()
	{
		for(int i=0;i<QUANTIDADE-1;i++)
			y[i]=y[i+1];
		y[QUANTIDADE-1]=aleatorio.nextInt(100)+100;
	}

	public void iniciarAlturas()
	{
		for(int i=0;i<QUANTIDADE;i++)
			y[i]=aleatorio.nextInt(100)+100;
	}

	public void paintComponent(Graphics g)
	{

		int[] x = new int[QUANTIDADE];
		x[0]=x0;
		for(int i=1;i<QUANTIDADE;i++)
		{
			x[i]=x[i-1]+200;
		}

		g.setColor(new Color(110,210,255));
		g.fillRect(0, 0, 700, 400);
		g.setColor(Color.WHITE);
		g.fillOval(70, 40, 130, 50);
		g.fillOval(370, 140, 130, 50);
		g.fillOval(100, 300, 130, 50);
		g.fillOval(650, 50, 130, 50);


		for(int i=0;i<QUANTIDADE;i++)
		{
			g.setColor(Color.black);
			g.fillRect(x[i]-1,0,52,y[i]-50);
			g.fillRect(x[i]-1,y[i]+50,52,300);
			g.fillRect(x[i]-11,y[i]-61,72,37);
			g.fillRect(x[i]-11,y[i]+49,72,37);

			g.setColor(Color.green);
			g.fillRect(x[i],0,50,y[i]-50);
			g.fillRect(x[i],y[i]+50,50,300);
			g.fillRect(x[i]-10,y[i]-60,70,35);
			g.fillRect(x[i]-10,y[i]+50,70,35);
		}




	}

}
