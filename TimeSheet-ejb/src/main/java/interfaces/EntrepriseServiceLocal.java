package interfaces;

import java.util.List;
import javax.ejb.Local;
import entities.Departement;
import entities.Entreprise;

@Local
public interface EntrepriseServiceLocal {
	public int ajouterEntreprise(Entreprise entreprise);
	public int ajouterDepartement(Departement dep);
	void affecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
}
