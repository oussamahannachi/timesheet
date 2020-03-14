package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departement")
public class Departement implements Serializable {
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_Departement")
	private int id;
	private String name;
	
	//OneToMany list des missions 
	@OneToMany(cascade=CascadeType.ALL ,mappedBy="departement")
	private List<Mission> missions = new ArrayList<Mission>(); 
	
	// ManyToOne avec Entreprise
	@ManyToOne
	private Entreprise entreprise;
	
	// ManyToMany list des employes
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Employe> employes;
	
	public Departement() { employes= new ArrayList<Employe>() ; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(ArrayList<Mission> missions) {
		this.missions = missions;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}
	
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(ArrayList<Employe> employes) {
		this.employes = employes;
	}
}
