package services;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Departement;
import entities.Employe;
import entities.Mission;
import entities.TimeSheet;
import interfaces.TimesheetServiceLocal;
import interfaces.TimesheetServiceRemote;

@Stateless
public class TimesheetService implements TimesheetServiceLocal, TimesheetServiceRemote {
	
	// Création d'un entité manager
	@PersistenceContext(unitName= "timesheet-ejb")
	EntityManager em;
	
	@Override
	public void ajouterMission(Mission mission) {
		em.persist(mission);
	}

	@Override
	public void affecterMissionADepartement(int missionId, int depId) {
		Mission mis = em.find(Mission.class, missionId);
		Departement dep = em.find(Departement.class, depId);
		dep.getMissions().add(mis);
	}

	@Override
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		Mission mis = em.find(Mission.class, missionId);
		Employe emp = em.find(Employe.class, employeId);
		TimeSheet ts= new TimeSheet();
		ts.setDateDebut(dateDebut);
		ts.setDateFin(dateFin);
		ts.setMission(mis);
		ts.setEmploye(emp);
	}

}
