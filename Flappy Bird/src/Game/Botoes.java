package Game;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.JButton;	

public class Botoes implements ActionListener {

	private boolean start=false, stop=false, reset=false;

	public void setReset()
	{
		reset=false;
	}

	public void setStart(boolean start)
	{
		this.start=start;
	}


	public boolean getStart()
	{
		return start;
	}

	public boolean getReset()
	{
		return reset;
	}

	public boolean getStop()
	{
		return stop;
	}

	public void actionPerformed(ActionEvent evento)
	{
		JButton botao= (JButton) evento.getSource();
		String escolha=botao.getText();
		if(escolha.equals("Iniciar"))
		{
			start=true;
		}
		else
			if(escolha.equals("Tentar Novamente"))
			{
				reset=true;
			}
			else
				if(escolha.equals("Desistir"))
				{
					stop=true;
				}

	}

}
