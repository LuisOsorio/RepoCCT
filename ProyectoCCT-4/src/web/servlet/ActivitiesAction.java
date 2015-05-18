package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.ConexionDB;

/**
 * Servlet implementation class ActivitiesAction
 */
@WebServlet("/ActivitiesAction")
public class ActivitiesAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConexionDB conexionDB = new ConexionDB();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivitiesAction() {
        super();
        // TODO Auto-generated constructor stub
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
		String ifObjective=request.getParameter("numeroObjetivo");
		String ifStrategy=request.getParameter("numeroEstrategia");
		String ifActivity=request.getParameter("numeroActividad");
		String ifTask=request.getParameter("numeroTarea");
		String description=request.getParameter("descripcion");
		HttpSession session = request.getSession(false);
		Boolean successOp= null;
		
		if(ifObjective!=null) {
			if(conexionDB.connect()!=null) {
				successOp=conexionDB.createObjetive(ifObjective, description);
			}
			
		} else if(ifStrategy!=null) {
			if(conexionDB.connect()!=null) {
				String idObjective=request.getParameter("list_objectives");
				conexionDB.createStrategy(ifStrategy,idObjective,description);
			}
			
		} else if(ifActivity!=null) {
			if(conexionDB.connect()!=null) {
				String idStrategy=request.getParameter("list_str");
				String idUser=request.getParameter("list_user");
				conexionDB.createActivity(ifActivity,idStrategy,description, idUser);
			}
				
			
		} else {
			String idActivity=request.getParameter("list_act");
			String idUser=request.getParameter("list_user");
			if(conexionDB.connect()!=null) {
				conexionDB.createTask(ifTask, idActivity, description, idUser);
			}
			
		}
		session.setAttribute("result", successOp);
		request.getServletContext().getRequestDispatcher("/WelPageLead.jsp").forward(request, response);
		
	}

}
