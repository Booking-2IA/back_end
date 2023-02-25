package prj.IIA.BD.entites;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PlasesTourist implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nomPlase;
	private String discription;
	private double localisationlatPlace;
	private double localisationlngPlace;
	private String image;
	@CreationTimestamp
    private LocalDateTime createDateTime;
 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}
	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	@ManyToOne
	@JoinColumn(name="CODE_V")
	private ville ville;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomPlase() {
		return nomPlase;
	}
	public void setNomPlase(String nomPlase) {
		this.nomPlase = nomPlase;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public double getLocalisationlatPlace() {
		return localisationlatPlace;
	}
	public void setLocalisationlatPlace(double localisationlatPlace) {
		this.localisationlatPlace = localisationlatPlace;
	}
	public double getLocalisationlngPlace() {
		return localisationlngPlace;
	}
	public void setLocalisationlngPlace(double localisationlngPlace) {
		this.localisationlngPlace = localisationlngPlace;
	}
	@JsonIgnore
	public ville getVille() {
		return ville;
	}
	@JsonSetter
	public void setVille(ville ville) {
		this.ville = ville;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public PlasesTourist(Long id, String nomPlase, String discription, double localisationlatPlace,
			double localisationlngPlace, String image, prj.IIA.BD.entites.ville ville) {
		super();
		this.id = id;
		this.nomPlase = nomPlase;
		this.discription = discription;
		this.localisationlatPlace = localisationlatPlace;
		this.localisationlngPlace = localisationlngPlace;
		this.image = image;
		this.ville = ville;
	}
	public PlasesTourist() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
