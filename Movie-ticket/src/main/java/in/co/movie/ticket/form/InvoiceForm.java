package in.co.movie.ticket.form;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import in.co.movie.ticket.entity.BaseEntity;
import in.co.movie.ticket.entity.InvoiceEntity;
import in.co.movie.ticket.entity.MovieEntity;


public class InvoiceForm extends BaseForm {

	
	private String invoiceNumber;
	@NotEmpty(message = "Name is required")
	@Pattern(regexp = "(^[A-Za-z ]*)*$",message = "Name is Invalid")
	private String name;
	@NotEmpty(message = "Email is required")
	@Pattern(regexp="(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$",message = "Email id is invalid")
	private String email;
	@NotEmpty(message = "Mobile No is required")
	@Pattern(regexp="(^[7-9][0-9]{9})*$",message = "MobileNo is Invalid")
	private String mobileNo;
	
	private long theatorId;
	private String theatorName;
	private long movieId;
	private String movieName;
	
	@NotEmpty(message = "Person is required")
	@Min(value=1, message="At leat must be 1")
	@Max(value=20, message="At lest must be minimum less then 20")
	private String noOfSeat;
	private String price;
	private String totalAmt;
	@NotEmpty(message = "Show Time is required")
	private String showtime;
	private Date date;
	private String screenNo;

	private long userId;
	
	
	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getTheatorId() {
		return theatorId;
	}

	public void setTheatorId(long theatorId) {
		this.theatorId = theatorId;
	}

	public String getTheatorName() {
		return theatorName;
	}

	public void setTheatorName(String theatorName) {
		this.theatorName = theatorName;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getNoOfSeat() {
		return noOfSeat;
	}

	public void setNoOfSeat(String noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(String screenNo) {
		this.screenNo = screenNo;
	}

	@Override
	public BaseEntity getBean() {
		InvoiceEntity entity=new InvoiceEntity();
		entity.setId(id);
		entity.setInvoiceNumber(invoiceNumber);
		entity.setName(name);
		entity.setEmail(email);
		entity.setMobileNo(mobileNo);
		entity.setTheatorId(theatorId);
		entity.setTheatorName(theatorName);
		entity.setMovieId(movieId);
		entity.setMovieName(movieName);
		entity.setNoOfSeat(noOfSeat);
		entity.setPrice(price);
		entity.setTotal(totalAmt);
		entity.setShow_time(showtime);
		entity.setDate(date);
		entity.setUserId(userId);
		entity.setScreenNo(screenNo);
		entity.setCreatedBy(createdBy);
		entity.setModifiedBy(modifiedBy);
		entity.setCreatedDateTime(createdDateTime);
		entity.setModifiedDateTime(modifiedDateTime);
		return entity;
	}

	@Override
	public void populate(BaseEntity baseEntity) {
		InvoiceEntity entity=(InvoiceEntity) baseEntity;
		id=entity.getId();
		invoiceNumber=entity.getInvoiceNumber();
		name=entity.getName();
		email=entity.getEmail();
		mobileNo=entity.getMobileNo();
		theatorId=entity.getTheatorId();
		theatorName=entity.getTheatorName();
		movieId=entity.getMovieId();
		movieName=entity.getMovieName();
		noOfSeat=entity.getNoOfSeat();
		totalAmt=entity.getTotal();
		showtime=entity.getShow_time();
		date=entity.getDate();
		screenNo=entity.getScreenNo();
		price=entity.getPrice();
		userId=entity.getUserId();
		createdBy=entity.getCreatedBy();
		modifiedBy=entity.getModifiedBy();
		createdDateTime=entity.getCreatedDateTime();
		modifiedDateTime=entity.getModifiedDateTime();
	}

}
