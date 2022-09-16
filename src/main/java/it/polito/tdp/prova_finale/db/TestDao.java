package it.polito.tdp.prova_finale.db;

import java.util.List;

import it.polito.tdp.prova_finale.model.Studente;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScuolaDao dao = new ScuolaDao();
		
		
		System.out.println("Codice: " + dao.getCodStud() + " ");
		
	}
	

}
