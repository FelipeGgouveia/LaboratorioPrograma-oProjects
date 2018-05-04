/**@author 
 * Aluno 1: Felipe da Silva Gouveia
 * Aluno 2: Jardesson Elliudo Lazaro da Costa
 * Aluno 3: Matheus de Moura Torres */

/**Classe principal que manipula as classes ProgressaoAritmetrica e Fibonacci.*/

import java.util.Scanner;

public class ExplorandoOMundoDasSeries {
    
    public static void main(String[] args) {
        ProgressaoAritmetica pa = new ProgressaoAritmetica();
        Fibonacci fi = new Fibonacci();
        
        final int progressaoAritmetica=1, fibonacci=2;
        int opcao, serieAtiva=0, n;
        Scanner s = new Scanner(System.in);
        
        while(true){
            while(true){
                System.out.println("Escolha uma opcao abaixo: \n");
                System.out.println("1 - Para criar uma progressão aritmetica; ");
                System.out.println("2 - Para criar uma serie de Fibonacci; ");
                System.out.println("3 - Para ver o termo \"n\" da sua PA; ");
                System.out.println("4 - Para ver o termo \"n\" da serie de Fibonacci; ");
                System.out.println("5 - Para mostrar os \"n\" primeiros termos da sua PA e da serie de Fibonacci; ");
                System.out.println("6 - Para sair.");
                opcao = s.nextInt();
                if(serieAtiva == 0){
                    if(opcao >=3 && opcao<=5){
                        System.out.println("Nao se pode ver o termo de uma PA ou uma serie de Fibonacci que nao existe.\n"
                                + "Sugiro que crie uma PA ou uma serie de Fibonacci antes.");
                    }else break;
                }else break;
            }
            
            
            switch(opcao){
                case 1: System.out.print("Digite o termo inicial e a razao da\n"
                        + "progressao aritmetica separados por espaco: ");
                    pa.setPrimeiroTermo(s.nextInt());
                    pa.setRazao(s.nextInt());
                    serieAtiva = 1;
                    System.out.println("Progressao Aritmetica Criada.");
                    break;
                case 2: serieAtiva = 2;
                    System.out.println("Serie de Fibonacci Criada.");
                    break;
                case 3: 
                    if(serieAtiva == 1){
                        System.out.print("Digite o \"n\" termo a ser verificado: ");
                        n = s.nextInt();
                        System.out.println("Termo N"+n+": "+pa.termo(n));
                    }else System.out.println("Voce nao criou uma PA ainda.");
                    break;
                case 4: 
                    if(serieAtiva == 2){
                        System.out.print("Digite o \"n\" termo a ser verificado: ");
                        n = s.nextInt();
                        System.out.println("Termo "+n+": "+fi.termo(n));
                    }else System.out.println("Voce nao criou uma serie de Fibonacci ainda.");
                    break;
                case 5: 
                    System.out.print("Digite quantos \"n\" termos serao mostrados: ");
                    n = s.nextInt();
                    if(serieAtiva == 1){                        
                        System.out.println("PA: ");
                        pa.geraTermos(n);
                    }
                    if(serieAtiva == 2){                        
                        System.out.println("Fibonacci: ");
                        fi.geraTermos(n);
                    }
                    
                    break;
                case 6: System.exit(0);
                default: System.out.println("Opcao invalida. Por favor digite\numa opcao entre 1 e 6.");
                    break;
            }
        }	
    }

}
