
package Laboratório01;

/**
 *
 * @Aluno: Felipe da Silva Gouveia
 */
import java.util.Scanner;
public class IdadeParaVotacaoInteligente {
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int idade, min = 16;
        System.out.println("Digite sua idade.");
        idade = s.nextInt();
        if(idade >= min){
            System.out.println("Voce tem " + idade + " e eh um eleitor apto a votar.");
        }else{
            System.out.println("Voce tem " + idade + " e nao eh um eleitor apto a votar.");
        }
    }
}
