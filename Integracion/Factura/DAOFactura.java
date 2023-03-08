package integracion.Factura;

import java.util.Collection;
import negocio.Factura.TFactura;

public interface DAOFactura {

	public int create(TFactura tFactura);

	public TFactura read(int id);

	public int update(TFactura tFactura);

	public int delete(int id);

	public Collection<TFactura> readAll();

	public int devolverEspectaculo(TFactura tFactura);

	public int deleteFisico(int id);

}