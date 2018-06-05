/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package Lab06;

import java.util.ArrayList;

/**
 * Armazena informacoes sobre um CD de musicas
 * @author kobby
 */
public class CD {
    private final String ARTISTA;
    private final String TITULO;
    private String trilhaPrincipal;
    private final int M;
    private ArrayList<String> album;
    private int slotAlbum=0;
    
    /**
     * Cria um CD
     * @param TITULO do CD
     * @param ARTISTA co CD
     * @param M Quantidade de musicas do CD
     * @throws Exception Se TITULO ou ARTISTA forem nulos ou se M foe menor ou igual a zero
     */
    public CD(String TITULO, String ARTISTA, int M) throws Exception{
        if(TITULO==null||ARTISTA==null) throw new Exception("Título e/ou artista não podem ser vazios.");
        if(M<1)throw new Exception("A quantidade de musicas do album nao pode ser negativa ou nula.Um album deve conter ao menos uma faixa de musica.");
        album = new ArrayList<>();
        this.TITULO = TITULO;
        this.ARTISTA = ARTISTA;
        this.M = M;
    }
    
    /**
     * Cria um CD com quantidade M de musicas predeterminadas
     * @param TITULO do CD
     * @param ARTISTA do CD
     * @throws Exception Se TITULO ou ARTISTA forem nulos
     */
    public CD(String TITULO, String ARTISTA) throws Exception{
        if(TITULO==null||ARTISTA==null) throw new Exception("Título e/ou artista não podem ser vazios.");
        album = new ArrayList<>();
        this.TITULO = TITULO;
        this.ARTISTA = ARTISTA;
        this.M = 10;
    }

    /**
     *
     * @return O artista do CD
     */
    public String getArtista() {
        return ARTISTA;
    }

    /**
     *
     * @return O titulo do CD
     */
    public String getTitulo() {
        return TITULO;
    }

    /**
     *
     * @return A trilha principal do CD
     */
    public String getTrilhaPrincipal() {
        return trilhaPrincipal;
    }
    
    /**
     *
     * @return A quantidade maxima que o CD pode possuir
     */
    public int getM() {
        return M;
    }
    
    /**
     * Determina a trilha principal do CD
     * @param trilhaPrincipal A musica a ser setada
     * @return  Se a operacao foi bem sucedida ou nao
     */
    public boolean setTrilhaPrincipal(String trilhaPrincipal){
        for(int i=0;i<album.size();i++){
            String faixa = album.get(i);
            if(faixa.equals(trilhaPrincipal)) {
                this.trilhaPrincipal = trilhaPrincipal;
                return true;
            }
        }
        return false;
    }

    /**
     * Mostra a musica indicada do CD
     * @param numFaixa Numero da musica 
     * @return A musica desejada
     */
    public String getFaixa(int numFaixa){
        if(numFaixa<=0||numFaixa>this.slotAlbum) return null;
        return album.get(numFaixa-1);
    }
    
    /**
     * Insere uma musica no CD
     * @param faixa Nome da musica a ser inserida
     * @return  Se a operacao foi bem sucedida ou nao
     */
    public boolean cadastroFaixa(String faixa){
        if(this.slotAlbum<this.M){
            album.add(this.slotAlbum, faixa);
            this.slotAlbum++;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "ARTISTA: "+this.ARTISTA+"  TITULO: "+this.TITULO+"\n";
    }
    
    /**
     * Compara dois CDs
     * @param cd O CD a ser comparado
     * @return Se a comparacao sucedeu ou nao
     */
    public boolean equals(CD cd){
        if(this.TITULO.equals(cd.TITULO)&&this.ARTISTA.equals(cd.ARTISTA)) return true;
        return false;
    }
    
}