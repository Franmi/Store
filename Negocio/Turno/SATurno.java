package negocio.Turno;

import java.util.Collection;

public interface SATurno {
	
	public int addTurno(TTurno tTurno);
	
	public int deleteTurno(int id);
	
	public int updateTurno(TTurno tTurno);

	public TTurno readTurno(int id);

	public Collection<TTurno> readTurnosByEmpleado(int id);

	public Collection<TTurno> readAllTurnos();
	
	public double calcularNomina(int id);
	
	public void bajaFisica(int id);
	
}