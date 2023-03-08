package negocio.Transacciones.imp;

import negocio.Transacciones.Transaction;
import negocio.Transacciones.TransactionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import integracion.Constante;


public class TransactionMySQL implements Transaction {

	private Connection connection;


	public TransactionMySQL() {
		try{
			connection=DriverManager.getConnection(Constante.JDBC_URL,Constante.USER, Constante.PASS);
		}catch(SQLException e){
		e.printStackTrace();
		}
	}


	public void start() {
		try{
			connection.setAutoCommit(false);
		}
		catch(SQLException e){
			e.printStackTrace();
			}
	}


	public void commit() {
		try{
			connection.commit();
			connection.close();
			TransactionManager.getInstance().eliminarTransaccion(Thread.currentThread());
		}
		catch(SQLException e){
			e.printStackTrace();
			}
	}


	public void rollback() {
		try{
			connection.rollback();
			connection.close();
			TransactionManager.getInstance().eliminarTransaccion(Thread.currentThread());
		}
		catch(SQLException e){
			e.printStackTrace();
			}
	}


	public Object getResource() {

		return connection;

	}
}