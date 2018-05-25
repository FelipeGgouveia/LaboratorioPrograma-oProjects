/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package Lab06;

import java.util.ArrayList;
import java.util.List;

public class CD {
    private final String ARTISTA;
    private final String TITULO;
    private String trilhaPrincipal;
    private final int M;
    private List<String> album;
    private int slotAlbum=0;
    
    public CD(String TITULO, String ARTISTA, int M) throws Exception{
        if(TITULO==null||ARTISTA==null) throw new Exception("Título e/ou artista não podem ser vazios.");
        album = new ArrayList<>();
        this.TITULO = TITULO;
        this.ARTISTA = ARTISTA;
        this.M = M;
    }
    
    public CD(String TITULO, String ARTISTA) throws Exception{
        if(TITULO==null||ARTISTA==null) throw new Exception("Título e/ou artista não podem ser vazios.");
        album = new ArrayList<>();
        this.TITULO = TITULO;
        this.ARTISTA = ARTISTA;
        this.M = 10;
    }

    public String getArtista() {
        return ARTISTA;
    }

    public String getTitulo() {
        return TITULO;
    }

    public String getTrilhaPrincipal() {
        return trilhaPrincipal;
    }
    
    public int getM() {
        return M;
    }
    
    public void setTrilhaPrincipal(String trilhaPrincipal) throws Exception {
        for(int i=0;i<album.size();i++){
            String faixa = album.get(i);
            if(faixa.equals(trilhaPrincipal)) {
                this.trilhaPrincipal = trilhaPrincipal;
                return;
            }
        }
        throw new Exception("Faixa nao consta no album");
    }

    public String getFaixa(int numFaixa){
        if(numFaixa<=0||numFaixa>this.M) return null;
        return album.get(numFaixa);
    }
    
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
        return "ARTISTA: "+this.ARTISTA+"\nTITULO: "+this.TITULO+"\nTRILHA PRINCIPAL: "+this.trilhaPrincipal+"\n";
    }
    
    public boolean equals(CD cd){
        if(this.TITULO.equals(cd.TITULO)&&this.ARTISTA.equals(cd.ARTISTA)) return true;
        return false;
    }
    
}
