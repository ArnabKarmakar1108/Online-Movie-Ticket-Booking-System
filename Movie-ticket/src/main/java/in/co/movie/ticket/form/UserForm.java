package in.co.movie.ticket.form;

import in.co.movie.ticket.entity.BaseEntity;
import in.co.movie.ticket.entity.UserEntity;

public class UserForm extends BaseForm {

	private String firstName;
	private String lastName;
	private String login;
	private String password;
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
