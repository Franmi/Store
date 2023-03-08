package integracion.Factura.imp;

import integracion.Factura.DAOLineaFactura;
import negocio.Factura.TLineaFactura;
import negocio.Transacciones.TransactionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DAOLineaFacturaImp implements DAOLineaFactura {

	public int create(TLineaFactura tLineaFactura) {
		int id = -1;

		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO Contiene (idEspectaculo, idFactura, numeroEntradas, precio) VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, tLineaFactura.getIdEspectaculo());
			preparedStatement.setInt(2, tLineaFactura.getIdFactura());
			preparedStatement.setInt(3, tLineaFactura.getNumeroEntradas());
			preparedStatement.setDouble(4, tLineaFactura.getPrecio());
			preparedStatement.executeUpdate();
			id = tLineaFactura.getIdFactura();
			preparedStatement.close();
		} catch (SQLException exception) {
			return -1;
		}

		return id;
	}

	public TLineaFactura read(int idFactura, int idEspectaculo) {
		TLineaFactura tLineaFactura = null;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM Contiene WHERE idFactura=? AND idEspectaculo=? FOR UPDATE",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, idFactura);
			preparedStatement.setInt(2, idEspectaculo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tLineaFactura = new TLineaFactura(resultSet.getInt("idFactura"), resultSet.getInt("idEspectaculo"),
						resultSet.getInt("numeroEntradas"), resultSet.getDouble("precio"));
			}
			preparedStatement.close();
		} catch (SQLException exception) {
			return null;
		}
		return tLineaFactura;
	}

	public int delete(int idFactura, int idEspectaculo) {
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement ps = connection.prepareStatement(
					"DELETE FROM contiene WHERE idEspectaculo=? AND idFactura=?", Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, idEspectaculo);
			ps.setInt(2, idFactura);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException exception) {
			return -1;
		}
		return idFactura;
	}

	public int update(TLineaFactura tLineaFactura) {
		int id = -1;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(
						"UPDATE contiene SET numeroEntradas=?, precio=? WHERE idFactura=? AND idEspectaculo=?",
						Statement.RETURN_GENERATED_KEYS);

				preparedStatement.setInt(1, tLineaFactura.getNumeroEntradas());
				preparedStatement.setDouble(2, tLineaFactura.getPrecio());
				preparedStatement.setInt(3, tLineaFactura.getIdFactura());
				preparedStatement.setInt(4, tLineaFactura.getIdEspectaculo());
				int filas = preparedStatement.executeUpdate();
				preparedStatement.close();
				if (filas > 0)
					id = tLineaFactura.getIdFactura();
			} catch (SQLException exception) {
				return -1;
			}
		}

		return id;
	}

	public Collection<TLineaFactura> readByFactura(int id) {
		Collection<TLineaFactura> list = new ArrayList<>();
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM contiene WHERE idFactura=? FOR UPDATE", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TLineaFactura linea = new TLineaFactura(resultSet.getInt("idFactura"),
						resultSet.getInt("idEspectaculo"), resultSet.getInt("numeroEntradas"),
						resultSet.getDouble("precio"));
				list.add(linea);
			}
			preparedStatement.close();
		}

		catch (SQLException exception) {
			return new ArrayList<>();
		}
		return list;
	}

	public Collection<TLineaFactura> readByEspectaculo(int id) {
		Collection<TLineaFactura> list = new ArrayList<>();
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM contiene WHERE idEspectaculo=? FOR UPDATE", Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				TLineaFactura linea = new TLineaFactura(resultSet.getInt("idFactura"),
						resultSet.getInt("idEspectaculo"), resultSet.getInt("numeroEntradas"),
						resultSet.getDouble("precio"));
				list.add(linea);
			}
			ps.close();
		}

		catch (SQLException exception) {
			return new ArrayList<>();
		}
		return list;
	}

}