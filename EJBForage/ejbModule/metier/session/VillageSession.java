package metier.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import metier.entities.Village;

/**
 * Session Bean implementation class VillageSession
 */
@Stateless(name = "SV")
@LocalBean
public class VillageSession implements VillageSessionLocal{
	@PersistenceContext(unitName="EJBForage")
	private EntityManager manager;
    public VillageSession() {
    }
    
	@Override
	public int insertVillage(Village V) {
		int ok = 0;
		
		try {
			manager.persist(V);;
			ok = 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public void deleteVillage(int id) {
		Village V = manager.find(Village.class, id);
		manager.remove(V);
		
	}

	@Override
	public void updateVillage(Village V) {
		manager.merge(V);
		
	}

	@Override
	public Village getVillage(int id) {
		Village v = manager.find(Village.class, id);
		if(v==null) throw new RuntimeException("Village introuvable");
		return v;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Village> allVillages() {
		Query query = manager.createQuery("SELECT v FROM Village v");
		return query.getResultList();
	}

}
