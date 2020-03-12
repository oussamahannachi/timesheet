package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="timesheet")
public class TimeSheet implements Serializable {
	
	private static final long serialVersionUID= 1L;
	
	@Column(name="date_debut")
	private Date dateDebut ;
	
	@Column(name="date_fin")
	private Date dateFin ;
	
	private Boolean isActive;
	
}
