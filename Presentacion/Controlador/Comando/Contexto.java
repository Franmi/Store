package presentacion.Controlador.Comando;

public class Contexto {

	private int evento;

	private Object datos;

	public Contexto(int evento, Object datos) {
		this.evento = evento;
		this.datos = datos;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public int getEvento() {
		return evento;
	}

	public void setDatos(Object datos) {
		this.datos = datos;
	}

	public Object getDatos() {
		return datos;
	}
}