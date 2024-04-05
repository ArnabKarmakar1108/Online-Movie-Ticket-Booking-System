package in.co.movie.ticket.form;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import in.co.movie.ticket.entity.BaseEntity;
import in.co.movie.ticket.entity.MovieEntity;


public class MovieForm extends BaseForm {

	@NotEmpty(message = "Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Name is Invalid")
	private String name;
	
	@Min(value = 1, message = "Theater Name required")
	private long theaterId;
	
	private String theaterName;
	@NotEmpty(message = "Movie Code is required")
	private String code;
	@NotEmpty(message = "Language is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Language is Invalid")
	private String language;
	@NotEmpty(message = "Cast is required")
	private String cast;
	@NotEmpty(message = "Director Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Director Name is Invalid")
	private String directorName;
	@NotEmpty(message = "Screen No is required")
	@Min(value=1, message="At leat must be 1")
	@Max(value=20, message="At lest must be minimum less then 20")
	private String screenNo;
	@NotEmpty(message = "Price is required")
	@Pattern(regexp = "^((\\d{1,3}|\\s*){1})((\\,\\d{3}|\\d)*)(\\s*|\\.(\\d{2}))$", message = "Price is Invalid")
	private String price;
	private MultipartFile image;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	

	public long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(String screenNo) {
		this.screenNo = screenNo;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public BaseEntity getBean() {
		MovieEntity entity=new MovieEntity();
		entity.setId(id);
		entity.setName(name);
		entity.setTheaterId(theaterId);
		entity.setTheaterName(theaterName);
		entity.setCode(code);
		entity.setLanguage(language);
		entity.setCast(cast);
		entity.setScreenNo(screenNo);
		entity.setPrice(price);
		entity.setDirectorName(directorName);
		entity.setCreatedBy(createdBy);
		entity.setModifiedBy(modifiedBy);
		entity.setCreatedDateTime(createdDateTime);
		entity.setModifiedDateTime(modifiedDateTime);
		return entity;
	}

	@Override
	public void populate(BaseEntity baseEntity) {
		MovieEntity entity=(MovieEntity) baseEntity;
		id=entity.getId();
		name=entity.getName();
		theaterId=entity.getTheaterId();
		theaterName=entity.getTheaterName();
		code=entity.getCode();
		screenNo=entity.getScreenNo();
		price=entity.getPrice();
		directorName=entity.getDirectorName();
		cast=entity.getCast();
		language=entity.getLanguage();
		createdBy=entity.getCreatedBy();
		modifiedBy=entity.getModifiedBy();
		createdDateTime=entity.getCreatedDateTime();
		modifiedDateTime=entity.getModifiedDateTime();
	}

}
