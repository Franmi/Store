package integracion.Query;

import integracion.Query.imp.EntradasVendidasPrecio;
import integracion.Query.imp.FactoriaQueryImp;
import integracion.Query.imp.FacturaEntradasEspectaculo;

public abstract class FactoriaQuery {

	private static FactoriaQuery instance;

	public static FactoriaQuery getInstance() {
		if (instance == null) {
			instance = new FactoriaQueryImp();
		}
		return instance;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public abstract EntradasVendidasPrecio EntradasVendidasPrecio();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public abstract FacturaEntradasEspectaculo FacturaEntradasEspectaculo();

	public abstract EntradasVendidasPrecio entradasVendidasPrecio();

	public abstract FacturaEntradasEspectaculo facturaEntradasEspectaculo();

}