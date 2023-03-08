package negocio.Factura;

import java.util.Collection;

public interface SAFactura {

	public int create(TOAFacturaEspectaculo toaFacturaEspectaculo);

	public TFactura read(int id);

	public int update(TFactura tFactura);

	public int delete(int id);

	public Collection<TFactura> readAll();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tLineaFactura
	* @param id
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void devolverEspectaculo(TLineaFactura tLineaFactura, int id);

	public int devolverEspectaculo(TLineaFactura tLineaFactura);

	public int deleteFisico(int id);

	public int queryEntradas(double precio);

}