package web.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import operations.ActivitiesLogic;
import persistence.ConexionDB;
import data.model.Activity;
import data.model.Objective;
import data.model.Strategy;
import data.model.Task;
import data.model.User;

/**
 * Servlet implementation class ActivitiesView
 */
@WebServlet("/ActivitiesView")
public class ActivitiesView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConexionDB conexionDB = new ConexionDB();
	private ActivitiesLogic act = new ActivitiesLogic();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActivitiesView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);
		Boolean result = (Boolean) session.getAttribute("result");
		
		/*
		 * List<Objective> listObjectives=act.getActivitiesView();
		 * if(listObjectives!=null) { out.println('<div class'panel-group'
		 * id='accordion'>'); for (Objective ob:listObjectives) {
		 * 
		 * out.println('<div class='panel panel-default'>'); out.println('<div
		 * class='panel-heading'>'); out.println('<h4 class='panel-title'>');
		 * out.println('<a data-toggle='collapse' data-parent='#accordion'
		 * href='#'+ob.getIdObjective()+'_ob'>');
		 * out.println(ob.getDescription()); out.println('</a>');
		 * out.println('</h4>'); out.println('</div>');
		 * 
		 * 
		 * out.println('<div id=''+ob.getIdObjective()+'_ob'
		 * class='panel-collapse collapse in'>'); out.println('<div
		 * class='panel-body'>'); int consecutiveStr=0; for (Strategy stra:
		 * ob.getListStrategies()) {
		 * 
		 * 
		 * 
		 * out.println('<div class='panel panel-default'>');// out.println('<div
		 * class='panel-heading'>');// out.println('<h4
		 * class='panel-title'>');// out.println('<a data-toggle='collapse'
		 * data-parent='#accordion' href='#'+consecutiveStr+'_st'>');//
		 * out.println(stra.getDescription()); out.println('</a>');//
		 * out.println('</h4>'); // h4 class out.println('</div>'); // panel
		 * heading strategy
		 * 
		 * out.println('<div id=''+consecutiveStr+'_st'' class='panel-collapse
		 * collapse in'>');// out.println('<div class='panel-body'>');
		 * consecutiveStr++; int consecutiveAct=0; for (Activity act:
		 * stra.getListActivties()) { out.println('<div class='panel
		 * panel-default'>');// out.println('<div class='panel-heading'>');//
		 * out.println('<h4 class='panel-title'>');// out.println('<a
		 * data-toggle='collapse' data-parent='#accordion'
		 * href='#'+consecutiveAct+'_act'>');//
		 * out.println(act.getIdActivity()); out.println('</a>');//
		 * out.println('</h4>'); // h4 class out.println('</div>'); //
		 * 
		 * out.println('<div id=''+consecutiveAct+'_act' class='panel-collapse
		 * collapse in'>');// out.println('<div class='panel-body'>');
		 * out.println(act.getDescription()); consecutiveAct++; int
		 * consecutiveTask=0; for (Task task: act.getListTasks()) {
		 * out.println('<div class='panel panel-default'>');// out.println('<div
		 * class='panel-heading'>');// out.println('<h4
		 * class='panel-title'>');// out.println('<a data-toggle='collapse'
		 * data-parent='#accordion' href='#'+consecutiveTask+'_task'>');//
		 * out.println(task.getIdTask()); out.println('</a>');//
		 * out.println('</h4>'); // h4 class out.println('</div>'); //
		 * 
		 * out.println('<div id=''+consecutiveTask+'_task' class='panel-collapse
		 * collapse in'>');// out.println('<div class='panel-body'>');
		 * out.println(task.getDescription()); consecutiveTask++;
		 * out.println('</div>'); out.println('</div>'); out.println('</div>');
		 * } out.println('</div>'); out.println('</div>');
		 * out.println('</div>');
		 * 
		 * }
		 * 
		 * //out.println('</div>');/// panel body out.println('</div>');//panle
		 * collapse out.println('</div>'); // panel default
		 * out.println('</div>');
		 * 
		 * } out.println('</div>'); out.println('</div>');
		 * 
		 * out.println('</div>');
		 * 
		 * } out.println('</div>'); // accordion group
		 * 
		 * }
		 */
		if ("objetive".equals(action)) {

			out.println("<div class='container'>");
			out.println("<form class='form-horizontal' role='form' action='ActivitiesAction' method='post'>");
			out.println("<div class='form-group'>");
			out.println("<div class='col-md-6'>");
			out.println("<h2>Crear Objetivo</h2>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>N&uacute;mero Objetivo</label>");
			out.println("<div class='col-md-3'>");
			out.println("<input type='text' class='form-control' id='numeroObjetivo' name='numeroObjetivo' placeholder='Numero Objetivo'>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>Descripci&oacute;n</label>");
			out.println("<div class='col-lg-3'>");
			out.println("<input type='text' class='form-control' id='descripcion' name='descripcion' placeholder='Descripción Objetivo'>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<div class='col-lg-offset-2 col-lg-10'>");
			out.println("<button type='submit' class='btn btn-primary'>Crear</button>");
			out.println("</div>");
			out.println("</div>");
			out.println("</form>");
			out.println("</div>");
		} else if ("strategy".equals(action)) {
			out.println("<div class='container'>");
			out.println("<form class='form-horizontal' role='form' action='ActivitiesAction' method='post'>");
			out.println("<div class='form-group'>");
			out.println("<div class='col-md-6'>");
			out.println("<h2>Crear Estrategia</h2>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>N&uacute;mero Estrategia</label>");
			out.println("<div class='col-md-3'>");
			out.println("<input type='text' class='form-control' id='numeroEstrategia' name='numeroEstrategia' placeholder='Numero Estrategia'>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>Descripci&oacute;n</label>");
			out.println("<div class='col-lg-3'>");
			out.println("<input type='text' class='form-control' id='descripcion' name='descripcion' placeholder='Descripción Estrategia'>");
			out.println("</div>");
			out.println("</div>");

			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>Objetivo Asociado</label>");
			out.println("<div class='col-lg-3'>");
			out.println("<select id='list_objectives' name='list_objectives' class='form-control'>");
			if (conexionDB.connect() != null) {
				List<Objective> listOb = conexionDB.getObjectives();
				for (Objective ob : listOb) {
					out.println("<option  value='" + ob.getIdObjective() + "'>" + ob.getIdObjective() + "</option>");
				}
			}
			out.println("</select>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<div class='col-lg-offset-3 col-lg-10'>");
			out.println("<button type='submit' class='btn btn-primary'>Crear</button>");
			out.println("</div>");
			out.println("</div>");
			out.println("</form>");
			out.println("</div>");

		} else if ("activity".equals(action)) {
			out.println("<div class='container'>");
			out.println("<form class='form-horizontal' role='form' action='ActivitiesAction' method='post'>");
			out.println("<div class='form-group'>");
			out.println("<div class='col-md-6'>");
			out.println("<h2>Crear Actividad</h2>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>N&uacute;mero Actividad</label>");
			out.println("<div class='col-md-3'>");
			out.println("<input type='text' class='form-control' id='numeroActividad' name='numeroActividad' placeholder='Numero Actividad'>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>Descripci&oacute;n</label>");
			out.println("<div class='col-lg-3'>");
			out.println("<input type='text' class='form-control' id='descripcion' name='descripcion' placeholder='Descripción Actividad'>");
			out.println("</div>");
			out.println("</div>");

			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>Estrategia Asociada</label>");
			out.println("<div class='col-lg-3'>");
			out.println("<select id='list_str' name='list_str'class='form-control'>");
			if (conexionDB.connect() != null) {
				List<Strategy> listSt = conexionDB.getStrategies();
				for (Strategy st : listSt) {
					out.println("<option value='" + st.getIdStrategy() + "'>" + st.getIdStrategy() + "</option>");
				}
			}
			out.println("</select>");
			out.println("</div>");
			out.println("</div>");

			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>Lider de Proceso Asignado</label>");
			out.println("<div class='col-lg-3'>");
			out.println("<select id='list_user' name='list_user' class='form-control'>");
			if (conexionDB.connect() != null) {
				List<User> listUs = conexionDB.getLeads();
				for (User us : listUs) {
					out.println("<option value='" + us.getEmail() + "'>" + us.getName() + "</option>");
				}
			}
			out.println("</select>");
			out.println("</div>");
			out.println("</div>");

			out.println("<div class='form-group'>");
			out.println("<div class='col-lg-offset-3 col-lg-10'>");
			out.println("<button type='submit' class='btn btn-primary'>Crear</button>");
			out.println("</div>");
			out.println("</div>");
			out.println("</form>");
			out.println("</div>");

		} else {
			out.println("<div class='container'>");
			out.println("<form class='form-horizontal' role='form' action='ActivitiesAction' method='post'>");
			out.println("<div class='form-group'>");
			out.println("<div class='col-md-6'>");
			out.println("<h2>Crear Tarea</h2>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>N&uacute;mero Tarea</label>");
			out.println("<div class='col-md-3'>");
			out.println("<input type='text' class='form-control' id='numeroTarea' name='numeroTarea' placeholder='Numero Tarea'>");
			out.println("</div>");
			out.println("</div>");
			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>Descripci&oacute;n</label>");
			out.println("<div class='col-lg-3'>");
			out.println("<input type='text' class='form-control' id='descripcion' name='descripcion' placeholder='Descripción Tarea'>");
			out.println("</div>");
			out.println("</div>");

			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>Actividad Asociada</label>");
			out.println("<div class='col-lg-3'>");
			out.println("<select id='list_act' name='list_act' class='form-control'>");
			if (conexionDB.connect() != null) {
				List<Activity> listAct = conexionDB.getActivities();
				for (Activity act : listAct) {
					out.println("<option value='" + act.getIdActivity() + "'>" + act.getIdActivity() + "</option>");
				}
			}
			out.println("</select>");
			out.println("</div>");
			out.println("</div>");

			out.println("<div class='form-group'>");
			out.println("<label class='col-md-3 control-label'>Lider de Proceso Asignado</label>");
			out.println("<div class='col-lg-3'>");
			out.println("<select id='list_user' name='list_user' class='form-control'>");
			if (conexionDB.connect() != null) {
				List<User> listUs = conexionDB.getLeads();
				for (User us : listUs) {
					out.println("<option value='" + us.getEmail() + "'>" + us.getName() + "</option>");
				}
			}
			out.println("</select>");
			out.println("</div>");
			out.println("</div>");

			out.println("<div class='form-group'>");
			out.println("<div class='col-lg-offset-3 col-lg-10'>");
			out.println("<button type='submit' class='btn btn-primary'>Crear</button>");
			out.println("</div>");
			out.println("</div>");
			out.println("</form>");
			out.println("</div>");
		}
		if (result != null) {
			if (result.booleanValue()) {
				out.println("<label class='col-md-3 control-label'>Se ha guardado éxitosamente el contenido</label>");
			} else {
				out.println("<label class='col-md-3 control-label'>Ha fallado la creación del contenido</label>");
			}

		}
	}

}
