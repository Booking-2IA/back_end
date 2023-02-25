package prj.IIA.BD.DTO;

import java.util.Date;

public class ReservationDTO {

	private int MM;
	private int counts;
	private double sumprix= 0;
	
	public ReservationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReservationDTO(int mM, int counts) {
		super();
		MM = mM;
		this.counts = counts;
	}
	public int getMM() {
		return MM;
	}
	public void setMM(int mM) {
		MM = mM;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public double getSumprix() {
		return sumprix;
	}
	public void setSumprix(double sumprix) {
		this.sumprix = sumprix;
	}
	public ReservationDTO(int mM, int counts, double sumprix) {
		super();
		MM = mM;
		this.counts = counts;
		this.sumprix = sumprix;
	}
	
}
