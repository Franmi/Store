package negocio.Pez;

public class TFluvial extends TPez {
	private int temperatura;

	public TFluvial(int idPez,String nombre,int temperatura) {
		super(idPez, "fluvial", nombre);
		this.temperatura= temperatura;
	}
	public TFluvial(String nombre,int temperatura) {
		super("fluvial", nombre);
		this.temperatura= temperatura;
	}
	
	public int getTemperatura() { return temperatura; }
	public void setTemperatura(int temperatura) {this.temperatura= temperatura; }

	public String toString() {
		return super.toString()+ "temperatura: "+ temperatura +"\n";
	}

}