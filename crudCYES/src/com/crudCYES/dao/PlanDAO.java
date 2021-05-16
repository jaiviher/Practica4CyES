package com.crudCYES.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crudCYES.conexion.Conexion;
import com.crudCYES.model.Plan;

public class PlanDAO {
	
		private Connection connection;
		private PreparedStatement statement;
		
		private boolean estadoOperacion;
		
		public boolean crear(Plan plan) throws SQLException {
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			
			try {
				connection.setAutoCommit(false);
				sql ="INSERT INTO plan(idPlan, nombre, importe) VALUES(?, ?, ?)";
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, null);
				statement.setString(2, plan.getNombre());
				statement.setString(3, plan.getImporte());
				
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
		
		
		public boolean actualizar(Plan plan) throws SQLException {
			
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			
			try{
				connection.setAutoCommit(false);
				sql = "UPDATE plan SET nombre = ?, importe = ? WHERE idPlan = ? ";
				statement = connection.prepareStatement(sql);
				
				statement.setString(1, plan.getNombre());
				statement.setString(2, plan.getImporte());
				statement.setInt(3, plan.getIdPlan());
				
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

		
		public boolean eliminar(int IdPlan) throws SQLException {
			
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			
			try{
				connection.setAutoCommit(false);
				sql = "DELETE FROM plan SET idPlan = ? ";
				statement = connection.prepareStatement(sql);
				
				statement.setInt(1, IdPlan);
				
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

		
		public List<Plan> consultar() throws SQLException {
			
			ResultSet resultSet = null;
			List<Plan> listaPlan = new ArrayList<>();
			
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			
			try {
				sql = "SELECT * FROM plan";
				resultSet = statement.executeQuery(sql);
				while(resultSet.next()) {
					Plan p = new Plan();
					p.setIdPlan(resultSet.getInt(1));
					p.setNombre(resultSet.getString(2));
					p.setImporte(resultSet.getString(3));
					listaPlan.add(p);
					
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return listaPlan;
		}
		
		public Plan consultar(int idPlan) throws SQLException {
			ResultSet resultSet = null;
			Plan p = new Plan();
			
			String sql = null;
			estadoOperacion = false;
			connection = obtenerConexion();
			
			try {
				sql = "SELECT * FROM plan WHERE idPlan = ? ";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, idPlan);
				resultSet = statement.executeQuery();
				
				if(resultSet.next()) {
					
					p.setIdPlan(resultSet.getInt(1));
					p.setNombre(resultSet.getString(2));
					p.setImporte(resultSet.getString(3));
					
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return p;
			
		}
		
		private Connection obtenerConexion() throws SQLException {
			return Conexion.getConnection();
			
		}

}
