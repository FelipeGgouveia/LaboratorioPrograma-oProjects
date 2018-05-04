/**@author
*Aluno 1: Felipe da Silva Gouveia 
*Aluno 2: Jardesson Elliudo Lazaro da Costa
*Aluno 3: Matheus de Moura Torres */

/**Classe que gera uma progressao aritmetica.*/

public class ProgressaoAritmetica {
    private int primeiroTermo;
    private int razao;
    private int termo;

    /**
    Muda o conteudo do primeiro termo da progressao aritmetica..
    @param primeiroTermo 
     */
    public void setPrimeiroTermo(int primeiroTermo) {
        this.primeiroTermo = primeiroTermo;
    }

    /**
    Muda o conteudo da razao da progressao aritmetica..
    @param razao 
     */
    public void setRazao(int razao) {
        this.razao = razao;
    }

    /**
    Calcula o primeiro termo da progressao aritmetica..
    @return o valor do primeiro termo pedido
     */
    public int primeiro() {
        this.termo=1; 
        return this.primeiroTermo + (this.termo - 1)*this.razao;
    }

    /**
    Calcula o proximo termo da progressao aritmetica..
    @return o valor do proximo termo pedido
     */
    public int proximo() {
        this.termo++;
        return this.primeiroTermo + (this.termo - 1)*this.razao;
    }

    /**
    Calcula qualquer termo da serie de Fibonacci..
    @param termo posicao do termo pedido
    @return o termo pedido
     */
    public int termo(int termo) {
        this.termo = termo;
        return this.primeiroTermo + (this.termo - 1)*this.razao;
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
