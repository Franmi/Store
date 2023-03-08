package negocio.Factoria.imp;

import negocio.Empleado.SAEmpleado;
import negocio.Empleado.imp.SAEmpleadoImp;
import negocio.EmpleadoJPA.SAEmpleadoJPA;
import negocio.EmpleadoJPA.SAEmpleadoJPAImp;
import negocio.Espectaculo.SAEspectaculo;
import negocio.Espectaculo.imp.SAEspectaculoImp;
import negocio.Factoria.FactoriaNegocio;
import negocio.Factura.SAFactura;
import negocio.Factura.imp.SAFacturaImp;
import negocio.FacturaJPA.SAFacturaJPA;
import negocio.FacturaJPA.SAFacturaJPAImp;
import negocio.Pez.SAPez;
import negocio.Pez.imp.SAPezImp;
import negocio.Producto.SAProductoImp;
import negocio.Producto.SAProductoJPA;
import negocio.Turno.SATurno;
import negocio.Turno.imp.SATurnoImp;

public class FactoriaNegocioImp extends FactoriaNegocio {


	@Override
	public SAFactura createSAFactura() {
		return new SAFacturaImp();
	}


	@Override
	public SAEspectaculo createSAEspectaculo() {
		return new SAEspectaculoImp();
	}

	@Override
	public SAEmpleado createSAEmpleado() {
		return new SAEmpleadoImp();
	}

	@Override
	public SAPez createSAPez() {
		return new SAPezImp();
	}


	@Override
	public SATurno createSATurno() {
		return new SATurnoImp();
	}


	@Override
	public SAEmpleadoJPA createSAEmpleadoJPA() {
		return new SAEmpleadoJPAImp();
	}


	@Override
	public SAFacturaJPA createSAFacturaJPA() {
		return new SAFacturaJPAImp();
	}


	@Override
	public SAProductoJPA createSAProducto() {
		return new SAProductoImp();
	}


}