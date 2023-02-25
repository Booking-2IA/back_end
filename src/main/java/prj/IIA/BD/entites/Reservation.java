package prj.IIA.BD.entites;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import jakarta.persistence.Column;
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
public class Reservation implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="ID_CH")
	private champre champre;
	
	private Long IDCLIENT;
	
	private Date dateIn;
	private Date dateOut;
	//@Column(name = "prix")
	
	private Double prix;
	
	public champre getChampre() {
		return champre;
	}
	
	public void setChampre(champre champre) {
		this.champre = champre;
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIDCLIENT() {
		return IDCLIENT;
	}
	public void setIDCLIENT(Long iDCLIENT) {
		IDCLIENT = iDCLIENT;
	}
	
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}
	public Date getDateOut() {
		return dateOut;
	}
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Reservation(Long id, prj.IIA.BD.entites.champre champre, Long iDCLIENT, Date dateIn, Date dateOut,
			double prix) {
		super();
		this.id = id;
		this.champre = champre;
		IDCLIENT = iDCLIENT;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.prix = prix;
	}
	
	
}
