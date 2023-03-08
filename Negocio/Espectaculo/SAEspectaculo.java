package negocio.Espectaculo;

import java.util.Set;

public interface SAEspectaculo {

	public int create(TEspectaculo espectaculo);

	public int update(TEspectaculo espectaculo);

	public int delete(int id);

	public TEspectaculo read(int id);

	public Set<TEspectaculo> readAll();

	public Set<TEspectaculo> readEspectaculoByEmpleado(int idempleado);

	public Set<TEspectaculo> readEspectaculoByPez(int idPez);

	public int anyadirPez(TParticipa p);

	public int eliminarPez(TParticipa p);

	//solo para testear
	public int deletefisico(int id);

	public int queryEspectaculo(int idEsp);

}