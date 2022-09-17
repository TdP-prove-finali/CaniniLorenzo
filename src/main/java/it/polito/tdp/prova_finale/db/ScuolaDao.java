package it.polito.tdp.prova_finale.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.prova_finale.model.Materia;
import it.polito.tdp.prova_finale.model.Voto;

public class ScuolaDao {
	
	public List<Voto> getAllVoti(String indirizzo, int classe, String materia){
		String sql = "SELECT * FROM voti, materie WHERE voti.Materia = materie.CodMat AND materie.Indirizzo = ? AND voti.Anno = ? AND materie.CodMat = ?";
		List<Voto> result = new ArrayList<Voto>();
		Connection conn = DBConnect.getConnection();
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, indirizzo);
			st.setInt(2, classe);
			st.setString(3, materia);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				Voto voto = new Voto (res.getInt("Risultato"), res.getInt("Anno"), res.getString("Materia"));
				result.add(voto);
			}
			res.close();
			st.close();
			conn.close();
			return result;
		} catch(SQLException e) {
			throw new RuntimeException ("Database error", e);
		}
	}

	public List<Materia> getMaterie(int classe, String indirizzo){
		List<Materia> result = new ArrayList<Materia>();
		switch(classe) {
		case 1:
			String sql = "SELECT CodMat, Materia FROM materie WHERE indirizzo = ? AND (Anno = 'S' OR Anno = 'B' OR Anno = '1' OR Anno = '4')";
			Connection conn = DBConnect.getConnection();
			try {
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, indirizzo);
				ResultSet res = st.executeQuery();
				while (res.next()) {
					Materia m = new Materia(res.getString("CodMat"), res.getString("Materia"));
					result.add(m);
				}
				res.close();
				st.close();
				conn.close();
				return result;
				
			} catch (SQLException e) {
				throw new RuntimeException("Database error", e) ;
			}
		case 2:
			String sql2 = "SELECT CodMat, Materia FROM materie WHERE indirizzo = ? AND (Anno = 'S' OR Anno = 'B' OR Anno = '2' OR Anno = '4')";
			Connection conn2 = DBConnect.getConnection();
			try {
				PreparedStatement st = conn2.prepareStatement(sql2);
				st.setString(1, indirizzo);
				ResultSet res = st.executeQuery();
				while (res.next()) {
					Materia m = new Materia(res.getString("CodMat"), res.getString("Materia"));
					result.add(m);
				}
				res.close();
				st.close();
				conn2.close();
				return result;
				
			} catch (SQLException e) {
				throw new RuntimeException("Database error", e) ;
			}
		case 3:
			String sql3 = "SELECT CodMat, Materia FROM materie WHERE indirizzo = ? AND (Anno = 'S' OR Anno = 'T' OR Anno = '3' OR Anno = '4' OR Anno = '34')";
			Connection conn3 = DBConnect.getConnection();
			try {
				PreparedStatement st = conn3.prepareStatement(sql3);
				st.setString(1, indirizzo);
				ResultSet res = st.executeQuery();
				while (res.next()) {
					Materia m = new Materia(res.getString("CodMat"), res.getString("Materia"));
					result.add(m);
				}
				res.close();
				st.close();
				conn3.close();
				return result;
				
			} catch (SQLException e) {
				throw new RuntimeException("Database error", e) ;
			}
		case 4:
			String sql4 = "SELECT CodMat, Materia FROM materie WHERE indirizzo = ? AND (Anno = 'S' OR Anno = 'T' OR Anno = '4' OR Anno = '34')";
			Connection conn4 = DBConnect.getConnection();
			try {
				PreparedStatement st = conn4.prepareStatement(sql4);
				st.setString(1, indirizzo);
				ResultSet res = st.executeQuery();
				while (res.next()) {
					Materia m = new Materia(res.getString("CodMat"), res.getString("Materia"));
					result.add(m);
				}
				res.close();
				st.close();
				conn4.close();
				return result;
				
			} catch (SQLException e) {
				throw new RuntimeException("Database error", e) ;
			}
		case 5:
			String sql5 = "SELECT CodMat, Materia FROM materie WHERE indirizzo = ? AND (Anno = 'S' OR Anno = 'T' OR Anno = '5')";
			Connection conn5 = DBConnect.getConnection();
			try {
				PreparedStatement st = conn5.prepareStatement(sql5);
				st.setString(1, indirizzo);
				ResultSet res = st.executeQuery();
				while (res.next()) {
					Materia m = new Materia(res.getString("CodMat"), res.getString("Materia"));
					result.add(m);
				}
				res.close();
				st.close();
				conn5.close();
				return result;
				
			} catch (SQLException e) {
				throw new RuntimeException("Database error", e) ;
			}
		}
		return result;
		
	}
	
	public int getCodStud() {
		String sql = "SELECT MAX(CodStud) AS CodStud FROM studenti";
		Connection conn = DBConnect.getConnection();
		int codice = 0;
		
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();
			while (res.next()) {
				codice = res.getInt("CodStud");
			}
			res.close();
			st.close();
			conn.close();
			return codice;
			
		} catch (SQLException e) {
			throw new RuntimeException("Database error", e) ;
		}
	}

}
