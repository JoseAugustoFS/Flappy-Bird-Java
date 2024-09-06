package Game;

import javax.swing.JFrame;

import javax.swing.JLayeredPane;

import javax.swing.JLabel;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JButton;

public class Main {

	public static void main(String[] args)
	{
		JFrame janela = new JFrame("Flappy Bird");
		JLayeredPane painel = new JLayeredPane();
		JLabel inicio = new JLabel("Flappy Bird");
		JLabel fim = new JLabel("FIM!!!");
		JButton start = new JButton("Iniciar");
		JButton reset = new JButton("Tentar Novamente");
		JButton stop = new JButton("Desistir");
		Font texto = new Font("Texto",Font.PLAIN,60);
		Font botao = new Font("Botao",Font.PLAIN,20);



		Cenario cenario = new Cenario();
		Bird passaro = new Bird();
		GameThread fundo = new GameThread("Cenario",cenario,passaro);
		GameThread ave = new GameThread("Passaro",cenario,passaro);
		Botoes escolha = new Botoes();

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(700, 400);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setVisible(true);
		janela.getContentPane().setBackground(new Color(110,210,255));
		painel.setBounds(0, 0, 700, 400);
		cenario.setBounds(0, 0, 700, 400);
		cenario.setOpaque(false);
		cenario.setVisible(false);
		passaro.setBounds(0, 0, 700, 400);
		passaro.setOpaque(false);
		passaro.setVisible(false);
		inicio.setBounds(180, -80, 500, 300);
		inicio.setFont(texto);
		start.setBounds(255, 150, 150, 70);
		start.setFont(botao);
		fim.setBounds(270, -150, 500, 500);
		fim.setFont(texto);
		reset.setBounds(200, 150, 300, 50);
		reset.setFont(botao);
		stop.setBounds(200, 250, 300, 50);
		stop.setFont(botao);

		painel.add(fim);
		painel.add(reset);
		painel.add(stop);
		painel.add(inicio);
		painel.add(start);
		painel.add(passaro);
		painel.add(cenario);

		stop.addActionListener(escolha);
		reset.addActionListener(escolha);
		start.addActionListener(escolha);
		janela.add(painel);
		janela.setFocusable(true);
		janela.addKeyListener(ave.tecla);

		Thread thread_fundo = new Thread(fundo);
		Thread thread_passaro = new Thread(ave);

		boolean end =false;
		while(!escolha.getStop())
		{
			System.out.flush();
			fim.setVisible(end);
			reset.setVisible(end);
			stop.setVisible(end);
			
			System.out.flush();
			if(escolha.getStart())
			{

				cenario.setVisible(true);
				passaro.setVisible(true);
				inicio.setVisible(false);
				start.setVisible(false);

				thread_fundo.start();
				thread_passaro.start();

				try {
					thread_passaro.join();
					fundo.Parar();
					thread_fundo.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				end=true;
				escolha.setStart(false);
			}
			if(escolha.getReset())
			{
				fundo.Reset();
				ave.Reset();
				thread_fundo = new Thread(fundo);
				thread_passaro = new Thread(ave);
				end=false;
				escolha.setReset();
				escolha.setStart(true);
			}
			if(escolha.getStop())
				System.exit(0);

		}

	}
}
