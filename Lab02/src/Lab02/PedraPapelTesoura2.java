
package Lab02;

/**
 *GRUPO:
 *  - Felipe da Silva Gouveia
 *  - Jardesson Ellíudo Lázaro da Costa
 *  - Matheus de Moura Torres
 **/

import java.util.Scanner;

public class PedraPapelTesoura2 {
    private static final int ENCERRAR = -1;
    private static int ler = 0;
    private Scanner s = new Scanner(System.in);
    private int opcao;
    
    public static void main (String []args){
        final int NUMERO_SIMBOLOS = 3;
        PedraPapelTesoura2 jogador1 = new PedraPapelTesoura2();
        PedraPapelTesoura2 jogador2 = new PedraPapelTesoura2();
        while(true){
            jogador1.lerOpcaoJogador(NUMERO_SIMBOLOS);
            jogador2.lerOpcaoJogador(NUMERO_SIMBOLOS);
            for (int i = 0; i < 3; ++i){
                System.out.println ();
            }
            System.out.println("Jogador 1 (" + jogador1.simbolo() + ") - Jogador 2 (" + jogador2.simbolo() + ")");
            declararVencedor(jogador1.opcao, jogador2.opcao, NUMERO_SIMBOLOS);
        }
    }
    
    private static void declararVencedor(int jogador1, int jogador2, int NUMERO_SIMBOLOS){
        double vencedor;
        vencedor = Math.abs((NUMERO_SIMBOLOS + jogador1 - jogador2) % NUMERO_SIMBOLOS);
        if(vencedor == 0){
            System.out.println("Empate!\n");
        }else if(vencedor <= NUMERO_SIMBOLOS/2){
            System.out.println("Jogador 1 Ganhou!\n");
        }else if(vencedor> NUMERO_SIMBOLOS/2){
            System.out.println("Jogador 2 Ganhou!\n");
        }
    }

    private void lerOpcaoJogador(int NUMERO_SIMBOLOS) {
        ler++;
        if(ler == 3){
            ler = 1;
        }
        do{
            System.out.println("Digite o número correspondente a opção de jogador " + ler + ".\nPedra (1), Papel (2), Tesoura (3)? ");
            System.out.println("Sair (-1)");
            this.opcao = s.nextInt();
            if(this.opcao == ENCERRAR){
                System.exit(0);
            }
            if(this.opcao < 1 || this.opcao > NUMERO_SIMBOLOS){
                System.out.println("Opção inválida.");
            }
        }while(this.opcao < 1 || this.opcao > NUMERO_SIMBOLOS);
    }
    
    private String simbolo() {
        switch(this.opcao){
            case 1: return "PEDRA";
            case 2: return "PAPEL";
            case 3: return "TESOURA";
            default : return "0";    
        }
    }
}
