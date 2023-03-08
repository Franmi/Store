package integracion.FactoriaEntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoriaEntityManager {
	
	private static EntityManagerFactory instance;

	private static String ENTITY_NAME = "Tienda";

	public synchronized static EntityManagerFactory getInstance() {
		if (instance == null)
			instance = Persistence.createEntityManagerFactory(ENTITY_NAME);
		return instance;
	}
	
	public void finalize(){
		if (instance != null)
			instance.close();
		instance = null;
	}
	
}
