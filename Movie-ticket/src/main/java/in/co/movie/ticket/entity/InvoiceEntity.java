package in.co.movie.ticket.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="M_INVOICE")
public class InvoiceEntity extends BaseEntity {

	
	@Column(name="INVOICE_NUMBER",length = 225)
	private String invoiceNumber;
	@Column(name="NAME",length = 225)
	private String name;
	@Column(name="EMAIL",length = 225)
	private String email;
	@Column(name="MOBILE_NO",length = 225)
	private String mobileNo;
	@Column(name="THEATER_ID")
	private long theatorId;
	@Column(name="THEATER_NAME",length = 225)
	private String theatorName;
	@Column(name="MOVIE_ID")
	private long movieId;
	@Column(name="MOVIE_NAME",length = 225)
	private String movieName;
	@Column(name="NO_OF_SEAT",length = 225)
	private String noOfSeat;
	@Column(name="PRICE",length = 225)
	private String price;
	@Column(name="TOTAL",length = 225)
	private String total;
	@Column(name="SHOW_TIME",length = 225)
	private String show_time;
	@Column(name = "DATE", columnDefinition = "DATE")
	private Date date;
	@Column(name="SCREEN_NO",length = 225)
	private String screenNo;
	
	@Column(name="USER_ID")
	private long userId;
	
	public InvoiceEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "InvoiceEntity [invoiceNumber=" + invoiceNumber + ", name=" + name + ", email=" + email + ", mobileNo="
				+ mobileNo + ", theatorId=" + theatorId + ", theatorName=" + theatorName + ", movieId=" + movieId
				+ ", movieName=" + movieName + ", noOfSeat=" + noOfSeat + ", price=" + price + ", total=" + total
				+ ", show_time=" + show_time + ", date=" + date + "]";
	}

	
	
	



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(String screenNo) {
		this.screenNo = screenNo;
	}

	public String getShow_time() {
		return show_time;
	}

	public void setShow_time(String show_time) {
		this.show_time = show_time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
