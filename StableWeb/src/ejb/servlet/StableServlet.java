package ejb.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.facade.FacadeLocal;
import ejb.stablepkg.Horse;
import ejb.stablepkg.Stable;

/**
 * Servlet implementation class StableServlet
 */
@WebServlet({ "/StableServlet", "/AllStables", "/Stable" })
public class StableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FacadeLocal facade;
	private final String showAllStables = "/WEB-INF/show-all-stables.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		makeRequestWithAllStables(facade, request, response);
	}
	
	private void makeRequestWithAllStables(FacadeLocal facade, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Stable> allStables = facade.findAllStables();

		request.setAttribute("allStables", allStables);
		
		String url = showAllStables;
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Stable stable = new Stable();
		stable.setStableName(request.getParameter("stableName"));
		
		int stableNumberConverted = Integer.parseInt(request.getParameter("stableNumber"));
		stable.setStableNumber(stableNumberConverted);
		
		facade.createStable(stable);
		
		makeRequestWithAllStables(facade, request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int stableNumberConverted = Integer.parseInt(request.getParameter("stableNumber"));
		Stable stable = facade.findStableByNumber(stableNumberConverted);
		
		stable.setStableName(request.getParameter("StableName"));
		
		facade.updateStable(stable);
		
		String url = showAllStables;
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
