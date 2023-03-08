package presentacion.Factoria;

import presentacion.IGUI;
import presentacion.Factoria.imp.FactoriaPresentacionImp;

public abstract class FactoriaPresentacion {

	private static FactoriaPresentacion instance;

	public synchronized static FactoriaPresentacion getInstance() {
		if (instance == null) {
			instance = new FactoriaPresentacionImp();
		}
		return instance;
	}

	public abstract IGUI generarVista(int id);
}