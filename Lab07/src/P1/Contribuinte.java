/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

public class Contribuinte {
    private String nome;
    private int numeroContribuinte;
    private boolean casa;
    private boolean carro;
    private double valorBens;
    private double tributo;
    private double desconto;

    public int getNumeroContribuinte() {
        return numeroContribuinte;
    }

    public void setTributo(double tributo) {
        this.tributo = tributo;
    }

    public double getTributo() {
        return tributo;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    
    public double calcularBens(double valorCasa, double valorCarro){
        valorBens = valorCasa+valorCarro;
        return valorBens;
    }
}
