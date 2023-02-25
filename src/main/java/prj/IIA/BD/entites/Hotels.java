package prj.IIA.BD.entites;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@SQLDelete(sql = "UPDATE Hotels SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity  
public class Hotels implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private String nomHotel;
	private String image;
	private int star;
	private String localisation;
	private double localisationlng;
	private double localisationlat;
	private String description;
	private String AVANTAGE; 
	private String LANGUE;
	private String AIRPORT;
	private String LIEU_PROCHE;
	private String SITE_WEB;
	private String TELEPHONE;
	@ManyToOne
	@JoinColumn(name="CODE_PH")
	private usere presedHotel;
	@CreationTimestamp
    private LocalDateTime createDateTime;
 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    
	
	@OneToMany(mappedBy="hotel",fetch=FetchType.LAZY)
	private Collection<Review> Review=new ArrayList<>();
	
	@OneToMany(mappedBy="hotel",fetch=FetchType.LAZY)
	private Collection<ListImageHotel> imageHotel=new ArrayList<>();

	@OneToMany(mappedBy="hotel",fetch=FetchType.LAZY)
	private Collection<PromoTion> promotions=new ArrayList<>();
	@ManyToOne
	@JoinColumn(name="CODE_VILLE")
	private ville villes;
	
	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;
	
	@OneToMany(mappedBy="hotel",fetch=FetchType.LAZY)
	private Collection<champre> champres=new ArrayList<>();
	
	public String getImage() {
		return image;
	}
	@JsonIgnore
	public Collection<Review> getReview() {
		return Review;
	}
	@JsonSetter
	public void setReview(Collection<Review> review) {
		Review = review;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Hotels() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getLocalisationlng() {
		return localisationlng;
	}
	public void setLocalisationlng(double localisationlng) {
		this.localisationlng = localisationlng;
	}
	public double getLocalisationlat() {
		return localisationlat;
	}
	public void setLocalisationlat(double localisationlat) {
		this.localisationlat = localisationlat;
	}
	
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomHotel() {
		return nomHotel;
	}
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonIgnore
	public usere getPresedHotel() {
		return presedHotel;
	}
	@JsonSetter
	public void setPresedHotel(usere presedHotel) {
		this.presedHotel = presedHotel;
	}
	
	
	@JsonIgnore
	public Collection<PromoTion> getPromotions() {
		return promotions;
	}
	@JsonSetter
	public void setPromotions(Collection<PromoTion> promotions) {
		this.promotions = promotions;
	}
	@JsonIgnore
	public ville getVilles() {
		return villes;
	}
	@JsonSetter
	public void setVilles(ville villes) {
		this.villes = villes;
	}
	@JsonIgnore
	public Collection<champre> getChampres() {
		return champres;
	}
	@JsonSetter
	public void setChampres(Collection<champre> champres) {
		this.champres = champres;
	}
	@JsonIgnore
	public Collection<ListImageHotel> getImageHotel() {
		return imageHotel;
	}
	@JsonSetter
	public void setImageHotel(Collection<ListImageHotel> imageHotel) {
		this.imageHotel = imageHotel;
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
	public String getAVANTAGE() {
		return AVANTAGE;
	}
	public void setAVANTAGE(String aVANTAGE) {
		AVANTAGE = aVANTAGE;
	}
	public String getLANGUE() {
		return LANGUE;
	}
	public void setLANGUE(String lANGUE) {
		LANGUE = lANGUE;
	}
	public String getAIRPORT() {
		return AIRPORT;
	}
	public void setAIRPORT(String aIRPORT) {
		AIRPORT = aIRPORT;
	}
	public String getLIEU_PROCHE() {
		return LIEU_PROCHE;
	}
	public void setLIEU_PROCHE(String lIEU_PROCHE) {
		LIEU_PROCHE = lIEU_PROCHE;
	}
	public String getSITE_WEB() {
		return SITE_WEB;
	}
	public void setSITE_WEB(String sITE_WEB) {
		SITE_WEB = sITE_WEB;
	}
	public String getTELEPHONE() {
		return TELEPHONE;
	}
	public void setTELEPHONE(String tELEPHONE) {
		TELEPHONE = tELEPHONE;
	}
	public Hotels(Long id, String nomHotel, String image, int star, String localisation, double localisationlng,
			double localisationlat, String description, String aVANTAGE, String lANGUE, String aIRPORT,
			String lIEU_PROCHE, String sITE_WEB, String tELEPHONE, usere presedHotel, LocalDateTime createDateTime,
			LocalDateTime updateDateTime, Collection<prj.IIA.BD.entites.Review> review,
			Collection<ListImageHotel> imageHotel, Collection<PromoTion> promotions, ville villes,
			Collection<champre> champres) {
		super();
		this.id = id;
		this.nomHotel = nomHotel;
		this.image = image;
		this.star = star;
		this.localisation = localisation;
		this.localisationlng = localisationlng;
		this.localisationlat = localisationlat;
		this.description = description;
		AVANTAGE = aVANTAGE;
		LANGUE = lANGUE;
		AIRPORT = aIRPORT;
		LIEU_PROCHE = lIEU_PROCHE;
		SITE_WEB = sITE_WEB;
		TELEPHONE = tELEPHONE;
		this.presedHotel = presedHotel;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		Review = review;
		this.imageHotel = imageHotel;
		this.promotions = promotions;
		this.villes = villes;
		this.champres = champres;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Hotels(Long id, String nomHotel, String image, int star, String localisation, double localisationlng,
			double localisationlat, String description, String aVANTAGE, String lANGUE, String aIRPORT,
			String lIEU_PROCHE, String sITE_WEB, String tELEPHONE, usere presedHotel, LocalDateTime createDateTime,
			LocalDateTime updateDateTime, Collection<prj.IIA.BD.entites.Review> review,
			Collection<ListImageHotel> imageHotel, Collection<PromoTion> promotions, ville villes, boolean deleted,
			Collection<champre> champres) {
		super();
		this.id = id;
		this.nomHotel = nomHotel;
		this.image = image;
		this.star = star;
		this.localisation = localisation;
		this.localisationlng = localisationlng;
		this.localisationlat = localisationlat;
		this.description = description;
		AVANTAGE = aVANTAGE;
		LANGUE = lANGUE;
		AIRPORT = aIRPORT;
		LIEU_PROCHE = lIEU_PROCHE;
		SITE_WEB = sITE_WEB;
		TELEPHONE = tELEPHONE;
		this.presedHotel = presedHotel;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		Review = review;
		this.imageHotel = imageHotel;
		this.promotions = promotions;
		this.villes = villes;
		this.deleted = deleted;
		this.champres = champres;
	}
	
	
}
