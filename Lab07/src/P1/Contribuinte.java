/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Contribuinte {
	private String nome;
	private int numero;
	private boolean casa;
	private boolean carro;
	private double valorCasa;
	private double valorCarro;
	private double imposto;
	private double desconto;
	
	public Contribuinte(String nome, boolean casa, boolean carro, double valorCasa, double valorCarro) {
		this.nome = nome;
		this.casa = casa;
		this.carro = carro;
		this.valorCasa = valorCasa;
		this.valorCarro = valorCarro;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public boolean isCasa() {
		return casa;
	}
	
	public void setCasa(boolean casa) {
		this.casa = casa;
	}
	
	public boolean isCarro() {
		return carro;
	}
	
	public void setCarro(boolean carro) {
		this.carro = carro;
	}
	
	public double getValorCasa() {
		return valorCasa;
	}
	
	public void setValorCasa(double valorCasa) {
		this.valorCasa = valorCasa;
	}
	
	public double getValorCarro() {
		return valorCarro;
	}
	
	public void setValorCarro(double valorCarro) {
		this.valorCarro = valorCarro;
	}
	
	public double getImposto() {
		return imposto;
	}
	
	public void setImposto(double imposto) {
		this.imposto = imposto;
	}
	
	public double getDesconto() {
		return desconto;
	}
	
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

}
