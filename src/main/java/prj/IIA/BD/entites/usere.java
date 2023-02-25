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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SQLDelete(sql = "UPDATE usere SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Entity
@Table(name="usere")
public class usere implements Serializable,UserDetails{
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    // TODO Auto-generated method stub
	    return List.of(new SimpleGrantedAuthority(role.name()));
	}


	@Override
	public boolean isAccountNonExpired() {
	    // TODO Auto-generated method stub
	    return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	    // TODO Auto-generated method stub
	    return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	    // TODO Auto-generated method stub
	    return true;
	}

	@Override
	public boolean isEnabled() {
	    // TODO Auto-generated method stub
	    return true;
	}



	



	@Override
	public String getUsername() {
	    // TODO Auto-generated method stub
	    return this.username;
	}

	
	
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String photo_user;
	@Column(unique = true)
	private String username;
	private String password;
	@Column(unique = true)
	private String CNI;
	private String Adress;
	private String nationalite;
	private String sexe;
	private String dateNaissance;
	  @Enumerated(EnumType.STRING)
	  private Role role;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Review> Reviews=new ArrayList<>();
	@OneToMany(mappedBy="presedHotel",fetch=FetchType.LAZY)
	private Collection<Hotels> hotels;
	@JsonIgnore
	public Collection<Review> getReviews() {
		return Reviews;
	}
	

	@JsonSetter
	public void setReviews(Collection<Review> reviews) {
		Reviews = reviews;
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
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPhoto_user() {
		return photo_user;
	}
	public void setPhoto_user(String photo_user) {
		this.photo_user = photo_user;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
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


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public usere() {
		super();
		// TODO Auto-generated constructor stub
	}


	public usere(Long id, String nom, String prenom, String photo_user, String username, String password, String cNI,
			String adress, String nationalite, String sexe, String dateNaissance, Role role, Collection<Review> reviews,
			Collection<Hotels> hotels) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.photo_user = photo_user;
		this.username = username;
		this.password = password;
		this.CNI = cNI;
		this.Adress = adress;
		this.nationalite = nationalite;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.role = role;
		Reviews = reviews;
		this.hotels = hotels;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Collection<Hotels> getHotels() {
		return hotels;
	}


	public void setHotels(Collection<Hotels> hotels) {
		this.hotels = hotels;
	}
	@CreationTimestamp
    private LocalDateTime createDateTime;
 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    
    private boolean deleted= Boolean.FALSE;
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
    

	
	
}
