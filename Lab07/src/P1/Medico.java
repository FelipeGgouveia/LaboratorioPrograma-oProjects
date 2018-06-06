/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Medico extends Contribuinte{
    private int numeroPacientesAno;
    private final double TRIBUTO_PACIENTE = 10.0;
    private double despesasCongressos;
    
    public double calcularTributo(){
        setTributo(numeroPacientesAno*TRIBUTO_PACIENTE);
        return getTributo();
    }
    
    public double calcularDesconto(){
        setDesconto(despesasCongressos);
        return getDesconto();
    }
    
}
