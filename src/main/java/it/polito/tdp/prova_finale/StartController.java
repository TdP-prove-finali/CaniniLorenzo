package it.polito.tdp.prova_finale;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.prova_finale.model.Materia;
import it.polito.tdp.prova_finale.model.Model;
import it.polito.tdp.prova_finale.model.Studente;
import it.polito.tdp.prova_finale.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class StartController {
	
	private Model model;
	private int nPrime;
	private int nSeconde;
	private int nTerze;
	private int nQuarte;
	private int nQuinte;
	private String indirizzo;
	private int[] bocciati;
	private int[] rimandati;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbIndirizzo;

    @FXML
    private TextField txtStudenti1;

    @FXML
    private TextField txtStudenti2;

    @FXML
    private TextField txtStudenti3;

    @FXML
    private TextField txtStudenti4;

    @FXML
    private TextField txtStudenti5;

    @FXML
    private ComboBox<Integer> cmbClassi1;

    @FXML
    private ComboBox<Integer> cmbClassi2;

    @FXML
    private ComboBox<Integer> cmbClassi3;

    @FXML
    private ComboBox<Integer> cmbClassi4;

    @FXML
    private ComboBox<Integer> cmbClassi5;

    @FXML
    private Label lblErrore;

    @FXML
    private Button btnSimula;
    
    @FXML
    private Button btnReset;

    
    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnPrime;

    @FXML
    private Button btnSeconde;

    @FXML
    private Button btnTerze;

    @FXML
    private Button btnQuarte;

    @FXML
    private Button btnQuinte;
    
    @FXML
    private Label lblCosti;

    @FXML
    private TextField costi;

    @FXML
    private Button btnCosti;

    @FXML
    private TextArea txtCosti;

    @FXML
    void simula(ActionEvent event) {
    	indirizzo = cmbIndirizzo.getValue();
    	if (indirizzo == null) {
    		lblErrore.setText("Selezionare un indirzzo");
    		return;
    	}
    	if (indirizzo.equals("Amministrazione, Finanza e Marketing")) {
    		indirizzo = "AFM";
    	} else if (indirizzo.equals("Informatica e Telecomunicazioni")) {
    		indirizzo = "IT";
    	}else if(indirizzo.equals("Costruzione, Ambiente e Territorio")) {
    		indirizzo = "CAT";
    	}
    	
    	
    	String studenti1 = txtStudenti1.getText();
    	if (studenti1 == null || studenti1 == "") {
    		lblErrore.setText("Inserire un numero di studenti per ogni classe");
    		return;
    	} else {
    		try {
    			nPrime = Integer.parseInt(studenti1);
    		}catch(NumberFormatException e) {
    			lblErrore.setText("Inserire un numero di studenti per ogni classe");
    			return;
    		}
    	}
    	
    	
    	String studenti2 = txtStudenti2.getText();
    	if (studenti2 == null || studenti2 == "") {
    		lblErrore.setText("Inserire un numero di studenti per ogni classe");
    		return;
    	} else {
    		try {
    			nSeconde = Integer.parseInt(studenti2);
    		}catch(NumberFormatException e) {
    			lblErrore.setText("Inserire un numero di studenti per ogni classe");
    			return;
    		}
    	}
    	
    	
    	String studenti3 = txtStudenti3.getText();
    	if (studenti3 == null || studenti3 == "") {
    		lblErrore.setText("Inserire un numero di studenti per ogni classe");
    		return;
    	} else {
    		try {
    			nTerze = Integer.parseInt(studenti3);
    		}catch(NumberFormatException e) {
    			lblErrore.setText("Inserire un numero di studenti per ogni classe");
    			return;
    		}
    	}
    	
    	
    	String studenti4 = txtStudenti4.getText();
    	if (studenti4 == null || studenti4 == "") {
    		lblErrore.setText("Inserire un numero di studenti per ogni classe");
    		return;
    	} else {
    		try {
    			nQuarte = Integer.parseInt(studenti4);
    		}catch(NumberFormatException e) {
    			lblErrore.setText("Inserire un numero di studenti per ogni classe");
    			return;
    		}
    	}
    	
    	
    	String studenti5 = txtStudenti5.getText();
    	if (studenti5 == null || studenti5 == "") {
    		lblErrore.setText("Inserire un numero di studenti per ogni classe");
    		return;
    	} else {
    		try {
    			nQuinte = Integer.parseInt(studenti5);
    		}catch(NumberFormatException e) {
    			lblErrore.setText("Inserire un numero di studenti per ogni classe");
    			return;
    		}
    	}
    	
    	Integer classi1 = cmbClassi1.getValue();
    	if (classi1 == null) {
    		lblErrore.setText("Selezionare un numero di classi per ogni anno");
    		return;
    	}
    	
    	Integer classi2 = cmbClassi2.getValue();
    	if (classi2 == null) {
    		lblErrore.setText("Selezionare un numero di classi per ogni anno");
    		return;
    	}
    	
    	Integer classi3 = cmbClassi3.getValue();
    	if (classi3 == null) {
    		lblErrore.setText("Selezionare un numero di classi per ogni anno");
    		return;
    	}
    	
    	Integer classi4 = cmbClassi4.getValue();
    	if (classi4 == null) {
    		lblErrore.setText("Selezionare un numero di classi per ogni anno");
    		return;
    	}
    	
    	Integer classi5 = cmbClassi5.getValue();
    	if (classi5 == null) {
    		lblErrore.setText("Selezionare un numero di classi per ogni anno");
    		return;
    	}
    	
    	if (((double)nPrime/(double)classi1) < 10.0 || ((double)nPrime/(double)classi1) > 25.0) {
    		lblErrore.setText("Le classi devono contenere minimo 10 e massimo 25 studenti, con i dati inseriti non si rispettano questi parametri. Prova a modificarli!");
    		return;
    	}
    	
    	if (((double)nSeconde/(double)classi2) < 10.0 || ((double)nSeconde/(double)classi2) > 25.0) {
    		lblErrore.setText("Le classi devono contenere minimo 10 e massimo 25 studenti, con i dati inseriti non si rispettano questi parametri. Prova a modificarli!");
    		return;
    	}
    	
    	if (((double)nTerze/(double)classi3) < 10.0 || ((double)nTerze/(double)classi3) > 25.0) {
    		lblErrore.setText("Le classi devono contenere minimo 10 e massimo 25 studenti, con i dati inseriti non si rispettano questi parametri. Prova a modificarli!");
    		return;
    	}
    	
    	if (((double)nQuarte/(double)classi4) < 10.0 || ((double)nQuarte/(double)classi4) > 25.0) {
    		lblErrore.setText("Le classi devono contenere minimo 10 e massimo 25 studenti, con i dati inseriti non si rispettano questi parametri. Prova a modificarli!");
    		return;
    	}
    	
    	if (((double)nQuinte/(double)classi5) < 10.0 || ((double)nQuinte/(double)classi5) > 25.0) {
    		lblErrore.setText("Le classi devono contenere minimo 10 e massimo 25 studenti, con i dati inseriti non si rispettano questi parametri. Prova a modificarli!");
    		return;
    	}
    	
    	
    	this.model.creaScuola(nPrime, nSeconde, nTerze, nQuarte, nQuinte, classi1, classi2, classi3, classi4, classi5, indirizzo);
    	this.model.simulaAnno();
    	this.bocciati = this.model.contaBocciati();
    	this.rimandati = this.model.contaRim();
    	this.btnPrime.setDisable(false);
    	this.btnSeconde.setDisable(false);
    	this.btnTerze.setDisable(false);
    	this.btnQuarte.setDisable(false);
    	this.btnQuinte.setDisable(false);
    	this.btnReset.setDisable(false);
    	this.lblCosti.setVisible(true);
    	this.costi.setVisible(true);
    	this.btnCosti.setVisible(true);
    	this.btnCosti.setDisable(false);
    	this.txtCosti.setVisible(true);
    }
    
    @FXML
    void onReset(ActionEvent event) {
    	txtArea.clear();
    	txtCosti.clear();
    	costi.clear();
    	model.resetScuola();
    	this.btnPrime.setDisable(true);
    	this.btnSeconde.setDisable(true);
    	this.btnTerze.setDisable(true);
    	this.btnQuarte.setDisable(true);
    	this.btnQuinte.setDisable(true);
    	this.btnReset.setDisable(true);
    }
    
    @FXML
    void stampaPrime(ActionEvent event) {
    	txtArea.clear();
    	txtArea.setStyle("-fx-font-family: monospace");
    	List<Studente> scuola = model.getScuola();
    	List<Materia> materie = model.getMaterie(scuola.get(1).getIndirizzo(), 1);
    	StringBuilder sb = new StringBuilder();
    	String intestazione = "Matricola";
    	String intestazione1 = "Classe";
    	sb.append(String.format("%-10s ", intestazione));
    	sb.append(String.format("%-8s ", intestazione1));
    	for (Materia m : materie) {
    		sb.append(String.format("%-10s ", m.getCodMat()));
    	}
    	txtArea.appendText(sb.toString() + "\n");
    	
    	for (Studente s : scuola) {
    		if (s.getClasse() == 1) {
    			StringBuilder sb1 = new StringBuilder();
    			String inizio = s.getIdStudente();
    			String classe = ""+ s.getClasse() + s.getSezione();
    			sb1.append(String.format("%-10s ", inizio));
    			sb1.append(String.format("%-8s", classe));
    			for (Voto v : s.getPagella()) {
    				sb1.append(String.format("%-10d ", v.getRisultato()));
    			}
    			txtArea.appendText(sb1.toString() + "\n");
    		}
    	}
    	
    	txtArea.appendText("\n");
    	txtArea.appendText("Sono stati bocciati " + bocciati[0] + " studenti\n");
    	txtArea.appendText("Sono stati rimandati " + rimandati[0] + " studenti");
    }

    @FXML
    void stampaQuarte(ActionEvent event) {
    	txtArea.clear();
    	txtArea.setStyle("-fx-font-family: monospace");
    	List<Studente> scuola = model.getScuola();
    	List<Materia> materie = model.getMaterie(scuola.get(1).getIndirizzo(), 4);
    	StringBuilder sb = new StringBuilder();
    	String intestazione = "Matricola";
    	String intestazione1 = "Classe";
    	sb.append(String.format("%-10s ", intestazione));
    	sb.append(String.format("%-8s ", intestazione1));
    	for (Materia m : materie) {
    		sb.append(String.format("%-10s ", m.getCodMat()));
    	}
    	txtArea.appendText(sb.toString() + "\n");
    	
    	for (Studente s : scuola) {
    		if (s.getClasse() == 4) {
    			StringBuilder sb1 = new StringBuilder();
    			String inizio = s.getIdStudente();
    			String classe = ""+ s.getClasse() + s.getSezione();
    			sb1.append(String.format("%-10s ", inizio));
    			sb1.append(String.format("%-8s", classe));
    			for (Voto v : s.getPagella()) {
    				sb1.append(String.format("%-10d ", v.getRisultato()));
    			}
    			txtArea.appendText(sb1.toString() + "\n");
    		}
    	}
    	
    	txtArea.appendText("\n");
    	txtArea.appendText("Sono stati bocciati " + bocciati[3] + " studenti\n");
    	txtArea.appendText("Sono stati rimandati " + rimandati[3] + " studenti");
    }

    @FXML
    void stampaQuinte(ActionEvent event) {
    	txtArea.clear();
    	txtArea.setStyle("-fx-font-family: monospace");
    	List<Studente> scuola = model.getScuola();
    	List<Materia> materie = model.getMaterie(scuola.get(1).getIndirizzo(), 5);
    	StringBuilder sb = new StringBuilder();
    	String intestazione = "Matricola";
    	String intestazione1 = "Classe";
    	sb.append(String.format("%-10s ", intestazione));
    	sb.append(String.format("%-8s ", intestazione1));
    	for (Materia m : materie) {
    		sb.append(String.format("%-10s ", m.getCodMat()));
    	}
    	txtArea.appendText(sb.toString() + "\n");
    	
    	for (Studente s : scuola) {
    		if (s.getClasse() == 5) {
    			StringBuilder sb1 = new StringBuilder();
    			String inizio = s.getIdStudente();
    			String classe = ""+ s.getClasse() + s.getSezione();
    			sb1.append(String.format("%-10s ", inizio));
    			sb1.append(String.format("%-8s", classe));
    			for (Voto v : s.getPagella()) {
    				sb1.append(String.format("%-10d ", v.getRisultato()));
    			}
    			txtArea.appendText(sb1.toString() + "\n");
    		}
    	}
    	
    	txtArea.appendText("\n");
    	txtArea.appendText("Sono stati bocciati " + bocciati[4] + " studenti\n");
    	txtArea.appendText("Sono stati rimandati " + rimandati[4] + " studenti");
    }

    @FXML
    void stampaSeconde(ActionEvent event) {
    	txtArea.clear();
    	txtArea.setStyle("-fx-font-family: monospace");
    	List<Studente> scuola = model.getScuola();
    	List<Materia> materie = model.getMaterie(scuola.get(1).getIndirizzo(), 2);
    	StringBuilder sb = new StringBuilder();
    	String intestazione = "Matricola";
    	String intestazione1 = "Classe";
    	sb.append(String.format("%-10s ", intestazione));
    	sb.append(String.format("%-8s ", intestazione1));
    	for (Materia m : materie) {
    		sb.append(String.format("%-10s ", m.getCodMat()));
    	}
    	txtArea.appendText(sb.toString() + "\n");
    	
    	for (Studente s : scuola) {
    		if (s.getClasse() == 2) {
    			StringBuilder sb1 = new StringBuilder();
    			String inizio = s.getIdStudente();
    			String classe = ""+ s.getClasse() + s.getSezione();
    			sb1.append(String.format("%-10s ", inizio));
    			sb1.append(String.format("%-8s", classe));
    			for (Voto v : s.getPagella()) {
    				sb1.append(String.format("%-10d ", v.getRisultato()));
    			}
    			txtArea.appendText(sb1.toString() + "\n");
    		}
    	}
    	
    	txtArea.appendText("\n");
    	txtArea.appendText("Sono stati bocciati " + bocciati[1] + " studenti\n");
    	txtArea.appendText("Sono stati rimandati " + rimandati[1] + " studenti");
    }

    @FXML
    void stampaTerze(ActionEvent event) {
    	txtArea.clear();
    	txtArea.setStyle("-fx-font-family: monospace");
    	List<Studente> scuola = model.getScuola();
    	List<Materia> materie = model.getMaterie(scuola.get(1).getIndirizzo(), 3);
    	StringBuilder sb = new StringBuilder();
    	String intestazione = "Matricola";
    	String intestazione1 = "Classe";
    	sb.append(String.format("%-10s ", intestazione));
    	sb.append(String.format("%-8s ", intestazione1));
    	for (Materia m : materie) {
    		sb.append(String.format("%-10s ", m.getCodMat()));
    	}
    	txtArea.appendText(sb.toString() + "\n");
    	
    	for (Studente s : scuola) {
    		if (s.getClasse() == 3) {
    			StringBuilder sb1 = new StringBuilder();
    			String inizio = s.getIdStudente();
    			String classe = ""+ s.getClasse() + s.getSezione();
    			sb1.append(String.format("%-10s ", inizio));
    			sb1.append(String.format("%-8s", classe));
    			for (Voto v : s.getPagella()) {
    				sb1.append(String.format("%-10d ", v.getRisultato()));
    			}
    			txtArea.appendText(sb1.toString() + "\n");
    		}
    	}
    	
    	txtArea.appendText("\n");
    	txtArea.appendText("Sono stati bocciati " + bocciati[2] + " studenti \n");
    	txtArea.appendText("Sono stati rimandati " + rimandati[2] + " studenti");
    }
    
    @FXML
    void calcolaCosti(ActionEvent event) {
    	txtCosti.clear();
    	int budget;
    	String finanze = costi.getText();
    	if (finanze == null || finanze == "") {
    		txtCosti.setText("Inserire il budget!");
    		return;
    	} else {
    		try {
    			budget = Integer.parseInt(finanze);
    		}catch(NumberFormatException e) {
    			lblErrore.setText("Inserire il budget in cifre!");
    			return;
    		}
    	}
    	int totStudenti = nPrime + nSeconde + nTerze + nQuarte + nQuinte; 
    	int bilancio = model.calcolaRisparmi(budget, totStudenti, model.contaProfessori(indirizzo));
    	txtCosti.appendText("ENTRATE" + "\n");
    	txtCosti.appendText("Finanziamenti: " + budget + "\n");
    	txtCosti.appendText("\n");
    	txtCosti.appendText("USCITE" + "\n");
    	txtCosti.appendText("Costi Amministrativi: " + model.costiAmministrativi(budget) + "\n");
    	txtCosti.appendText("Spese per il personale: " + model.getSpesePersonale() + "\n");
    	txtCosti.appendText("Spese per libri di testo: " + model.costiLibri(totStudenti) + "\n");
    	txtCosti.appendText("Spese per corsi di recupero: " + model.costiCorsiRecupero(model.contaProfessori(indirizzo)) + "\n");
    	int totUscite = model.costiAmministrativi(budget) + model.getSpesePersonale() + model.costiLibri(totStudenti) + model.costiCorsiRecupero(model.contaProfessori(indirizzo));
    	txtCosti.appendText("Totale uscite: " + totUscite + "\n");
    	if (bilancio < 0) {
    		txtCosti.appendText("I finanziamenti inseriti non bastanno a coprire i costi della scuola, il bilancio è in negativo di " + bilancio + "€");
    	}else if (bilancio == 0){
    		txtCosti.appendText("I finanziamenti inseriti bastanno solo a coprire i costi della scuola, il bilancio è in pari. Non rimangono soldi per i progetti scolastici");
    	}else {
    		txtCosti.appendText("I finanziamenti inseriti coprono i costi della scuola, il bilancio è in positivo di " + bilancio + "€. Questi soldi possono essere tutti usati per organizzare progetti scolastici");
    	}
    }

    @FXML
    void initialize() {
        assert cmbIndirizzo != null : "fx:id=\"cmbIndirizzo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStudenti1 != null : "fx:id=\"txtStudenti1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStudenti2 != null : "fx:id=\"txtStudenti2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStudenti3 != null : "fx:id=\"txtStudenti3\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStudenti4 != null : "fx:id=\"txtStudenti4\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStudenti5 != null : "fx:id=\"txtStudenti5\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbClassi1 != null : "fx:id=\"cmbClassi1\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbClassi2 != null : "fx:id=\"cmbClassi2\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbClassi3 != null : "fx:id=\"cmbClassi3\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbClassi4 != null : "fx:id=\"cmbClassi4\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbClassi5 != null : "fx:id=\"cmbClassi5\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblErrore != null : "fx:id=\"lblErrore\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnPrime != null : "fx:id=\"btnPrime\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSeconde != null : "fx:id=\"btnSeconde\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTerze != null : "fx:id=\"btnTerze\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnQuarte != null : "fx:id=\"btnQuarte\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnQuinte != null : "fx:id=\"btnQuinte\" was not injected: check your FXML file 'Scene.fxml'.";
        assert lblCosti != null : "fx:id=\"lblCosti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert costi != null : "fx:id=\"costi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCosti != null : "fx:id=\"btnCosti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCosti != null : "fx:id=\"txtCosti\" was not injected: check your FXML file 'Scene.fxml'.";
        
    }
    
    void setModel(Model model) {
    	this.model = model;
    	cmbIndirizzo.getItems().addAll("Amministrazione, Finanza e Marketing", "Informatica e Telecomunicazioni", "Costruzione, Ambiente e Territorio");
    	cmbClassi1.getItems().addAll(1,2,3,4);
    	cmbClassi2.getItems().addAll(1,2,3,4);
    	cmbClassi3.getItems().addAll(1,2,3,4);
    	cmbClassi4.getItems().addAll(1,2,3,4);
    	cmbClassi5.getItems().addAll(1,2,3,4);
    }
}

