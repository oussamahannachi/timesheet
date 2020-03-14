package interfaces;

import java.util.Date;

import javax.ejb.Local;

import entities.Mission;

@Local
public interface TimesheetServiceLocal {
	public int ajouterMission(Mission mission);
	public void affecterMissionADepartement(int missionId, int depId);
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin);
}
