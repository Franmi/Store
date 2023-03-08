package integracion.Pez.imp;

import integracion.Pez.DAOPez;
import negocio.Pez.TFluvial;
import negocio.Pez.TMarino;
import negocio.Pez.TPez;
import negocio.Transacciones.TransactionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

public class DAOPezImp implements DAOPez {

	public int create(TPez tPez) {
		int id = 0;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {

			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO PEZ (idPez, nombre,tipo, activo) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, tPez.getIdPez());
			ps.setString(2, tPez.getNombre());
			ps.setString(3, tPez.getTipo());
			ps.setBoolean(4, tPez.getActivo());
			ps.executeUpdate();
			ResultSet resultSet = ps.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
			if (tPez instanceof TMarino) {
				TMarino tMarino = (TMarino) tPez;
				PreparedStatement ps2 = connection.prepareStatement(
						"INSERT INTO marino (idPez, salinidad) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
				ps2.setInt(1, id);
				ps2.setDouble(2, tMarino.getSalinidad());
				ps2.executeUpdate();
			} else if (tPez instanceof TFluvial) {
				TFluvial tFluvial = (TFluvial) tPez;
				PreparedStatement ps2 = connection.prepareStatement(
						"INSERT INTO fluvial (idPez, temperatura) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
				ps2.setInt(1, id);
				ps2.setInt(2, tFluvial.getTemperatura());
				ps2.executeUpdate();
			}

		}

		catch (SQLException exception) {
			exception.printStackTrace();
			return -1;
		}

		return id;

	}

	public int delete(int id) {
		int result = 0;
		Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE pez SET activo = ? WHERE idPez = ?",
					Statement.RETURN_GENERATED_KEYS);
			ps.setBoolean(1, false);
			ps.setInt(2, id);

			int exito = ps.executeUpdate();

			if (exito == 1) {
				result = id;
			} else {
				result = -1;
			}

			ps.close();
		} catch (SQLException e) {
			result = -1;
		}

		return result;
	}

	public int update(TPez tPez) {

		int id = -1;
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {

			PreparedStatement ps = connection.prepareStatement(
					"UPDATE Pez SET nombre=?, tipo=?, activo=? WHERE idPez= ?", Statement.RETURN_GENERATED_KEYS);
			ps.setInt(4, tPez.getIdPez());
			ps.setString(1, tPez.getNombre());
			ps.setString(2, tPez.getTipo());
			ps.setBoolean(3, tPez.getActivo());
			int filasCambiadas = ps.executeUpdate();

			if (tPez instanceof TMarino) {
				TMarino tMarino = (TMarino) tPez;
				PreparedStatement ps2 = connection.prepareStatement("UPDATE Marino SET salinidad=? WHERE idPez= ?",
						Statement.RETURN_GENERATED_KEYS);
				ps2.setInt(2, tMarino.getIdPez());
				ps2.setDouble(1, tMarino.getSalinidad());
				ps2.executeUpdate();
			} else if (tPez instanceof TFluvial) {
				TFluvial tFluvial = (TFluvial) tPez;
				PreparedStatement ps2 = connection.prepareStatement("UPDATE Fluvial SET temperatura=? WHERE idPez= ?",
						Statement.RETURN_GENERATED_KEYS);
				ps2.setInt(2, tFluvial.getIdPez());
				ps2.setInt(1, tFluvial.getTemperatura());
				ps2.executeUpdate();
			}

			if (filasCambiadas > 0)
				id = tPez.getIdPez();

		}

		catch (SQLException exception) {
			return -1;
		}

		return id;
	}

	public TPez read(int id) {
		TPez tPez = null;
		Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM pez WHERE idPez = ? FOR UPDATE",
					Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String tipo = rs.getString("tipo");
				String nombre = rs.getString("nombre");
				int idPez = rs.getInt("idPez");
				boolean activo = rs.getBoolean("activo");

				ResultSet rs2;
				PreparedStatement ps2 = null;

				if (tipo.equals("marino")) {
					ps2 = con.prepareStatement("SELECT * FROM marino WHERE idPez = ? FOR UPDATE",
							Statement.RETURN_GENERATED_KEYS);
					ps2.setInt(1, id);
					rs2 = ps2.executeQuery();

					if (rs2.next()) {
						double salinidad = rs2.getDouble("salinidad");
						tPez = new TMarino(idPez, nombre, salinidad);
					}

				} else if (tipo.equals("fluvial")) {
					ps2 = con.prepareStatement("SELECT * FROM fluvial WHERE idPez = ? FOR UPDATE",
							Statement.RETURN_GENERATED_KEYS);
					ps2.setInt(1, id);
					rs2 = ps2.executeQuery();

					if (rs2.next()) {
						int temperatura = rs2.getInt("temperatura");
						tPez = new TFluvial(idPez, nombre, temperatura);
					}
				}

				if (!activo && tPez != null) {
					tPez.setActivo(false);
				}
				ps2.close();
			}

			ps.close();
		} catch (SQLException e) {

		}

		return tPez;
	}

	public Set<TPez> readAll() {
		Set<TPez> set = new LinkedHashSet<TPez>();
		TPez tPez = null;
		Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM pez WHERE activo = true FOR UPDATE",
					Statement.RETURN_GENERATED_KEYS), ps2;
			ResultSet rs = ps.executeQuery(), rs2;

			while (rs.next()) {
				String tipo = rs.getString("tipo");
				String nombre = rs.getString("nombre");
				boolean activo = rs.getBoolean("activo");
				int idPez = rs.getInt("idPez");

				if (tipo.equals("marino")) {
					ps2 = con.prepareStatement("SELECT * FROM marino WHERE idPez = ? FOR UPDATE",
							Statement.RETURN_GENERATED_KEYS);
					ps2.setInt(1, idPez);
					rs2 = ps2.executeQuery();

					if (rs2.next()) {
						double salinidad = rs2.getDouble("salinidad");
						tPez = new TMarino(idPez, nombre, salinidad);
					}

				} else if (tipo.equals("fluvial")) {
					ps2 = con.prepareStatement("SELECT * FROM fluvial WHERE idPez = ? FOR UPDATE",
							Statement.RETURN_GENERATED_KEYS);
					ps2.setInt(1, idPez);
					rs2 = ps2.executeQuery();

					if (rs2.next()) {
						int temperatura = rs2.getInt("temperatura");
						tPez = new TFluvial(idPez, nombre, temperatura);
					}
				}
				if (!activo) {
					tPez.setActivo(false);
				}

				set.add(tPez);
			}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			set = null;
		}

		return set;
	}

	@Override
	public Set<TPez> readPezbyEspectaculo(int idEspectaculo) {
		Set<TPez> set = new LinkedHashSet<TPez>();
		TPez tPez = null;
		Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();
		try {
			PreparedStatement ps = con.prepareStatement(
					"SELECT * FROM pez JOIN participa ON participa.idPez=pez.idPez WHERE idEspectaculo = ? FOR UPDATE",
					Statement.RETURN_GENERATED_KEYS), ps2;
			ps.setInt(1, idEspectaculo);
			ResultSet rs = ps.executeQuery(), rs2;

			while (rs.next()) {
				String tipo = rs.getString("tipo");
				String nombre = rs.getString("nombre");
				boolean activo = rs.getBoolean("activo");
				int idPez = rs.getInt("idPez");

				if (tipo.equals("marino")) {
					ps2 = con.prepareStatement("SELECT * FROM marino WHERE idPez = ? FOR UPDATE",
							Statement.RETURN_GENERATED_KEYS);
					ps2.setInt(1, idPez);
					rs2 = ps2.executeQuery();

					if (rs2.next()) {
						double salinidad = rs2.getDouble("salinidad");
						tPez = new TMarino(idPez, nombre, salinidad);
					}

				} else if (tipo.equals("fluvial")) {
					ps2 = con.prepareStatement("SELECT * FROM fluvial WHERE idPez = ? FOR UPDATE",
							Statement.RETURN_GENERATED_KEYS);
					ps2.setInt(1, idPez);
					rs2 = ps2.executeQuery();

					if (rs2.next()) {
						int temperatura = rs2.getInt("temperatura");
						tPez = new TFluvial(idPez, nombre, temperatura);
					}
				}
				if (!activo) {
					tPez.setActivo(false);
				}

				set.add(tPez);
			}

			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			set = null;
		}

		return set;
	}

	@Override
	public void deletefisico(int id) {
		Connection connection = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();
		try {
			PreparedStatement ps1 = connection.prepareStatement("DELETE FROM fluvial WHERE idPez = ?",
					Statement.RETURN_GENERATED_KEYS);
			ps1.setInt(1, id);
			ps1.executeUpdate();
			ps1.close();

			PreparedStatement ps2 = connection.prepareStatement("DELETE FROM marino WHERE idPez = ?",
					Statement.RETURN_GENERATED_KEYS);
			ps2.setInt(1, id);
			ps2.executeUpdate();
			ps2.close();

			PreparedStatement ps3 = connection.prepareStatement("DELETE FROM pez WHERE idPez = ?",
					Statement.RETURN_GENERATED_KEYS);
			ps3.setInt(1, id);
			ps3.executeUpdate();
			ps3.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}