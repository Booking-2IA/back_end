package prj.IIA.BD.DTO;

public class PlacesTouristsDTO {

	private int counts;
	private int MM;
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public int getMM() {
		return MM;
	}
	public void setMM(int mM) {
		MM = mM;
	}
	public PlacesTouristsDTO(int counts, int mM) {
		super();
		this.counts = counts;
		MM = mM;
	}
	public PlacesTouristsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
