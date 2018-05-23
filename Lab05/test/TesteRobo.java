import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteRobo {
    private Sala sala;
    private final int NUM_LINHAS = 10;
    private final int NUM_COLUNAS = 10;
    
    @Before
    public void criaObjetos() throws Exception {
	sala = new Sala(NUM_LINHAS, NUM_COLUNAS);
    }
    
    @Test
    public void testaCriaRobo() {
	try {
            new Robo(sala, -1);
            Assert.fail("Esperava excecao, pois o valor da energia eh negativo ou nulo.");
	} catch (Exception e) {
            Assert.assertEquals(
                "Mensagem errada",
                "O Robo nao pode ter ser inicializado com energia negativa ou nula..",
                e.getMessage());
	}

	try {
            sala = null;
            new Robo(sala,10);
            Assert.fail("Esperava excecao, pois o objeto aponta pra \"null\".");
	} catch (Exception e) {
            Assert.assertEquals(
                "Mensagem errada",
                "Deve ser criada uma sala antes de criar um Robo..",
                e.getMessage());
	}
        
        try {
            for(int i=0;i<sala.getNumPosicoesHorizontais();i++)
                for(int j=0;j<sala.getNumPosicoesVerticais();j++)
                    sala.inserirObstaculo(i, j);
            
            new Robo(sala,10);
            Assert.fail("Esperava excecao, pois a sala esta cheia de obstaculos.");
	} catch (Exception e) {
            Assert.assertEquals(
                "Mensagem errada",
                "Nao ha lugar vago para um Robo na sala..",
                e.getMessage());
	}
    }
    
}
