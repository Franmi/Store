/**
 * 
 */
package presentacion.Controlador.Comando.imp.ComandoFacturaJPA;

import negocio.Factoria.FactoriaNegocio;
import negocio.FacturaJPA.TFacturaJPA;
import negocio.FacturaJPA.TLineaFacturaJPA;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author diega
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class ComandoDevolverProducto implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#ejecutar(Object datos)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Contexto ejecutar(Object datos) {
		TLineaFacturaJPA tLinea = (TLineaFacturaJPA) datos;
		int res = FactoriaNegocio.getInstance().createSAFacturaJPA().devolverProducto(tLinea);
		Contexto contexto;
		
		if(res == -1) {
			contexto = new Contexto(Evento.RES_DEVOLVER_PRODUCTO_KO, "No se pudo realizar la devolución");
		} else if (res == -2) {
			contexto = new Contexto(Evento.RES_DEVOLVER_PRODUCTO_KO, "La cantidad debe ser mayor que 0");
		} else if(res == -3) {
			contexto = new Contexto(Evento.RES_DEVOLVER_PRODUCTO_KO, "La factura no existe o está inactiva");
		} else if (res == -4){
			contexto = new Contexto(Evento.RES_DEVOLVER_PRODUCTO_KO, "El producto no existe");
		} else if (res == -5) {
			contexto = new Contexto(Evento.RES_DEVOLVER_PRODUCTO_KO, "La factura no contiene el producto especificado");
		}
		else {
			contexto = new Contexto(Evento.RES_DEVOLVER_PRODUCTO_OK, "La devolución se ha realizado correctamente");
		}
		
		return contexto;
	}
}