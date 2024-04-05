package in.co.movie.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "M_Movies")
public class MovieEntity extends BaseEntity {

	@Column(name="THEATER_ID")
	private long theaterId;
	@Column(name="THEATER_NAME",length = 225)
	private String theaterName;
	@Column(name="NAME",length = 225)
	private String name;
	@Column(name="CODE",length = 225)
	private String code;
	@Column(name="LANGUAGE",length = 225)
	private String language;
	@Column(name="CAST",length = 225)
	private String cast;
	@Column(name="DIRECTOR_NAME",length = 225)
	private String directorName;
	@Column(name="SCREEN_NO",length = 225)
	private String screenNo;
	@Lob
    @Column(name = "IMAGE", columnDefinition="LONGBLOB")
	private byte[] image;
	@Column(name="PRICE",length = 225)
	private String price;
	
	public MovieEntity() {
	}
	
	@Override
	public String toString() {
		return "MovieEntity [theaterId=" + theaterId + ", theaterName=" + theaterName + ", name=" + name + ", code="
				+ code + ", language=" + language + ", cast=" + cast + ", directorName=" + directorName + ", screenNo="
				+ screenNo + ", price=" + price + "]";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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



	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		return name;
	}

}
