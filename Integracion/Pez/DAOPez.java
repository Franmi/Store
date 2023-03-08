package integracion.Pez;

import negocio.Pez.TPez;
import java.util.Set;

public interface DAOPez {

	public int create(TPez tPez);

	public int delete(int id);

	public int update(TPez tPez);

	public TPez read(int id);

	public Set<TPez> readAll();

	public void deletefisico(int id);

	public Set<TPez> readPezbyEspectaculo(int idEspectaculo);
}