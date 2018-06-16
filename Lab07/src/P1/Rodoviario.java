/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Rodoviario extends Contribuinte{
	public Rodoviario(String nome, boolean casa, boolean carro, double valorCasa, double valorCarro) {
		super(nome, casa, carro, valorCasa, valorCarro);
	}

	private float quilometros;
	
	public float getQuilometros() {
		return quilometros;
	}
	
	public void setQuilometros(float quilometros) {
		this.quilometros = quilometros;
	}
}
