package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contrat")
public class Contrat implements Serializable {
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private int reference;
	
	private Date dateDebut;
	private String typeContrat;
	private float salaire;
	
	// Relation OneToOne avec Employe
	@OneToOne(mappedBy="contrat")
	private Employe employe;
	
	public Contrat() {}

	public Date getDateDebut() {return dateDebut;}

	public void setDateDebut(Date dateDebut) {this.dateDebut = dateDebut;}

	public String getTypeContrat() {return typeContrat;}

	public void setTypeContrat(String typeContrat) {this.typeContrat = typeContrat;}

	public float getSalaire() {return salaire;}

	public void setSalaire(float salaire) {this.salaire = salaire;}

	public Employe getEmploye() {return employe;}

	public void setEmploye(Employe employe) {this.employe = employe;}
	
}
