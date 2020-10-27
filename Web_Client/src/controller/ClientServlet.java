package controller;



import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.entities.Client;
import metier.session.ClientSessionLocal;
import metier.session.VillageSessionLocal;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/Client")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @EJB
    private ClientSessionLocal clientdao;
    @EJB
    private VillageSessionLocal villagedao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("village", villagedao.allVillages());
		request.setAttribute("client", clientdao.allClients());
		request.getRequestDispatcher("client.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prenom = request.getParameter("prenom").toString();
 		String nom = request.getParameter("nom").toString();
 		String adress = request.getParameter("adress").toString();
 		String tel = request.getParameter("telephone").toString();
 		
 		Client client = new Client();
 		client.setPrenom(prenom);
 		client.setNom(nom);
 		client.setAdress(adress);
 		client.setTelephone(tel);
 		client.setVillage(villagedao.getVillage(Integer.parseInt(request.getParameter("idVillage"))));
 		
 		clientdao.insertClient(client);
 		response.sendRedirect("Client");
 	}

}
