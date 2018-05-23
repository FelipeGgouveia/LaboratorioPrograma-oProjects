
public class Sala {
    private int NUM_LINHAS;
    private int NUM_COLUNAS;
    private int sala[][];
    
    private void zerarSala(){
        for(int i=0;i<this.NUM_LINHAS;i++){
            for(int j=0;i<this.NUM_COLUNAS;j++){
                sala[i][j]=0;
            }
        }
    }
    
    public Sala(int NUM_LINHAS, int NUM_COLUNAS) throws Exception{
        if(((NUM_LINHAS<=0)&&(NUM_COLUNAS<=0))||NUM_LINHAS<=0||NUM_COLUNAS<=0) throw new Exception("Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero");       
        
        this.sala = new int[NUM_LINHAS][NUM_COLUNAS];
        zerarSala();
        this.NUM_LINHAS = NUM_LINHAS;
        this.NUM_COLUNAS = NUM_COLUNAS;
    }

    public int getNumPosicoesHorizontais() {
        return this.NUM_LINHAS;
    }

    public int getNumPosicoesVerticais() {
        return this.NUM_COLUNAS;
    }

    public boolean isVazia() {
        for(int i=0;i<this.NUM_LINHAS;i++){
            for(int j=0;i<this.NUM_COLUNAS;j++){
                if(sala[i][j]!=0) return false;
            }
        }
        return true;
    }

    public boolean inserirObstaculo(int POSICAO_LINHA, int POSICAO_COLUNA) {
        if(POSICAO_LINHA<0||POSICAO_COLUNA<0||POSICAO_LINHA>=this.NUM_LINHAS||POSICAO_COLUNA>=this.NUM_COLUNAS){
            return false;
        }
        sala[POSICAO_LINHA][POSICAO_COLUNA]=1;
        return true;
    }

    public boolean posicaoValida(int POSICAO_LINHA, int POSICAO_COLUNA) {
        if(POSICAO_LINHA<0||POSICAO_COLUNA<0||POSICAO_LINHA>=this.NUM_LINHAS||POSICAO_COLUNA>=this.NUM_COLUNAS){
            return false;
        }
        return true;
    }

    public boolean isPosicaoLivre(int POSICAO_LINHA, int POSICAO_COLUNA) throws Exception{
        if(sala[POSICAO_LINHA][POSICAO_COLUNA]!=0) return false;
        return true;
    }
}
