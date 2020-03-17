package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TimeSheet
 *
 */

@Entity
@Table(name="Timesheet")
public class TimeSheet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TimeSheetPk id ;
	
	@ManyToOne
	@JoinColumn(name="idMission", referencedColumnName="Id_Mission", insertable=false , updatable=false)
	private Mission mission ;
	
	@ManyToOne
	@JoinColumn(name="idEmploye", referencedColumnName="Id_Employe", insertable=false , updatable=false)
	private Employe employe;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date_Debut")
	private Date dateDebut ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date_Fin")
	private Date dateFin ;
	
	private Boolean isActive;
	
	public TimeSheet() {}
	
	public TimeSheetPk getId() { return id; }

	public void setId(TimeSheetPk id) { this.id = id; }


	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
