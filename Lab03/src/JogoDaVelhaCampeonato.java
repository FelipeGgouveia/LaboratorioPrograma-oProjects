/* Aluno 1: Felipe da Silva Gouveia */
/* Aluno 2: Jardesson Ellíudo Lázaro da Costa */
/* Aluno 3: Matheus de Moura Torres */

import java.util.Scanner;

public class JogoDaVelhaCampeonato {
    static Scanner sc = new Scanner(System.in);
    static final char OPCAO[] = {'O', 'X'};
    static char tabuleiro[][] = new char[3][3];
    static int jogada = 0, i, j;
    
    public static void main(String[] args) {
        do{
            limparTabuleiro();
            while(jogada<=9){
                lerJogada();
                if(verificarVencedor()==1)break;           
            }
        }while(novoJogo()==0);
    }

    private static void limparTabuleiro() {
        for(int a=0;a<3;a++)
	        for(int b=0;b<3;b++)
	            tabuleiro[a][b]=' ';
    }

    private static void lerJogada() {
        mostrarTabuleiro();
        
        System.out.println("\nINSIRA AS COORDENADAS");
	if((jogada%2)==1)System.out.print("PLAYER 2\nLINHA: ");
	else System.out.print("PLAYER 1\nLINHA: ");

	i = sc.nextInt();
	System.out.print("COLUNA: ");
	j = sc.nextInt();

	if(tabuleiro[i-1][j-1]==' '){
                tabuleiro[i-1][j-1]=OPCAO[jogada%2];
                jogada++;
        }	        
    }

    private static void mostrarTabuleiro() {
        System.out.print("  JOGO DA VELHA \n");
	for(int c=0;c<3;c++){
	    System.out.print(tabuleiro[c][0]+"|"+tabuleiro[c][1]+"|"+tabuleiro[c][2]);
	    if(c<3-1)System.out.print("\n------\n");
	            
	}
    }

    private static int verificarVencedor() {
        for(int d=0;d<2;d++) {
            if((tabuleiro[0][0]==OPCAO[d] && tabuleiro[0][1]==OPCAO[d] && tabuleiro[0][2]==OPCAO[d])||
            (tabuleiro[1][0]==OPCAO[d] && tabuleiro[1][1]==OPCAO[d] && tabuleiro[1][2]==OPCAO[d])||
            (tabuleiro[2][0]==OPCAO[d] && tabuleiro[2][1]==OPCAO[d] && tabuleiro[2][2]==OPCAO[d])||
            (tabuleiro[0][0]==OPCAO[d] && tabuleiro[1][0]==OPCAO[d] && tabuleiro[2][0]==OPCAO[d])||
            (tabuleiro[0][1]==OPCAO[d] && tabuleiro[1][1]==OPCAO[d] && tabuleiro[2][1]==OPCAO[d])||
            (tabuleiro[0][2]==OPCAO[d] && tabuleiro[1][2]==OPCAO[d] && tabuleiro[2][2]==OPCAO[d])||
            (tabuleiro[0][0]==OPCAO[d] && tabuleiro[1][1]==OPCAO[d] && tabuleiro[2][2]==OPCAO[d])||
            (tabuleiro[0][2]==OPCAO[d] && tabuleiro[1][1]==OPCAO[d] && tabuleiro[2][0]==OPCAO[d]))
            {
        	mostrarTabuleiro();
        	System.out.println("\nPLAYER "+(d+1)+", VOCE VENCEU!!!");
        	return 1;       		
            }
        	
            if(jogada==9){
        	mostrarTabuleiro();
        	System.out.println("\nPARTIDA EMPATADA");
        	return 1;
            }
        }
        return 0;
    }

    private static int novoJogo() {
        final int ENCERRAR = 2;
        final int COMECAR = 1;
        int novojogo;
        do{
            System.out.println("\nNOVO JOGO?\nSIM (1)\nNAO (2)");
            novojogo = sc.nextInt();
            if(novojogo == ENCERRAR)
                System.exit(0);    
            if(novojogo < COMECAR || novojogo > ENCERRAR)
                System.out.println("Opção inválida.");
        }while(novojogo < COMECAR || novojogo > ENCERRAR);
        return 0;
    }
    
}