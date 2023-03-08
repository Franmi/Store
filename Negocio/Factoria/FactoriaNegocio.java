package negocio.Factoria;

import negocio.Empleado.SAEmpleado;
import negocio.EmpleadoJPA.SAEmpleadoJPA;
import negocio.Espectaculo.SAEspectaculo;
import negocio.Factoria.imp.FactoriaNegocioImp;
import negocio.Factura.SAFactura;
import negocio.FacturaJPA.SAFacturaJPA;
import negocio.Pez.SAPez;
import negocio.Producto.SAProductoJPA;
import negocio.Turno.SATurno;

public abstract class FactoriaNegocio {

	private static FactoriaNegocio instance;

	public synchronized static FactoriaNegocio getInstance() {
		if (instance == null) instance = new FactoriaNegocioImp();
		return instance;
	}

	public abstract SAFactura createSAFactura();

	public abstract SAEspectaculo createSAEspectaculo();

	public abstract SAEmpleado createSAEmpleado();

	public abstract SAPez createSAPez();


	//JPA
	public abstract SATurno createSATurno();

	public abstract SAEmpleadoJPA createSAEmpleadoJPA();

	public abstract SAFacturaJPA createSAFacturaJPA();

	public abstract SAProductoJPA createSAProducto();
}