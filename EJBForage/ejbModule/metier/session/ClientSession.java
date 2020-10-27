package metier.session;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import metier.entities.Client;

/**
 * Session Bean implementation class ClientSession
 */
@Stateless(name = "SC")
@LocalBean
public class ClientSession implements ClientSessionLocal {

	@PersistenceContext(unitName="EJBForage")
	private EntityManager manager;
    public ClientSession() {
    }

	@Override
	public int insertClient(Client C) {
		int ok = 0;
		
		try {
			//manager.getTransaction().begin();
			manager.persist(C);
			//manager.getTransaction().commit();
			ok = 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ok;
	}

	@Override
	public void deleteClient(int id) {
		Client C = manager.find(Client.class, id);
		manager.remove(C);	
	}

	@Override
	public void updateClient(Client C) {
		manager.merge(C);
		
	}

	@Override
	public Client getClient(int id) {
		Client C = manager.find(Client.class, id);
		if(C==null) throw new RuntimeException("Client introuvable");
		return C;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> allClients() {
		Query query = manager.createQuery("SELECT c FROM Client c");
		return query.getResultList();
	}

}
