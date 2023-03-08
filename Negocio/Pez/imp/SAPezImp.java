package negocio.Pez.imp;

import negocio.Espectaculo.TEspectaculo;
import negocio.Pez.SAPez;
import negocio.Pez.TPez;
import negocio.Transacciones.Transaction;
import negocio.Transacciones.TransactionManager;

import java.util.Set;

import integracion.Espectaculo.DAOEspectaculo;
import integracion.Factoria.FactoriaIntegracion;
import integracion.Pez.DAOPez;

public class SAPezImp implements SAPez {

	public int create(TPez tPez) {
		int id = -1;
		DAOPez daoPez = FactoriaIntegracion.getInstance().createDAOPez();
		Transaction ts = TransactionManager.getInstance().getTransaction(Thread.currentThread());
		ts.start();
		TPez mismoId = daoPez.read(tPez.getIdPez());
		if (mismoId == null) {
			id = daoPez.create(tPez);
			ts.commit();
		} else if (mismoId != null && !mismoId.getActivo() && mismoId.getTipo().equals(tPez.getTipo())) {
			id = daoPez.update(tPez);
			ts.commit();
		} else
			ts.rollback();

		return id;
	}

	public int delete(int id) {
		int resultado;
		DAOPez daoPez = FactoriaIntegracion.getInstance().createDAOPez();
		TransactionManager tm = TransactionManager.getInstance();
		Transaction ts;

		if (id < 0)
			return -1;

		try {
			ts = tm.nuevaTransaccion(Thread.currentThread());
		} catch (Exception e) {
			ts = tm.getTransaction(Thread.currentThread());
		}

		ts.start();
		TPez tPez = daoPez.read(id);

		if (tPez == null || !tPez.getActivo()) {
			resultado = -2;
			ts.rollback();
		} else {
			DAOEspectaculo daoEsp = FactoriaIntegracion.getInstance().createDAOEspectaculo();

			Set<TEspectaculo> espectaculos = daoEsp.readEspectaculoByPez(id);

			if (espectaculos != null && !espectaculos.isEmpty()) {
				resultado = -2;
				ts.rollback();
			} else {
				resultado = daoPez.delete(id);
				ts.commit();
			}
		}

		return resultado;
	}

	public int update(TPez tPez) {
		if (!tPez.getActivo())
			throw new IllegalArgumentException(
					"No se puede dar de baja al modificar, ni se pueden modificar peces dados de baja");
		int id = -1;
		DAOPez daoPez = FactoriaIntegracion.getInstance().createDAOPez();
		Transaction ts = TransactionManager.getInstance().getTransaction(Thread.currentThread());
		ts.start();
		TPez mismoId = daoPez.read(tPez.getIdPez());
		if (mismoId != null) {
			if (mismoId.getTipo().equals(tPez.getTipo())) {
				id = daoPez.update(tPez);
				ts.commit();
			} else {
				ts.rollback();
				throw new IllegalArgumentException("No se puede cambiar el tipo de pez");
			}
		} else {
			ts.rollback();
			throw new IllegalArgumentException("No se ha podido leer el pez con el id introducido");
		}

		return id;
	}

	public TPez read(int id) {
		DAOPez daoPez = FactoriaIntegracion.getInstance().createDAOPez();
		TransactionManager tm = TransactionManager.getInstance();
		Transaction ts;

		if (id < 0)
			return null;

		try {
			ts = tm.nuevaTransaccion(Thread.currentThread());
		} catch (Exception e) {
			ts = tm.getTransaction(Thread.currentThread());
		}

		ts.start();
		TPez tPez = daoPez.read(id);

		if (tPez == null) {
			ts.rollback();
		} else {
			ts.commit();
		}

		return tPez;
	}

	public Set<TPez> readAll() {
		DAOPez daoPez = FactoriaIntegracion.getInstance().createDAOPez();
		TransactionManager tm = TransactionManager.getInstance();
		Transaction ts;

		try {
			ts = tm.nuevaTransaccion(Thread.currentThread());
		} catch (Exception e) {
			ts = tm.getTransaction(Thread.currentThread());
		}

		ts.start();
		Set<TPez> set = daoPez.readAll();
		ts.commit();
		return set;
	}

	public Set<TPez> readPezByEspectaculo(int idEspectaculo) {
		DAOPez daoPez = FactoriaIntegracion.getInstance().createDAOPez();
		TransactionManager tm = TransactionManager.getInstance();
		Transaction ts;

		try {
			ts = tm.nuevaTransaccion(Thread.currentThread());
		} catch (Exception e) {
			ts = tm.getTransaction(Thread.currentThread());
		}

		ts.start();
		Set<TPez> set = daoPez.readPezbyEspectaculo(idEspectaculo);
		ts.commit();
		return set;
	}

	@Override
	public int deletefisico(int id) {
		DAOPez daoPez = FactoriaIntegracion.getInstance().createDAOPez();
		Transaction ts = TransactionManager.getInstance().getTransaction(Thread.currentThread());
		ts.start();
		daoPez.deletefisico(id);
		ts.commit();
		return 0;
	}
}