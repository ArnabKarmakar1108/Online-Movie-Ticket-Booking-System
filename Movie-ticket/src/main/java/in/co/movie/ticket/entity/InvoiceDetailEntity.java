package in.co.movie.ticket.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="M_INVOICE_DETAIL")
public class InvoiceDetailEntity extends BaseEntity {

	@Column(name="INVOICE_NUMBER",length = 225)
	private String invoiceNumber;
	@Column(name="THEATER_NAME",length = 225)
	private String theaterName;
	@Column(name="MOVIE_NAME",length = 225)
	private String movieName;
	@Column(name="PRICE",length = 225)
	private String price;
	@Column(name="SHOW_TIME",length = 225)
	private String show_time;
	@Column(name = "DATE", columnDefinition = "DATE")
	private Date date;
	
	@Column(name="SCREEN_NO",length = 225)
	private String screenNo;
	
	
	@Column(name="SEAT_NO",length = 225)
	private String seatNo;
	@Column(name="USER_ID")
	private long userId;
	
	public InvoiceDetailEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "InvoiceDetailEntity [invoiceNumber=" + invoiceNumber + ", theaterName=" + theaterName + ", movieName="
				+ movieName + ", price=" + price + ", show_time=" + show_time + ", date=" + date + "]";
	}
	
	

	
	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public String getSeatNo() {
		return seatNo;
	}



	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}



	public String getScreenNo() {
		return screenNo;
	}



	public void setScreenNo(String screenNo) {
		this.screenNo = screenNo;
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
