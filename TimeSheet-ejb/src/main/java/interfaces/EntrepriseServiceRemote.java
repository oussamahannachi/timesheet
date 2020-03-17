package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Departement;
import entities.Entreprise;

@Remote
public interface EntrepriseServiceRemote {
	public void ajouterEntreprise(Entreprise entreprise);
	public void ajouterDepartement(Departement dep);
	public void affecterDepartementAEntreprise(int depId, int entrepriseId);
	public List<Departement> getAllDepartementsNamesByEntreprise(int entrepriseId);
	public Departement getDepartementById(int entrepriseId);
}
