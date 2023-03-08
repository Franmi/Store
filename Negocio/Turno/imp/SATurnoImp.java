package negocio.Turno.imp;

import negocio.EmpleadoJPA.Entidad.Empleado;
import negocio.Turno.SATurno;
import negocio.Turno.TTurno;
import negocio.Turno.Entidad.Turno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;

import integracion.FactoriaEntityManager.FactoriaEntityManager;

public class SATurnoImp implements SATurno {
	
	public int addTurno(TTurno tTurno) {
		int id = -1;
		
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			Turno turno = new Turno(tTurno.getNombre(), tTurno.getComienzo(),
					tTurno.getFin(), tTurno.getActivo());
			
			TypedQuery<Turno> typedQuery = entityManager.createNamedQuery("Turno.findBynombre", Turno.class);
			typedQuery.setParameter("nombre", tTurno.getNombre());
			List<Turno> leido = typedQuery.getResultList();
			if (leido.isEmpty()) {
				entityManager.persist(turno);
				entityManager.getTransaction().commit();
				id = turno.getId();
			}
			else if (!leido.get(0).getActivo()) {
				leido.get(0).setActivo(true);
				leido.get(0).setComienzo(tTurno.getComienzo());
				leido.get(0).setFin(tTurno.getFin());
				entityManager.getTransaction().commit();
				id = leido.get(0).getId();
			}
			
		} 
		catch (Exception exception) {
			entityManager.getTransaction().rollback();
			id = -1;
		} 
		finally {
			entityManager.close();
		}
		
		return id;
	}
	
	public int deleteTurno(int id) {
		int idTurno = -1;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Turno turno = entityManager.find(Turno.class, id);
			if (turno != null && turno.getActivo() && turno.getEmpleados().isEmpty()) {
				if (turno.getEmpleados().isEmpty()) {
					turno.setActivo(false);
					idTurno = turno.getId();
				}
			}
			entityManager.getTransaction().commit();
		}
		catch (Exception exception) {
			entityManager.getTransaction().rollback();
			id = -1;
		} 
		
		finally {
			entityManager.close();
		}
		
		return idTurno;
	}
	
	public int updateTurno(TTurno tTurno) {
		int id = -1;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Turno leido = entityManager.find(Turno.class, tTurno.getId());
			
			TypedQuery<Turno> typedQuery = entityManager.createNamedQuery("Turno.findBynombre", Turno.class);
			typedQuery.setParameter("nombre", tTurno.getNombre());
			List<Turno> almacenado = typedQuery.getResultList();
			
			if (leido != null && leido.getActivo() &&
					(almacenado.isEmpty() || almacenado.get(0).getId() == leido.getId())) {
				leido.setNombre(tTurno.getNombre());
				leido.setComienzo(tTurno.getComienzo());
				leido.setFin(tTurno.getFin());
				id = leido.getId();
				entityManager.getTransaction().commit();
			}
			else {
				entityManager.getTransaction().rollback();
				id = -1;
			}
		} catch (Exception exception) {
			entityManager.getTransaction().rollback();
			id = -1;
		} finally {
			entityManager.close();
		}
		return id;
	}
	
	public TTurno readTurno(int id) {
		TTurno result = null;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			Turno turno = entityManager.find(Turno.class, id);
			if (turno != null)
				result = turno.toTransfer();
			entityManager.getTransaction().commit();				
		}
		catch (Exception exception) {
			entityManager.getTransaction().rollback();
			result = null;
		}
		finally {
			entityManager.close();
		}
		return result;
	}
	
	public Collection<TTurno> readTurnosByEmpleado(int id) {
		Collection<TTurno> turnos = new ArrayList<TTurno>();
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			Empleado empleado = entityManager.find(Empleado.class, id);
			if (empleado != null && !empleado.getTurnos().isEmpty()) {
				for (Turno turno : empleado.getTurnos())
					turnos.add(turno.toTransfer());
			}
			entityManager.getTransaction().commit();
		}
		catch (Exception exception) {
			entityManager.getTransaction().rollback();
			turnos = null;
		}
		finally {
			entityManager.close();
		}
		return turnos;
	}
	
	public Collection<TTurno> readAllTurnos() {
		Collection<TTurno> result = new ArrayList<TTurno>();
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			TypedQuery<Turno> typedQuery = entityManager.createNamedQuery("Turno.findAll", Turno.class);
			List<Turno> turnos = typedQuery.getResultList();
			if (!turnos.isEmpty()){
				for (Turno turno: turnos)
					result.add(turno.toTransfer());
			}
			entityManager.getTransaction().commit();				
		}
		catch (Exception exception) {
			entityManager.getTransaction().rollback();
			result = null;
		}
		finally {
			entityManager.close();
		}
		return result;
	}
	
	public double calcularNomina(int id) {
		double result = 0;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			Turno turno = entityManager.find(Turno.class, id, LockModeType.OPTIMISTIC);
			if (turno != null && turno.getActivo()) {
				for (Empleado empleado : turno.getEmpleados())
					result += empleado.calcularSueldo();
			}
			else result = -1;
			entityManager.getTransaction().commit();				
		}
		catch (Exception exception) {
			entityManager.getTransaction().rollback();
			result = -1;
		}
		finally {
			entityManager.close();
		}
		return result;
	}
	
	public void bajaFisica(int id) {
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Turno turno = entityManager.find(Turno.class, id);
			
			if (turno != null) {
				entityManager.remove(turno);
				
				entityManager.getTransaction().commit();	
			}
			else entityManager.getTransaction().rollback();
		}
		catch (Exception exception) {	
			entityManager.getTransaction().rollback();
		}
		finally {
			entityManager.close();
		}
	}
	
}