package in.co.movie.ticket.form;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import in.co.movie.ticket.entity.BaseEntity;
import in.co.movie.ticket.entity.InvoiceDetailEntity;
import in.co.movie.ticket.entity.MovieEntity;


public class InvoiceDetailForm extends BaseForm {

	
	private String invoiceNumber;
	private String theaterName;
	private String movieName;
	private String price;
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

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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
		InvoiceDetailEntity entity=new InvoiceDetailEntity();
		entity.setId(id);
		entity.setInvoiceNumber(invoiceNumber);
		entity.setTheaterName(theaterName);
		entity.setMovieName(movieName);
		entity.setPrice(price);
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
		InvoiceDetailEntity entity=(InvoiceDetailEntity) baseEntity;
		id=entity.getId();
		theaterName=entity.getTheaterName();
		invoiceNumber=entity.getInvoiceNumber();
		movieName=entity.getMovieName();
		showtime=entity.getShow_time();
		date=entity.getDate();
		userId=entity.getUserId();
		screenNo=entity.getScreenNo();
		price=entity.getPrice();
		createdBy=entity.getCreatedBy();
		modifiedBy=entity.getModifiedBy();
		createdDateTime=entity.getCreatedDateTime();
		modifiedDateTime=entity.getModifiedDateTime();
	}

}
