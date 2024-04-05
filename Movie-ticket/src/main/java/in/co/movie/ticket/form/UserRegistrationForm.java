package in.co.movie.ticket.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.movie.ticket.entity.BaseEntity;
import in.co.movie.ticket.entity.UserEntity;


public class UserRegistrationForm extends BaseForm {

	@NotEmpty(message = "First Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "First Name is Invalid")
	private String firstName;
	
	@NotEmpty(message = "Last Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Last Name is Invalid")
	private String lastName;
	
	@NotEmpty(message = "Login is required")
	@Pattern(regexp="(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$",message = "Login id is invalid")
	private String login;
	
	@NotEmpty(message = "Password is required")
	// @Pattern(regexp="(^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12})*$",message="Password is invalid must be 6 letter")
	private String password;
	
	
	@NotEmpty(message = "Mobile No is required")
	@Pattern(regexp="(^[7-9][0-9]{9})*$",message = "MobileNo is Invalid")
	private String mobileNo;
	
	@NotEmpty(message = "Confirm Password is required")
	private String confirmPassword;
	
	
	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

	@Override
	public BaseEntity getBean() {
		UserEntity bean=new UserEntity();
		bean.setId(id);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setLogin(login);
		bean.setPassword(password);
		bean.setMobileNo(mobileNo);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDateTime(createdDateTime);
		bean.setModifiedDateTime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseEntity baseBean) {
		UserEntity bean=(UserEntity)baseBean;
		id=bean.getId();
		firstName=bean.getFirstName();
		lastName=bean.getLastName();
		login=bean.getLogin();
		password=bean.getPassword();
		mobileNo=bean.getMobileNo();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getMobileNo();
		createdDateTime=bean.getCreatedDateTime();
		modifiedDateTime=bean.getModifiedDateTime();
	}

}
