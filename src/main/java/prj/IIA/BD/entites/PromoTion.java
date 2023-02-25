package prj.IIA.BD.entites;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class PromoTion implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private double tauxPro;
	private String Type;
	private Date debut;
	private Date fin;
	private boolean active=false;
	@ManyToOne
	@JoinColumn(name="CODE_HOT")
	private Hotels hotel;
	public PromoTion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PromoTion(Long id, double tauxPro, boolean active, Hotels hotel) {
		super();
		this.id = id;
		this.tauxPro = tauxPro;
		this.active = active;
		this.hotel = hotel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getTauxPro() {
		return tauxPro;
	}
	public void setTauxPro(double tauxPro) {
		this.tauxPro = tauxPro;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Hotels getHotel() {
		return hotel;
	}
	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	
}
