/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Taxista extends Rodoviario{
	public Taxista(String nome, boolean casa, boolean carro, double valorCasa, double valorCarro) {
		super(nome, casa, carro, valorCasa, valorCarro);
	}

	private int passageiros;
	
	public int getPassageiros() {
		return passageiros;
	}
	
	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}
	
}
