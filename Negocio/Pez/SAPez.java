package negocio.Pez;

import java.util.Set;

public interface SAPez {

	public int create(TPez tPez);

	public int delete(int id);

	public int update(TPez tPez);

	public TPez read(int id);

	public Set<TPez> readAll();

	public Set<TPez> readPezByEspectaculo(int idEspectaculo);

	/**Solo para testing*/
	public int deletefisico(int id);
}