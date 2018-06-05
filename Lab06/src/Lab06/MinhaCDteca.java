/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package Lab06;

import java.util.ArrayList;
import java.util.Iterator;

public class MinhaCDteca {
    ArrayList<CD> cdTeca = new ArrayList<CD>();;
    
    public void adicionaCD(CD cd){
        this.cdTeca.add(cd);
    }
    
    public void adicionaCDS(ArrayList<CD> colecaoCD){
        Iterator<CD> it = colecaoCD.iterator();
        while(it.hasNext()){
            cdTeca.add(it.next());
        }
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
        boolean menos1 = false;
        for(int i=0;i<cdTeca.size();i++){
            cdTeca.remove(i);
            menos1 = true;
        }
        return menos1;
    }
    
    public String pesquisaCD(String titulo){
        for(int i=0;i<cdTeca.size();i++){
            CD cd = cdTeca.get(i);
            if(cd.getTitulo().equals(titulo)){
                return cd.getTitulo()+" é o "+(i+1)+" cd da lista.\n";
            }
        }
        return null;
    }
    
    public int numeroDeCDs(){
        return cdTeca.size();
    }
    
    @Override
    public String toString(){
        String informacoesCD="";
        Iterator<CD> it = cdTeca.iterator();
        while(it.hasNext()){
            CD cd = it.next();
            informacoesCD += cd.toString();
        }
        return informacoesCD;
    }
    
    public boolean equals(ArrayList<CD> lista2){
        
    }
        
}
