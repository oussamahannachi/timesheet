package entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

@Entity
@Table(name="employe")
public class Employe implements Serializable {
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_Employe")
	private int id;
	
	private String prenom;
	private String nom;
	
	@Column(unique=true)
	private String email;
	
	private Boolean isActif;
	
	// Enumeration
	@Enumerated(EnumType.STRING)
	private Role role;
	
	// Relation avec Contrat
	@OneToOne
	private Contrat contrat;
	
	// Listes des departemens
	@ManyToMany(cascade=CascadeType.ALL)
	private ArrayList<Departement> departements; 
	
	public Employe() {}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public ArrayList<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(ArrayList<Departement> departements) {
		this.departements = departements;
	}
	
}
