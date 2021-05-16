package com.crudCYES.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crudCYES.conexion.Conexion;
import com.crudCYES.model.Suscriptor;

public class SuscriptorDAO {
	private Connection connection;
	private PreparedStatement statement;
	
	private boolean estadoOperacion;
	
	public boolean crear(Suscriptor suscriptor) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			sql ="INSERT INTO suscriptor(idSuscriptor, nomPila, apPat, apMat, servicio, fechaNac, estatus, plan) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, null);
			statement.setString(2, suscriptor.getNomPila());
			statement.setString(3, suscriptor.getApPat());
			statement.setString(4, suscriptor.getApMat());
			statement.setString(5, suscriptor.getServicio());
			statement.setDate(6, suscriptor.getFechaNac());
			statement.setString(7, suscriptor.getEstatus());
			statement.setString(8, suscriptor.getPlan());
			
			estadoOperacion = statement.executeUpdate() > 0;
			
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		}
		
		return estadoOperacion;
	}
	
	
	public boolean actualizar(Suscriptor suscriptor) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try{
			connection.setAutoCommit(false);
			sql = "UPDATE suscriptor SET nomPila = ?, apPat = ?, apmat = ?, servicio = ?, fechaNac = ?, estatus = ?, plan = ? WHERE idSuscriptor = ? ";
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, suscriptor.getNomPila());
			statement.setString(2, suscriptor.getApPat());
			statement.setString(3, suscriptor.getApMat());
			statement.setString(4, suscriptor.getServicio());
			statement.setDate(5, suscriptor.getFechaNac());
			statement.setString(6, suscriptor.getEstatus());
			statement.setString(7, suscriptor.getPlan());
			statement.setInt(8, suscriptor.getIdSuscriptor());
			
			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();
			
		}catch(SQLException e){
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}

	
	public boolean eliminar(int IdSuscriptor) throws SQLException {
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try{
			connection.setAutoCommit(false);
			sql = "DELETE FROM suscriptor SET idSuscriptor = ? ";
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, IdSuscriptor);
			
			estadoOperacion = statement.executeUpdate() > 0;
			connection.commit();
			statement.close();
			connection.close();
			
		}catch(SQLException e){
			connection.rollback();
			e.printStackTrace();
		}
		return estadoOperacion;
	}

	
	public List<Suscriptor> consultar() throws SQLException {
		ResultSet resultSet = null;
		List<Suscriptor> listaSuscriptor = new ArrayList<>();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			sql = "SELECT * FROM suscriptor";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Suscriptor s = new Suscriptor();
				s.setIdSuscriptor(resultSet.getInt(1));
				s.setNomPila(resultSet.getString(2));
				s.setApPat(resultSet.getString(3));
				s.setApMat(resultSet.getString(4));
				s.setServicio(resultSet.getString(5));
				s.setFechaNac(resultSet.getDate(6));
				s.setEstatus(resultSet.getString(7));
				s.setPlan(resultSet.getString(8));
				listaSuscriptor.add(s);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaSuscriptor;
	}
	
	public Suscriptor consultar(int idSuscriptor) throws SQLException {
		ResultSet resultSet = null;
		Suscriptor s = new Suscriptor();
		
		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();
		
		try {
			sql = "SELECT * FROM suscriptor WHERE idSuscriptor = ? ";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idSuscriptor);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				
				s.setIdSuscriptor(resultSet.getInt(1));
				s.setNomPila(resultSet.getString(2));
				s.setApPat(resultSet.getString(3));
				s.setApMat(resultSet.getString(4));
				s.setServicio(resultSet.getString(5));
				s.setFechaNac(resultSet.getDate(6));
				s.setEstatus(resultSet.getString(7));
				s.setPlan(resultSet.getString(8));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
		
	}


}
