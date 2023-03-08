/**
 * 
 */
package negocio.EmpleadoJPA;

import negocio.EmpleadoJPA.TEmpleadoJPA;

import java.util.Collection;
import java.util.Set;

public interface SAEmpleadoJPA {

	public int deleteEmpleado(int id);
	public int createEmpleado(TEmpleadoJPA tEmpleado);
	public TEmpleadoJPA readEmpleado(int id);
	public Collection<TEmpleadoJPA> readAllEmpleados();
	public int updateEmpleado(TEmpleadoJPA tEmpleado);
	public int vincularTurno(TTrabaja tTrabaja);
	public int desvincularTurno(TTrabaja tTrabaja);
	public Collection<TEmpleadoJPA> readEmpleadosByTurno(int id);
	public double calcularNomina (int idEmpleado);
	
}