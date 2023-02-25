package prj.IIA.BD.DTO;

public class ImageHotelDTO {

	private long id;
	private String image;
	private int totalImage;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getTotalImage() {
		return totalImage;
	}
	public void setTotalImage(int totalImage) {
		this.totalImage = totalImage;
	}
	public ImageHotelDTO(long id, String image, int totalImage) {
		super();
		this.id = id;
		this.image = image;
		this.totalImage = totalImage;
	}
	public ImageHotelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
