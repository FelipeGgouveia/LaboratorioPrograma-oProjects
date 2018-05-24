/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

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
            new Sala(NUM_LINHAS, NUM_COLUNAS);
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
            sala = new Sala(NUM_LINHAS, NUM_COLUNAS);
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
    
    @Test
    public void testaPosicaoInicial() throws Exception{
        Robo robo = new Robo(sala, 10);
        Assert.assertTrue(robo.confirmarPosicaoAtual(0,0));
    }
    
    @Test
    public void testaMovimentarRobo() throws Exception{
        Robo robo = new Robo(sala, 10);
        Assert.assertFalse(robo.subir());
        Assert.assertFalse(robo.esquerda());
        
        Assert.assertTrue(robo.getEnergia()==10);
        Assert.assertTrue(robo.getPassos()==0);
        
        Assert.assertTrue(robo.descer());
        Assert.assertTrue(robo.confirmarPosicaoAtual(1, 0));
        Assert.assertTrue(robo.direita());
        Assert.assertTrue(robo.confirmarPosicaoAtual(1, 1));
        
        Assert.assertTrue(robo.subir());
        Assert.assertTrue(robo.confirmarPosicaoAtual(0, 1));
        Assert.assertTrue(robo.esquerda());
        Assert.assertTrue(robo.confirmarPosicaoAtual(0, 0));
    }
    
    @Test
    public void testaMovimentarComObstaculos() throws Exception{
        Robo robo = new Robo(sala, 10);
        sala.inserirObstaculo(1, 0);
        sala.inserirObstaculo(0, 2);
        
        Assert.assertFalse(robo.descer());
        Assert.assertTrue(robo.getEnergia()==10);
        Assert.assertTrue(robo.confirmarPosicaoAtual(0, 0));
        
        Assert.assertTrue(robo.direita());
        Assert.assertTrue(robo.confirmarPosicaoAtual(0, 1));
        Assert.assertTrue(robo.getPassos()==1);
        Assert.assertTrue(robo.getEnergia()==9);
        
        Assert.assertFalse(robo.direita());
        Assert.assertTrue(robo.getPassos()==1);
        Assert.assertTrue(robo.getEnergia()==9);
        
        Assert.assertTrue(robo.descer());
        Assert.assertTrue(robo.confirmarPosicaoAtual(1, 1));
        Assert.assertTrue(robo.getPassos()==2);
        Assert.assertTrue(robo.getEnergia()==8);
        
        Assert.assertTrue(robo.direita());
        Assert.assertTrue(robo.confirmarPosicaoAtual(1, 2));
        Assert.assertTrue(robo.getPassos()==3);
        Assert.assertTrue(robo.getEnergia()==7);
        
        Assert.assertTrue(robo.esquerda());
        Assert.assertTrue(robo.confirmarPosicaoAtual(1, 1));
        Assert.assertTrue(robo.getPassos()==4);
        Assert.assertTrue(robo.getEnergia()==6);
        
        Assert.assertFalse(robo.esquerda());
        Assert.assertTrue(robo.getPassos()==4);
        Assert.assertTrue(robo.getEnergia()==6);
    }
    
    @Test
    public void testeMovimentarQuinasDaSala() throws Exception{
        sala = new Sala(3,3);
        Robo robo = new Robo(sala,10);
        
        Assert.assertTrue(robo.direita());
        Assert.assertTrue(robo.confirmarPosicaoAtual(0, 1));
        Assert.assertTrue(robo.getPassos()==1);
        Assert.assertTrue(robo.getEnergia()==9);
        Assert.assertTrue(robo.direita());
        Assert.assertTrue(robo.confirmarPosicaoAtual(0, 2));
        Assert.assertTrue(robo.getPassos()==2);
        Assert.assertTrue(robo.getEnergia()==8);
        Assert.assertFalse(robo.direita());
        Assert.assertTrue(robo.getPassos()==2);
        Assert.assertTrue(robo.getEnergia()==8);
        
        Assert.assertTrue(robo.descer());
        Assert.assertTrue(robo.confirmarPosicaoAtual(1, 2));
        Assert.assertTrue(robo.getPassos()==3);
        Assert.assertTrue(robo.getEnergia()==7);
        Assert.assertTrue(robo.descer());
        Assert.assertTrue(robo.confirmarPosicaoAtual(2, 2));
        Assert.assertTrue(robo.getPassos()==4);
        Assert.assertTrue(robo.getEnergia()==6);
        Assert.assertFalse(robo.descer());
        Assert.assertTrue(robo.getPassos()==4);
        Assert.assertTrue(robo.getEnergia()==6);
        
        Assert.assertTrue(robo.esquerda());
        Assert.assertTrue(robo.confirmarPosicaoAtual(2, 1));
        Assert.assertTrue(robo.getPassos()==5);
        Assert.assertTrue(robo.getEnergia()==5);
        Assert.assertTrue(robo.esquerda());
        Assert.assertTrue(robo.confirmarPosicaoAtual(2, 0));
        Assert.assertTrue(robo.getPassos()==6);
        Assert.assertTrue(robo.getEnergia()==4);
        Assert.assertFalse(robo.esquerda());
        Assert.assertTrue(robo.getPassos()==6);
        Assert.assertTrue(robo.getEnergia()==4);
    }
    
    @Test
    public void testaEquals() throws Exception{
        Robo robo = new Robo(sala, 10);
	Sala outraSala = new Sala(NUM_LINHAS, NUM_COLUNAS);
	Robo outroRobo = new Robo(outraSala, 10);
	Assert.assertTrue(robo.equals(outroRobo));
        
        sala.inserirObstaculo(5, 5);
        robo = new Robo(sala, 10);
        Assert.assertFalse(robo.equals(outroRobo));
        outraSala.inserirObstaculo(5, 5);
        outroRobo = new Robo(outraSala, 10);
        Assert.assertTrue(robo.equals(outroRobo));
        
        robo.direita();
        Assert.assertFalse(robo.equals(outroRobo));
        outroRobo.direita();
        Assert.assertTrue(robo.equals(outroRobo));
    }
}
