package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mission")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public class Mission implements Serializable {
	
	protected static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_Mission")
	protected int id;
	protected String name;
	protected String description;
	
	// ManyToOne avce Departement
	@ManyToOne
	protected Departement departement ;
	
	@OneToMany(mappedBy="mission")
	private List<TimeSheet> timesheets=timesheets = new ArrayList<TimeSheet>() ;
	
	public Mission() {  }

	public int getId() { return id;}
	
	public void setId(int id) { this.id = id;}
	
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public Departement getDepartement() { return departement; }

	public void setDepartement(Departement departement) { this.departement = departement; }

	public List<TimeSheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<TimeSheet> timesheets) {
		this.timesheets = timesheets;
	}
	
}
