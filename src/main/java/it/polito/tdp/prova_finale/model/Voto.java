package it.polito.tdp.prova_finale.model;

public class Voto {
	
	private int risultato;
	private int anno;
	private String materia;
	
	public Voto(int risultato, int anno, String materia) {
		this.risultato = risultato;
		this.anno = anno;
		this.materia = materia;
	}

	public int getRisultato() {
		return risultato;
	}

	public void setRisultato(int risultato) {
		this.risultato = risultato;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		result = prime * result + ((materia == null) ? 0 : materia.hashCode());
		result = prime * result + risultato;
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
		Voto other = (Voto) obj;
		if (anno != other.anno)
			return false;
		if (materia == null) {
			if (other.materia != null)
				return false;
		} else if (!materia.equals(other.materia))
			return false;
		if (risultato != other.risultato)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Voto [risultato=" + risultato + ", anno=" + anno + ", materia=" + materia + "]";
	}
	
	

}
