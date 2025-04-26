package br.dev.gabriellacerda.temperatura.model;

// Criamos a classe Temperatura responsavel por executar
// o calculo de conversão de Celsius para Kelvin ou
// Fahreinheit.
public class Temperatura {
	private double celsius;
	
	// Criamos o setCelsius para atribuirmos valor ao
	// parametro celsius.
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	
	//Retorna o valor do parametro celsius
	public double getCelsius() {
		return celsius;
	}
	
	//Responsavel por converter Celsius em Kelvin.
	public double converterParaKelvin() {
		double kelvin = getCelsius() + 273.15;
		return kelvin;
	}
	
	
	//Responsavel por converter Celsius em Fahreinheit.
	public double converterParaFahreinheit() {
		double fahreinheit = (getCelsius() * 1.8) + 32;
		return fahreinheit;
	}
	
}
