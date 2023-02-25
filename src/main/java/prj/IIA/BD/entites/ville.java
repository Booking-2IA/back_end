package prj.IIA.BD.entites;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SQLDelete(sql = "UPDATE champre SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
public class ville  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nomVille;

	
	private String description;
	private String imageville;
	@Column(name="lat")
	private double lat;
	@Column(name="lng")
	private double lng;
	
	

	
	@OneToMany(mappedBy="villes",fetch=FetchType.LAZY)
	private Collection<Hotels> Hotels;
	
	@OneToMany(mappedBy="ville",fetch=FetchType.LAZY)
	private Collection<PlasesTourist> placesTourist;
	
	
	@CreationTimestamp
    private LocalDateTime createDateTime;
 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    
    private boolean deleted = Boolean.FALSE;
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

	public ville() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Collection<Hotels> getHotels() {
		return Hotels;
	}
	
	public void setHotels(Collection<Hotels> hotels) {
		Hotels = hotels;
	}
	public String getImageville() {
		return imageville;
	}
	public void setImageville(String imageville) {
		this.imageville = imageville;
	}
	
	
	

	/*public ville(Long id, String nomVille, String description, String imageville, double localisationlat,
			double localisationlng, Collection<prj.IIA.BD.entites.Hotels> hotels, Country country) {
		super();
		this.id = id;
		this.nomVille = nomVille;
		this.description = description;
		this.imageville = imageville;
		this.localisationlatVille = localisationlat;
		this.localisationlngVille = localisationlng;
		Hotels = hotels;
		this.country = country;
	}

	public double getLocalisationlat() {
		return localisationlatVille;
	}

	public void setLocalisationlat(double localisationlat) {
		this.localisationlatVille = localisationlat;
	}

	public double getLocalisationlng() {
		return localisationlngVille;
	}

	public void setLocalisationlng(double localisationlng) {
		this.localisationlngVille = localisationlng;
	}
*/
	@JsonIgnore
	public Collection<PlasesTourist> getPlacesTourist() {
		return placesTourist;
	}

	@JsonSetter
	public void setPlacesTourist(Collection<PlasesTourist> placesTourist) {
		this.placesTourist = placesTourist;
	}

	public ville(Long id, String nomVille, String description, String imageville,
			Collection<prj.IIA.BD.entites.Hotels> hotels, Collection<PlasesTourist> placesTourist,
			LocalDateTime createDateTime, LocalDateTime updateDateTime) {
		super();
		this.id = id;
		this.nomVille = nomVille;
		this.description = description;
		this.imageville = imageville;
		Hotels = hotels;
		this.placesTourist = placesTourist;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public ville(Long id, String nomVille, String description, String imageville, double lat, double lng,
			Collection<prj.IIA.BD.entites.Hotels> hotels, Collection<PlasesTourist> placesTourist,
			LocalDateTime createDateTime, LocalDateTime updateDateTime, boolean deleted) {
		super();
		this.id = id;
		this.nomVille = nomVille;
		this.description = description;
		this.imageville = imageville;
		this.lat = lat;
		this.lng = lng;
		Hotels = hotels;
		this.placesTourist = placesTourist;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.deleted = deleted;
	}



	

	
	
	
}
