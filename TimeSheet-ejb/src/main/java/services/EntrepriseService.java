package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entities.Departement;
import entities.Entreprise;
import interfaces.EntrepriseServiceLocal;
import interfaces.EntrepriseServiceRemote;

@Stateless
public class EntrepriseService implements EntrepriseServiceLocal, EntrepriseServiceRemote {

	// Création d'un entité manager
	@PersistenceContext(unitName= "timesheet-ejb")
	EntityManager em;
	
	@Override
	public void ajouterEntreprise(Entreprise entreprise) {
		em.persist(entreprise);
	}

	@Override
	public void ajouterDepartement(Departement dep) {
		em.persist(dep);
	}

	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		Entreprise ent = em.find(Entreprise.class, entrepriseId);
		Departement dep = em.find(Departement.class, depId);
		ent.getDepartements().add(dep);
	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		List<String> names = (List<String>)em.createNamedQuery("select name from departement where entreprise_ID_Entreprise=:id", String.class)
				.setParameter("id", entrepriseId)
				.getResultList();
		return names;
	}

}
