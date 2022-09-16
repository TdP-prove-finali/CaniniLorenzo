package it.polito.tdp.prova_finale.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.prova_finale.db.ScuolaDao;

public class Model {
	
	private ScuolaDao dao;
	private List<Studente> scuola = new ArrayList<Studente>();
	private char[] sezioni = {'A', 'B', 'C', 'D'};
	private final int spesePerPersonale = 144000;
	
	public Model() {
		dao = new ScuolaDao();
	}
	
	public void creaScuola(int nStud1, int nStud2, int nStud3, int nStud4, int nStud5, int nClassi1, int nClassi2, int nClassi3, int nClassi4, int nClassi5, String indirizzo) {
		creaClasse(nStud1, nClassi1, 1, indirizzo);
		creaClasse(nStud2, nClassi2, 2, indirizzo);
		creaClasse(nStud3, nClassi3, 3, indirizzo);
		creaClasse(nStud4, nClassi4, 4, indirizzo);
		creaClasse(nStud5, nClassi5, 5, indirizzo);
	}
	
	private void creaClasse(int NStud, int NClassi, int anno, String indirizzo) {
		int classe = 0;
		int resto = 0;
		if (NStud%NClassi == 0) {
			classe = NStud/NClassi;
		}else {
			classe = NStud/NClassi;
			resto = NStud%NClassi;
		}
		for (int x = 0; x < NClassi; x++) {
			for(int i = 0; i < classe; i++) {
				String idStud = "STU" + String.valueOf(scuola.size() + 1);
				Studente stud = new Studente(idStud, anno, sezioni[x], indirizzo);
				scuola.add(stud);
				
			}
		}
		for (int y = 0; y < resto; y++) {
			String idStud = "STU" + String.valueOf(scuola.size() + 1);
			Studente stud = new Studente(idStud, anno, sezioni[y], indirizzo);
			scuola.add(stud);
		}
	}
	
	public void simulaAnno() {
		for (Studente s : scuola) {
			List<Materia> materie = dao.getMaterie(s.getClasse(), s.getIndirizzo());
			for (Materia mat : materie) {
				Voto v = new Voto(calcolaVoto(s.getIndirizzo(), s.getClasse(), mat.getCodMat()), s.getClasse(), mat.getMateria());
				s.aggiungiVoto(v);
			}
		}
	}
	
	private int calcolaVoto(String indirizzo, int classe, String materia) {
		List<Voto> voti = new ArrayList<Voto>();
		voti = dao.getAllVoti(indirizzo, classe, materia);
		int[] percentuali = calcolaPercentuali(voti);
		int[] probabilità = new int[10];
		int somma = 0;
		for (int i = 0; i < 10; i++) {
			somma = somma + percentuali[i];
			probabilità[i] = somma;
		}
		int voto = simulaVoto(probabilità);
		return voto;
	}
	
	private int[] calcolaPercentuali(List<Voto> v) {
		int[] percentuali = new int[10];
		int somma = 0;
		for (int i = 0;  i < 10; i++) {
			double percentuale = Math.floor(((double)contaVoti(i+1, v)/(double)v.size())*100);
			percentuali[i] = (int)percentuale;
			somma = somma + (int)percentuale;
		}
		
		if (somma == 100) {
			return percentuali;
		} else {
			int a = 100 - somma;
			percentuali[4] = percentuali[4] + a;
			return percentuali;
		}
	}
	
	private int contaVoti(int i, List<Voto> v) {
		int cont = 0;
		for (Voto x : v) {
			if (x.getRisultato() == i) {
				cont ++;
			}
		}
		return cont;
	}
	
	private int simulaVoto(int[] probabilità) {
		double v = Math.random() * 100;
		int i = 0;
		for (i = 0; i < 10; i++) {
			if (v < probabilità[i]) {
				break;
			}
		}
		return i + 1;
	}
	
	public int[] contaBocciati() {
		int[] bocciati = new int[5];
		for (Studente s : scuola) {
			if (s.contaInsufficienze() > 3) {
				bocciati[s.getClasse()]++;
			}
		}
		return bocciati;
	}
	
	public int contaProfessori(String indirizzo) {
		int nProfessori = 0;
		for (int i = 0; i < 5; i++) {
			List<Materia> m = dao.getMaterie(i+1, indirizzo);
			m = contaRimandati(m, i+1);
			for (Materia x : m) {
				if (x.getRimandati() > 0) {
					nProfessori ++;
				}
			}
		}
		return nProfessori;
	}
	
	public List<Materia> contaRimandati(List<Materia> materie, int anno) {
		for (Materia m : materie) {
			for (Studente s : scuola) {
				if (s.getClasse() == anno && s.getVoto(m) < 6) {
					m.setRimandati(m.getRimandati() + 1);
				}
			}
		}
		return materie;
	}
	
	public int getSpesePersonale() {
		return this.spesePerPersonale;
	}
	
	public int calcolaRisparmi(int budget, int nStud, int nProfessori) {
		return budget- this.spesePerPersonale - costiAmministrativi(budget) - costiLibri(nStud) - costiCorsiRecupero(nProfessori);
	}
	
	public int costiAmministrativi(int budget) {
		return (budget/100)*20;
	}
	
	public int costiLibri(int nStud) {
		return 100*nStud;
	}
	
	public int costiCorsiRecupero(int nProfessori) {
		return nProfessori*8*25;
	}
	
	public void resetScuola() {
		scuola.clear();
	}
	
	public void clearPagelle() {
		for (Studente s : scuola) {
			s.clearPagella();
		}
	}
	
	public List<Studente> getScuola(){
		return scuola;
	}
	
	public List<Materia> getMaterie(String indirizzo, int anno){
		return dao.getMaterie(anno, indirizzo);
	}
	
}
