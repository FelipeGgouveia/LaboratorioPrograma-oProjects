/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

public class Sala{
    static final int OCUPADO=1, LIVRE=0;
    private final int NUM_LINHAS;
    private final int NUM_COLUNAS;
    private int sala[][];
    
    private void zerarSala(){
        for(int i=0;i<this.NUM_LINHAS;i++){
            for(int j=0;i<this.NUM_COLUNAS;j++){
                sala[i][j]=LIVRE;
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
            for(int j=0;j<this.NUM_COLUNAS;j++){
                if(this.sala[i][j]!=LIVRE) return false;
            }
        }
        return true;
    }

    public boolean inserirObstaculo(int POSICAO_LINHA, int POSICAO_COLUNA) {
        if(POSICAO_LINHA<0||POSICAO_COLUNA<0||POSICAO_LINHA>=this.NUM_LINHAS||POSICAO_COLUNA>=this.NUM_COLUNAS){
            return false;
        }
        sala[POSICAO_LINHA][POSICAO_COLUNA]=OCUPADO;
        return true;
    }

    public boolean posicaoValida(int POSICAO_LINHA, int POSICAO_COLUNA) {
        return !(POSICAO_LINHA<0||POSICAO_COLUNA<0||POSICAO_LINHA>=this.NUM_LINHAS||POSICAO_COLUNA>=this.NUM_COLUNAS);
    }

    public boolean isPosicaoLivre(int POSICAO_LINHA, int POSICAO_COLUNA) throws Exception{
        if(posicaoValida(POSICAO_LINHA, POSICAO_COLUNA)==false) throw new Exception("Posicao inexistente.");
        return (sala[POSICAO_LINHA][POSICAO_COLUNA] == LIVRE);
    }

    boolean setPosicao(int POSICAO_LINHA, int POSICAO_COLUNA, int opcao) {
        if(posicaoValida(POSICAO_LINHA, POSICAO_COLUNA)==false) return false;
        sala[POSICAO_LINHA][POSICAO_COLUNA]=opcao;
        return true;
    }
    
    public boolean equals(Sala outraSala){
        for(int i=0;i<this.NUM_LINHAS;i++){
            for(int j=0;j<this.NUM_COLUNAS;j++){
                if(this.sala[i][j]!=outraSala.sala[i][j]) return false;
            }
        }
        return true;
    }
}
