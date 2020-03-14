package services;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Contrat;
import entities.Departement;
import entities.Employe;
import interfaces.EmployeServiceLocal;
import interfaces.EmployeServiceRemote;

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
		List<Employe> employes = em.createQuery("select * from employe",Employe.class).getResultList();
		return  (long)employes.size();
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		List<String> names = (List<String>)em.createQuery("SELECT prenom FROM employe").getResultList();
		return names;
	}

}
