package in.co.movie.ticket.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import in.co.movie.ticket.entity.BaseEntity;
import in.co.movie.ticket.entity.UserEntity;


public class LoginForm extends BaseForm {

	
	@NotEmpty(message = "Login is required")
	@Pattern(regexp="(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$",message = "Login id is invalid")
	private String login;
	
	@NotEmpty(message = "Password is required")
	private String password;


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

	// To set data into  user entity class
	@Override
	public BaseEntity getBean() {
		UserEntity bean=new UserEntity();
		bean.setLogin(login);
		bean.setPassword(password);
		return bean;
	}

	// to populate data from user entity class
	@Override
	public void populate(BaseEntity baseBean) {
	}

}
