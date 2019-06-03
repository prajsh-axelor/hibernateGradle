package PersonPhone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="PhoneDetails")
public class PhoneDetails {
	
	@Id
	@GeneratedValue
	private Long id;
	private String provider;
	private String technology;
	
	public PhoneDetails() {}

	public PhoneDetails(String provider, String technology) {
		super();
		this.provider = provider;
		this.technology = technology;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
	
	

}
