package prj.IIA.BD.DTO;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import prj.IIA.BD.entites.Role;

public class UsereDTO {
	private Long id;
	private String nom;
	private String prenom;
	private String photo_user;
	private String username;
	private String password;
	private String CNI;
	private String Adress;
	private String nationalite;
	private String sexe;
	private String dateNaissance;
	private int couts;
	private int MM;
	private String role;
	private String token;
	

	public UsereDTO(Long id, String nom, String prenom, String photo_user, String username, String password, String cNI,
			String adress, String nationalite, String sexe, String dateNaissance, String role, String token) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.photo_user = photo_user;
		this.username = username;
		this.password = password;
		CNI = cNI;
		Adress = adress;
		this.nationalite = nationalite;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.role = role;
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	

	

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getCouts() {
		return couts;
	}

	public void setCouts(int couts) {
		this.couts = couts;
	}

	public int getMM() {
		return MM;
	}

	public void setMM(int mM) {
		MM = mM;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	

	public String getPhoto_user() {
		return photo_user;
	}

	public void setPhoto_user(String photo_user) {
		this.photo_user = photo_user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCNI() {
		return CNI;
	}

	public void setCNI(String cNI) {
		CNI = cNI;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public UsereDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsereDTO(Long id, String nom, String prenom, String photo_user, String username, String password, String cNI,
			String adress, String nationalite, String sexe, String dateNaissance, String token) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.photo_user = photo_user;
		this.username = username;
		this.password = password;
		CNI = cNI;
		Adress = adress;
		this.nationalite = nationalite;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.token = token;
	}

	

	

	

	
}
