package prj.IIA.BD.DTO;

public class VilleDTO {

	
	private String nomVille;
	private int counts ;
	private int MM;
	private long countHotel;
	public VilleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VilleDTO( String nomVille,  long countHotel) {
		super();
		
		this.nomVille = nomVille;
		
		this.countHotel = countHotel;
	}
	
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	
	public long getCountHotel() {
		return countHotel;
	}
	public void setCountHotel(long countHotel) {
		this.countHotel = countHotel;
	}
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
	
	
	
}
