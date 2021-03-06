package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Contrat;
import entities.Employe;

@Remote
public interface EmployeServiceRemote {
	public void ajouterEmploye(Employe employe);
	public void affecterEmployeADepartement(int employeId, int depId);
	public void ajouterContrat(Contrat contrat);
	public void affecterContratAEmploye(int contratId, int employeId);
	public String getEmployePrenomById(int employeId);
	public long getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
}
