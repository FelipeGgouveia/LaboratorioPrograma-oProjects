/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Professor extends Contribuinte{
    private final double SALARIO_MINIMO = 954.0;
    private double salario;
    private double despesasMaterial;
    
    public int calcularSalarios(){
        double aux = salario/SALARIO_MINIMO;
        return (int) aux;
    }
    
    public double calcularTributo(){
        if(calcularSalarios()>5) setTributo(salario*0.2);
        else if(calcularSalarios()>1) setTributo(salario*0.1);
            else setTributo(salario*0.05);
        return getTributo();
    }
    
    public double calcularDesconto(){
        setDesconto(despesasMaterial*0.5);
        return getDesconto();
    }
}
