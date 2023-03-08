package integracion.Empleado;

import negocio.Empleado.TEmpleado;
import java.util.Set;

public interface DAOEmpleado {

	public int create(TEmpleado emp);

	public TEmpleado read(int id);

	public Set<TEmpleado> readAll();

	public int update(TEmpleado emp);

	public int delete(int idEmpleado);

	public TEmpleado readEmpleadoPorDNI(String DNI);

	public TEmpleado readId(int id);
}