package ejb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.facade.FacadeLocal;
import ejb.stablepkg.Horse;
import ejb.stablepkg.Stable;

/**
 * Servlet implementation class StableMainServlet
 */
@WebServlet("/StableMainServlet")
public class StableMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FacadeLocal facade;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StableMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		
//		Horse h1 = new Horse();
//		h1.setHorseNumber(1);
//		h1.setColor("Bay");
//		h1.setName("Briar");
//		
//		facade.createHorse(h1);
		
//		Stable s6 = new Stable();
//		s6.setStableNumber(1);
//		s6.setStableName("Flyinge");
//		facade.createStable(s6);
//		
		
		Stable s = facade.findStableByNumber(1);
		
		out.println(s.getStableName());
		Set<Horse> horselist = s.getHorses();
		
		for(Horse h : horselist){
		
			out.println(h.getName());
		}
//		
		Horse h2 = new Horse();
		h2.setHorseNumber(5);
		h2.setName("Bellagio");
		h2.setColor("White");
		h2.setStable(s);
		
		
		horselist.add(h2);
		
		facade.updateStable(s);
		
		Stable s2 = facade.findStableByNumber(1);
		
		out.println(s.getStableName());
		Set<Horse> horselist2 = s2.getHorses();
		
		for(Horse h : horselist2){
		
			out.println(h.getName());
		}
		
//		if(horselist)
//		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
