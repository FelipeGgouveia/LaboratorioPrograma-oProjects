/* Aluno 1: Felipe da Silva Gouveia */
/* Aluno 2: Jardesson Elliudo Lazaro da Costa */
/* Aluno 3: Matheus de Moura Torres */

public class Fibonacci {
    private int primeiroTermo;
    private int segundoTermo;
    private int quantosTermos;
    
    public Fibonacci() {
        this.primeiroTermo = 0;
        this.segundoTermo = 1;
    }
    
    public int primeiro() {
        int aux;
        this.quantosTermos=1; 
        for(int i=0;i<this.quantosTermos;i++){
            aux = this.segundoTermo;
            this.segundoTermo = this.segundoTermo + this.primeiroTermo;
            this.primeiroTermo = aux;
        }
        return segundoTermo;
    }
    
}
