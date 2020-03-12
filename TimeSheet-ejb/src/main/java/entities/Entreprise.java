package entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="entreprise")
public class Entreprise implements Serializable {
	
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_Entreprise")
	private int id;
	
	private String name;
	private String raisonSocial;
	
	// List departement
	@OneToMany(cascade=CascadeType.ALL, mappedBy="entreprise")
	private ArrayList<Departement> departements;
	
	public Entreprise() { departements= new ArrayList<Departement>(); }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public ArrayList<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(ArrayList<Departement> departements) {
		this.departements = departements;
	}
	
}
