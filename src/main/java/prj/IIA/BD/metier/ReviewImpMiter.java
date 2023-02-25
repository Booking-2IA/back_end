package prj.IIA.BD.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prj.IIA.BD.dao.ReviewRepository;
import prj.IIA.BD.entites.Review;
@Service
@Transactional
public class ReviewImpMiter implements ReviewMitier{

	@Autowired
	private ReviewRepository rerepository;

	@Override
	public Review save(Review r) {
		// TODO Auto-generated method stub
		return rerepository.save(r);
	}

	@Override
	public int countLike(long id) {
		// TODO Auto-generated method stub
		return rerepository.countLike(id);
	}

	@Override
	public int countDisLink(long id) {
		// TODO Auto-generated method stub
		return rerepository.countDisLike(id);
	}

	@Override
	public Page<Review> ListReviw(long id,Pageable pageable) {
		// TODO Auto-generated method stub
		return rerepository.ListReviw(id, pageable);
	}

	@Override
	public Review findByidClientandidHotel(long idc, long idh) {
		// TODO Auto-generated method stub
		return rerepository.findbyidclientandhotel(idc, idh);
	}
}
