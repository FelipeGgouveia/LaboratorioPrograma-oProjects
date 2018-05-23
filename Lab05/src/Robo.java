
public class Robo {
    private int posicaoRobo[] = new int [2];
    private Sala sala=null;
    private int energia, passos=0;
    
    private boolean posicaoInicial() throws Exception{
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
        if(!posicaoInicial())throw new Exception("Nao ha lugar vago para um Robo na sala..");
        this.sala = sala;
        this.energia = energia;
    }
    
    public boolean existeEnergia(){
        return energia>0;
    }
    
    public boolean subir() throws Exception{
        if(!existeEnergia()) throw new Exception("Robo sem energia..");
        if(sala.posicaoValida(posicaoRobo[0]-1, posicaoRobo[1])&&sala.isPosicaoLivre(posicaoRobo[0]-1, posicaoRobo[1])){
            sala.setPosicao(0, 1, Sala.LIVRE);
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
            sala.setPosicao(0, 1, Sala.LIVRE);
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
            sala.setPosicao(0, 1, Sala.LIVRE);
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
            sala.setPosicao(0, 1, Sala.LIVRE);
            sala.inserirObstaculo(posicaoRobo[0], ++posicaoRobo[1]);
            energia--;
            passos++;
            return true;
        }
        return false;
    }
}
