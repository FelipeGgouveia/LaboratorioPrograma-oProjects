/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package Teste.Lab06;

import Lab06.CD;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TesteCD {
    private CD cd;
    private final String TITULO = "titulo";
    private final String ARTISTA = "artista";
    
    @Before
    public void criaObjetos() throws Exception {
	cd = new CD(TITULO, ARTISTA);
    }
    
    @Test
    public void testaCriaCD(){
        try {
            new CD("titulo", "artista",0);
            Assert.fail("Esperava excecao, pois a quantidade de musicas do album esta errada.");
	} catch (Exception e) {
            Assert.assertEquals(
                "Mensagem errada",
                "A quantidade de musicas do album nao pode ser negativa ou nula.Um album deve conter ao menos uma faixa de musica.",
                e.getMessage());
	}
        
        try {
            new CD("titulo", "artista",-1);
            Assert.fail("Esperava excecao, pois a quantidade de musicas do album esta errada.");
	} catch (Exception e) {
            Assert.assertEquals(
                "Mensagem errada",
                "A quantidade de musicas do album nao pode ser negativa ou nula.Um album deve conter ao menos uma faixa de musica.",
                e.getMessage());
	}
        
        try {
            new CD(null,null,10);
            Assert.fail("Esperava excecao, pois o titulo e o artista nao foram informados.");
	} catch (Exception e) {
            Assert.assertEquals(
                "Mensagem errada",
                "Título e/ou artista não podem ser vazios.",
                e.getMessage());
	}
        
        try {
            new CD(null,null);
            Assert.fail("Esperava excecao, pois o titulo e o artista nao foram informados.");
	} catch (Exception e) {
            Assert.assertEquals(
                "Mensagem errada",
                "Título e/ou artista não podem ser vazios.",
                e.getMessage());
	}
        
        try {
            Assert.assertTrue(cd.getM()==10);
        } catch (Exception e) {
            e.getCause();
        }
    }
    
    @Test
    public void testaCadastroFaixa() throws Exception{
        cd = new CD(TITULO, ARTISTA, 1);
        Assert.assertTrue(cd.cadastroFaixa("musica1"));
        Assert.assertFalse(cd.cadastroFaixa("musica2"));
        
        cd = new CD(TITULO, ARTISTA, 2);
        Assert.assertTrue(cd.cadastroFaixa("musica1"));
        Assert.assertTrue(cd.cadastroFaixa("musica2"));
    }
    
    @Test
    public void testaSetTrilhaPrincipal(){
        Assert.assertFalse(cd.setTrilhaPrincipal("musica"));
        Assert.assertTrue(cd.cadastroFaixa("musica"));
        Assert.assertTrue(cd.setTrilhaPrincipal("musica"));
    }
    
    @Test
    public void testaGetFaixa(){
        Assert.assertFalse(cd.getFaixa(0)!=null);
        Assert.assertFalse(cd.getFaixa(1)!=null);
        Assert.assertTrue(cd.cadastroFaixa("musica1"));
        Assert.assertTrue(cd.getFaixa(1)!=null);
        Assert.assertFalse(cd.getFaixa(2)!=null);
    }
    
    @Test
    public void testaEquals() throws Exception{
        CD cd2 = new CD(TITULO,ARTISTA);
        Assert.assertTrue(cd.equals(cd2));
        cd2 = new CD("titulo2","artista2");
        Assert.assertFalse(cd.equals(cd2));
        cd = new CD("titulo2","artista2");
        Assert.assertTrue(cd.equals(cd2));
    }
        
}














