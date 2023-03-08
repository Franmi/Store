
package negocio.FacturaJPA;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;

import integracion.FactoriaEntityManager.FactoriaEntityManager;
import negocio.EmpleadoJPA.Entidad.Empleado;
import negocio.FacturaJPA.Entidad.Factura;
import negocio.Producto.FacturaProducto;
import negocio.Producto.TProducto;
import negocio.Producto.Entidad.Producto;



public class SAFacturaJPAImp  implements SAFacturaJPA {

	public int altaFactura(TFacturaConCarrito tFacturaCarrito) {
		int id = -1;
		
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			TFacturaJPA tFactura= tFacturaCarrito.getTFactura();

			Empleado empleadoLeido = entityManager.find(Empleado.class, tFactura.getIdEmpleado(),LockModeType.OPTIMISTIC);
			Factura factura = new Factura(empleadoLeido, tFactura.getFecha());
			boolean unoVendido=false;
			double total = 0;
			if(empleadoLeido!=null && empleadoLeido.getActivo()){
				entityManager.persist(factura);
				id= factura.getId();

				for(Map.Entry<Integer, Integer> entry:tFacturaCarrito.getCarrito().entrySet()){
					Producto productoLeido =entityManager.find(Producto.class, entry.getKey());
					FacturaProducto fp=null;
					if(productoLeido!=null && productoLeido.getActivo()){
						if(productoLeido.getStock()<entry.getValue()){// no hay stock suficiente , se compra lo que se pueda
							if(productoLeido.getStock()>0){
								fp= new FacturaProducto(productoLeido.getPrecio(),productoLeido.getStock(),true,productoLeido,factura);
								unoVendido=true;
								productoLeido.setStock(0);
							}
						}else{
							productoLeido.setStock(productoLeido.getStock()-entry.getValue());
							fp= new FacturaProducto(productoLeido.getPrecio(),entry.getValue(),true,productoLeido,factura);
							unoVendido=true;
						}
						
						entityManager.persist(productoLeido);
						if(fp!=null) {
							entityManager.persist(fp);
							total += fp.getCantidad() * fp.getPrecio();
						}
					}
				}if(!unoVendido){// No se ha podido comprar ningun producto
					id=-2;
					entityManager.getTransaction().rollback();
				} else {
					factura.setTotal(total);
					entityManager.getTransaction().commit();
				}
			}else{//Empleado Inexistente o inactivo
				id=-1;
				entityManager.getTransaction().rollback();
			}
			
		} 
		catch(IndexOutOfBoundsException e){//Producto inexistente
			entityManager.getTransaction().rollback();
			id = -1;
		}
		catch (Exception exception) {// Otros errores (por ejemplo concurrencia)
			entityManager.getTransaction().rollback();
			id = -3;
		} 
		finally {
			entityManager.close();
		}
		
		return id;
	}

	public int bajaFactura(int idFactura) {
		int result = -1;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			Factura factura = entityManager.find(Factura.class, idFactura);
			if(factura == null || !factura.getActivo())  {
				result = -2;
				throw new IllegalArgumentException();
			}
			
			Set<FacturaProducto> listaLineas = factura.getLineas();
			Iterator<FacturaProducto> it = listaLineas.iterator();
			FacturaProducto linea;
			while(it.hasNext()) {
				linea = it.next();
				linea.getProducto().setActivo(true);
				int stockAnterior = linea.getProducto().getStock();
				linea.getProducto().setStock(stockAnterior + linea.getCantidad());
				it.remove();
				entityManager.remove(linea);
			}
			
			factura.setTotal(0);
			factura.setActivo(false);
			entityManager.getTransaction().commit();
			result = 1;
		} catch (Exception e ) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return result;
	}


	public int modificarFactura(TFacturaJPA tFactura) {
		int result = -1;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			Factura factura = entityManager.find(Factura.class, tFactura.getIdFactura());
			if (factura != null && factura.getActivo()){

				Empleado empleadoLeido = entityManager.find(Empleado.class, tFactura.getIdEmpleado(),LockModeType.OPTIMISTIC);
				if(empleadoLeido!=null && empleadoLeido.getActivo()){
					factura.setEmpleado(empleadoLeido);
					result= factura.getId();
					entityManager.getTransaction().commit();
				}else{// Empleado inactivo
					result=-2;
					entityManager.getTransaction().rollback();
				}
				
			}else entityManager.getTransaction().rollback();

		}
		catch(IndexOutOfBoundsException e){// No existe el empleado al que se quiere cambiar
			if (entityManager.getTransaction().isActive())
				entityManager.getTransaction().rollback();
			result = -2;
		}
		catch (Exception exception) {// Otros errores
			if (entityManager.getTransaction().isActive())
				entityManager.getTransaction().rollback();
			result = -3;
		}
		finally {
			entityManager.close();
		}
		return result;
	}


	public TFacturaJPA leerFactura(int idFactura) {
		TFacturaJPA result = null;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			Factura factura = entityManager.find(Factura.class, idFactura);
			if(factura == null) throw new IllegalArgumentException();
			entityManager.getTransaction().commit();
			result = factura.toTransfer();
		} catch (Exception e ) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return result;
	}

	public Collection<TFacturaJPA> leerTodasFacturas() {
		Collection<TFacturaJPA> result = null;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			
			TypedQuery<Factura> typedQuery = entityManager.createNamedQuery("Factura.findAll", Factura.class);
			List<Factura> facturas = typedQuery.getResultList();
			if(facturas == null || facturas.isEmpty()) throw new IllegalArgumentException();
			result = new LinkedHashSet<TFacturaJPA>();
			for(Factura f: facturas) {
				if(f.getActivo()) result.add(f.toTransfer());
			}
			
			entityManager.getTransaction().commit();
		} catch (Exception e ) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return result;
	}

	public int devolverProducto(TLineaFacturaJPA tLineaFactura) {
		int result = -1;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			if(tLineaFactura.getCantidad() <= 0)  {
				result = -2;
				throw new IllegalArgumentException();
			}
			
			Factura factLeida = entityManager.find(Factura.class, tLineaFactura.getIdFactura());
			if(factLeida == null || !factLeida.getActivo())  {
				result = -3;
				throw new IllegalArgumentException();
			}
			
			Producto prodLeido = entityManager.find(Producto.class, tLineaFactura.getIdProducto());
			if(prodLeido == null) {
				result = -4;
				throw new IllegalArgumentException();
			}
			
			Set<FacturaProducto> listaProductos = factLeida.getLineas();
			boolean encontrado = false;
			Iterator<FacturaProducto> it = listaProductos.iterator();
			FacturaProducto linea = null;
			while(!encontrado && it.hasNext()) {
				linea = it.next();
				if(linea.getProducto().getID() == tLineaFactura.getIdProducto()) encontrado = true;
			}
			
			if(!encontrado || linea == null)  {
				result = -5;
				throw new IllegalArgumentException();
			}

			int cantidadDevolver = tLineaFactura.getCantidad();
			if(cantidadDevolver >= linea.getCantidad()) {
				cantidadDevolver = linea.getCantidad();
				listaProductos.remove(linea);
				entityManager.remove(linea);
			} else {
				int cantAnterior = linea.getCantidad();
				linea.setCantidad(cantAnterior - cantidadDevolver);
			}

			int stockAnterior = prodLeido.getStock();
			double totalAnterior = factLeida.getTotal();
			factLeida.setTotal(totalAnterior - (cantidadDevolver * linea.getPrecio()));
			if(factLeida.getTotal() == 0) factLeida.setActivo(false);
			prodLeido.setActivo(true);
			prodLeido.setStock(stockAnterior + cantidadDevolver);
			entityManager.getTransaction().commit();
			result = 1;
			
		} catch (Exception e ) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		
		return result;
	}
	
	public Collection<TFacturaJPA> leerPorProducto(int id) {
		Collection<TFacturaJPA> result = null;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			Producto producto = entityManager.find(Producto.class, id);
			if(producto == null || !producto.getActivo()) throw new IllegalArgumentException();
			
			Set<FacturaProducto> lineas = producto.getFacturaProducto();
			if(lineas != null)  {
				result = new LinkedHashSet<TFacturaJPA>();
				for(FacturaProducto fp: lineas) {
					Factura factura = entityManager.find(Factura.class, fp.getFactura().getId());
					if(factura != null && factura.getActivo()) result.add(factura.toTransfer());
				}
			}
			
			entityManager.getTransaction().commit();
		} catch (Exception e ) {
			entityManager.getTransaction().rollback();
			result = null;
		} finally {
			entityManager.close();
		}
		return result;
	}

	@Override
	public TOAFacturaProducto mostrarFacturaCompleta(int idFactura) {
		TOAFacturaProducto result = null;
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			Factura factura = entityManager.find(Factura.class, idFactura);
			if (factura != null){
				Set<TLineaFacturaJPA> lineas= new HashSet<TLineaFacturaJPA>();
				Map<Integer, TProducto> productos= new HashMap<Integer,TProducto>();
				for(FacturaProducto linea: factura.getLineas()){
					lineas.add(linea.toTransfer());
					productos.put(linea.getProducto().getID(), linea.getProducto().toTransfer());
				}
				entityManager.getTransaction().commit();
				result= new TOAFacturaProducto(factura.toTransfer(), lineas, productos);
				
			}else entityManager.getTransaction().rollback();
			
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
	
	public double calcularTotal(int idFactura) {
		EntityManager entityManager = FactoriaEntityManager.getInstance().createEntityManager();
		double total = 0;
		
		try {
			entityManager.getTransaction().begin();
			
			Factura factura = entityManager.find(Factura.class, idFactura, LockModeType.OPTIMISTIC);
			if(factura == null || !factura.getActivo()) throw new IllegalArgumentException();

			Set<FacturaProducto> lineasLeidas = factura.getLineas();
			for(FacturaProducto fp: lineasLeidas) {
				total += fp.getPrecio() * fp.getCantidad();
			}
			
			entityManager.getTransaction().commit();
		} catch (Exception e ) {
			entityManager.getTransaction().rollback();
			total = -1;
		} finally {
			entityManager.close();
		}
		return total;
	}
}