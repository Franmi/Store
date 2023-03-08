package integracion.Factoria;

import integracion.Espectaculo.DAOEspectaculo;
import integracion.Factoria.imp.FactoriaIntegracionImp;
import integracion.Factura.DAOFactura;
import integracion.Factura.DAOLineaFactura;
import integracion.Pez.DAOPez;
import integracion.Empleado.DAOEmpleado;

public abstract class FactoriaIntegracion {

	private static FactoriaIntegracion instance;

	
	public static FactoriaIntegracion getInstance() {
		if (instance == null)
			instance = new FactoriaIntegracionImp();
		return instance;
	}

	public abstract DAOEspectaculo createDAOEspectaculo();

	public abstract DAOFactura createDAOFactura();

	public abstract DAOLineaFactura createDAOLineaFactura();

	public abstract DAOPez createDAOPez();

	public abstract DAOEmpleado createDAOEmpleado();

}