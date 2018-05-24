/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

public class Robo {
    private int posicaoRobo[] = new int [2];
    private Sala sala=null;
    private int energia, passos=0;
    
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

    public Robo(Sala sala, int energia) throws Exception{
        if(energia<=0) throw new Exception("O Robo nao pode ter ser inicializado com energia negativa ou nula..");
        if(sala==null) throw new Exception("Deve ser criada uma sala antes de criar um Robo..");
        this.sala = sala;
        if(!setPosicaoInicial())throw new Exception("Nao ha lugar vago para um Robo na sala..");
        this.energia = energia;
    }
    
    public boolean existeEnergia(){
        return energia>0;
    }
    
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

    public boolean confirmarPosicaoAtual(int POSICAO_LINHA, int POSICAO_COLUNA) {
        return posicaoRobo[0]==POSICAO_LINHA&&posicaoRobo[1]==POSICAO_COLUNA;
    }

    public int getEnergia() {
        return this.energia;
    }

    public int getPassos() {
        return this.passos;
    }
    
    public boolean equals(Robo outroRobo){
        return this.sala.equals(outroRobo.sala)&&this.posicaoRobo[0]==outroRobo.posicaoRobo[0]&&this.posicaoRobo[1]==outroRobo.posicaoRobo[1];
    }
}
