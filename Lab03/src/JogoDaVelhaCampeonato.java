/* Aluno 1: Felipe da Silva Gouveia */
/* Aluno 2: Jardesson Elliudo Lazaro da Costa */
/* Aluno 3: Matheus de Moura Torres */

import java.util.Arrays;
import java.util.Scanner;

public class JogoDaVelhaCampeonato {
    static Scanner sc = new Scanner(System.in);
    static final char OPCAO[] = {'O','X'};
    static char tabuleiro[][] = new char[3][3];
    static String jogadores[] = new String[4];
    static int quemjoga[] = {0,0}, vitorias[] = {0,0,0,0};
    static int jogada = 0, i, j;
    
    public static void main(String[] args) {
        iniciarCampeonato();
        do{
            jogada = 0;
            quemJoga();
            limparTabuleiro();
            while(jogada<=9){
                lerJogada();
                if(verificarVencedor()==1)break;           
            }
        }while(novoJogo()==0);
        tabela();
    }

    private static void limparTabuleiro() {
        for(int a=0;a<3;a++)
	    for(int b=0;b<3;b++)
	        tabuleiro[a][b]=' ';
    }

    private static void lerJogada() {
        mostrarTabuleiro();
        do{
            System.out.println("\nINSIRA AS COORDENADAS");
            if((jogada%2)==1)System.out.print("***"+(jogadores[quemjoga[1]])+"***\nLINHA: ");
            else System.out.print("***"+(jogadores[quemjoga[0]])+"***\nLINHA: ");

            i = sc.nextInt();
            System.out.print("COLUNA: ");
            j = sc.nextInt();
            if(i<1 || i>3 || j<1 || j>3){
                System.out.println("OPCAO INVALIDA.");
            }
        }while(i<1 || i>3 || j<1 || j>3);
        

	if(tabuleiro[i-1][j-1]==' '){
            tabuleiro[i-1][j-1]=OPCAO[jogada%2];
            jogada++;
        }	        
    }

    private static void mostrarTabuleiro() {
        System.out.print("\n  JOGO DA VELHA \n");
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
        	System.out.println("\n"+jogadores[quemjoga[d]]+", VOCE VENCEU!!!");
                vitorias[quemjoga[d]]++;
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
                return 1;    
            if(novojogo < COMECAR || novojogo > ENCERRAR)
                System.out.println("OPCAO INVALIDA.");
        }while(novojogo < COMECAR || novojogo > ENCERRAR);
        return 0;
    }

    private static void iniciarCampeonato() {
        for(int e=0;e<jogadores.length;e++){
            System.out.print("Digite o nome do "+(e+1)+"º jogador: ");
            jogadores[e] = sc.next();
        }
    }

    private static void quemJoga() {
        System.out.println("\nQuem vai jogar esta partida?");
        System.out.println("Escolha o 1º jogador.");
        System.out.print(jogadores[0]+"(1) "+jogadores[1]+"(2) "+jogadores[2]+"(3) "+jogadores[3]+"(4): ");
        quemjoga[0] = sc.nextInt()-1;
        System.out.println("Escolha o 2º jogador.");
        for(int f=0;f<jogadores.length;f++){
            if(f!=quemjoga[0]) System.out.print(jogadores[f]+"("+(f+1)+") ");
        }
        quemjoga[1] = sc.nextInt()-1;
    }

    private static void tabela() {
        String jogadoresDecrescente[] = new String[jogadores.length];
        int vitoriasDecrescente[] = new int[vitorias.length];		
	for(int g=0;g<vitorias.length;g++){
            vitoriasDecrescente[g] = vitorias[g]*(-1);
	}
	Arrays.sort(vitoriasDecrescente);
	for(int h=0;h<vitorias.length;h++){
            vitoriasDecrescente[h] = vitoriasDecrescente[h]*(-1);
	}		
	System.out.println("\n*****TABELA FINAL*****\n");
        System.out.println("   Vitorias | Jogadores");
		
	int m=1;
	for(int k=0;k<vitorias.length;k++){
            for(int l=0;l<vitorias.length;l++){
		if(vitoriasDecrescente[k] == vitorias[l]){
                    System.out.printf("%d.   %2d        %s\n", m, vitoriasDecrescente[k], jogadores[l]);
                    vitorias[l] = -1;
                    m++;
		}
            }
	}
    }
    
}