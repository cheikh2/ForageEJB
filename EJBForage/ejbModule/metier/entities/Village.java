package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Village
 *
 */
@Entity
public class Village implements Serializable {

	   
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	@Column(name="libelle")
	private String libelle;
	@OneToMany(mappedBy = "village", fetch = FetchType.LAZY)
	List<Client> clients = new ArrayList<Client>();
	
	private static final long serialVersionUID = 1L;

	public Village() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Village(int id, String libelle, List<Client> clients) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.clients = clients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
