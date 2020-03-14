package interfaces;

import java.util.List;
import javax.ejb.Local;
import entities.Departement;
import entities.Entreprise;

@Local
public interface EntrepriseServiceLocal {
	public void ajouterEntreprise(Entreprise entreprise);
	public void ajouterDepartement(Departement dep);
	void affecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
}
