package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Contrat;
import entities.Employe;

@Local
public interface EmployeServiceLocal {
	public void ajouterEmploye(Employe employe);
	public void affecterEmployeADepartement(int employeId, int depId);
	public void ajouterContrat(Contrat contrat);
	public void affecterContratAEmploye(int contratId, int employeId);
	public String getEmployePrenomById(int employeId);
	public long getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
}
