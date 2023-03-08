package negocio.Factura.imp;

import negocio.Espectaculo.TEspectaculo;
import negocio.Factura.SAFactura;
import negocio.Factura.TFactura;
import negocio.Factura.TLineaFactura;
import negocio.Factura.TOAFacturaEspectaculo;
import negocio.Transacciones.Transaction;
import negocio.Transacciones.TransactionManager;

import java.util.ArrayList;
import java.util.Collection;

import integracion.Espectaculo.DAOEspectaculo;
import integracion.Factoria.FactoriaIntegracion;
import integracion.Factura.DAOFactura;
import integracion.Factura.DAOLineaFactura;
import integracion.Query.FactoriaQuery;

public class SAFacturaImp implements SAFactura {

	public int create(TOAFacturaEspectaculo toaFacturaEspectaculo) {
		int idFactura = -1;

		DAOLineaFactura daoLineaFactura = FactoriaIntegracion.getInstance().createDAOLineaFactura();
		DAOFactura daoFactura = FactoriaIntegracion.getInstance().createDAOFactura();
		DAOEspectaculo daoEspectaculo = FactoriaIntegracion.getInstance().createDAOEspectaculo();

		Collection<TLineaFactura> lineas = new ArrayList<TLineaFactura>();
		Collection<TEspectaculo> espectaculos = new ArrayList<TEspectaculo>();

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion;

		try {
			transaccion = transactionManager.nuevaTransaccion(Thread.currentThread());
		} catch (Exception exception) {
			transaccion = transactionManager.getTransaction(Thread.currentThread());
		}
		try {
			transaccion.start();
			double precio = 0;
			int numeroEspectaculos = 0;
			for (TLineaFactura linea : toaFacturaEspectaculo.getTLineaFactura()) {
				TEspectaculo tEspectaculo = daoEspectaculo.read(linea.getIdEspectaculo());
				int cantidad = 0;
				if (tEspectaculo.getEntradas() == 0 && tEspectaculo.getActivo())
					return -2;
				if (tEspectaculo != null && tEspectaculo.getActivo() && linea.getNumeroEntradas() > 0
						&& tEspectaculo.getEntradas() > 0) {
					lineas.add(linea);
					if (linea.getNumeroEntradas() <= tEspectaculo.getEntradas()) {
						cantidad += linea.getNumeroEntradas();
						precio += cantidad * tEspectaculo.getPrecio();
						tEspectaculo.setEntradas(tEspectaculo.getEntradas() - linea.getNumeroEntradas());
					} else {
						cantidad += tEspectaculo.getEntradas();
						precio += cantidad * tEspectaculo.getPrecio();
						tEspectaculo.setEntradas(0);
						linea.setNumeroEntradas(cantidad);
					}
					numeroEspectaculos++;
					espectaculos.add(tEspectaculo);
					daoEspectaculo.update(tEspectaculo);
				}

			}

			if (!lineas.isEmpty() && !espectaculos.isEmpty()) {
				toaFacturaEspectaculo.getTFactura().setNumeroEspectaculos(numeroEspectaculos);
				toaFacturaEspectaculo.getTFactura().setTotal(precio);
				idFactura = daoFactura.create(toaFacturaEspectaculo.getTFactura());
				if (idFactura > 0) {
					for (TLineaFactura linea : toaFacturaEspectaculo.getTLineaFactura()) {
						linea.setPrecio(daoEspectaculo.read(linea.getIdEspectaculo()).getPrecio());
						linea.setIdFactura(idFactura);
						daoLineaFactura.create(linea);
					}
				}
			}

			if (idFactura == -1)
				transaccion.rollback();
			else
				transaccion.commit();

		} catch (Exception exception) {
			return -1;
		}
		return idFactura;
	}

	public TFactura read(int id) {
		TransactionManager manager = TransactionManager.getInstance();
		Transaction transaction;
		TFactura factura = null;

		try {
			transaction = manager.nuevaTransaccion(Thread.currentThread());
		} catch (Exception exception) {
			transaction = manager.getTransaction(Thread.currentThread());
		}
		try {
			transaction.start();
			factura = FactoriaIntegracion.getInstance().createDAOFactura().read(id);

			if (factura == null)
				transaction.rollback();
			else
				transaction.commit();

		} catch (Exception exception) {
			return null;
		}
		return factura;
	}

	public int update(TFactura tFactura) {
		int id = -1;
		TransactionManager manager = TransactionManager.getInstance();
		Transaction transaction;
		TFactura factura = null;

		try {
			transaction = manager.nuevaTransaccion(Thread.currentThread());

		} catch (Exception exception) {
			transaction = manager.getTransaction(Thread.currentThread());
		}

		try {
			transaction.start();
			DAOFactura daoFactura = FactoriaIntegracion.getInstance().createDAOFactura();
			factura = daoFactura.read(tFactura.getId());

			if (factura != null)
				id = daoFactura.update(tFactura);

			if (id == -1)
				transaction.rollback();
			else
				transaction.commit();

		} catch (Exception exception) {
			return -1;
		}

		return id;
	}

	public int delete(int id) {
		int idFactura = -1;

		DAOLineaFactura daoLineaFactura = FactoriaIntegracion.getInstance().createDAOLineaFactura();
		DAOFactura daoFactura = FactoriaIntegracion.getInstance().createDAOFactura();
		DAOEspectaculo daoEspectaculo = FactoriaIntegracion.getInstance().createDAOEspectaculo();

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaccion;

		try {
			transaccion = transactionManager.nuevaTransaccion(Thread.currentThread());
		} catch (Exception e) {
			transaccion = transactionManager.getTransaction(Thread.currentThread());
		}
		try {
			transaccion.start();

			Collection<TLineaFactura> tLineaFactura = daoLineaFactura.readByFactura(id);

			for (TLineaFactura linea : tLineaFactura) {
				TEspectaculo espectaculo = daoEspectaculo.read(linea.getIdEspectaculo());
				if (espectaculo != null) {
					espectaculo.setEntradas(espectaculo.getEntradas() + linea.getNumeroEntradas());
					daoEspectaculo.update(espectaculo);
				}
				daoLineaFactura.delete(linea.getIdFactura(), linea.getIdEspectaculo());
			}
			if (daoFactura.read(id) != null)
				idFactura = daoFactura.delete(id);

			if (idFactura == -1)
				transaccion.rollback();
			else
				transaccion.commit();
		} catch (Exception exception) {
			return -1;
		}
		return idFactura;
	}

	public Collection<TFactura> readAll() {
		TransactionManager manager = TransactionManager.getInstance();
		Transaction transaction;

		try {
			transaction = manager.nuevaTransaccion(Thread.currentThread());

		} catch (Exception exception) {
			transaction = manager.getTransaction(Thread.currentThread());
		}

		try {
			transaction.start();
			DAOFactura daoFactura = FactoriaIntegracion.getInstance().createDAOFactura();
			Collection<TFactura> facturas;

			facturas = daoFactura.readAll();

			if (facturas == null)
				transaction.rollback();

			transaction.commit();

			return facturas;

		} catch (Exception exception) {
			transaction.rollback();
		}

		return null;
	}

	/** 
	* (non-Javadoc)
	* @see SAFactura#devolverEspectaculo(TLineaFactura tLineaFactura, int id)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void devolverEspectaculo(TLineaFactura tLineaFactura, int id) {
		// begin-user-code
		// TODO Auto-generated method stub

		// end-user-code
	}

	public int devolverEspectaculo(TLineaFactura tLineaFactura) {
		int id = -1;

		DAOLineaFactura daoLineaFactura = FactoriaIntegracion.getInstance().createDAOLineaFactura();
		DAOFactura daoFactura = FactoriaIntegracion.getInstance().createDAOFactura();
		DAOEspectaculo daoEspectaculo = FactoriaIntegracion.getInstance().createDAOEspectaculo();

		TransactionManager manager = TransactionManager.getInstance();
		Transaction transaction;

		try {
			transaction = manager.nuevaTransaccion(Thread.currentThread());

		} catch (Exception exception) {
			transaction = manager.getTransaction(Thread.currentThread());
		}

		try {
			transaction.start();
			TLineaFactura almacenada = daoLineaFactura.read(tLineaFactura.getIdFactura(),
					tLineaFactura.getIdEspectaculo());
			TEspectaculo espectaculo = daoEspectaculo.read(tLineaFactura.getIdEspectaculo());
			TFactura tFactura = daoFactura.read(tLineaFactura.getIdFactura());
			if (espectaculo != null && espectaculo.getActivo() && tFactura != null && tFactura.getActivo()) {
				id = tFactura.getId();
				if (tLineaFactura.getNumeroEntradas() >= almacenada.getNumeroEntradas()) {
					daoLineaFactura.delete(tLineaFactura.getIdFactura(), tLineaFactura.getIdEspectaculo());
					tFactura.setNumeroEspectaculos(tFactura.getNumeroEspectaculos() - 1);
					tFactura.setTotal(tFactura.getTotal() - espectaculo.getPrecio() * almacenada.getNumeroEntradas());
					espectaculo.setEntradas(espectaculo.getEntradas() + almacenada.getNumeroEntradas());
				} else {
					espectaculo.setEntradas(espectaculo.getEntradas() + tLineaFactura.getNumeroEntradas());
					almacenada.setNumeroEntradas(almacenada.getNumeroEntradas() - tLineaFactura.getNumeroEntradas());
					tFactura.setTotal(
							tFactura.getTotal() - espectaculo.getPrecio() * tLineaFactura.getNumeroEntradas());
					daoLineaFactura.update(almacenada);
				}
				daoFactura.devolverEspectaculo(tFactura);
				if (tFactura.getNumeroEspectaculos() == 0)
					daoFactura.delete(tFactura.getId());
				daoEspectaculo.update(espectaculo);
			}

			if (id == -1) {
				transaction.rollback();
			} else
				transaction.commit();

		} catch (Exception exception) {
			id = -1;
		}

		return id;
	}

	public int deleteFisico(int idFactura) {

		int id = -1;

		DAOLineaFactura daoLineaFactura = FactoriaIntegracion.getInstance().createDAOLineaFactura();
		DAOFactura daoFactura = FactoriaIntegracion.getInstance().createDAOFactura();

		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion;

		try {
			transaccion = tm.nuevaTransaccion(Thread.currentThread());
		} catch (Exception exception) {
			transaccion = tm.getTransaction(Thread.currentThread());
		}
		try {
			transaccion.start();

			Collection<TLineaFactura> tLineaFactura = daoLineaFactura.readByFactura(idFactura);

			for (TLineaFactura linea : tLineaFactura) {
				daoLineaFactura.delete(linea.getIdFactura(), linea.getIdEspectaculo());
			}

			id = daoFactura.deleteFisico(idFactura);

			if (id == -1)
				transaccion.rollback();
			else
				transaccion.commit();
		} catch (Exception exception) {
			return -1;
		}
		return id;
	}

	public int queryEntradas(double precio) {
		TransactionManager tm = TransactionManager.getInstance();
		Transaction transaccion;

		int entradas = -1;
		try {
			transaccion = tm.nuevaTransaccion(Thread.currentThread());
		} catch (Exception exception) {
			transaccion = tm.getTransaction(Thread.currentThread());
		}
		transaccion.start();

		entradas = (int) FactoriaQuery.getInstance().entradasVendidasPrecio().execute(precio);
		if (entradas == -1)
			transaccion.rollback();
		else
			transaccion.commit();
		return entradas;
	}

}