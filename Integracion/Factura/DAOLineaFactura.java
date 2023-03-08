package integracion.Factura;

import negocio.Factura.TLineaFactura;

import java.util.Collection;

public interface DAOLineaFactura {

	public int create(TLineaFactura tLineaFactura);

	public TLineaFactura read(int idFactura, int idEspectaculo);

	public int delete(int idFactura, int idEspectaculo);

	public int update(TLineaFactura tLineaFactura);

	public Collection<TLineaFactura> readByFactura(int id);

	public Collection<TLineaFactura> readByEspectaculo(int id);

}