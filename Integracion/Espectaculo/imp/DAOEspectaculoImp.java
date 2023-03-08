package integracion.Espectaculo.imp;

import integracion.Espectaculo.DAOEspectaculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;
import negocio.Espectaculo.TEspectaculo;
import negocio.Espectaculo.TParticipa;
import negocio.Transacciones.TransactionManager;

public class DAOEspectaculoImp implements DAOEspectaculo {

	public int create(TEspectaculo esp) {
		int id = -1;
		String sql = "INSERT INTO espectaculo (idEspectaculo, nombre, precio, entradas, idEmpleado, activo) VALUES(?,?,?,?,?,?)";
		try {
			Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
					.getResource();
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, esp.getId());
			ps.setString(2, esp.getNombre());
			ps.setDouble(3, esp.getPrecio());
			ps.setInt(4, esp.getEntradas());
			ps.setInt(5, esp.getIdEmpleado());
			ps.setBoolean(6, true);
			ps.executeUpdate();
			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					id = rs.getInt(1);
				}
			}
			ps.close();
		} catch (SQLException e) {
			System.err.println("no pudo conectarse");
			System.err.println(e.getMessage());
			return -2;
		}
		return id;
	}

	public int delete(int id) {
		int exito = 0;
		String sql1 = "UPDATE espectaculo SET activo=false WHERE idEspectaculo=?";
		String sql2 = "DELETE FROM participa WHERE idEspectaculo=?";
		try {
			Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
					.getResource();
			PreparedStatement ps = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			int nrow = ps.executeUpdate();
			if (nrow == 0) {
				exito = 0;
			} else if (nrow == 1) {
				exito = 1;
				PreparedStatement pt = con.prepareStatement(sql2);
				pt.setInt(1, id);
				pt.execute();
			} else {
				exito = -1;
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return -2;
		}
		return exito;
	}

	public Set<TEspectaculo> readAll() {

		Set<TEspectaculo> set = new LinkedHashSet<TEspectaculo>();
		TEspectaculo t;
		Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM espectaculo WHERE activo=true FOR UPDATE",
					Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = ps.executeQuery("SELECT * FROM espectaculo WHERE activo=true FOR UPDATE");

			while (rs.next()) {
				int id = rs.getInt("idEspectaculo");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int entradas = rs.getInt("entradas");
				int idEmpleado = rs.getInt("IDEmpleado");
				boolean activo = rs.getBoolean("activo");
				t = new TEspectaculo(id, nombre, precio, entradas, idEmpleado, activo);
				if (!activo) {
					t.setActivo(false);
				}

				set.add(t);
			}

			ps.close();
		} catch (SQLException e) {
			set = null;
			System.err.println(e.getMessage());
		}

		return set;

	}

	public int update(TEspectaculo esp) {

		int id = 0;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE espectaculo SET nombre=?, precio=?, entradas=?,idEmpleado=?, activo=? WHERE idEspectaculo=?",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, esp.getNombre());
			ps.setDouble(2, esp.getPrecio());
			ps.setInt(3, esp.getEntradas());
			ps.setInt(4, esp.getIdEmpleado());
			ps.setBoolean(5, esp.getActivo());
			ps.setInt(6, esp.getId());
			int row = ps.executeUpdate();
			//ResultSet resultSet = ps.getGeneratedKeys();
			if (row > 0) {
				id = esp.getId();
			}

		}

		catch (SQLException exception) {
			System.err.println(exception.getMessage());
			return -1;
		}

		return id;

	}

	public TEspectaculo read(int id) {

		TEspectaculo t = null;
		Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();
		try {
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM espectaculo WHERE idEspectaculo=? and activo=true FOR UPDATE",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int entradas = rs.getInt("entradas");
				int idEmpleado = rs.getInt("idEmpleado");
				boolean activo = rs.getBoolean("activo");

				t = new TEspectaculo(rs.getInt("idEspectaculo"), nombre, precio, entradas, idEmpleado, activo);
				if (!activo) {
					t.setActivo(false);
				}
			}

			ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return t;
		// end-user-code

	}

	@Override
	public Set<TEspectaculo> readEspectaculoByEmpleado(int idempleado) {
		// TODO Auto-generated method stub
		Set<TEspectaculo> set = new LinkedHashSet<TEspectaculo>();
		String sql = "SELECT * FROM espectaculo WHERE idEmpleado=? FOR UPDATE";
		try {
			Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
					.getResource();
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, idempleado);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					TEspectaculo aux = new TEspectaculo(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),
							rs.getInt(5), rs.getBoolean(6));
					if (aux.getActivo()) {
						set.add(aux);
					}
				}
			}
			ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());

		}
		return set;
	}

	@Override
	public int anyadirPez(TParticipa p) {
		// TODO Auto-generated method stub
		int correct = -1;
		String sql = "INSERT INTO participa (idEspectaculo, idPez) VALUES(?,?)";
		try {
			Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
					.getResource();
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, p.getIdEspectaculo());
			ps.setInt(2, p.getIdPez());
			int ok = ps.executeUpdate();
			if (ok == 1) {
				correct = 1;
			}
			ps.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return -2;
		}
		return correct;
	}

	@Override
	public int eliminarPez(TParticipa p) {
		// TODO Auto-generated method stub
		int correct = -1;
		String sql = "DELETE FROM participa WHERE idEspectaculo=? AND idPez=?";
		try {
			Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
					.getResource();
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, p.getIdEspectaculo());
			ps.setInt(2, p.getIdPez());
			int ok = ps.executeUpdate();
			if (ok == 1) {
				correct = 1;
			}
			ps.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return -2;
		}
		return correct;
	}

	@Override
	public Set<TEspectaculo> readEspectaculoByPez(int idPez) {
		// TODO Auto-generated method stub
		Set<TEspectaculo> set = new LinkedHashSet<TEspectaculo>();
		String sql = "SELECT * FROM espectaculo e JOIN acuario.participa p ON e.idEspectaculo=p.idEspectaculo WHERE idPez=? FOR UPDATE";
		try {
			Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
					.getResource();
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, idPez);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					TEspectaculo aux = new TEspectaculo(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4),
							rs.getInt(5), rs.getBoolean(6));
					set.add(aux);
				}
			}
			ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return set;
	}

	@Override
	public int deletefisico(int id) {
		// TODO Auto-generated method stub
		int exito = -1;
		String sql = "DELETE FROM espectaculo WHERE idEspectaculo=?";
		try {
			Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
					.getResource();
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			int ok = ps.executeUpdate();
			if (ok == 1)
				exito = 1;
			ps.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return -2;
		}
		return exito;
	}
}