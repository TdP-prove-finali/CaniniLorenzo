package it.polito.tdp.prova_finale.model;

import java.util.ArrayList;
import java.util.List;

public class Studente {
	
	private String idStudente;
	private int classe;
	private char sezione;
	private String indirizzo;
	private List<Voto> pagella;
	
	
	public Studente(String idStudente, int classe, char sezione, String indirizzo) {
		this.idStudente = idStudente;
		this.classe = classe;
		this.sezione = sezione;
		this.indirizzo = indirizzo;
		this.pagella = new ArrayList<Voto>();
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getClasse() {
		return classe;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public char getSezione() {
		return sezione;
	}

	public void setSezione(char sezione) {
		this.sezione = sezione;
	}

	public List<Voto> getPagella() {
		return pagella;
	}
	
	public boolean aggiungiVoto(Voto v) {
		if(pagella.contains(v)) {
			return false;
		}
		pagella.add(v);
		return true;
	}
	
	public int contaInsufficienze() {
		int cont = 0;
		for (Voto v : pagella) {
			if(v.getRisultato() < 6) {
				cont ++;
			}
		}
		return cont;
	}

	public String getIdStudente() {
		return idStudente;
	}

	public void setIdStudente(String idStudente) {
		this.idStudente = idStudente;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStudente == null) ? 0 : idStudente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (idStudente == null) {
			if (other.idStudente != null)
				return false;
		} else if (!idStudente.equals(other.idStudente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return idStudente;
	}

	public void alzaVoti() {
		for (Voto v : pagella) {
			if (v.getRisultato() < 6) {
				v.setRisultato(6);
			}
		}
	}

	public void clearPagella() {
		pagella.clear();
	}

	public int getVoto(Materia m) {
		int voto = 0;
		for (Voto v : pagella) {
			if (v.getMateria().equals(m.getMateria())) {
				voto = v.getRisultato();
			}
		}
		return voto;
	}
	

}
