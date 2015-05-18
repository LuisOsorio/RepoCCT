package persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import data.model.Activity;
import data.model.Format;
import data.model.Objective;
import data.model.Strategy;
import data.model.Task;
import data.model.User;

public class ConexionDB {

	static Connection conexion = null;
	private static String DB_NAME = "sgc";
	private Statement stmt = null;

	public static Connection connect() {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_NAME, "root", "sgc12!M1324fgv");
			System.out.println("conexion exitosa");
		} catch (SQLException ex) {
			System.out.println("No se establecio conexi�n por sql");

			System.out.println(ex);

		} catch (Exception ex) {
			System.out.println("No se establecio conexi�n");
			System.out.println(ex);
		}

		return conexion;
	}
	public void closeConnection (){
		try {
		conexion.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	public User getIfUserExists(String email, String password) {

		String query = "select * from usuario where email='" + email + "' and password='"+password+"';";
		User user = null;
		ResultSet rs = null;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				rs.next();
				String em = rs.getString("email");
				String name = rs.getString("nombre");
				String sex = rs.getString("sexo");
				String pass = rs.getString("password");
				String idProcess = rs.getString("num_proceso");
				String processLead = rs.getString("lider_proceso");
				user = new User();
				user.setIdProcess(idProcess);
				user.setProcessLead(processLead);

			} else {
				System.out.println("No existe el usuario");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conexion.close();
			} catch (Exception e) {

			}

		}

		return user;

	}

	public List<Format> getFormatsByProcessOrNo(String idProcess ,String leadProcess) {
		String query=null;
		if("Y".equals(leadProcess)) {
			query = "select * from formatos where proceso_id='" + idProcess + "' and "
					+ "aprobado='Y' and activo='Y';";
		} else {
			query = "select * from formatos where aprobado='Y' and activo='Y';";
		}
		
		List<Format> listFormats = null;
		ResultSet rs = null;

		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				listFormats = new ArrayList<Format>();
				Format format = null;
				while (rs.next()) {
					String idFormat = rs.getString("id_formato");
					String idPro = rs.getString("proceso_id");
					String version = rs.getString("version");
					String nameFormat = rs.getString("nombre_formato");
					String extension = rs.getString("extension");
					String userModi= rs.getString("usuario_ultima_mod");
					format = new Format();
					format.setExtension(extension);
					format.setProcessId(idPro);
					format.setIdFormat(idFormat);
					format.setNameFormat(nameFormat);
					format.setVersion(version);
					format.setUserLastModification(userModi);
					listFormats.add(format);
				}
			} else {
				System.out.println("No existen formatos");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conexion.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo cerrar la conexion");
			}

		}

		return listFormats;
	}
	public List<Objective> getObjectives() {
		List<Objective> listObjectives=null;
		String query = "select * from objetivo";
		
		ResultSet rs = null;

		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				listObjectives = new ArrayList<Objective>();
				Objective ob = null;
				while (rs.next()) {
					String idObjective = rs.getString("id_objetivo");
					String description = rs.getString("descripcion");
					ob = new Objective();
					ob.setIdObjective(idObjective);
					ob.setDescription(description);
					listObjectives.add(ob);
				}
			} else {
				System.out.println("No existen objetivos");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				//conexion.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo cerrar la conexion");
			}

		}
		
		return listObjectives;
		
		
	}
	public List<Strategy> getStrategies() {
		List<Strategy> listStrategy=null;
		String query = "select * from estrategia";
		
		ResultSet rs = null;

		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				listStrategy = new ArrayList<Strategy>();
				Strategy st = null;
				while (rs.next()) {
					String idObjective = rs.getString("id_estrategia");
					String idStrategy= rs.getString("id_estrategia");
					String description = rs.getString("descripcion");
					st = new Strategy();
					st.setDescription(description);
					st.setIdObjective(idObjective);
					st.setIdStrategy(idStrategy);
					listStrategy.add(st);
				}
			} else {
				System.out.println("No existen objetivos");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				//conexion.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo cerrar la conexion");
			}

		}
		
		return listStrategy;
		
		
	}
	public List<Activity> getActivities() {
		List<Activity> listAct=null;
		String query = "select * from actividad";
		
		ResultSet rs = null;

		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				listAct = new ArrayList<Activity>();
				Activity act = null;
				while (rs.next()) {
					String idActividad = rs.getString("id_actividad");
					String description = rs.getString("descripcion");
					act = new Activity();
					act.setIdActivity(idActividad);
					act.setDescription(description);
					listAct.add(act);
				}
			} else {
				System.out.println("No existen objetivos");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				//conexion.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo cerrar la conexion");
			}

		}
		
		return listAct;
		
		
	}
	public List<User> getLeads() {
		List<User> userList=null;
		String query = "select * from usuario where lider_proceso='Y'";
		
		ResultSet rs = null;

		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				userList = new ArrayList<User>();
				User us = null;
				while (rs.next()) {
					String email = rs.getString("email");
					String name= rs.getString("nombre");
					
					us = new User();
					us.setEmail(email);
					us.setName(name);
					userList.add(us);
				}
			} else {
				System.out.println("No existen objetivos");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				//conexion.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo cerrar la conexion");
			}

		}
		
		return userList;
		
		
	}
	public List<Strategy> getStrategiesByObjective(String objective) {
		List<Strategy> listStrategies=null;
		String query = "select * from estrategia where id_objetivo='"+objective+"';";
		ResultSet rs = null;

		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				listStrategies = new ArrayList<Strategy>();
				Strategy stra = null;
				while (rs.next()) {
					String idStrategy = rs.getString("id_estrategia");
					String description = rs.getString("descripcion");
					stra = new Strategy();
					stra.setIdStrategy(idStrategy);
					stra.setIdObjective(objective);
					stra.setDescription(description);
					listStrategies.add(stra);
				}
			} else {
				System.out.println("No existen estrategias para este objetivo");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				//conexion.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo cerrar la conexion");
			}

		}
		return listStrategies;
	}
	public List<Activity> getActivitiesByStrategy(String strategy) {
		List<Activity> listActivities=null;
		String query = "select * from actividad where id_estrategia='"+strategy+"';";
		ResultSet rs = null;

		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				listActivities = new ArrayList<Activity>();
				Activity act = null;
				while (rs.next()) {
					String idActividad= rs.getString("id_actividad");
					String description = rs.getString("descripcion");
					act = new Activity();
					act.setIdActivity(idActividad);
					act.setIdStrategy(strategy);
					act.setDescription(description);					
					listActivities.add(act);
				}
			} else {
				System.out.println("No existen actividades para la estrategia");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				//conexion.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo cerrar la conexion");
			}

		}
		return listActivities;
	}
	public List<Task> getTaksByActivity(String activity) {
		List<Task> listTasks=null;
		String query = "select * from tarea where id_actividad='"+activity+"';";
		ResultSet rs = null;

		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				listTasks = new ArrayList<Task>();
				Task task = null;
				while (rs.next()) {
					String idTarea= rs.getString("id_tarea");
					String description = rs.getString("descripcion");
					task = new Task();
					task.setIdActivity(activity);
					task.setIdTask(idTarea);
					task.setDescription(description);
					listTasks.add(task);
				}
			} else {
				System.out.println("No existen tareas para este actividad");
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				//conexion.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("No se pudo cerrar la conexion");
			}

		}
		return listTasks;
	}
	public Boolean createObjetive(String idObjective, String descripcion) {
		String query = "insert into objetivo values ('"+idObjective+"','"+descripcion+"');";
		boolean success=true;
		try {

			stmt = conexion.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException se) {
			se.printStackTrace();
			success=false;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			success=false;
		}
		return new Boolean(success);
	}
	public void createStrategy(String idStrategy, String idObjective , String descripcion) {
		String query = "insert into estrategia values ('"+idStrategy+"','"+idObjective+"','"+descripcion+"');";
		try {

			stmt = conexion.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	public void createActivity(String idActivity, String idStrategy , String descripcion, String user) {
		String query = "insert into actividad values ('"+idActivity+"','"+idStrategy+"','"+descripcion+"','"+user+"');";
		try {

			stmt = conexion.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	public void createTask(String idTask, String idActivity , String descripcion, String user) {
		String query = "insert into tarea values ('"+idTask+"','"+idActivity+"','"+descripcion+"','"+user+"');";
		try {

			stmt = conexion.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	public void createPendingFormat(Format format, String userLastModi, String processId, String aproved) {
		String query = "insert into formatos values ('" + format.getIdFormat() + "','" + format.getVersion() + "'," + " '"
				+ userLastModi + "', '" + format.getExtension() + "' , '" + aproved + "','" + "Y'" + ",'"
				+ format.getNameFormat() + "', '" + processId + "');";
		try {

			stmt = conexion.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}
	public void updateApprovalFormat (String idFormat, String idVersion, String value) {
		String query = "update formatos set aprobado='"+value+"'where id_formato='"+ idFormat +"' and version='"+idVersion
				+ "';";
		try {

			stmt = conexion.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexion.close();
			} catch (Exception e) {

			}

		}
	}
	public void updateActiveFormat (String idFormat, String idVersion, String value) {
		String query = "update formatos set activo='"+value+"'where id_formato='" + idFormat + "'and version=" + "'" +idVersion
				+ "';";
		try {

			stmt = conexion.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexion.close();
			} catch (Exception e) {

			}

		}
	}

	public Format getFormat(String idFormat, String idVersion) {
		String query = "select * from formatos where id_formato='" + idFormat + "' and version=" + "'" + idVersion
				+ "';";
		Format formatResult = null;
		ResultSet rs = null;
		try {
			stmt = conexion.createStatement();
			rs = stmt.executeQuery(query);
			if (rs != null) {
				rs.next();

				String nameFormat = rs.getString("nombre_formato");
				String extension = rs.getString("extension");
				String aproved = rs.getString("aprobado");
				String activated = rs.getString("activo");
				String process = rs.getString("proceso_id");
				String userModi= rs.getString("usuario_ultima_mod");
				formatResult = new Format();
				formatResult.setIdFormat(idFormat);
				formatResult.setVersion(idVersion);
				formatResult.setNameFormat(nameFormat);
				formatResult.setExtension(extension);
				formatResult.setActived(activated);
				formatResult.setAprobado(aproved);
				formatResult.setProcessId(process);
				formatResult.setUserLastModification(userModi);

			} else {
				System.out.println("No existe el usuario");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conexion.close();
			} catch (Exception e) {

			}

		}

		return formatResult;

	}

	public List<Format> getFormatsNapproved(){
	List <Format> formats=null;
	String query= "select * from formatos where aprobado='N' and activo='Y';";
	
	ResultSet rs = null;

	try {
		stmt = conexion.createStatement();
		rs = stmt.executeQuery(query);
		if (rs != null) {
			formats = new ArrayList<Format>();
			Format format = null;
			while (rs.next()) {
				String idFormat = rs.getString("id_formato");
				String idProcess = rs.getString("proceso_id");
				String version = rs.getString("version");
				String nameFormat = rs.getString("nombre_formato");
				String extension = rs.getString("extension");
				String  userModi= rs.getString("extension");
				format = new Format();
				format.setExtension(extension);
				format.setProcessId(idProcess);
				format.setIdFormat(idFormat);
				format.setNameFormat(nameFormat);
				format.setVersion(version);
				format.setUserLastModification(userModi);
				formats.add(format);
			}
		} else {
			System.out.println("No existen formatos");
		}

	} catch (SQLException se) {
		se.printStackTrace();
	} catch (Exception e) {
		// Handle errors for Class.forName
		e.printStackTrace();
	} finally {
		try {
			rs.close();
			stmt.close();
			conexion.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se pudo cerrar la conexion");
		}

	}
	
			return formats;
	}
}
