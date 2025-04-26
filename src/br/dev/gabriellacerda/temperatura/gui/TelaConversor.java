package br.dev.gabriellacerda.temperatura.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import br.dev.gabriellacerda.temperatura.model.Temperatura;

public class TelaConversor {
	private JTextField textCelsius;
	
	private JLabel labelCelsius;
	
	private JButton buttonKelvin;
	private JButton buttonFahreinheit;
	
	private JLabel labelResultado;
	private JLabel labelMensagemErro;

	//Função para criar a tela, e fazer aparecer
	
	public void criarTelaConversor() {
		
		/*
		 Cria a tela, define o tamanho, aplica o comportamento
		 de parar a execução do programa quando clicar para fechar,
		 aplica o comportamento de não poder editar o tamanho da janela,
		 define o nome da janela, e define o tipo de layout que vai ser
		 utilizado.
		 */
		JFrame tela = new JFrame();
		tela.setSize(360, 300);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setTitle("Conversor de Temperatura");
		tela.setLayout(null);
		
		// Define a tela como espaço de conteudo.
		Container container = tela.getContentPane();
		
		// Cria a descrição do que deve ser escrito no campo,
		// e define o posicionamento, e tamanho na tela.
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus celsius:");
		labelCelsius.setBounds(50, 40, 200, 30);
		
		// Cria o campo onde o usuario vai digitar.
		textCelsius = new JTextField();
		textCelsius.setBounds(50, 70, 250, 25);
		
		// Cria o botão de conversão de Celsius para Kelvin
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(50, 100, 120, 30);
		
		// Cria o botão de conversão de Celsius para Fahreinheit
		buttonFahreinheit = new JButton();
		buttonFahreinheit.setText("Fahreinheit");
		buttonFahreinheit.setBounds(180, 100, 120, 30);
		
		// Cria o resultado que vai aparecer na tela do usuario
		// após clicar em um dos botões.
		labelResultado = new JLabel();
		
		// Cria uma estilização de fonte.
		Font tamanhoFonteResultado = new Font(null, Font.BOLD, 24);
		
		// Define que o labelResultado vai utilizar a estilização
		// de fonte passada anteriormente.
		labelResultado.setFont(tamanhoFonteResultado);
		
		// Define que não é visivel no momento.
		labelResultado.setVisible(false);
		
		// Aqui ja passamos a mensagem de erro como parametro
		// pois sera única.
		labelMensagemErro = new JLabel("Dados fornecidos invalidos");
		
		//Cria uma estilização de fonte.
		Font tamanhoFonteMensagemErro = new Font(null, Font.BOLD, 18);
		
		// Define que não é visivel no momento.
		labelMensagemErro.setVisible(false);
		
		// Define a cor da letra.
		labelMensagemErro.setForeground(Color.RED);
		
		// Define que o labelMensagemErro vai utilizar a estilização
		// de fonte passada anteriormente.
		labelMensagemErro.setFont(tamanhoFonteMensagemErro);
		labelMensagemErro.setBounds(55, 180, 300, 40);
		
		// Adiciona todos os objetos criados dentro do
		// painel de conteudo/tela
		container.add(labelCelsius);
		container.add(textCelsius);
		container.add(buttonKelvin);
		container.add(buttonFahreinheit);
		container.add(labelResultado);
		container.add(labelMensagemErro);
		
		// Aqui estamos adicionando a função do botão Kelvin
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				 O try e catch serve para tratamento de erros,
				 com os dois estou falando para o Java:
				 "Tente executar esse bloco de código, caso
				  haja algum erro presente, pegue esse erro,
				  trate o erro, e execute esse outro bloco de
				  código" 
				 */
				
				try {
					
					labelMensagemErro.setVisible(false);
					
					/*
					 Criamos uma variavel celsius que vai guardar
					 o que o usuario passou em forma de string.
					  
					 Aqui com o replace estou dizendo que se
					 dentro dos dados que o usuário me passou
					 tiver um virgula, substitua a virgula por
					 um ponto.
					 */
					String celsius = textCelsius.getText().replace(",", ".");
					
					/*
					 Criamos uma variavel celsiusDouble para
					 guardarmos o valor em forma de valor decimal.
					 */
					double celsiusDouble = Double.parseDouble(celsius);
					
					//Criamos um objeto temperatura
					Temperatura temperatura = new Temperatura();
					
					//Passamos o valor em decimal para executar
					//o calculo presente na classe Temperatura.
					temperatura.setCelsius(celsiusDouble);
					
					//Guardamos o valor convertido na variavel temperaturaKelvin.
					double temperaturaKelvin = temperatura.converterParaKelvin();				
					
					/*
					 Passamos o valor dos graus Celsius convertidos
					 para Kelvin para o labelResultado com duas casas decimais. 
					 */
					labelResultado.setText(String.format("%.2f", temperaturaKelvin) + " KELVIN");
					labelResultado.setBounds(100, 140, 360, 40);
					
					//Definimos que ele esta visivel.
					labelResultado.setVisible(true);
					
				//Caso haja o erro.
				} catch (NumberFormatException exception) {
					
					//Esconde o resultado anterior, se tiver
					labelResultado.setVisible(false);
					
					//Deixa a mensagem de erro visivel.
					labelMensagemErro.setVisible(true);
					
				}
			
			}
		});
		
		//Aqui executamos a mesma coisa do bloco de código acima
		//mas agora para o botão Fahreinheit.
		buttonFahreinheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					labelMensagemErro.setVisible(false);
					
					String celsius = textCelsius.getText().replace(",", ".");
					double celsiusDouble = Double.parseDouble(celsius);
					
					Temperatura temperatura = new Temperatura();
					temperatura.setCelsius(celsiusDouble);
					
					double temperaturaFahreinheit = temperatura.converterParaFahreinheit();
					
					labelResultado.setText(String.format("%.2f", temperaturaFahreinheit) + " FAHREINHEIT");
					labelResultado.setBounds(58, 140, 360, 40);
					labelResultado.setVisible(true);
					
				} catch (NumberFormatException exception) {
					
					labelResultado.setVisible(false);
					labelMensagemErro.setVisible(true);
					
				}
			}
		});
		
		tela.setVisible(true);
	}
	
}