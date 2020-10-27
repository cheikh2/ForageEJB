package metier.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
public class Role implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="libelle")
	private String libelle;
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    List<User> users = new ArrayList<User>();
	private static final long serialVersionUID = 1L;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int id, String libelle, List<User> users) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.users = users;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}  
}
