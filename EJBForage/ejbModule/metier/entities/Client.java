package metier.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	@Column(name="prenom")
	private String prenom;
	@Column(name="nom")
	private String nom;
	@Column(name="adress")
    private String adress;
	@Column(name="telephone")
    private String telephone;
	@ManyToOne  
	@JoinColumn( name="idVillage" )
	private Village village;	
	
	private static final long serialVersionUID = 1L;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int id, String prenom, String nom, String adress, String telephone, metier.entities.Village village) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.adress = adress;
		this.telephone = telephone;
		this.village = village;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}