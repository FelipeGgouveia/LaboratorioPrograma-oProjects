/* Aluno 1: Felipe da Silva Gouveia */
/* Aluno 2: Jardesson Elliudo Lazaro da Costa */
/* Aluno 3: Matheus de Moura Torres */

public class ProgressaoAritmetica {
    private int primeiroTermo;
    private int razao;
    private int termo;

    public ProgressaoAritmetica(int primeiroTermo, int razao) {
        this.primeiroTermo = primeiroTermo;
        this.razao = razao;
    }

    public int primeiro() {
        this.termo=1; 
        return this.primeiroTermo + (this.termo - 1)*this.razao;
    }

    public int proximo() {
        this.termo++;
        return this.primeiroTermo + (this.termo - 1)*this.razao;
    }

    public int termo(int termo) {
        this.termo = termo;
        return this.primeiroTermo + (this.termo - 1)*this.razao;
    }

    public String geraTermos(int variosTermos) {
        int cincoTermos[] = new int[5];
        cincoTermos[0] = primeiro();
        for(int i=1;i<variosTermos;i++){
            cincoTermos[i] = proximo();
        }
        return "["+cincoTermos[0]+", "+cincoTermos[1]+", "+cincoTermos[2]+
                ", "+cincoTermos[3]+", "+cincoTermos[4]+"]";
    }
    
}
