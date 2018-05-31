/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package Lab06;

import java.util.ArrayList;
import java.util.List;

public class MinhaCDteca {
    List<CD> cdTeca = new ArrayList<>();;
    
    public void adicionaCD(CD cd){
        this.cdTeca.add(cd);
    }
    
    public void adicionaCDS(List<CD> colecaoCD){
        this.cdTeca.add((CD) colecaoCD);
    }
    
    public CD removeCD(String titulo){
        for(int i=0;i<cdTeca.size();i++){
            CD cd = cdTeca.get(i);
            if(cd.getTitulo().equals(titulo)){
                this.cdTeca.remove(i);
                return cd;
            }
        }
        return null;
    }
    
    public boolean removeCDs(){
        
    }
}
