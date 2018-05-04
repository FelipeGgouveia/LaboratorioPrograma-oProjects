/**@author
*Aluno 1: Felipe da Silva Gouveia 
*Aluno 2: Jardesson Elliudo Lazaro da Costa
*Aluno 3: Matheus de Moura Torres */

/**Classe que gera uma sequencia de Fibonacci.*/

public class Fibonacci {
    private final double binet = 1.618034;
    private int primeiroTermo;
    private int segundoTermo;
    private int posicaoTermos;
    private double termo;
    
    public Fibonacci() {
        this.primeiroTermo = 0;
        this.segundoTermo = 1;
    }
    
    /**
    Calcula o primeiro termo da serie de Fibonacci..
    @return o valor do primeiro termo pedido
     */
    public int primeiro() {
        this.posicaoTermos=1; 
        termo = (Math.pow(binet,this.posicaoTermos)-(Math.pow(1-binet,this.posicaoTermos)))/Math.sqrt(5);
        return (int)termo;
    }
    
    /**
    Calcula o proximo termo da serie de Fibonacci..
    @return o valor do proximo termo pedido
     */
    public int proximo() {
        this.posicaoTermos++;
        termo = (Math.pow(binet,this.posicaoTermos)-(Math.pow(1-binet,this.posicaoTermos)))/Math.sqrt(5);
        return (int)termo;
    }
    
    /**
    Calcula qualquer termo da serie de Fibonacci..
    @param posicaoTermos posicao do termo pedido
    @return o termo pedido
     */
    public int termo(int posicaoTermos) {
        this.posicaoTermos = posicaoTermos;
        termo = (Math.pow(binet,this.posicaoTermos)-(Math.pow(1-binet,this.posicaoTermos)))/Math.sqrt(5);
        return (int)termo;
    }
    
    /**
    Gera varios termos da serie de Fibonacci..
    @param variosTermos a quantidade de termos da sequencia
     */
    public void geraTermos(int variosTermos) {
        System.out.print("["+primeiro()+", ");
        for(int i=1;i<variosTermos;i++){
            if(i == variosTermos-1)System.out.println(proximo()+"]");
            else System.out.print(proximo()+", ");
        }
    }
    
}
