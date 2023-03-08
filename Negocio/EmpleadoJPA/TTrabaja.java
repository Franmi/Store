/**
 * 
 */
package negocio.EmpleadoJPA;

public class TTrabaja {

	int idEmpleado;
	int idTurno;
	
	public TTrabaja(int idEmpl, int idTurn){
		this.idEmpleado = idEmpl;
		this.idTurno = idTurn;
	}
	
	int getIdEmpleado(){return idEmpleado;}
	int getIdTurno(){return idTurno;}
	void setIdEmpleado(int idEmplead){this.idEmpleado = idEmplead;}
	void setIdTurno(int idTurno){this.idTurno = idTurno;}
}