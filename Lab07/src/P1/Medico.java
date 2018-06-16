/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Medico extends Contribuinte{
	public Medico(String nome, boolean casa, boolean carro, double valorCasa, double valorCarro) {
		super(nome, casa, carro, valorCasa, valorCarro);
		// TODO Auto-generated constructor stub
	}
	private int pacientes;
	private double despesas;
	
	public int getPacientes() {
		return pacientes;
	}
	
	public void setPacientes(int pacientes) {
		this.pacientes = pacientes;
	}
	
	public double getDespesas() {
		return despesas;
	}
	
	public void setDespesas(double despesas) {
		this.despesas = despesas;
	}
}
