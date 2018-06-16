/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Caminhoneiro extends Rodoviario{
	public Caminhoneiro(String nome, boolean casa, boolean carro, double valorCasa, double valorCarro) {
		super(nome, casa, carro, valorCasa, valorCarro);
	}

	private float toneladas;
	
	public float getToneladas() {
		return toneladas;
	}
	
	public void setToneladas(float toneladas) {
		this.toneladas = toneladas;
	}
	
}
