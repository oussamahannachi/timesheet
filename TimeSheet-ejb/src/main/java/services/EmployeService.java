package services;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Contrat;
import entities.Departement;
import entities.Employe;
import interfaces.EmployeServiceLocal;
import interfaces.EmployeServiceRemote;

@Stateless
public class EmployeService implements EmployeServiceLocal, EmployeServiceRemote {

	// Création d'un entité manager
	@PersistenceContext(unitName= "timesheet-ejb")
	EntityManager em;
	
	@Override
	public void ajouterEmploye(Employe employe) {
		em.persist(employe);
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		Employe emp = em.find(Employe.class, employeId);
		Departement dep = em.find(Departement.class, depId);
		dep.getEmployes().add(emp);
	}

	@Override
	public void ajouterContrat(Contrat contrat) {
		em.persist(contrat);
	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		Employe emp = em.find(Employe.class, employeId);
		Contrat cont = em.find(Contrat.class, contratId);
		emp.setContrat(cont);
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		Employe emp = em.find(Employe.class, employeId);
		return "Le prenom du l'employé est "+emp.getPrenom();
	}

	@Override
	public long getNombreEmployeJPQL() {
		Query q=em.createQuery("select count(*) from employe");
		long nombres = (Long)q.getSingleResult();
		return  nombres;
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		TypedQuery<String> q = em.createQuery("select prenom from employe",String.class);
		List<String> names = q.getResultList();
		return names;
	}

}
