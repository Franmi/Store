package negocio.Espectaculo;

public class TParticipa {
	
	
	private int idPez;
	private int idEspectaculo;
	
	public TParticipa(int p,int esp){
		idPez=p;
		idEspectaculo=esp;
	}

	public int getIdPez(){
		return idPez;
	}
	
	public int getIdEspectaculo(){
		return idEspectaculo;
	}
	
	public void setIdPez(int p){
		this.idPez=p;
	}
	
	public void setIdEspectaculo(int esp){
		this.idEspectaculo=esp;
	}
}
