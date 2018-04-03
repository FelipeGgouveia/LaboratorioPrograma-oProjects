
package Laboratório01;

import java.util.Scanner;

/**
 *
 * @Aluno: Felipe da Silva Gouveia
 */
public class IdadeParaVotacaoInteligente2 {
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int anoatual = 2018, anodenascimento, idade, min = 16, max=70, obrigatorio=18;
        System.out.println("Digite o seu ano ne nascimento.");
        anodenascimento = s.nextInt();
        idade = anoatual - anodenascimento;
        if((idade > max) || ((idade < obrigatorio)&&(idade >= min))){
            System.out.println("Voce tem " + idade + " anos e pode votar, mas nao eh obrigado a tal.");
        }else{
            if(idade > obrigatorio){
                System.out.println("Voce tem " + idade + " anos e eh um eleitor apto obrigatoriamente a votar.");
            }else{
                System.out.println("Voce tem " + idade + " e nao eh um eleitor apto a votar.");
            }
        }
    }
}
