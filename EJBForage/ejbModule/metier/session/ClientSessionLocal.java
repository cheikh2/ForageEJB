package metier.session;

import java.util.List;
import javax.ejb.Local;
import metier.entities.Client;

@Local
public interface ClientSessionLocal {
	public int insertClient(Client C);
	public void deleteClient(int id);
	public void updateClient(Client C);
	public Client getClient(int id);
	public List<Client> allClients();
}
