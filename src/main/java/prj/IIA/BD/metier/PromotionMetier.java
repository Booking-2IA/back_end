package prj.IIA.BD.metier;

import java.util.List;

import prj.IIA.BD.entites.PromoTion;

public interface PromotionMetier {

	public PromoTion save(PromoTion p);
	public List<PromoTion> ListPromotion();
	public List<PromoTion> ListByHotel(long id);
	public List<PromoTion> Topdeuxpromotion();
	public PromoTion promotionHotel(long id);
}
