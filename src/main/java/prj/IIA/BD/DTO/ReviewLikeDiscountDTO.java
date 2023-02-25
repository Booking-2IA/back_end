package prj.IIA.BD.DTO;

public class ReviewLikeDiscountDTO {

	private int countLike;
	private int countdislike;
	public ReviewLikeDiscountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewLikeDiscountDTO(int countLike, int countdislike) {
		super();
		this.countLike = countLike;
		this.countdislike = countdislike;
	}
	public int getCountLike() {
		return countLike;
	}
	public void setCountLike(int countLike) {
		this.countLike = countLike;
	}
	public int getCountdislike() {
		return countdislike;
	}
	public void setCountdislike(int countdislike) {
		this.countdislike = countdislike;
	}
	
}
