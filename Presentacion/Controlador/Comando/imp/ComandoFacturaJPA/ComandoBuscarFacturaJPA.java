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
public class ComandoBuscarFacturaJPA implements Comando {
	/** 
	* (non-Javadoc)
	* @see Comando#ejecutar(Object datos)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Contexto ejecutar(Object datos) {
		int id = (int) datos;
		TFacturaJPA tLeido = FactoriaNegocio.getInstance().createSAFacturaJPA().leerFactura(id);
		Contexto contexto;
		
		if(tLeido == null) {
			contexto = new Contexto(Evento.RES_BUSCAR_FACTURA_JPA_KO, "No se pudo completar la búsqueda, o bien la factura no existe");
		} else {
			contexto = new Contexto(Evento.RES_BUSCAR_FACTURA_JPA_OK, tLeido);
		}
		
		return contexto;
	}
}