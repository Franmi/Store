package negocio.Transacciones;

import java.util.concurrent.ConcurrentHashMap;

import negocio.Transacciones.imp.TransactionManagerImp;
import negocio.Transacciones.Transaction;


public abstract class TransactionManager {

	private static TransactionManager instance;


	public static TransactionManager getInstance() {

		return instance==null?instance=new TransactionManagerImp():instance ;

	}

	public abstract Transaction nuevaTransaccion(Thread hilo);


	public abstract Transaction getTransaction(Thread hilo);


	public abstract void eliminarTransaccion(Thread hilo);
	
	//agregue
	public abstract ConcurrentHashMap<Thread, Transaction> getTransacciones();
}