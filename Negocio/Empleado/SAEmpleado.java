package negocio.Empleado;

import java.util.Set;

public interface SAEmpleado {

	public int addEmpleado(TEmpleado empleado);
	public TEmpleado readEmpleado(int id);
	public int deleteEmpleado(int id);
	public int updateEmpleado(TEmpleado empleado);
	public Set<TEmpleado> readAllEmpleados();
	public TEmpleado readEmpleadoPorDNI(String DNI);

}