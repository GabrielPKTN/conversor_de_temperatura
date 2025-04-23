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
		tela.setSize(360, 400);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setTitle("Conversor de Temperatura");
		
		Container container = tela.getContentPane();
		
		textCelsius = new JTextField();
		textCelsius.setBounds(50, 70, 250, 25);
		
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius:");
		labelCelsius.setBounds(50, 40, 200, 30);
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(50, 100, 120, 30);
		
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setBounds(180, 100, 120, 30);
		
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonKelvin);
		container.add(buttonFahreinheit);
		
		tela.setVisible(true);
	}
	
}