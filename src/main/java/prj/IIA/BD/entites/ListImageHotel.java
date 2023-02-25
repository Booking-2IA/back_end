package prj.IIA.BD.entites;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ListImageHotel implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String image;
	@ManyToOne
	@JoinColumn(name="CODE_H")
	private Hotels hotel;
	public ListImageHotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListImageHotel(Long id, Hotels hotel) {
		super();
		this.id = id;
		this.hotel = hotel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Hotels getHotel() {
		return hotel;
	}
	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
