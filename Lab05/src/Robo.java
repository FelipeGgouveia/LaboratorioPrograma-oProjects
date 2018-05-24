/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

public class Robo {
    private int posicaoRobo[] = new int [2];
    private Sala sala=null;
    private int energia, passos=0;
    
    /**
     *  Aloca o robo criado na primeira posicao livre da sala
     */
    private boolean setPosicaoInicial() throws Exception{
        for(int i=0;i<this.sala.getNumPosicoesHorizontais();i++){
            for(int j=0;j<this.sala.getNumPosicoesVerticais();j++){
                if(this.sala.isPosicaoLivre(i, j)){
                    this.sala.inserirObstaculo(i, j);
                    posicaoRobo[0]=i;
                    posicaoRobo[1]=j;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *  Cria um objeto robo
     * @param sala endereco da sala designada
     * @param energia capacidade do robo de se locomover pela sala
     * @throws Exception Retorna uma excecao se os parametros estiverem abaixo do desejado ou se nao existir uma sala
     */
    public Robo(Sala sala, int energia) throws Exception{
        if(energia<=0) throw new Exception("O Robo nao pode ser inicializado com energia negativa ou nula..");
        if(sala==null) throw new Exception("Deve ser criada uma sala antes de criar um Robo..");
        this.sala = sala;
        if(!setPosicaoInicial())throw new Exception("Nao ha lugar vago para um Robo na sala..");
        this.energia = energia;
    }
    
    /**
     *  Verifica se o robo possui energia para se mover
     * @return Retorna se a energia eh maior que zero ou nao
     */
    public boolean existeEnergia(){
        return energia>0;
    }
    
    /**
     *  Movimenta o robo para cima
     * @return Retorna se o movimento foi bem sucedido ou nao
     * @throws Exception Retorna uma excecao se o robo nao tiver energia
     */
    public boolean subir() throws Exception{
        if(!existeEnergia()) throw new Exception("Robo sem energia..");
        if(sala.posicaoValida(posicaoRobo[0]-1, posicaoRobo[1])&&sala.isPosicaoLivre(posicaoRobo[0]-1, posicaoRobo[1])){
            sala.setPosicao(posicaoRobo[0], posicaoRobo[1], Sala.LIVRE);
            sala.inserirObstaculo(--posicaoRobo[0], posicaoRobo[1]);
            energia--;
            passos++;
            return true;
        }
        return false;
    }
    
    /**
     *  Movimenta o robo para baixo
     * @return Retorna se o movimento foi bem sucedido ou nao
     * @throws Exception Retorna uma excecao se o robo nao tiver energia
     */
    public boolean descer() throws Exception{
        if(!existeEnergia()) throw new Exception("Robo sem energia..");
        if(sala.posicaoValida(posicaoRobo[0]+1, posicaoRobo[1])&&sala.isPosicaoLivre(posicaoRobo[0]+1, posicaoRobo[1])){
            sala.setPosicao(posicaoRobo[0], posicaoRobo[1], Sala.LIVRE);
            sala.inserirObstaculo(++posicaoRobo[0], posicaoRobo[1]);
            energia--;
            passos++;
            return true;
        }
        return false;
    }
    
    /**
     *  Movimenta o robo para a esquerda
     * @return Retorna se o movimento foi bem sucedido ou nao
     * @throws Exception Retorna uma excecao se o robo nao tiver energia
     */
    public boolean esquerda() throws Exception{
        if(!existeEnergia()) throw new Exception("Robo sem energia..");
        if(sala.posicaoValida(posicaoRobo[0], posicaoRobo[1]-1)&&sala.isPosicaoLivre(posicaoRobo[0], posicaoRobo[1]-1)){
            sala.setPosicao(posicaoRobo[0], posicaoRobo[1], Sala.LIVRE);
            sala.inserirObstaculo(posicaoRobo[0], --posicaoRobo[1]);
            energia--;
            passos++;
            return true;
        }
        return false;
    }
    
    /**
     *  Movimenta o robo para a direita
     * @return Retorna se o movimento foi bem sucedido ou nao
     * @throws Exception Retorna uma excecao se o robo nao tiver energia
     */
    public boolean direita() throws Exception{
        if(!existeEnergia()) throw new Exception("Robo sem energia..");
        if(sala.posicaoValida(posicaoRobo[0], posicaoRobo[1]+1)&&sala.isPosicaoLivre(posicaoRobo[0], posicaoRobo[1]+1)){
            sala.setPosicao(posicaoRobo[0], posicaoRobo[1], Sala.LIVRE);
            sala.inserirObstaculo(posicaoRobo[0], ++posicaoRobo[1]);
            energia--;
            passos++;
            return true;
        }
        return false;
    }

    /**
     *  Confirma se o robo esta em uma determinada posicao da sala
     * @param POSICAO_LINHA Coordenada linha
     * @param POSICAO_COLUNA Coordenada coluna
     * @return Retorna se a verificacao foi bem sucedida ou nao
     */
    public boolean confirmarPosicaoAtual(int POSICAO_LINHA, int POSICAO_COLUNA) {
        return posicaoRobo[0]==POSICAO_LINHA&&posicaoRobo[1]==POSICAO_COLUNA;
    }

    /**
     *  Mostra o valor atual de energia do robo
     * @return Retorna o valor da energia
     */
    public int getEnergia() {
        return this.energia;
    }

    /**
     *  Mostra quantos passos o robo deu na sua sala
     * @return Retorna a quantidade de passos
     */
    public int getPassos() {
        return this.passos;
    }
    
    /**
     * Compara dois robos
     * @param outroRobo Objeto a ser comparado
     * @return Retorna se os robos examinados sao iguais ou nao
     */
    public boolean equals(Robo outroRobo){
        return this.sala.equals(outroRobo.sala)&&this.posicaoRobo[0]==outroRobo.posicaoRobo[0]&&this.posicaoRobo[1]==outroRobo.posicaoRobo[1];
    }
}
