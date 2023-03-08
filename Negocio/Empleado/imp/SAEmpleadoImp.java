package negocio.Empleado.imp;

import java.util.Set;

import integracion.Empleado.DAOEmpleado;
import integracion.Factoria.FactoriaIntegracion;
import integracion.Espectaculo.DAOEspectaculo;
import negocio.Empleado.SAEmpleado;
import negocio.Empleado.TEmpleado;
import negocio.Espectaculo.TEspectaculo;
import negocio.Transacciones.Transaction;
import negocio.Transacciones.TransactionManager;

public class SAEmpleadoImp implements SAEmpleado {



	public int addEmpleado(TEmpleado empleado) {

		int id = -1;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction;

		DAOEmpleado daoEmpleado = FactoriaIntegracion.getInstance().createDAOEmpleado();
		TEmpleado empleadoLeido = daoEmpleado.read(empleado.getId());
		TEmpleado empleadoExiste = daoEmpleado.readEmpleadoPorDNI(empleado.getdni());

		try {
			transaction = transactionManager.nuevaTransaccion(Thread.currentThread());
		} catch (Exception exception) {
			transaction = transactionManager.getTransaction(Thread.currentThread());
		}

		try {
			transaction.start();

			if (empleadoLeido == null && empleadoExiste == null) {
				id = daoEmpleado.create(empleado);
				transaction.commit();
			} else if (empleadoLeido != null && !empleadoLeido.getActivo()) {
				empleadoLeido.setActivo(true);
				daoEmpleado.update(empleadoLeido);
				id = empleadoLeido.getId();
				transaction.commit();
			} else {
				transaction.rollback();
			}
		} catch (Exception exception) {
			return -1;
		}
		return id;
	}

	public TEmpleado readEmpleado(int id) {

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction;
		TEmpleado empleadoLeido;

		try {
			transaction = transactionManager.nuevaTransaccion(Thread.currentThread());
		} catch (Exception exception) {
			transaction = transactionManager.getTransaction(Thread.currentThread());
		}

		try {
			transaction.start();
			DAOEmpleado daoEmpleado = FactoriaIntegracion.getInstance().createDAOEmpleado();
			empleadoLeido = daoEmpleado.read(id);

			if (empleadoLeido != null && empleadoLeido.getActivo()) {
				transaction.commit();
			} else {
				empleadoLeido = null;
				transaction.rollback();
			}
		} catch (Exception e) {
			return null;
		}
		return empleadoLeido;
	}

	public int deleteEmpleado(int id) {

		int variable = -1;
		TransactionManager manager = TransactionManager.getInstance();
		Transaction transaction;

		try {
			transaction = manager.nuevaTransaccion(Thread.currentThread());

		} catch (Exception exception) {
			transaction = manager.getTransaction(Thread.currentThread());
		}
		try {
			transaction.start();

			DAOEmpleado daoEmpleado = FactoriaIntegracion.getInstance().createDAOEmpleado();
			TEmpleado empleadoLeido = daoEmpleado.read(id);
			DAOEspectaculo daoEspectaculo = FactoriaIntegracion.getInstance().createDAOEspectaculo();

			if (empleadoLeido != null && empleadoLeido.getActivo()) {
				Set<TEspectaculo> listaEspectaculos = daoEspectaculo.readEspectaculoByEmpleado(id);
				if (listaEspectaculos.isEmpty()) {
					variable = empleadoLeido.getId();
					daoEmpleado.delete(id);
					transaction.commit();
				} else
					transaction.rollback();
			} else {
				transaction.rollback();
			}
		} catch (Exception e) {
			return -1;
		}
		return variable;

	}

	public int updateEmpleado(TEmpleado empleado) {

		int id = 0;

		TransactionManager manager = TransactionManager.getInstance();
		Transaction transaction;

		try {
			transaction = manager.nuevaTransaccion(Thread.currentThread());

		} catch (Exception exception) {
			transaction = manager.getTransaction(Thread.currentThread());
		}

		try {
			transaction.start();

			DAOEmpleado daoEmpleado = FactoriaIntegracion.getInstance().createDAOEmpleado();
			TEmpleado empleadoLeido = daoEmpleado.readId(empleado.getId());
			TEmpleado empleadoLeido2 = daoEmpleado.readEmpleadoPorDNI(empleado.getdni());

			if (empleadoLeido != null && empleadoLeido2 == null
					|| (empleadoLeido2 != null && empleado.getId() == empleadoLeido2.getId())) {
				empleado.setActivo(true);
				daoEmpleado.update(empleado);
				transaction.commit();
				id = empleado.getId();

			} else {
				transaction.rollback();
			}

		} catch (Exception e) {
			return -1;
		}
		return id;
	}

	public Set<TEmpleado> readAllEmpleados() {

		DAOEmpleado daoEmpleado = FactoriaIntegracion.getInstance().createDAOEmpleado();
		TransactionManager tm = TransactionManager.getInstance();
		Transaction ts;

		try {
			ts = tm.nuevaTransaccion(Thread.currentThread());
		} catch (Exception e) {
			ts = tm.getTransaction(Thread.currentThread());
		}

		ts.start();
		Set<TEmpleado> set = daoEmpleado.readAll();
		ts.commit();
		return set;
	}

	public TEmpleado readEmpleadoPorDNI(String DNI) {

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction;
		TEmpleado empleadoLeido;

		try {
			transaction = transactionManager.nuevaTransaccion(Thread.currentThread());
		} catch (Exception exception) {
			transaction = transactionManager.getTransaction(Thread.currentThread());
		}

		try {
			transaction.start();
			DAOEmpleado daoEmpleado = FactoriaIntegracion.getInstance().createDAOEmpleado();
			empleadoLeido = daoEmpleado.readEmpleadoPorDNI(DNI);

			if (empleadoLeido != null && empleadoLeido.getActivo()) {
				transaction.commit();
			} else {
				empleadoLeido = null;
				transaction.rollback();
			}
		} catch (Exception e) {
			return null;
		}
		return empleadoLeido;
	}
}