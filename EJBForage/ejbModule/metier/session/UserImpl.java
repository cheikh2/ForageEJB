package metier.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.entities.User;

/**
 * Session Bean implementation class ClientSession
 */
@Stateless(name = "SU")
@LocalBean
public class UserImpl implements IUser{
	private EntityManager em;
	
	public UserImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("foragePU");
		
		this.em = emf.createEntityManager();
	}

	@Override
	public int add(User user) {
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return 1;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

	@Override
	public User getLogin(String email, String password) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email=:e AND u.password=:p");
		query.setParameter("e", email);
		query.setParameter("p", password);
		try {
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
