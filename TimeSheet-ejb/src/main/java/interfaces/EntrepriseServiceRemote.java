package interfaces;

import java.util.List;

import javax.ejb.Remote;
import entities.*;

@Remote
public interface EntrepriseServiceRemote {

	public int ajouterEntreprise(Entreprise entreprise);
	public int ajouterDepartement(Departement dep);
	void affecterDepartementAEntreprise(int depId, int entrepriseId);
	List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);
	
}
