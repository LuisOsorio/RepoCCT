package operations;

import java.util.ArrayList;
import java.util.List;

import data.model.Activity;
import data.model.Objective;
import data.model.Strategy;
import data.model.Task;
import persistence.ConexionDB;


public class ActivitiesLogic {
	private ConexionDB conexionDB = new ConexionDB(); 
	public List<Objective> getActivitiesView() {
		List<Objective> listObjectivesFinal= new ArrayList<Objective>();
		if(conexionDB.connect()!=null) {
			List<Objective> listObjectives=conexionDB.getObjectives();
			for (Objective ob: listObjectives) {
				List<Strategy> listStrategiesOb=conexionDB.getStrategiesByObjective
						(ob.getIdObjective());
				for(Strategy str:listStrategiesOb) {
					List<Activity> listActivities=conexionDB.getActivitiesByStrategy
							(str.getIdStrategy());
					str.setListActivties(listActivities);
					for(Activity act: listActivities) {
						List<Task> listTask=conexionDB.getTaksByActivity(act.getIdActivity());
						act.setListTasks(listTask);
					}
				}
				
				ob.setListStrategies(listStrategiesOb);
				listObjectivesFinal.add(ob);
			}
		}
		conexionDB.closeConnection();
		return listObjectivesFinal;
	}

}
