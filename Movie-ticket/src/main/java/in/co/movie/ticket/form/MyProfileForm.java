package in.co.movie.ticket.form;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.movie.ticket.entity.BaseEntity;
import in.co.movie.ticket.entity.UserEntity;




public class MyProfileForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "First Name is Invalid")
	private String firstName;
	
	@NotEmpty(message = "LastName is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Last Name is Invalid")
	private String lastName;
	
	@NotEmpty(message = "Login is required")
	@Pattern(regexp="(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$",message = "Login id is invalid")
	private String login;
	
	@NotEmpty(message = "Mobile No is required")
	@Pattern(regexp="(^[7-9][0-9]{9})*$",message = "MobileNo is Invalid")
	private String mobileNo;


	


	
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public BaseEntity getBean() {
		UserEntity entity = new UserEntity();
		entity.setMobileNo(mobileNo);
		entity.setLogin(login);
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		return entity;
	}

	
	public void populate(BaseEntity bEntity) {
		UserEntity entity = (UserEntity) bEntity;
		mobileNo = entity.getMobileNo();
		login = entity.getLogin();
		firstName = entity.getFirstName();
		lastName = entity.getLastName();
	}

	

}
