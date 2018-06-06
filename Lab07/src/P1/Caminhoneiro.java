/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Caminhoneiro extends Rodoviario{
    private double toneladasAno;
    
    public double calcularTributo(){
        if(toneladasAno>10) setTributo(500 + toneladasAno+100);
        else setTributo(500);
        return getTributo();
    }
    
}
