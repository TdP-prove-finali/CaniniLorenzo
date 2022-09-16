package it.polito.tdp.prova_finale.model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		List<Voto> voti = new ArrayList<Voto>();
		Voto v1 = new Voto(1,1,"ITA");
		Voto v2 = new Voto(3,1,"ITA");
		Voto v3 = new Voto(4,1,"ITA");
		Voto v4 = new Voto(4,1,"ITA");
		Voto v5 = new Voto(5,1,"ITA");
		Voto v6 = new Voto(5,1,"ITA");
		Voto v7 = new Voto(5,1,"ITA");
		Voto v8 = new Voto(5,1,"ITA");
		Voto v9 = new Voto(5,1,"ITA");
		Voto v10 = new Voto(5,1,"ITA");
		Voto v11 = new Voto(5,1,"ITA");
		Voto v12 = new Voto(5,1,"ITA");
		Voto v13 = new Voto(6,1,"ITA");
		Voto v14 = new Voto(6,1,"ITA");
		Voto v15 = new Voto(6,1,"ITA");
		Voto v16 = new Voto(6,1,"ITA");
		Voto v17 = new Voto(6,1,"ITA");
		Voto v18 = new Voto(6,1,"ITA");
		Voto v19 = new Voto(6,1,"ITA");
		Voto v20 = new Voto(6,1,"ITA");
		Voto v21 = new Voto(6,1,"ITA");
		Voto v22 = new Voto(6,1,"ITA");
		Voto v23 = new Voto(6,1,"ITA");
		Voto v24 = new Voto(6,1,"ITA");
		Voto v25 = new Voto(6,1,"ITA");
		Voto v26 = new Voto(7,1,"ITA");
		Voto v27 = new Voto(7,1,"ITA");
		Voto v28 = new Voto(7,1,"ITA");
		Voto v29 = new Voto(7,1,"ITA");
		Voto v30 = new Voto(7,1,"ITA");
		Voto v31 = new Voto(7,1,"ITA");
		Voto v32 = new Voto(7,1,"ITA");
		Voto v33 = new Voto(8,1,"ITA");
		Voto v34 = new Voto(8,1,"ITA");
		Voto v35 = new Voto(8,1,"ITA");
		Voto v36 = new Voto(8,1,"ITA");
		Voto v37 = new Voto(6,1,"ITA");
		
		voti.add(v1);
		voti.add(v2);
		voti.add(v3);
		voti.add(v4);
		voti.add(v5);
		voti.add(v6);
		voti.add(v7);
		voti.add(v8);
		voti.add(v9);
		voti.add(v10);
		voti.add(v11);
		voti.add(v12);
		voti.add(v13);
		voti.add(v14);
		voti.add(v15);
		voti.add(v16);
		voti.add(v17);
		voti.add(v18);
		voti.add(v19);
		voti.add(v20);
		voti.add(v21);
		voti.add(v22);
		voti.add(v23);
		voti.add(v24);
		voti.add(v25);
		voti.add(v26);
		voti.add(v27);
		voti.add(v28);
		voti.add(v29);
		voti.add(v30);
		voti.add(v31);
		voti.add(v32);
		voti.add(v33);
		voti.add(v34);
		voti.add(v35);
		voti.add(v36);
		voti.add(v37);
		
		model.creaScuola(10, 10, 10, 10, 10, 1, 1, 1, 1, 1, "IT");
		model.simulaAnno();
		//int[] percentuali = model.calcolaPercentuali(voti);
//		List<Studente> scuola = model.getScuola();
//    	List<Materia> materie = model.getMaterie(scuola.get(1).getIndirizzo(), 1);
//    	String intestazione = "Matricola ";
//    	for (Materia m : materie) {
//    		intestazione = intestazione + " | " + m.getCodMat() ;
//    	}
//    	System.out.println(intestazione);
    	
//    	for (Studente s : scuola) {
//    		if (s.getClasse() == 1) {
//    			String inizio = s.getIdStudente() + " 	";
//    			for (Voto v : s.getPagella()) {
//    				inizio = inizio + "   |	 " + v.getRisultato();
//    			}
//    			System.out.println(inizio);
//    		}
//    	}
//    	model.resetScuola();
    	
    	System.out.println(model.contaProfessori("IT"));
    	System.out.println(model.costiCorsiRecupero(model.contaProfessori("IT")));

	}

}
