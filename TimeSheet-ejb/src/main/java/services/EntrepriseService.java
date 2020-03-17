package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
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
	@PersistenceContext(unitName="timesheet-ejb")
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
		dep.setEntreprise(ent);
	}

	@Override
	public List<Departement> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Entreprise ent = em.find(Entreprise.class, entrepriseId);
		List<Departement> names = new ArrayList<Departement>();
		for(Departement d : ent.getDepartements()) {
			names.add(d);
		}
		return names;
	}

	@Override
	public Departement getDepartementById(int Id) {
		Departement d=(Departement)em.find(Departement.class, Id);
		return d;
	}

}
