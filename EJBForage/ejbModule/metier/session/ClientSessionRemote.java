package metier.session;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.Client;

@Remote
public interface ClientSessionRemote {
	public int insertClient(Client C);
	public void deleteClient(int id);
	public void updateClient(Client C);
	public Client getClient(int id);
	public List<Client> allClients();
}
