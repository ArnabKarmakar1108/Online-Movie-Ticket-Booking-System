package in.co.movie.ticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="M_THEATER")
public class TheaterEntity extends BaseEntity {

	@Column(name="NAME",length = 225)
	private String name;
	@Column(name="CITY",length = 225)
	private String city;
	@Column(name="ADDRESS",length = 225)
	private String address;
	@Column(name="TYPE",length = 225)
	private String type;
	
	@Lob
    @Column(name = "IMAGE", columnDefinition="LONGBLOB")
	private byte[] image;
	
	public TheaterEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public String toString() {
		return "TheatreEntity [name=" + name + ", city=" + city + ", address=" + address + ", type=" + type + "]";
	}

	


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


	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}



	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}

}
