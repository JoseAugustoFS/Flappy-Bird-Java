package Game;

import java.awt.Color;

import javax.swing.JLabel;

public class GameThread implements Runnable {

	private String nome;
	private boolean parar;

	private Cenario fundo;
	private Bird passaro;
	Teclado tecla = new Teclado();
	JLabel placar = new JLabel();

	public GameThread(String nome, Cenario fundo, Bird passaro)
	{
		this.nome=nome;
		this.parar = false;
		this.fundo=fundo;
		this.passaro=passaro;

	}

	private int x_cano=465, y_bird=150, tempo_pulo=0,pontuacao=0;
	public void Reset()
	{
		x_cano=465; y_bird=150; tempo_pulo=0;
		fundo.iniciarAlturas();
		parar=false;
	}

	@Override
	public void run() {


		fundo.iniciarAlturas();
		while(!parar)
		{
			try {
				if(this.nome.equals("Cenario"))
				{
					x_cano--;
					if(x_cano+50==0)
					{
						x_cano=150;
						fundo.arrumarAlturas();
					}
					fundo.repaint();
					fundo.setX(x_cano);

					placar.setForeground(Color.black);
					placar.setText("Pontuação: "+pontuacao);
					placar.setBounds(20,0,90,40);
					fundo.add(placar);

					if(x_cano==35)
						pontuacao++;

					Thread.sleep(35);
				}
				if(this.nome.equals("Passaro"))
				{
					if((tecla.getPulo())&&(y_bird>=24))
						tempo_pulo=16;
					tecla.setPulo(false);
					if(tempo_pulo>0)
					{
						y_bird-=2;
						tempo_pulo--;
					}
					else
						y_bird++;


					passaro.repaint();
					passaro.setY(y_bird);

					Thread.sleep(20);

					if((y_bird>=338))
						parar=true;
					if(((y_bird<=fundo.getY0()-65)&&(fundo.getX0()==103))||((y_bird<=fundo.getY0()-25)&&(y_bird>=fundo.getY0()-65)&&(fundo.getX0()-10==103)))		
						parar=true;
					if(((y_bird>=fundo.getY0()+65)&&(fundo.getX0()==103))||((y_bird>=fundo.getY0()+25)&&(y_bird<=fundo.getY0()+65)&&(fundo.getX0()-10==103)))		
						parar=true;
					if(((fundo.getX0()-10>=31)&&(fundo.getX0()-10<=105))&&(((y_bird==fundo.getY0()-25)||(y_bird==fundo.getY0()+25))))
						parar=true;

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

	public synchronized void Parar()
	{
		this.parar=true;
	}



}
