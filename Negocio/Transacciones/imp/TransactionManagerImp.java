package negocio.Transacciones.imp;

import negocio.Transacciones.TransactionManager;

import negocio.FactoriaTransaccion.FactoriaTransaccion;
import negocio.Transacciones.Transaction;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionManagerImp extends TransactionManager {

	private ConcurrentHashMap<Thread,Transaction> concurrentHashMap;

	public TransactionManagerImp(){
		concurrentHashMap=new ConcurrentHashMap<Thread,Transaction>();
	}

	@Override
	public Transaction nuevaTransaccion(Thread hilo) {
		Transaction tr=null;
		if(concurrentHashMap.get(hilo)==null){
			tr=FactoriaTransaccion.getInstance().newTransaction();
			concurrentHashMap.put(hilo, tr);
		}else{
			throw new RuntimeException("Transaccion ya iniciada");
		}
		
		return tr;

	}

	@Override
	public Transaction getTransaction(Thread hilo) {
		if(concurrentHashMap.get(hilo)==null){
			nuevaTransaccion(hilo);
		}
		return concurrentHashMap.get(hilo);

	}

	@Override
	public void eliminarTransaccion(Thread hilo) {
		concurrentHashMap.remove(hilo);
	}
	


	@Override
	public ConcurrentHashMap<Thread, Transaction> getTransacciones() {
		// TODO Auto-generated method stub
		return concurrentHashMap;
	}
}