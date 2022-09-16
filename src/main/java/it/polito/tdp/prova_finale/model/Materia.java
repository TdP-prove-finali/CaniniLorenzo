package it.polito.tdp.prova_finale.model;

public class Materia {
	
	private String codMat;
	private String materia;
	private int rimandati;

	public Materia(String codMat, String materia) {
		this.codMat = codMat;
		this.materia = materia;
	}

	public String getCodMat() {
		return codMat;
	}

	public String getMateria() {
		return materia;
	}

	public int getRimandati() {
		return rimandati;
	}

	public void setRimandati(int rimandati) {
		this.rimandati = rimandati;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codMat == null) ? 0 : codMat.hashCode());
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
		Materia other = (Materia) obj;
		if (codMat == null) {
			if (other.codMat != null)
				return false;
		} else if (!codMat.equals(other.codMat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return materia;
	}
	
	

}
