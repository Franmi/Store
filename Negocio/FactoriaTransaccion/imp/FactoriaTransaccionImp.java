package negocio.FactoriaTransaccion.imp;

import negocio.FactoriaTransaccion.FactoriaTransaccion;
import negocio.Transacciones.Transaction;
import negocio.Transacciones.imp.TransactionMySQL;

public class FactoriaTransaccionImp extends FactoriaTransaccion {

	public Transaction newTransaction() {

		return new TransactionMySQL();

	}
}