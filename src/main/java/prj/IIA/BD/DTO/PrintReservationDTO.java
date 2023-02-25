package prj.IIA.BD.DTO;

import java.util.Date;

public class PrintReservationDTO {

	private int NumberChamper;
	private String typeChamper;
	private String DescriptionHotel;
	private String LocalisationHotel;
	private String NomHotel;
	private String Sit_WebHotel;
	private int StarHoetl;
	private String TelephonHotel;
	private String NomVille;
	private Date DateOut;
	private Date DateIn;
	private double prix;
	private String nomUser;
	private String prenomUser;
	private String photo_User;
	private String CNI_User;
	private String Adress_user;
	private String NationaliteUser;
	private String sexUser;
    private String DateNaissance;
	public PrintReservationDTO(int numberChamper, String typeChamper, String descriptionHotel, String localisationHotel,
			String nomHotel, String sit_WebHotel, int starHoetl, String telephonHotel, String nomVille, Date dateOut,
			Date dateIn, double prix, String nomUser, String prenomUser, String photo_User, String cNI_User,
			String adress_user, String nationaliteUser, String sexUser, String dateNaissance) {
		super();
		NumberChamper = numberChamper;
		this.typeChamper = typeChamper;
		DescriptionHotel = descriptionHotel;
		LocalisationHotel = localisationHotel;
		NomHotel = nomHotel;
		Sit_WebHotel = sit_WebHotel;
		StarHoetl = starHoetl;
		TelephonHotel = telephonHotel;
		NomVille = nomVille;
		DateOut = dateOut;
		DateIn = dateIn;
		this.prix = prix;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.photo_User = photo_User;
		CNI_User = cNI_User;
		Adress_user = adress_user;
		NationaliteUser = nationaliteUser;
		this.sexUser = sexUser;
		DateNaissance = dateNaissance;
	}
	public PrintReservationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNumberChamper() {
		return NumberChamper;
	}
	public void setNumberChamper(int numberChamper) {
		NumberChamper = numberChamper;
	}
	public String getTypeChamper() {
		return typeChamper;
	}
	public void setTypeChamper(String typeChamper) {
		this.typeChamper = typeChamper;
	}
	public String getDescriptionHotel() {
		return DescriptionHotel;
	}
	public void setDescriptionHotel(String descriptionHotel) {
		DescriptionHotel = descriptionHotel;
	}
	public String getLocalisationHotel() {
		return LocalisationHotel;
	}
	public void setLocalisationHotel(String localisationHotel) {
		LocalisationHotel = localisationHotel;
	}
	public String getNomHotel() {
		return NomHotel;
	}
	public void setNomHotel(String nomHotel) {
		NomHotel = nomHotel;
	}
	public String getSit_WebHotel() {
		return Sit_WebHotel;
	}
	public void setSit_WebHotel(String sit_WebHotel) {
		Sit_WebHotel = sit_WebHotel;
	}
	public int getStarHoetl() {
		return StarHoetl;
	}
	public void setStarHoetl(int starHoetl) {
		StarHoetl = starHoetl;
	}
	public String getTelephonHotel() {
		return TelephonHotel;
	}
	public void setTelephonHotel(String telephonHotel) {
		TelephonHotel = telephonHotel;
	}
	public String getNomVille() {
		return NomVille;
	}
	public void setNomVille(String nomVille) {
		NomVille = nomVille;
	}
	public Date getDateOut() {
		return DateOut;
	}
	public void setDateOut(Date dateOut) {
		DateOut = dateOut;
	}
	public Date getDateIn() {
		return DateIn;
	}
	public void setDateIn(Date dateIn) {
		DateIn = dateIn;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getPrenomUser() {
		return prenomUser;
	}
	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}
	public String getPhoto_User() {
		return photo_User;
	}
	public void setPhoto_User(String photo_User) {
		this.photo_User = photo_User;
	}
	public String getCNI_User() {
		return CNI_User;
	}
	public void setCNI_User(String cNI_User) {
		CNI_User = cNI_User;
	}
	public String getAdress_user() {
		return Adress_user;
	}
	public void setAdress_user(String adress_user) {
		Adress_user = adress_user;
	}
	public String getNationaliteUser() {
		return NationaliteUser;
	}
	public void setNationaliteUser(String nationaliteUser) {
		NationaliteUser = nationaliteUser;
	}
	public String getSexUser() {
		return sexUser;
	}
	public void setSexUser(String sexUser) {
		this.sexUser = sexUser;
	}
	public String getDateNaissance() {
		return DateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		DateNaissance = dateNaissance;
	}
    
    
}
