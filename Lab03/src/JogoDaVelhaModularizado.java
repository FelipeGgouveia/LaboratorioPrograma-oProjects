import java.util.Scanner;
import java.lang.ArrayIndexOutOfBoundsException;

/*
Aluno 1: Felipe da Silva Gouveia
Aluno 2: Jardesson Ellíudo Lázaro da Costa  
Aluno 3: Matheus de Moura Torres
*/

public class JogoDaVelhaModularizado{
    
    private static final char TABULEIRO[][]=new char[3][3];
    private static final char OX[] = {'O','X'};
    private static final char VAZIO = ' ';
    
    private static int jogada = 0,jogador, j, i, win;
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]){
        limpar_tabuleiro();
        verificar_vencedor();
    }

    public static void limpar_tabuleiro(){
    	for(i=0;i<3;i++)
    		for(j=0;j<3;j++)
    			TABULEIRO[i][j]= VAZIO;
    }

    public static void ler_jogada(){
       
        try{
        	win=0;
            mostrar_tabuleiro();
            System.out.println("\nINSIRA AS COORDENADAS\n");
            jogador = jogada%2;
            System.out.print("PLAYER "+(jogador+1)+"\n\nLINHA: ");
            
            i = sc.nextInt();
            System.out.print("COLUNA: ");
            j = sc.nextInt();
            
            
            if(TABULEIRO[i-1][j-1]== VAZIO){
            	TABULEIRO[i-1][j-1]=OX[jogador];
            	jogada++;
            }else
            	System.out.println("COORDENADA INVÁLIDA!");
            
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("COORDENADA INVÁLIDA!");
            
        }
                
    }

    public static void mostrar_tabuleiro(){
        System.out.print("\nJOGO DA VELHA \n");
        for(i=0;i<3;i++){
        	System.out.print(TABULEIRO[i][0]+"|"+TABULEIRO[i][1]+"|"+TABULEIRO[i][2]);
        	if(i<3-1){
        		System.out.print("\n------\n");
        	}
        }
    }

    public static void verificar_vencedor(){
        while(jogada<=9){
	
        	ler_jogada();
        
        	for(int a=0;a<2;a++) {
        		if((TABULEIRO[0][0]==OX[a] && TABULEIRO[0][1]==OX[a] && TABULEIRO[0][2]==OX[a])||
        			(TABULEIRO[1][0]==OX[a] && TABULEIRO[1][1]==OX[a] && TABULEIRO[1][2]==OX[a])||
        			(TABULEIRO[2][0]==OX[a] && TABULEIRO[2][1]==OX[a] && TABULEIRO[2][2]==OX[a])||
        			(TABULEIRO[0][0]==OX[a] && TABULEIRO[1][0]==OX[a] && TABULEIRO[2][0]==OX[a])||
        			(TABULEIRO[0][1]==OX[a] && TABULEIRO[1][1]==OX[a] && TABULEIRO[2][1]==OX[a])||
        			(TABULEIRO[0][2]==OX[a] && TABULEIRO[1][2]==OX[a] && TABULEIRO[2][2]==OX[a])||
        			(TABULEIRO[0][0]==OX[a] && TABULEIRO[1][1]==OX[a] && TABULEIRO[2][2]==OX[a])||
        			(TABULEIRO[0][2]==OX[a] && TABULEIRO[1][1]==OX[a] && TABULEIRO[2][0]==OX[a]))
        		{
        			mostrar_tabuleiro();
        			System.out.print("\nPLAYER "+(jogador+1)+", VOCE VENCEU!!!");
        			win=1;
        			break;       		
        		}
        	
        		if(jogada==9){
        			mostrar_tabuleiro();
        			System.out.print("\nPARTIDA EMPATADA");
        			win=1;
        			break;
        		}
            }
            if(win==1) {
            	break;
            }
        }
        novo_jogo();
    }
    
   public static void novo_jogo(){
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
        if(novojogo == COMECAR)
        	limpar_tabuleiro();
            verificar_vencedor();
      
    }
    
}