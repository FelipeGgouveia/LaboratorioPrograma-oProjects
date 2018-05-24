/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

public class Sala{
    static final int OCUPADO=1, LIVRE=0;
    private final int NUM_LINHAS;
    private final int NUM_COLUNAS;
    private int sala[][];
    
    /**
     *  Esvazia a nova sala criada
     */
    private void zerarSala(){
        for(int i=0;i<this.NUM_LINHAS;i++){
            for(int j=0;i<this.NUM_COLUNAS;j++){
                sala[i][j]=LIVRE;
            }
        }
    }
    
    /**
     *  Cria um objeto sala
     * @param NUM_LINHAS Numero de linhas da sala
     * @param NUM_COLUNAS Numero de colunas da sala
     * @throws Exception Retorna uma excecao se os parametros estiverem abaixo do desejado
     */
    public Sala(int NUM_LINHAS, int NUM_COLUNAS) throws Exception{
        if(((NUM_LINHAS<=0)&&(NUM_COLUNAS<=0))||NUM_LINHAS<=0||NUM_COLUNAS<=0) throw new Exception("Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero");       
        
        this.sala = new int[NUM_LINHAS][NUM_COLUNAS];
        zerarSala();
        this.NUM_LINHAS = NUM_LINHAS;
        this.NUM_COLUNAS = NUM_COLUNAS;
    }

    /**
     *  Mostra o numero de linhas da sala
     * @return Retorna o numero de linhas
     */
    public int getNumPosicoesHorizontais() {
        return this.NUM_LINHAS;
    }

    /**
     *  Mostra o numero de colunas da sala
     * @return Retorna o numero de colunas
     */
    public int getNumPosicoesVerticais() {
        return this.NUM_COLUNAS;
    }

    /**
     *Mostra o estado da sala
     * @return Retorna se a sala esta vazia ou nao
     */
    public boolean isVazia() {
        for(int i=0;i<this.NUM_LINHAS;i++){
            for(int j=0;j<this.NUM_COLUNAS;j++){
                if(this.sala[i][j]!=LIVRE) return false;
            }
        }
        return true;
    }

    /**
     *  Insere um obstaculo na sala
     * @param POSICAO_LINHA Coordenada linha
     * @param POSICAO_COLUNA Coordenada coluna
     * @return Retorna se a insercao do obstaculo foi bem sucedida ou nao
     */
    public boolean inserirObstaculo(int POSICAO_LINHA, int POSICAO_COLUNA) {
        if(POSICAO_LINHA<0||POSICAO_COLUNA<0||POSICAO_LINHA>=this.NUM_LINHAS||POSICAO_COLUNA>=this.NUM_COLUNAS){
            return false;
        }
        sala[POSICAO_LINHA][POSICAO_COLUNA]=OCUPADO;
        return true;
    }

    /**
     *  Verifica se uma determinada coordenada da sala eh valida
     * @param POSICAO_LINHA Coordenada linha
     * @param POSICAO_COLUNA Coordenada coluna
     * @return Retorna se a posicao examinada eh valida ou nao
     */
    public boolean posicaoValida(int POSICAO_LINHA, int POSICAO_COLUNA) {
        return !(POSICAO_LINHA<0||POSICAO_COLUNA<0||POSICAO_LINHA>=this.NUM_LINHAS||POSICAO_COLUNA>=this.NUM_COLUNAS);
    }

    /**
     *  Verifica se uma determinada posicao da sala esta livre
     * @param POSICAO_LINHA Coordenada linha
     * @param POSICAO_COLUNA Coordenada coluna
     * @return Retorna se a posicao examinada possui um obstaculo ou nao
     * @throws Exception Retorna uma excecao se a posicao examinada eh valida ou nao
     */
    public boolean isPosicaoLivre(int POSICAO_LINHA, int POSICAO_COLUNA) throws Exception{
        if(posicaoValida(POSICAO_LINHA, POSICAO_COLUNA)==false) throw new Exception("Posicao inexistente.");
        return (sala[POSICAO_LINHA][POSICAO_COLUNA] == LIVRE);
    }

    /**
     *  Muda o estado de uma posicao da sala
     * @param POSICAO_LINHA Coordenada linha
     * @param POSICAO_COLUNA Coordenada coluna
     * @param opcao Indica a insercao de um obstaculo ou o esvaziamento da posicao examinada 
     * @return
     */
    public boolean setPosicao(int POSICAO_LINHA, int POSICAO_COLUNA, int opcao) {
        if(posicaoValida(POSICAO_LINHA, POSICAO_COLUNA)==false) return false;
        sala[POSICAO_LINHA][POSICAO_COLUNA]=opcao;
        return true;
    }
    
    /**
     *  Compara duas salas
     * @param outraSala Objeto a ser comparado
     * @return Retorna se as salas examinadas sao iguais ou nao
     */
    public boolean equals(Sala outraSala){
        for(int i=0;i<this.NUM_LINHAS;i++){
            for(int j=0;j<this.NUM_COLUNAS;j++){
                if(this.sala[i][j]!=outraSala.sala[i][j]) return false;
            }
        }
        return true;
    }
}
