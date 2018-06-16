/*Aluno 1: Felipe da Silva Gouveia*/
/*Aluno 2: Jardesson Elliudo Lazaro da Costa*/
/*Aluno 3: Matheus de Moura Torres */

package P1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CalcularTributo {
	private static int numeroCadastro=1;
	private static double riquesaRodoviario;
	private static double riquesaMedico;
	private static double riquesaProfessor;
	private static List<Rodoviario> rodoviarios = new ArrayList<Rodoviario>();
	private static List<Medico> medicos = new ArrayList<Medico>();
	private static List<Professor> professores = new ArrayList<Professor>();
	
	public static void Cadastrar(Rodoviario r) {
		r.setNumero(numeroCadastro);
		numeroCadastro++;
		rodoviarios.add(r);
	}
	
	public static void Cadastrar(Medico m) {
		m.setNumero(numeroCadastro);
		numeroCadastro++;
		medicos.add(m);
	}

	public static void Cadastrar(Professor p) {
		p.setNumero(numeroCadastro);
		numeroCadastro++;
		professores.add(p);
	}
	
	public static boolean calcularImposto(int numero, int pacientes, double despesas) {
		for(int i=0; i<medicos.size(); i++) {
			Medico m = medicos.get(i);
			if(m.getNumero()==numero) {
				m.setPacientes(pacientes);
				m.setDespesas(despesas);
				m.setImposto(m.getPacientes()*10.0);
				m.setDesconto(m.getDespesas());
				return true;
			}
		}	
		return false;
	}
	
	public static boolean calcularImposto(int numero, double salario, double despesas) {
		for(int i=0; i<professores.size(); i++) {
			Professor p = professores.get(i);
			if(p.getNumero()==numero) {
				p.setSalario(salario);
				p.setDespesas(despesas);
				if(p.getSalario()/p.getSALARIO_MINIMO()<=1) p.setImposto(p.getSalario()*0.05);
				else if(p.getSalario()/p.getSALARIO_MINIMO()<=5) p.setImposto(p.getSalario()*0.1);
				else p.setImposto(p.getSalario()*0.2);
				return true;
			}
		}	
		return false;
	}
	
	public static boolean calcularImposto(int numero, int passageiros, float quilometros) {
		for(int i=0; i<rodoviarios.size(); i++) {
			Taxista r = (Taxista) rodoviarios.get(i);
			if(r.getNumero()==numero) {
				r.setPassageiros(passageiros);
				r.setQuilometros(quilometros);
				r.setImposto(r.getPassageiros()*0.5);
				r.setDesconto(r.getQuilometros()*0.01);
				return true;
			}
		}	
		return false;
	}
	
	public static boolean calcularImposto(int numero, float toneladas, float quilometros) {
		for(int i=0; i<rodoviarios.size(); i++) {
			Caminhoneiro r = (Caminhoneiro) rodoviarios.get(i);
			if(r.getNumero()==numero) {
				r.setToneladas(toneladas);
				r.setQuilometros(quilometros);
				if(r.getToneladas()<=10) r.setImposto(500);
				else r.setImposto(500 + (r.getToneladas()-10)*100);
				r.setDesconto(r.getQuilometros()*0.01);
				return true;
			}
		}	
		return false;
	}

	public static void calcularRiquesa() {
		Iterator<Medico> it1 = medicos.iterator();
		while(it1.hasNext()) {
			Medico m = it1.next();
			riquesaMedico += m.getValorCarro()+m.getValorCasa();
		}
		riquesaMedico = (riquesaMedico/medicos.size())+riquesaMedico*0.5;
		
		Iterator<Professor> it2 = professores.iterator();
		while(it2.hasNext()) {
			Professor p = it2.next();
			riquesaProfessor += p.getValorCarro()+p.getValorCasa();
		}
		riquesaProfessor = (riquesaProfessor/professores.size())+riquesaProfessor*0.5;
		
		Iterator<Rodoviario> it3 = rodoviarios.iterator();
		while(it2.hasNext()) {
			Rodoviario r = it3.next();
			riquesaRodoviario += r.getValorCarro()+r.getValorCasa();
		}
		riquesaRodoviario = (riquesaRodoviario/rodoviarios.size())+riquesaRodoviario*0.5;
	}
}
