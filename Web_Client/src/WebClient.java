import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.entities.Client;
import metier.session.ClientSessionLocal;

@WebService
public class WebClient {
	@EJB
	private ClientSessionLocal LocalClient;
		@WebMethod
		 public void insertClient(
				 @WebParam (name="Prenom_Client")String prenom, 
				 @WebParam (name="Nom_Client")String nom, 
				 @WebParam (name="Adress_Client")String adress, 
				 @WebParam (name="Telephone_Client")String telephone) {
			Client C = new Client();
			C.setPrenom(prenom);
			C.setNom(nom);
			C.setAdress(adress);
			C.setTelephone(telephone);
			LocalClient.insertClient(C);
		}
		
		@WebMethod
		 public Client getClient(@WebParam (name="ID_Client") int id) {
			return LocalClient.getClient(id);
		}
		
		@WebMethod
		 public List<Client> allClients(){
			return LocalClient.allClients();
			
		}
}
