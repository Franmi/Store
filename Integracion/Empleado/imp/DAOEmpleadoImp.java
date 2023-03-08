package integracion.Empleado.imp;

import negocio.Empleado.TEmpleado;
import negocio.Transacciones.TransactionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import integracion.Empleado.DAOEmpleado;

public class DAOEmpleadoImp implements DAOEmpleado {

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private DAOEmpleado dAOEmpleado;

	public int create(TEmpleado emp) {

		int id = 0;//-1;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO EMPLEADO (idEmpleado, nombre, apellidos, DNI, telefono, correo, activo) VALUES (?, ?, ?, ?, ?, ?,?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, emp.getId());
			preparedStatement.setString(2, emp.getNombre());
			preparedStatement.setString(3, emp.getApellidos());
			preparedStatement.setString(4, emp.getdni());
			preparedStatement.setString(5, emp.getTelefono());
			preparedStatement.setString(6, emp.getCorreo());
			preparedStatement.setBoolean(7, emp.getActivo());
			preparedStatement.executeUpdate();

			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

				if (resultSet.next()) {

					id = resultSet.getInt(1);
				}
			}
			preparedStatement.close();
			///resultSet.close();///
		}

		catch (SQLException exception) {
			System.err.println("no pudo conectarse");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
			return -1;
		}
		return id;
	}

	public TEmpleado read(int id) {

		TEmpleado tEmpleado = null;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM empleado WHERE idEmpleado=? AND activo=true FOR UPDATE",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tEmpleado = new TEmpleado(resultSet.getInt("idEmpleado"), resultSet.getString("nombre"),
						resultSet.getString("apellidos"), resultSet.getString("DNI"), resultSet.getString("telefono"),
						resultSet.getString("correo"), resultSet.getBoolean("activo"));
			}
			preparedStatement.close();

		} catch (SQLException exception) {
			return null;
		}
		return tEmpleado;
	}

	public Set<TEmpleado> readAll() {
		Set<TEmpleado> lista = new LinkedHashSet<TEmpleado>();
		TEmpleado e;
		Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM EMPLEADO", Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = ps.executeQuery("SELECT * FROM EMPLEADO  WHERE activo = true");

			while (rs.next()) {

				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");
				String dni = rs.getString("DNI");
				String telefono = rs.getString("Telefono");
				String correo = rs.getString("Correo");
				boolean activo = rs.getBoolean("Activo");
				int id = rs.getInt("idEmpleado");

				e = new TEmpleado(id, nombre, apellidos, dni, telefono, correo, activo);

				if (!activo) {
					e.setActivo(false);
				}

				lista.add(e);
			}

			ps.close();
		} catch (SQLException exception) {
			exception.printStackTrace();
			lista = null;
		}

		return lista;
	}

	public int update(TEmpleado emp) {
		int id = 0;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE Empleado SET nombre=?, apellidos=?, dni=?, telefono=?, correo=?, activo=true WHERE idEmpleado=?",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, emp.getNombre());
			ps.setString(2, emp.getApellidos());
			ps.setString(3, emp.getdni());
			ps.setString(4, emp.getTelefono());
			ps.setString(5, emp.getCorreo());
			ps.setInt(6, emp.getId());

			ps.executeUpdate();
			ResultSet resultSet = ps.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}

		}

		catch (SQLException exception) {
			exception.printStackTrace();
		}

		return id;

	}

	public int delete(int idEmpleado) {
		int exito = 0;
		String sql1 = "UPDATE empleado SET activo=false WHERE idEmpleado=?";
		try {
			Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
					.getResource();
			PreparedStatement ps = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, idEmpleado);

			int nrow = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if (nrow == 1) {
				exito = 0;
				rs.next();
			} else {
				exito = -2;
			}
			ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return -1;
		}
		return exito;
	}

	@Override
	public TEmpleado readEmpleadoPorDNI(String DNI) {
		TEmpleado tEmpleado = null;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM empleado WHERE DNI=? FOR UPDATE", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, DNI);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tEmpleado = new TEmpleado(resultSet.getInt("idEmpleado"), resultSet.getString("nombre"),
						resultSet.getString("apellidos"), resultSet.getString("DNI"), resultSet.getString("telefono"),
						resultSet.getString("correo"), resultSet.getBoolean("activo"));
			}
			preparedStatement.close();

		} catch (SQLException exception) {
			return null;
		}
		return tEmpleado;
	}

	public TEmpleado readId(int id) {

		TEmpleado tEmpleado = null;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"SELECT * FROM empleado WHERE idEmpleado=? FOR UPDATE", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				tEmpleado = new TEmpleado(resultSet.getInt("idEmpleado"), resultSet.getString("nombre"),
						resultSet.getString("apellidos"), resultSet.getString("DNI"), resultSet.getString("telefono"),
						resultSet.getString("correo"), resultSet.getBoolean("activo"));
			}
			preparedStatement.close();

		} catch (SQLException exception) {
			return null;
		}
		return tEmpleado;
	}
}