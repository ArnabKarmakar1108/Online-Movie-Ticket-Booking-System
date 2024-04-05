package in.co.movie.ticket.form;

import java.io.IOException;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import in.co.movie.ticket.entity.BaseEntity;
import in.co.movie.ticket.entity.TheaterEntity;


public class TheaterForm extends BaseForm {

	@NotEmpty(message = "Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Name is Invalid")
	private String name;
	
	@NotEmpty(message = "City is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "City is Invalid")
	private String city;
	
	@NotEmpty(message = "Address is required")
	private String address;
	
	@NotEmpty(message = "Type is required")
	private String type;
	
	private MultipartFile image;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	@Override
	public BaseEntity getBean() {
		TheaterEntity entity=new TheaterEntity();
		entity.setId(id);
		entity.setName(name);
		entity.setCity(city);
		entity.setAddress(address);
		entity.setType(type);
		entity.setCreatedBy(createdBy);
		entity.setModifiedBy(modifiedBy);
		entity.setCreatedDateTime(createdDateTime);
		entity.setModifiedDateTime(modifiedDateTime);
		return entity;
	}

	@Override
	public void populate(BaseEntity baseEntity) {
		TheaterEntity entity=(TheaterEntity) baseEntity;
		id=entity.getId();
		name=entity.getName();
		city=entity.getCity();
		address=entity.getAddress();
		type=entity.getType();
		createdBy=entity.getCreatedBy();
		modifiedBy=entity.getModifiedBy();
		createdDateTime=entity.getCreatedDateTime();
		modifiedDateTime=entity.getModifiedDateTime();
	}

}
