package integracion.Query.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import integracion.Query.Query;
import negocio.Transacciones.TransactionManager;

public class FacturaEntradasEspectaculo implements Query {

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private static String Query;
	private final String query = "SELECT MAX(numeroEntradas) FROM acuario.contiene WHERE idEspectaculo = ? FOR UPDATE";

	@Override
	public Object execute(Object object) {
		int result = -1;
		Connection con = (Connection) TransactionManager.getInstance().getTransaction(Thread.currentThread())
				.getResource();

		try {
			PreparedStatement ps;
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, (int) object);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
			ps.close();

		} catch (SQLException e) {
			return -1;
		}

		return result;
	}

}
