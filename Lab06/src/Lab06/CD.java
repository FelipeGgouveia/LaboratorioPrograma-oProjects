/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package Lab06;

import java.util.List;

public class CD {
    String artista;
    String titulo;
    String trilhaPrincipal;
    final int M;
    List<String> faixas;
    
    public CD(String titulo, String artista, int M){
        this.titulo = titulo;
        this.artista = artista;
        this.M = M;
    }
    
    public CD(String titulo, String artista){
        this.titulo = titulo;
        this.artista = artista;
        this.M = 10;
    }
    
}
