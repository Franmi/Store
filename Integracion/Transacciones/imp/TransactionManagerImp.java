/**
 * 
 */
package integracion.Transacciones.imp;

import integracion.Transacciones.TransactionManager;
import java.util.Set;
import integracion.Transacciones.Transaction;
import java.util.concurrent.ConcurrentHashMap;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author diega
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class TransactionManagerImp extends TransactionManager {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Set<Transaction> transaction;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private ConcurrentHashMap concurrentHashMap;

	/** 
	* (non-Javadoc)
	* @see TransactionManager#nuevaTransaccion(Thread hilo)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Transaction nuevaTransaccion(Thread hilo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see TransactionManager#getTransaction(Thread hilo)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Transaction getTransaction(Thread hilo) {
		// begin-user-code
		// TODO Auto-generated method stub
		return null;
		// end-user-code
	}

	/** 
	* (non-Javadoc)
	* @see TransactionManager#eliminarTransaccion(Thread hilo)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void eliminarTransaccion(Thread hilo) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}
}