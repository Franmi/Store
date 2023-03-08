package presentacion.Controlador;

import presentacion.Controlador.imp.ControladorImp;

public abstract class Controlador {

	private static Controlador instance;

	public static synchronized Controlador getInstance() {
		if (instance == null) {
			instance = new ControladorImp();
		}
		return instance;
	}

	public abstract void accion(int evento, Object datos);

}