package integracion.Factoria.imp;

import integracion.Empleado.DAOEmpleado;
import integracion.Empleado.imp.DAOEmpleadoImp;
import integracion.Espectaculo.DAOEspectaculo;
import integracion.Espectaculo.imp.DAOEspectaculoImp;
import integracion.Factoria.FactoriaIntegracion;
import integracion.Factura.DAOFactura;
import integracion.Factura.DAOLineaFactura;
import integracion.Factura.imp.DAOFacturaImp;
import integracion.Factura.imp.DAOLineaFacturaImp;
import integracion.Pez.DAOPez;
import integracion.Pez.imp.DAOPezImp;

public class FactoriaIntegracionImp extends FactoriaIntegracion {
	
	@Override
	public DAOEspectaculo createDAOEspectaculo() {
		return new DAOEspectaculoImp();
		
	}

	@Override
	public DAOFactura createDAOFactura() {
		return new DAOFacturaImp();
	}

	@Override
	public DAOLineaFactura createDAOLineaFactura() {
		return new DAOLineaFacturaImp();
	}

	@Override
	public DAOPez createDAOPez() {
		return new DAOPezImp();
	}

	@Override
	public DAOEmpleado createDAOEmpleado() {
		return new DAOEmpleadoImp();
	}

}