/**
 * 
 */
package presentacion.Controlador.Comando.imp.ComandoFacturaJPA;

import negocio.Factoria.FactoriaNegocio;
import negocio.FacturaJPA.TFacturaJPA;
import presentacion.Controlador.Evento;
import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.Comando.Contexto;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author diega
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class ComandoEliminarFacturaJPA implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#ejecutar(Object datos)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		int result = FactoriaNegocio.getInstance().createSAFacturaJPA().bajaFactura(id);
		Contexto contexto;
		
		if(result == -1) {
			contexto = new Contexto(Evento.RES_ELIMINAR_FACTURA_JPA_KO, "No se pudo realizar la baja");
		} else if(result == -2) {
			contexto = new Contexto(Evento.RES_ELIMINAR_FACTURA_JPA_KO, "La factura no existe o está inactiva");
		}
		else {
			contexto = new Contexto(Evento.RES_ELIMINAR_FACTURA_JPA_OK, "La baja se realizó correctamente");
		}
		
		return contexto;
	}
}