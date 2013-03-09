package ejb.stablepkg;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stable")
public class Stable implements Serializable{
	
	
	private long stableNumber;
	private String stableName;
	
	@Id
	@Column(name="stableName")
	public long getStableNumber() {
		return stableNumber;
	}
	public void setStableNumber(long stableNumber) {
		this.stableNumber = stableNumber;
	}
	
	@Column(name="stableName")
	public String getStableName() {
		return stableName;
	}
	public void setStableName(String stableName) {
		this.stableName = stableName;
	}
	
}
