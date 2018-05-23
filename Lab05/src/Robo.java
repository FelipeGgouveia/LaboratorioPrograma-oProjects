
public class Robo {
    private int posicaoRobo[] = new int [2];
    private Sala ambiente;
    private int energia, passos=0;
    
    private boolean posicaoInicial() throws Exception{
        for(int i=0;i<ambiente.getNumPosicoesHorizontais();i++){
            for(int j=0;j<ambiente.getNumPosicoesVerticais();j++){
                if(ambiente.isPosicaoLivre(i, j)){
                    ambiente.inserirObstaculo(i, j);
                    posicaoRobo[0]=i;
                    posicaoRobo[1]=j;
                    return true;
                }
            }
        }
        return false;
    }

    public Robo(Sala ambiente, int energia) throws Exception{
        if(energia<=0) throw new Exception("O Robo nao pode ter ser inicializado com energia negativa ou nula..");
        if(ambiente==null) throw new Exception("Deve ser criada uma sala antes de criar um Robo..");
        if(posicaoInicial()==false)throw new Exception("Nao ha lugar vago para o Robo entrar na sala..");
        this.ambiente = ambiente;
        this.energia = energia;
    }
    
    public boolean existeEnergia(){
        return energia>0;
    }
    
    public boolean subir() throws Exception{
        if(!existeEnergia()) throw new Exception("Robo sem energia..");
        if(ambiente.posicaoValida(posicaoRobo[0]-1, posicaoRobo[1])&&ambiente.isPosicaoLivre(posicaoRobo[0]-1, posicaoRobo[1])){
            ambiente.setPosicao(0, 1, Sala.LIVRE);
            ambiente.inserirObstaculo(--posicaoRobo[0], posicaoRobo[1]);
            energia--;
            passos++;
            return true;
        }
        return false;
    }
    
    public boolean descer() throws Exception{
        if(!existeEnergia()) throw new Exception("Robo sem energia..");
        if(ambiente.posicaoValida(posicaoRobo[0]+1, posicaoRobo[1])&&ambiente.isPosicaoLivre(posicaoRobo[0]+1, posicaoRobo[1])){
            ambiente.setPosicao(0, 1, Sala.LIVRE);
            ambiente.inserirObstaculo(++posicaoRobo[0], posicaoRobo[1]);
            energia--;
            passos++;
            return true;
        }
        return false;
    }
    
    public boolean esquerda() throws Exception{
        if(!existeEnergia()) throw new Exception("Robo sem energia..");
        if(ambiente.posicaoValida(posicaoRobo[0], posicaoRobo[1]-1)&&ambiente.isPosicaoLivre(posicaoRobo[0], posicaoRobo[1]-1)){
            ambiente.setPosicao(0, 1, Sala.LIVRE);
            ambiente.inserirObstaculo(posicaoRobo[0], --posicaoRobo[1]);
            energia--;
            passos++;
            return true;
        }
        return false;
    }
    
    public boolean direita() throws Exception{
        if(!existeEnergia()) throw new Exception("Robo sem energia..");
        if(ambiente.posicaoValida(posicaoRobo[0], posicaoRobo[1]+1)&&ambiente.isPosicaoLivre(posicaoRobo[0], posicaoRobo[1]+1)){
            ambiente.setPosicao(0, 1, Sala.LIVRE);
            ambiente.inserirObstaculo(posicaoRobo[0], ++posicaoRobo[1]);
            energia--;
            passos++;
            return true;
        }
        return false;
    }
}
