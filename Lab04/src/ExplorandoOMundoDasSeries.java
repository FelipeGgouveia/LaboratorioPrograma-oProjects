/* Aluno 1: Felipe da Silva Gouveia */
/* Aluno 2: Jardesson Elliudo Lazaro da Costa */
/* Aluno 3: Matheus de Moura Torres */

public class ExplorandoOMundoDasSeries {
    
    public static void main(String[] args) {
	ProgressaoAritmetica pa = new ProgressaoAritmetica(2, 4);
	Fibonacci fi = new Fibonacci();
        
	//mostra 5 primeiros termos da PA, gerando um por vez
	System.out.println("5 primeiros termos da PA: um por vez...");
	System.out.println("Primeiro: " + pa.primeiro());
	for (int i = 2; i <=5; i++) {
            System.out.println("Termo " + i + ": " + pa.proximo());
	}
	
	//mostra um termo qualquer e seu proximo
	System.out.println("Um termo qualquer (8): " + pa.termo(8));
	System.out.println("Proximo: " + pa.proximo());
	
	//mostra 5 primeiros termos da PA, gerando todos de uma vez
	System.out.println("5 primeiros termos da PA: todos de uma vez...");
	pa.geraTermos(5);
	System.out.println("Proximo: " + pa.proximo());
	
	//reinicia a PA
	System.out.println("Primeiro: " + pa.primeiro());
	System.out.println("Proximo: " + pa.proximo());
               
        System.out.println(fi.primeiro());
        System.out.println(fi.proximo());
        System.out.println(fi.proximo());
        System.out.println(fi.proximo());
        System.out.println(fi.termo(10));
        fi.geraTermos(10);
    }

}
