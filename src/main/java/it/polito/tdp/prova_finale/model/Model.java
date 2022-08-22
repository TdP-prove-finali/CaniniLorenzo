package it.polito.tdp.prova_finale.model;

import it.polito.tdp.prova_finale.db.ScuolaDao;

public class Model {
	
	private ScuolaDao dao;
	
	
	public Model() {
		dao = new ScuolaDao();
	}
}
