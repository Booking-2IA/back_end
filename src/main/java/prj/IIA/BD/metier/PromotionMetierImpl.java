package prj.IIA.BD.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prj.IIA.BD.dao.PromotionRepository;
import prj.IIA.BD.entites.PromoTion;
@Service
@Transactional
public class PromotionMetierImpl implements PromotionMetier{
	@Autowired
	private PromotionRepository promotionRepository;
	
	@Override
	public PromoTion save(PromoTion p) {
		// TODO Auto-generated method stub
		return promotionRepository.save(p);
	}

	@Override
	public List<PromoTion> ListPromotion() {
		// TODO Auto-generated method stub
		return promotionRepository.findAll();
	}

	@Override
	public List<PromoTion> ListByHotel(long id) {
		// TODO Auto-generated method stub
		return promotionRepository.ListAllpromotionByHotel(id);
	}

	@Override
	public List<PromoTion> Topdeuxpromotion() {
		// TODO Auto-generated method stub
		return promotionRepository.Topdeuxpromotion();
	}

	@Override
	public PromoTion promotionHotel(long id) {
		// TODO Auto-generated method stub
		return promotionRepository.promoActiveHotel(id);
	}

}
