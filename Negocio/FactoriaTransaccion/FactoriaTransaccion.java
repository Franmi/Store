package negocio.FactoriaTransaccion;

import negocio.Transacciones.Transaction;
import negocio.FactoriaTransaccion.imp.*;

public abstract class FactoriaTransaccion {

	private static FactoriaTransaccion instance;

	public static FactoriaTransaccion getInstance() {
		if (instance == null) {
			instance = new FactoriaTransaccionImp();
		}
		return instance;
	}

	public abstract Transaction newTransaction();
}