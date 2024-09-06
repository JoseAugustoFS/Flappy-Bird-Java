package Game;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

public class Teclado extends KeyAdapter {


	private boolean pulo = false;

	public boolean getPulo()
	{
		return pulo;
	}

	public void setPulo(boolean pulo)
	{
		this.pulo=pulo;
	}

	public void keyPressed(KeyEvent e)
	{
		int tecla = e.getKeyCode();

		if((tecla==KeyEvent.VK_W)||(tecla==KeyEvent.VK_UP))
		{
			pulo=true;
		}

	}

}
