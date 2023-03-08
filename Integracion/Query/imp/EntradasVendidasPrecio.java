package integracion.Query.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import integracion.Query.Query;
import negocio.Transacciones.TransactionManager;

public class EntradasVendidasPrecio implements Query {
	private final String query = "SELECT SUM(numeroEntradas) FROM contiene WHERE precio > ? FOR UPDATE";

	@Override
	public Object execute(Object object) {
		int entradas = -1;
		Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();
		try {
			PreparedStatement ps;
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, (Double) object);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				entradas = rs.getInt(1);
			}
			ps.close();

		} catch (SQLException e) {
			return -1;
		}

		return entradas;
	}

}
