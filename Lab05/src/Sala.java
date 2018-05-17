
public class Sala {
    private int NUM_LINHAS, NUM_COLUNAS;

    Sala(int NUM_LINHAS, int NUM_COLUNAS) {
        this.NUM_LINHAS = NUM_LINHAS;
        this.NUM_COLUNAS = NUM_COLUNAS;
    }
    
    private int sala[][] = new int[this.NUM_LINHAS][this.NUM_COLUNAS];
}
