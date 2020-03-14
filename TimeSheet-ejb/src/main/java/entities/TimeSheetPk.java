package entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class TimeSheetPk implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idMission ;
	private int idEmploye ;
	public TimeSheetPk() {}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEmploye;
		result = prime * result + idMission;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeSheetPk other = (TimeSheetPk) obj;
		if (idEmploye != other.idEmploye)
			return false;
		if (idMission != other.idMission)
			return false;
		return true;
	}
	
}
