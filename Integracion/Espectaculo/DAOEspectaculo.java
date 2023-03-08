
package integracion.Espectaculo;

import java.util.Set;
import negocio.Espectaculo.TEspectaculo;
import negocio.Espectaculo.TParticipa;

public interface DAOEspectaculo {

	public int create(TEspectaculo esp);

	public int delete(int id);

	public Set<TEspectaculo> readAll();

	public int update(TEspectaculo esp);

	public TEspectaculo read(int id);

	public Set<TEspectaculo> readEspectaculoByEmpleado(int idempleado);

	public Set<TEspectaculo> readEspectaculoByPez(int idPez);

	public int anyadirPez(TParticipa p);

	public int eliminarPez(TParticipa p);

	public int deletefisico(int id);

}