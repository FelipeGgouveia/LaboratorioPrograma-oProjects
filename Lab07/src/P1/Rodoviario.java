/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Rodoviario extends Contribuinte{
    private double quilometrosPercorridosAno;
    private final double DESCONTO_RODOVIARIO = 0.01;
    
    public double calcularDesconto(){
        setDesconto(quilometrosPercorridosAno*DESCONTO_RODOVIARIO);
        return getDesconto();
    }
}
