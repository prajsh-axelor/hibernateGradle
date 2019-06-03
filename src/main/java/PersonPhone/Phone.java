package PersonPhone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="Phone")
public class Phone {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="number")
	private String number;
	
	@OneToOne
	@JoinColumn(name="details_id")
	private PhoneDetails details;
	
	public Phone() {}
	
	

	public Phone(String number) {
		super();
		this.number = number;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneDetails getDetails() {
		return details;
	}

	public void setDetails(PhoneDetails details) {
		this.details = details;
	}
	

	
}
