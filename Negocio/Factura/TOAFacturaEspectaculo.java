package negocio.Factura;

import java.util.Collection;
import java.util.Set;
import negocio.Espectaculo.TEspectaculo;

public class TOAFacturaEspectaculo {

	private TFactura tFactura;

	private Collection<TLineaFactura> tLineaFactura;

	private Set<TEspectaculo> tEspectaculo;

	public TOAFacturaEspectaculo() {
	}

	public void deleteLineaFactura(int idEspectaculo) {
	}

	public void setTFactura(TFactura tFactura) {
		this.tFactura = tFactura;
	}

	public TFactura getTFactura() {
		return tFactura;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tLineaFactura
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setTLineaFactura(TLineaFactura... tLineaFactura) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void setTLineaFactura(Collection<TLineaFactura> tLineaFactura) {
		this.tLineaFactura = tLineaFactura;
	}

	public Collection<TLineaFactura> getTLineaFactura() {
		return tLineaFactura;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tEspectaculo
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setTEspectaculo(TEspectaculo... tEspectaculo) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public void setTEspectaculo(Set<TEspectaculo> tEspectaculo) {
		this.tEspectaculo = tEspectaculo;
	}

	public Set<TEspectaculo> getTEspectaculo() {
		return tEspectaculo;
	}
}