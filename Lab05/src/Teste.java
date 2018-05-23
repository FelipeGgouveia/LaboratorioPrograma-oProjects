
public class Teste {
    public static void main(String []args) throws Exception{
        Sala sala = new Sala(10,10);
        for(int i=0;i<sala.getNumPosicoesHorizontais();i++)
            for(int j=0;j<sala.getNumPosicoesVerticais();j++)
                sala.inserirObstaculo(i, j);

        Robo robo = new Robo(sala, 10);
        System.out.println(robo.posicaoInicial());
    }
}
