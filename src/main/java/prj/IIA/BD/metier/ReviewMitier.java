package prj.IIA.BD.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import prj.IIA.BD.dao.ReviewRepository;
import prj.IIA.BD.entites.Review;

public interface ReviewMitier {

	public Review save(Review r);
	public int countLike(long id);
	public int countDisLink(long id);
	public Page<Review> ListReviw(long id,Pageable pageable);
	public Review findByidClientandidHotel(long idc,long idh);
	
}
