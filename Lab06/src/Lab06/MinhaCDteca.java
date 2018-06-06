/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package Lab06;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Armazena um conjunto de CDs em uma lista
 */
public class MinhaCDteca {
    ArrayList<CD> cdTeca = new ArrayList<CD>();;
    
    /**
     * Adiciona um CD a lista
     * @param cd O objeto a ser adicionado
     */
    public void adicionaCD(CD cd){
        this.cdTeca.add(cd);
    }
    
    /**
     * Adiciona uma colecao de CDs na lista
     * @param colecaoCD A colecao a ser armazenada
     */
    public void adicionaCDS(ArrayList<CD> colecaoCD){
        Iterator<CD> it = colecaoCD.iterator();
        while(it.hasNext()){
            cdTeca.add(it.next());
        }
    }
    
    /**
     * Remove um CD da lista
     * @param titulo Do CD
     * @return O CD removido ou null se o CD nao for encontrado
     */
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
    
    /**
     * Remove um conjunto de CDs da lista
     * @return Se ao menos um CD da lista foi removido
     */
    public boolean removeCDs(){
        boolean menos1 = false;
        for(int i=0;i<cdTeca.size();i++){
            cdTeca.remove(i);
            menos1 = true;
        }
        return menos1;
    }
    
    /**
     * Procura um CD na lista
     * @param titulo Do CD
     * @return A posicao da lista ou null se o CD nao for encontrado
     */
    public String pesquisaCD(String titulo){
        for(int i=0;i<cdTeca.size();i++){
            CD cd = cdTeca.get(i);
            if(cd.getTitulo().equals(titulo)){
                return cd.getTitulo()+" é o "+(i+1)+" cd da lista.\n";
            }
        }
        return null;
    }
    
    /**
     * Informa o numero de CDs da lista
     * @return O numero de CDs
     */
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
        
}
