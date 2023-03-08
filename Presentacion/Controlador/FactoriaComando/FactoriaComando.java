package presentacion.Controlador.FactoriaComando;

import presentacion.Controlador.Comando.Comando;
import presentacion.Controlador.FactoriaComando.imp.FactoriaComandoImp;

public abstract class FactoriaComando {

	private static FactoriaComando instance;

	public static FactoriaComando getInstance() {
		if (instance == null)
			instance = new FactoriaComandoImp();
		return instance;
	}

	public abstract Comando createComando(int evento);

}