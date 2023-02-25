package prj.IIA.BD.DTO;

public class ListAllHotelDTO {
	private Long id;
	private String nomHotel;
	private String image;
	private String description;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ListAllHotelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListAllHotelDTO(Long id, String nomHotel, String image, String description) {
		super();
		this.id = id;
		this.nomHotel = nomHotel;
		this.image = image;
		this.description = description;
	}
	
}
