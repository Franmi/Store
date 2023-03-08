package negocio.EmpleadoJPA;

import negocio.EmpleadoJPA.Entidad.Empleado;
import negocio.EmpleadoJPA.Entidad.TiempoCompleto;
import negocio.EmpleadoJPA.Entidad.TiempoParcial;
import negocio.Turno.Entidad.Turno;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;

import integracion.FactoriaEntityManager.FactoriaEntityManager;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class SAEmpleadoJPAImp implements SAEmpleadoJPA {
	
	@Override
	public int deleteEmpleado(int id) {
		int idEmpleado = -1;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Empleado empleado = entityManager.find(Empleado.class, id);
			
			if (empleado != null && empleado.getActivo()) {
				
				if (empleado.getTurnos().isEmpty()) {
					empleado.setActivo(false);
					idEmpleado = empleado.getID();
				}
			}

			entityManager.getTransaction().commit();
		}
		catch (Exception exception) {
			entityManager.getTransaction().rollback();
			idEmpleado = -1;
		} 
		finally {
			entityManager.close();
		}
	return idEmpleado;
	}
	
	@Override
	public int createEmpleado(TEmpleadoJPA tEmpleado) {
		
		int idEmpleado = -1;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			
			TypedQuery<Empleado> empleadoLectura = entityManager.createNamedQuery("negocio.EmpleadoJPA.Entidad.Empleado.findBydni", Empleado.class);
			empleadoLectura.setParameter("dni", tEmpleado.getDni());
			empleadoLectura.setLockMode(LockModeType.OPTIMISTIC);

			List<Empleado> empleadoLeido = empleadoLectura.getResultList();
			
			Empleado empleado;
			if(tEmpleado instanceof TTiempoCompleto)
				empleado = new TiempoCompleto(tEmpleado.getID(),tEmpleado.getNombre(),tEmpleado.getApellidos(),tEmpleado.getDni(),
						tEmpleado.getActivo(), tEmpleado.getBase(),tEmpleado.getComplemento());
			else
				empleado = new TiempoParcial(tEmpleado.getID(),tEmpleado.getNombre(),tEmpleado.getApellidos(),tEmpleado.getDni(),
						tEmpleado.getActivo(), tEmpleado.getSueldo(),tEmpleado.getHorasTrabajadas());
			
			
			if (empleadoLeido.isEmpty()){
				entityManager.persist(empleado);
				entityManager.getTransaction().commit();
				idEmpleado = empleado.getID();
			}
			else if(!empleadoLeido.get(0).getActivo()){
				
				if(tEmpleado instanceof TTiempoCompleto){
					((TiempoCompleto) empleadoLeido.get(0)).setBase(tEmpleado.getBase());
					((TiempoCompleto) empleadoLeido.get(0)).setComplemento(tEmpleado.getComplemento());
				}
				else{
					((TiempoParcial) empleadoLeido.get(0)).setSueldo(((TTiempoParcial)tEmpleado).getSueldo());
					((TiempoParcial) empleadoLeido.get(0)).setHorasTrabajadas(((TTiempoParcial)tEmpleado).getHorasTrabajadas());
				}
				
				empleadoLeido.get(0).setNombre(tEmpleado.getNombre());
				empleadoLeido.get(0).setApellidos(tEmpleado.getApellidos());
				empleadoLeido.get(0).setDni(tEmpleado.getDni());
				empleadoLeido.get(0).setActivo(tEmpleado.getActivo());
				entityManager.getTransaction().commit();
				idEmpleado = empleadoLeido.get(0).getID();
			}
			else entityManager.getTransaction().commit();
		} 
		catch (Exception exception) {
			entityManager.getTransaction().rollback();
			idEmpleado = -1;
		} 
		finally {
			entityManager.close();
		}
		
		return idEmpleado;
	}
	
	@Override
	public TEmpleadoJPA readEmpleado(int id) {
		TEmpleadoJPA res = null;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			Empleado empleado = entityManager.find(Empleado.class, id);
			
			if (empleado != null)
				res = empleado.toTransfer();
			entityManager.getTransaction().commit();				
		}
		catch (Exception exception) {
			entityManager.getTransaction().rollback();
			res = null;
		}
		finally {
			entityManager.close();
		}
		return res ;
	}

	@Override
	public Collection<TEmpleadoJPA> readAllEmpleados() {
		Collection<TEmpleadoJPA> res = new ArrayList<TEmpleadoJPA>();
		
		EntityManager em = FactoriaEntityManager.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Empleado> query = em.createNamedQuery("negocio.EmpleadoJPA.Entidad.Empleado.findAll", Empleado.class);
		List<Empleado> listaLeida = query.getResultList();
		if(listaLeida.size() > 0){
			TEmpleadoJPA empleado;
			for (Empleado e : listaLeida){
				if (e instanceof TiempoCompleto) {
					empleado = new TTiempoCompleto();
					empleado.setBase(((TiempoCompleto) e).getBase());
					empleado.setComplemento(((TiempoCompleto) e).getComplemento());
				}
				else {
					empleado = new TTiempoParcial();
					empleado.setSueldo(((TiempoParcial)e).getSueldo());
					empleado.setHorasTrabajadas(((TiempoParcial)e).getHorasTrabajadas());
				}
				empleado.setID(e.getID());
				empleado.setDni(e.getDni());
				empleado.setNombre(e.getNombre());
				empleado.setApellidos(e.getApellidos());
				empleado.setActivo(e.getActivo());
				res.add(empleado);
			}
			em.getTransaction().commit();
		}
		else {
			em.getTransaction().rollback();
		}
		em.close();
		return res;
	}
	
	@Override
	public int vincularTurno(TTrabaja tTrabaja) {
		int res = -1;
		EntityManager em = FactoriaEntityManager.getInstance().createEntityManager();
		try{
			em.getTransaction().begin();
			
			Turno turnoLeido = em.find(Turno.class, tTrabaja.getIdTurno(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			Empleado empleadoLeido = em.find(Empleado.class, tTrabaja.getIdEmpleado(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			
			boolean encontrado = false;
			Set<Turno> listaTurnos = empleadoLeido.getTurnos();
			if (turnoLeido.getActivo() && empleadoLeido.getActivo() && turnoLeido != null && empleadoLeido != null) {
				if (listaTurnos.contains(turnoLeido)) {
					res = -1;
					encontrado = true;
				}
			}
			if (turnoLeido != null && turnoLeido.getActivo() && empleadoLeido.getActivo() && !encontrado) {
				listaTurnos.add(turnoLeido);
				res = 1;
				em.persist(empleadoLeido);
			}
			em.getTransaction().commit();
		}
		catch (Exception exception) {
			em.getTransaction().rollback();
			res = -1;
		} 
		finally {
			em.close();
		}	

	return res;
	}
	
	
	@Override
	public int desvincularTurno(TTrabaja tTrabaja) {
		int res = -1;
		EntityManager em = FactoriaEntityManager.getInstance().createEntityManager();
		try{
			em.getTransaction().begin();
			
			Turno turnoLeido = em.find(Turno.class, tTrabaja.getIdTurno(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			Empleado empleadoLeido = em.find(Empleado.class, tTrabaja.getIdEmpleado(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			
			boolean encontrado = false;
			Set<Turno> listaTurnos = empleadoLeido.getTurnos();
			if (turnoLeido.getActivo() && empleadoLeido.getActivo() && turnoLeido != null && empleadoLeido != null) {
				if (listaTurnos.contains(turnoLeido)) {
					listaTurnos.remove(turnoLeido);
					res = 1;
					encontrado = true;
					em.persist(empleadoLeido);
					em.getTransaction().commit();
				}
			}
			if (turnoLeido.getActivo() && empleadoLeido.getActivo() && turnoLeido != null && !encontrado) {
				res = -1;
				em.getTransaction().rollback();
			}

		}
		catch (Exception exception) {
			em.getTransaction().rollback();
			res = -1;
		} 
		finally {
			em.close();
		}	

	return res;
	}
	
	@Override
	public Collection<TEmpleadoJPA> readEmpleadosByTurno(int id) {
		Collection<TEmpleadoJPA> empleados = new ArrayList<TEmpleadoJPA>();
		EntityManager em = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			em.getTransaction().begin();
			
			Turno turno = em.find(Turno.class, id);
			if (turno != null && !turno.getEmpleados().isEmpty()) {
				for (Empleado empleado : turno.getEmpleados())
					empleados.add(empleado.toTransfer());
			}
			em.getTransaction().commit();				
		}
		catch (Exception exception) {
			em.getTransaction().rollback();
			empleados = null;
		}
		finally {
			em.close();
		}
		return empleados;
	}

	@Override
	public int updateEmpleado(TEmpleadoJPA tEmpleado) {
		int idEmpleado = -1;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try{

			entityManager.getTransaction().begin();

			Empleado empleado = entityManager.find(Empleado.class, tEmpleado.getID());
	
			TypedQuery<Empleado> empleadoLectura = entityManager.createNamedQuery("negocio.EmpleadoJPA.Entidad.Empleado.findBydni", Empleado.class);
			empleadoLectura.setParameter("dni", tEmpleado.getDni());
			List<Empleado> empleadoLeido = empleadoLectura.getResultList();

			if (empleado != null && empleado.getActivo() && (empleadoLeido.size() == 0  || empleadoLeido.get(0).getID() == empleado.getID())) {
				
				empleado.setNombre(tEmpleado.getNombre());
				empleado.setApellidos(tEmpleado.getApellidos());
				empleado.setActivo(tEmpleado.getActivo());
				empleado.setDni(tEmpleado.getDni());
				
				if (tEmpleado instanceof TTiempoCompleto) {
					((TiempoCompleto) empleado).setBase(tEmpleado.getBase());
					((TiempoCompleto) empleado).setComplemento(tEmpleado.getComplemento());
				}
				else {
					((TiempoParcial) empleado).setSueldo(tEmpleado.getSueldo());
					((TiempoParcial) empleado).setHorasTrabajadas(tEmpleado.getHorasTrabajadas());
				}
			
				entityManager.getTransaction().commit();
				idEmpleado = tEmpleado.getID();
			}
			else{
				entityManager.getTransaction().rollback();
			}
		}catch (Exception exception) {
			entityManager.getTransaction().rollback();
			idEmpleado = -1;
		} finally {
			entityManager.close();
		}
		return idEmpleado;	
		

	}
	
	@Override
	public double calcularNomina(int idEmpleado) {
		double nomina = 0;
		
		EntityManager em = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			em.getTransaction().begin();
			
			Empleado empleado = em.find(Empleado.class, idEmpleado, LockModeType.OPTIMISTIC);
			
			if(empleado != null && empleado.getActivo()){
				nomina = empleado.calcularSueldo();
				em.getTransaction().commit();
			}
			else{
				nomina = -1;
				em.getTransaction().rollback();
			}
		}
		catch(Exception exception) {	
			em.getTransaction().rollback();
			nomina = -1;
		}
		finally {em.close();}
		
		return nomina;
	}
	
}