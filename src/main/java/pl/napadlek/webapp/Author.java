package pl.napadlek.webapp;

import java.util.Date;

public class Author implements IdAware {
	private Long id;
	private String firstName;
	private String lastName;
	private Date born;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getBorn() {
		return born;
	}
	
	public void setBorn(Date born) {
		this.born = born;
	}
}
