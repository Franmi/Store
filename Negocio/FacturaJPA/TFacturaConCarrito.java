package negocio.FacturaJPA;

import java.util.Map;

public class TFacturaConCarrito {
	private TFacturaJPA tFactura;
	private Map<Integer, Integer> carrito;
	
	public TFacturaConCarrito(TFacturaJPA tFactura,Map<Integer, Integer> carrito){
		this.tFactura= tFactura;
		this.carrito=carrito;
	}
	
	public TFacturaJPA getTFactura(){ return tFactura; }
	public Map<Integer, Integer> getCarrito(){ return carrito; }
	
	
}
