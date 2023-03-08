package negocio.Pez;

public class TMarino extends TPez {

	private double salinidad;

	public TMarino(int idPez,String nombre,double salinidad) {
		super(idPez, "marino", nombre);
		this.salinidad= salinidad;
	}
	public TMarino(String nombre,double salinidad) {
		super("marino", nombre);
		this.salinidad= salinidad;
	}

	public double getSalinidad() { return salinidad; }
	public void setSalinidad(double salinidad) { this.salinidad= salinidad; }

	public String toString() {
		return super.toString()+ "salinidad: "+ salinidad +"\n";
	}

}