/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Professor extends Contribuinte{
	public Professor(String nome, boolean casa, boolean carro, double valorCasa, double valorCarro) {
		super(nome, casa, carro, valorCasa, valorCarro);
		// TODO Auto-generated constructor stub
	}
	private final double SALARIO_MINIMO = 954.00;
	private double salario;
	private double despesas;
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double getDespesas() {
		return despesas;
	}
	
	public void setDespesas(double despesas) {
		this.despesas = despesas;
	}
	
	public double getSALARIO_MINIMO() {
		return SALARIO_MINIMO;
	}
}
