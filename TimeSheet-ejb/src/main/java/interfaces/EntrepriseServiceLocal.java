package interfaces;

import java.util.List;
import javax.ejb.Local;
import entities.Departement;
import entities.Entreprise;

@Local
public interface EntrepriseServiceLocal {
	public void ajouterEntreprise(Entreprise entreprise);
	public void ajouterDepartement(Departement dep);
	public void affecterDepartementAEntreprise(int depId, int entrepriseId);
	public List<Departement> getAllDepartementsNamesByEntreprise(int entrepriseId);
	public Departement getDepartementById(int entrepriseId);
}
