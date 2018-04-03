
package Lab02;

/**
 *GRUPO:
 *  - Felipe da Silva Gouveia
 *  - Jardesson Ellíudo Lázaro da Costa
 *  - Matheus de Moura Torres
 **/

import java.util.Scanner;
import java.util.Random;

public class PedraPapelTesoura3 {
    private static Random r = new Random();
    private Scanner s = new Scanner(System.in);
    private static final int ENCERRAR = -1;
    private static int ler = 0;
    private int opcao;
    
    public static void main (String []args){
        final int NUMERO_SIMBOLOS = 3;
        PedraPapelTesoura3 jogador1 = new PedraPapelTesoura3();
        PedraPapelTesoura3 computador = new PedraPapelTesoura3();
        while(true){
            jogador1.lerOpcaoJogador(NUMERO_SIMBOLOS);
            computador.lerOpcaoComputador(NUMERO_SIMBOLOS);
            for (int i = 0; i < 3; ++i){
                System.out.println ();
            }
            System.out.println("Jogador 1 (" + jogador1.simbolo() + ") - Jogador 2 (" + computador.simbolo() + ")");
            declararVencedor(jogador1.opcao, computador.opcao, NUMERO_SIMBOLOS);
        }
    }
    
    private static void declararVencedor(int jogador1, int computador, int NUMERO_SIMBOLOS){
        double vencedor;
        vencedor = Math.abs((NUMERO_SIMBOLOS + jogador1 - computador) % NUMERO_SIMBOLOS);
        if(vencedor == 0){
            System.out.println("Empate!\n");
        }else if(vencedor <= NUMERO_SIMBOLOS/2){
            System.out.println("Jogador 1 Ganhou!\n");
        }else if(vencedor> NUMERO_SIMBOLOS/2){
            System.out.println("Computador Ganhou!\n");
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
    private void lerOpcaoComputador(int NUMERO_SIMBOLOS){
        do{
            this.opcao = r.nextInt(3);
        }while(this.opcao < 1 || this.opcao > NUMERO_SIMBOLOS);
    }
}
