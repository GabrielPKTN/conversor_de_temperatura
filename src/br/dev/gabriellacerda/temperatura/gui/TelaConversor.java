package br.dev.gabriellacerda.temperatura.gui;

import java.awt.Container;

import javax.swing.*;

public class TelaConversor {
	private JTextField textCelsius;
	
	private JLabel labelCelsius;
	
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	
	private JLabel labelResultado;
	private JLabel labelMensagemErro;

	public void criarTelaConversor() {
		
		JFrame tela = new JFrame();
		tela.setSize(400, 400);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		
		Container container = tela.getContentPane();
		
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius:");
		labelCelsius.setBounds(50, 40, 200, 30);
		
		textCelsius = new JTextField();
		textCelsius.setBounds(45, 70, 300, 25);
		
		
		
		
		container.add(labelCelsius);
		container.add(textCelsius);
		
		tela.setVisible(true);
	}
	
}