/**
 * 
 */
package negocio.Espectaculo.imp;

import negocio.Empleado.TEmpleado;
import negocio.Espectaculo.SAEspectaculo;
import negocio.Espectaculo.TEspectaculo;
import negocio.Espectaculo.TParticipa;
import negocio.Factura.TLineaFactura;
import negocio.Pez.TPez;
import negocio.Transacciones.Transaction;
import negocio.Transacciones.TransactionManager;

import java.util.Collection;
import java.util.Set;

import integracion.Empleado.DAOEmpleado;
import integracion.Espectaculo.DAOEspectaculo;
import integracion.Factoria.FactoriaIntegracion;
import integracion.Factura.DAOLineaFactura;
import integracion.Pez.DAOPez;
import integracion.Query.FactoriaQuery;

public class SAEspectaculoImp implements SAEspectaculo {

	public int create(TEspectaculo espectaculo) {
		int id = -1;
		DAOEspectaculo esp = FactoriaIntegracion.getInstance().createDAOEspectaculo();
		DAOEmpleado emp = FactoriaIntegracion.getInstance().createDAOEmpleado();
		if (espectaculo != null) {
			Transaction tr;
			try {
				tr = TransactionManager.getInstance().nuevaTransaccion(Thread.currentThread());
			} catch (Exception e) {
				tr = TransactionManager.getInstance().getTransaction(Thread.currentThread());
			}
			tr.start();
			TEmpleado aux = emp.read(espectaculo.getIdEmpleado());

			if (espectaculo != null && aux != null && aux.getActivo()) {
				id = esp.create(espectaculo);
			}
			if (id < 0) {
				tr.rollback();
			} else {
				tr.commit();
			}
		}
		return id;

	}

	public int update(TEspectaculo espectaculo) {
		int id = -1;
		DAOEspectaculo esp = FactoriaIntegracion.getInstance().createDAOEspectaculo();
		DAOEmpleado emp = FactoriaIntegracion.getInstance().createDAOEmpleado();
		if (espectaculo != null) {
			Transaction tr;
			try {
				tr = TransactionManager.getInstance().nuevaTransaccion(Thread.currentThread());
			} catch (Exception e) {
				tr = TransactionManager.getInstance().getTransaction(Thread.currentThread());
			}
			tr.start();
			TEmpleado aux = emp.read(espectaculo.getIdEmpleado());
			if (espectaculo != null && espectaculo.getActivo() && aux != null && aux.getActivo()) {
				espectaculo.setIdEmpleado(aux.getId());
				id = esp.update(espectaculo);

			}
			if (id > 0)
				tr.commit();
			else {
				tr.rollback();
			}
		}

		return id;
	}

	public int delete(int id) {
		int ok = -1;
		DAOEspectaculo esp = FactoriaIntegracion.getInstance().createDAOEspectaculo();
		DAOPez p = FactoriaIntegracion.getInstance().createDAOPez();
		DAOLineaFactura lf = FactoriaIntegracion.getInstance().createDAOLineaFactura();
		if (id > 0) {
			Transaction tr;
			try {
				tr = TransactionManager.getInstance().nuevaTransaccion(Thread.currentThread());
			} catch (Exception e) {
				tr = TransactionManager.getInstance().getTransaction(Thread.currentThread());
			}
			tr.start();

			TEspectaculo aux = esp.read(id);
			Set<TPez> setEsp = p.readPezbyEspectaculo(id);
			Collection<TLineaFactura> lista = lf.readByEspectaculo(id);

			if (aux != null && aux.getActivo() && setEsp.isEmpty() && lista.isEmpty()) {
				ok = esp.delete(id);
			}
			if (ok < 0) {
				tr.rollback();
			} else {
				tr.commit();
			}
		}
		return ok;

	}

	public TEspectaculo read(int id) {
		Transaction tr;
		try {
			tr = TransactionManager.getInstance().nuevaTransaccion(Thread.currentThread());
		} catch (Exception e) {
			tr = TransactionManager.getInstance().getTransaction(Thread.currentThread());
		}
		tr.start();
		TEspectaculo tEsp = null;
		DAOEspectaculo esp = FactoriaIntegracion.getInstance().createDAOEspectaculo();
		if (id > 0) {
			tEsp = esp.read(id);
		}
		tr.commit();
		return tEsp;
	}

	public Set<TEspectaculo> readAll() {
		Transaction tr;
		try {
			tr = TransactionManager.getInstance().nuevaTransaccion(Thread.currentThread());
		} catch (Exception e) {
			tr = TransactionManager.getInstance().getTransaction(Thread.currentThread());
		}
		tr.start();
		DAOEspectaculo esp = FactoriaIntegracion.getInstance().createDAOEspectaculo();
		Set<TEspectaculo> SetEsp = esp.readAll();
		tr.commit();
		return SetEsp;
	}

	@Override
	public Set<TEspectaculo> readEspectaculoByEmpleado(int idempleado) {
		Set<TEspectaculo> SetEsp = null;
		Transaction tr;
		try {
			tr = TransactionManager.getInstance().nuevaTransaccion(Thread.currentThread());
		} catch (Exception e) {
			tr = TransactionManager.getInstance().getTransaction(Thread.currentThread());
		}
		tr.start();
		DAOEspectaculo esp = FactoriaIntegracion.getInstance().createDAOEspectaculo();
		DAOEmpleado emp = FactoriaIntegracion.getInstance().createDAOEmpleado();
		TEmpleado aux = emp.read(idempleado);
		if (aux != null) {
			SetEsp = esp.readEspectaculoByEmpleado(idempleado);
		}
		tr.commit();
		return SetEsp;
	}

	@Override
	public int anyadirPez(TParticipa p) {
		int correct = -1;
		if (p != null) {
			Transaction tr;
			try {
				tr = TransactionManager.getInstance().nuevaTransaccion(Thread.currentThread());
			} catch (Exception e) {
				tr = TransactionManager.getInstance().getTransaction(Thread.currentThread());
			}
			tr.start();
			DAOEspectaculo esp = FactoriaIntegracion.getInstance().createDAOEspectaculo();
			DAOPez pez = FactoriaIntegracion.getInstance().createDAOPez();
			TEspectaculo tesp = esp.read(p.getIdEspectaculo());
			TPez tpez = pez.read(p.getIdPez());
			if (tesp.getActivo() && tesp != null && tpez != null && tpez.getActivo()) {
				Set<TEspectaculo> espectaculoPez = esp.readEspectaculoByPez(p.getIdPez());
				boolean asignado = false;
				for (TEspectaculo e : espectaculoPez) {
					if (e.getId() == p.getIdEspectaculo()) {
						asignado = true;
						break;
					}
				}
				if (!asignado) {
					correct = esp.anyadirPez(p);
				}
			}
			if (correct < 0) {
				tr.rollback();
			} else {
				tr.commit();
			}
		}
		return correct;
	}

	@Override
	public int eliminarPez(TParticipa p) {
		int correct = -1;
		if (p != null) {
			Transaction tr;
			try {
				tr = TransactionManager.getInstance().nuevaTransaccion(Thread.currentThread());
			} catch (Exception e) {
				tr = TransactionManager.getInstance().getTransaction(Thread.currentThread());
			}
			tr.start();
			DAOEspectaculo esp = FactoriaIntegracion.getInstance().createDAOEspectaculo();
			DAOPez pez = FactoriaIntegracion.getInstance().createDAOPez();
			TEspectaculo tesp = esp.read(p.getIdEspectaculo());
			TPez tpez = pez.read(p.getIdPez());
			if (tesp.getActivo() && tesp != null && tpez != null && tpez.getActivo()) {
				Set<TEspectaculo> espectaculoPez = esp.readEspectaculoByPez(p.getIdPez());
				boolean asignado = false;
				for (TEspectaculo e : espectaculoPez) {
					if (e.getId() == p.getIdEspectaculo()) {
						asignado = true;
						break;
					}
				}
				if (asignado) {
					correct = esp.eliminarPez(p);
				}
			}
			if (correct < 0) {
				tr.rollback();
			} else {
				tr.commit();
			}
		}
		return correct;
	}

	@Override
	public Set<TEspectaculo> readEspectaculoByPez(int idPez) {
		Set<TEspectaculo> SetEsp = null;
		Transaction tr;
		try {
			tr = TransactionManager.getInstance().nuevaTransaccion(Thread.currentThread());
		} catch (Exception e) {
			tr = TransactionManager.getInstance().getTransaction(Thread.currentThread());
		}
		tr.start();
		DAOEspectaculo esp = FactoriaIntegracion.getInstance().createDAOEspectaculo();
		DAOPez p = FactoriaIntegracion.getInstance().createDAOPez();
		TPez tpez = null;
		tpez = p.read(idPez);
		if (tpez != null) {
			SetEsp = esp.readEspectaculoByPez(idPez);
		}
		tr.commit();
		return SetEsp;
	}

	@Override
	public int deletefisico(int id) {
		// TODO Auto-generated method stub
		int ok = -1;
		DAOEspectaculo esp = FactoriaIntegracion.getInstance().createDAOEspectaculo();
		if (id > 0) {
			Transaction tr;
			try {
				tr = TransactionManager.getInstance().nuevaTransaccion(Thread.currentThread());
			} catch (Exception e) {
				tr = TransactionManager.getInstance().getTransaction(Thread.currentThread());
			}
			tr.start();
			int ok1 = esp.deletefisico(id);
			if (ok1 == 1) {
				ok = 1;
				tr.commit();
			} else {
				tr.rollback();
			}
		}
		return ok;
	}

	public int queryEspectaculo(int idEsp) {
		int result;

		if (idEsp < 0)
			return -1;

		DAOEspectaculo dao = FactoriaIntegracion.getInstance().createDAOEspectaculo();
		TEspectaculo tEsp = dao.read(idEsp);

		if (tEsp == null || !tEsp.getActivo())
			return -1;

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion;

		try {
			transaccion = tm.nuevaTransaccion(Thread.currentThread());
		} catch (Exception exception) {
			transaccion = tm.getTransaction(Thread.currentThread());
		}
		transaccion.start();

		result = (int) FactoriaQuery.getInstance().facturaEntradasEspectaculo().execute(idEsp);

		if (result >= 0) {
			transaccion.commit();
		} else {
			transaccion.rollback();
		}

		return result;
	}
}