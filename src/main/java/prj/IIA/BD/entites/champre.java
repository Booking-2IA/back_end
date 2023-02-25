package prj.IIA.BD.entites;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SQLDelete(sql = "UPDATE champre SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
public class champre implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int numchampre;
	private String photo;
	private String type;
	private double prix;
	private boolean libre=true;
	private Date dateFinReservation;
	@CreationTimestamp
    private LocalDateTime createDateTime;
 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    private boolean deleted = Boolean.FALSE;
	@ManyToOne
	@JoinColumn(name="CODE_HOT")
	private Hotels hotel;
	@OneToMany(mappedBy="champre",fetch=FetchType.LAZY)
	private Collection<Reservation> Reservations=new ArrayList<>();
	public champre() {
		super();
		// TODO Auto-generated constructor stub
	}
	@JsonIgnore
	public Collection<Reservation> getReservations() {
		return Reservations;
	}
	@JsonSetter
	public void setReservations(Collection<Reservation> reservations) {
		Reservations = reservations;
	}
	public champre(Long id, int numchampre, String type, double prix, boolean libre, Date dateFinReservation,
			Hotels hotel, Collection<Reservation> reservations) {
		super();
		this.id = id;
		this.numchampre = numchampre;
		this.type = type;
		this.prix = prix;
		this.libre = libre;
		this.dateFinReservation = dateFinReservation;
		this.hotel = hotel;
		Reservations = reservations;
	}
	public Date getDateFinReservation() {
		return dateFinReservation;
	}
	public void setDateFinReservation(Date dateFinReservation) {
		this.dateFinReservation = dateFinReservation;
	}
	public champre(Long id, int numchampre,  String type, double prix, boolean libre,
			Date dateFinReservation, Hotels hotel) {
		super();
		this.id = id;
		this.numchampre = numchampre;
		
		this.type = type;
		this.prix = prix;
		this.libre = libre;
		this.dateFinReservation = dateFinReservation;
		this.hotel = hotel;
	}
	public champre(Long id, int numchampre, String type, double prix, boolean libre, Hotels hotel) {
		super();
		this.id = id;
		this.numchampre = numchampre;
		
		this.type = type;
		this.prix = prix;
		this.libre = libre;
		this.hotel = hotel;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumchampre() {
		return numchampre;
	}
	public void setNumchampre(int numchampre) {
		this.numchampre = numchampre;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public boolean isLibre() {
		return libre;
	}
	public void setLibre(boolean libre) {
		this.libre = libre;
	}
	public Hotels getHotel() {
		return hotel;
	}
	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
	}
	public champre(Long id, int numchampre, String photo, String type, double prix, boolean libre,
			Date dateFinReservation, Hotels hotel, Collection<Reservation> reservations) {
		super();
		this.id = id;
		this.numchampre = numchampre;
		this.photo = photo;
		this.type = type;
		this.prix = prix;
		this.libre = libre;
		this.dateFinReservation = dateFinReservation;
		this.hotel = hotel;
		Reservations = reservations;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
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
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public champre(Long id, int numchampre, String photo, String type, double prix, boolean libre,
			Date dateFinReservation, LocalDateTime createDateTime, LocalDateTime updateDateTime, boolean deleted,
			Hotels hotel, Collection<Reservation> reservations) {
		super();
		this.id = id;
		this.numchampre = numchampre;
		this.photo = photo;
		this.type = type;
		this.prix = prix;
		this.libre = libre;
		this.dateFinReservation = dateFinReservation;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.deleted = deleted;
		this.hotel = hotel;
		Reservations = reservations;
	}
	
	
}
