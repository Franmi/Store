/**
 * 
 */
package negocio.Producto;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;

import integracion.FactoriaEntityManager.FactoriaEntityManager;
import negocio.Espectaculo.TEspectaculo;
import negocio.Producto.Entidad.Producto;

public class SAProductoImp implements SAProductoJPA {

	@Override
	public int eliminarProducto(int idProducto) {
		// TODO Auto-generated method stub
		EntityManager em=null;
		EntityTransaction et=null;
		int result=-1;
		
		try{
			em=FactoriaEntityManager.getInstance().createEntityManager();
			et=em.getTransaction();
			et.begin();
			Producto p=em.find(Producto.class, idProducto);
			if(p!=null && p.getActivo()){
				result=1;
				p.setActivo(false);
				et.commit();
			}else{
				result=-1;
				et.rollback();
			}
			
		}catch(OptimisticLockException e){
			result=-1;
		}catch(RollbackException e){
			result=-1;
		}catch(PersistenceException e){
			result=-1;
			e.fillInStackTrace();
			et.rollback();
		}finally{
			em.close();
		}
		return result;
	}

	@Override
	public int createProducto(TProducto TProducto) {
		// TODO Auto-generated method stub
		EntityManager em=FactoriaEntityManager.getInstance().createEntityManager();
		EntityTransaction et=em.getTransaction();
		int id=-1;
		
		try{
			et.begin();
			TypedQuery<Producto> tp=em.createNamedQuery("Producto.findBycodigo", Producto.class);
			tp.setParameter("codigo", TProducto.getCodigo());
			//tp.setLockMode(LockModeType.OPTIMISTIC);
			List<Producto> l=tp.getResultList();
			if(l.isEmpty()){
				Producto p=new Producto(TProducto);
				em.persist(p);
				et.commit();
				id=p.getID();
			}else{
				Producto p=l.get(0);
				if(!p.getActivo()){
					p.setCodigo(TProducto.getCodigo());
					p.setNombre(TProducto.getNombre());
					p.setPrecio(TProducto.getPrecio());
					p.setStock(TProducto.getStock());
					p.setActivo(true);
					id=p.getID();
					et.commit();
				}else{
					id=-1;
					et.rollback();
				}
			}
		}catch (RollbackException e) {
			id = -1;
		}catch(PersistenceException e){
			id = -1;
			e.printStackTrace();
			et.rollback();
		}finally{
			em.close();
		}
		return id;
	}

	@Override
	public TProducto readProducto(int id) {
		// TODO Auto-generated method stub
		EntityManager em=null;
		EntityTransaction et=null;
		TProducto tprod=null;
		try{
			em=FactoriaEntityManager.getInstance().createEntityManager();
			et=em.getTransaction();
			et.begin();
			Producto p=em.find(Producto.class, id);
			if(p!=null){
				tprod=p.toTransfer();
				et.commit();
			}else{
				et.rollback();
			}
		}catch(PersistenceException e){
			tprod=null;
			e.fillInStackTrace();
			et.rollback();
		}
		finally{
			em.close();
		}
		
		return tprod;
	}

	@Override
	public Set<TProducto> readAllProducto() {
		// TODO Auto-generated method stub
		Set<TProducto> prod=new LinkedHashSet<TProducto>();
		EntityManager em=null;
		EntityTransaction et=null;
		try{
			 em=FactoriaEntityManager.getInstance().createEntityManager();
			 et=em.getTransaction();
			et.begin();
			TypedQuery<Producto> tp=em.createNamedQuery("Producto.findAll", Producto.class);
			for(Producto p:tp.getResultList()){
				if(p.getActivo()){
					prod.add(p.toTransfer());
				}
			}
		}catch(OptimisticLockException e){
			prod=new LinkedHashSet<>();
		} catch(RollbackException e){
			prod = new LinkedHashSet<>();
		}
		catch(PersistenceException e){
			prod=new LinkedHashSet<>();
			e.fillInStackTrace();
			et.rollback();
		}finally{
			em.close();
		}
		return prod;
	}

	@Override
	public int modificarProducto(TProducto TProducto) {
		EntityManager em=null;
		EntityTransaction et=null;
		int id=-1;
		try{
			em=FactoriaEntityManager.getInstance().createEntityManager();
			et=em.getTransaction();
			et.begin();
			if(TProducto!=null){
				Producto p=em.find(Producto.class, TProducto.getID());
				if(p!=null && p.getActivo()){
					p.setCodigo(TProducto.getCodigo());
					p.setNombre(TProducto.getNombre());
					p.setPrecio(TProducto.getPrecio());
					p.setStock(TProducto.getStock());
					p.setActivo(true);
					id=p.getID();
					et.commit();
				}else{
					id=-1;
					et.rollback();
				}
			}
		}catch(OptimisticLockException e){
			id = -1;
		} catch(RollbackException e){
			id = -1;
		}
		catch(PersistenceException e){
			id=-1;
			e.printStackTrace();
			et.rollback();
		}finally{
			em.close();
		}
		return id;
	}



}