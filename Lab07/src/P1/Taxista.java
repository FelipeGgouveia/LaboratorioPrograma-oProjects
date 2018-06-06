/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Taxista extends Rodoviario{
    private int passageirosAno;
    private final double TRIBUTO_PASSAGEIRO = 0.5;
    
    public double calcularTributo(){
        setTributo(passageirosAno*TRIBUTO_PASSAGEIRO);
        return getTributo();
    }
    
}
