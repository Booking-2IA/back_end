package prj.IIA.BD.DTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import prj.IIA.BD.entites.PromoTion;
import prj.IIA.BD.entites.champre;
import prj.IIA.BD.entites.ville;

public class HotelDTO {
	private Long id;
	private String nomHotel;
	private String emailchafhote;
	private int star;
	private String image;
	private String localisation;
	private int countChamperByHotel;
	private int countHotelByville;
	private double localisationlng;
	private double localisationlat;
	private String description;
    private Long presedHotel;
	private double maxprix;
	private double minprix;
	private String nomVille;
	private double rating;
	private int nombertotalPage;
	private int countUserReserve;
	private int count;
	private long idVille;
	private int MM;
	private String AVANTAGE; 
	private String LANGUE;
	private String AIRPORT;
	private String LIEU_PROCHE;
	private String SITE_WEB;
	private String TELEPHONE;
	private Collection<PromoTion> promotions=new ArrayList<>();

	private Long villes;
	public Long getId() {
		return id;
	}
	


	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getLocalisation() {
		return localisation;
	}



	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}



	public int getNombertotalPage() {
		return nombertotalPage;
	}



	public void setNombertotalPage(int nombertotalPage) {
		this.nombertotalPage = nombertotalPage;
	}



	public int getCountHotelByville() {
		return countHotelByville;
	}



	public void setCountHotelByville(int countHotelByville) {
		this.countHotelByville = countHotelByville;
	}



	public double getMaxprix() {
		return maxprix;
	}

	public void setMaxprix(double maxprix) {
		this.maxprix = maxprix;
	}

	public double getMinprix() {
		return minprix;
	}

	public void setMinprix(double minprix) {
		this.minprix = minprix;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getCountUserReserve() {
		return countUserReserve;
	}

	public void setCountUserReserve(int countUserReserve) {
		this.countUserReserve = countUserReserve;
	}

	public Collection<PromoTion> getPromotions() {
		return promotions;
	}

	public void setPromotions(Collection<PromoTion> promotions) {
		this.promotions = promotions;
	}

	
	public int getCountChamperByHotel() {
		return countChamperByHotel;
	}



	public void setCountChamperByHotel(int countChamperByHotel) {
		this.countChamperByHotel = countChamperByHotel;
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
	public Long getPresedHotel() {
		return presedHotel;
	}
	public void setPresedHotel(Long presedHotel) {
		this.presedHotel = presedHotel;
	}
	
	public Long getVilles() {
		return villes;
	}
	public void setVilles(Long villes) {
		this.villes = villes;
	}
	public HotelDTO() {
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



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public int getMM() {
		return MM;
	}



	public void setMM(int mM) {
		MM = mM;
	}



	public String getEmailchafhote() {
		return emailchafhote;
	}



	public void setEmailchafhote(String emailchafhote) {
		this.emailchafhote = emailchafhote;
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



	public long getIdVille() {
		return idVille;
	}



	public void setIdVille(long idVille) {
		this.idVille = idVille;
	}
	
	
}
