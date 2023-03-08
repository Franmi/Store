package integracion.Factura.imp;

import integracion.Factura.DAOFactura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import negocio.Factura.TFactura;
import negocio.Transacciones.TransactionManager;

public class DAOFacturaImp implements DAOFactura {

	public int create(TFactura tFactura) {
		int id = 0;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO factura (DNICliente, coste, numEspectaculos, fecha, activo) VALUES (?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, tFactura.getDNICliente());
			preparedStatement.setDouble(2, tFactura.getTotal());
			preparedStatement.setInt(3, tFactura.getNumeroEspectaculos());
			preparedStatement.setString(4, tFactura.getFecha());
			preparedStatement.setBoolean(5, tFactura.getActivo());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			preparedStatement.close();
		}

		catch (SQLException exception) {
			return -1;
		}
		return id;
	}

	public TFactura read(int id) {
		TFactura tFactura = null;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM factura WHERE idFactura=? AND activo=true FOR UPDATE",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tFactura = new TFactura(resultSet.getInt("idFactura"), resultSet.getString("DNICliente"),
						resultSet.getString("fecha"), resultSet.getDouble("coste"),
						resultSet.getInt("numEspectaculos"));
				resultSet.getBoolean("activo");
			}
			preparedStatement.close();

		} catch (SQLException exception) {
			return null;
		}
		return tFactura;
	}

	public int update(TFactura tFactura) {
		int id = -1;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(
						"UPDATE factura SET DNICliente=?, fecha=? WHERE idFactura=?", Statement.RETURN_GENERATED_KEYS);

				preparedStatement.setString(1, tFactura.getDNICliente());
				preparedStatement.setString(2, tFactura.getFecha());
				preparedStatement.setInt(3, tFactura.getId());
				int filas = preparedStatement.executeUpdate();
				preparedStatement.close();
				if (filas > 0)
					id = tFactura.getId();
			} catch (SQLException exception) {
				return -1;
			}
		}

		return id;
	}

	public int delete(int id) {
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE factura SET activo=? WHERE idFactura=? AND activo=true", Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setBoolean(1, false);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException exception) {
			return -1;
		}

		return id;
	}

	public Collection<TFactura> readAll() {
		Collection<TFactura> list = new ArrayList<TFactura>();

		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM factura WHERE activo=true FOR UPDATE", Statement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				TFactura tFactura = new TFactura(resultSet.getInt("idFactura"), resultSet.getString("DNICliente"),
						resultSet.getString("fecha"), resultSet.getDouble("coste"),
						resultSet.getInt("numEspectaculos"));
				list.add(tFactura);
			}
			preparedStatement.close();
		}

		catch (SQLException exception) {
			return new ArrayList<TFactura>();
		}
		return list;
	}

	public int devolverEspectaculo(TFactura tFactura) {
		int id = -1;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(
						"UPDATE factura SET coste=?, numEspectaculos=? WHERE idFactura=?",
						Statement.RETURN_GENERATED_KEYS);

				preparedStatement.setDouble(1, tFactura.getTotal());
				preparedStatement.setInt(2, tFactura.getNumeroEspectaculos());
				preparedStatement.setInt(3, tFactura.getId());
				int filas = preparedStatement.executeUpdate();
				preparedStatement.close();
				if (filas > 0)
					id = tFactura.getId();
			} catch (SQLException exception) {
				return -1;
			}
		}

		return id;
	}

	public int deleteFisico(int id) {
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM factura WHERE idFactura=?",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException exception) {
			id = -1;
		}
		return id;
	}

}