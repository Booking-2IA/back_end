package prj.IIA.BD.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import prj.IIA.BD.entites.PromoTion;

public interface PromotionRepository extends JpaRepository<PromoTion, Long>{
	
	
	@Query("select c from PromoTion c where c.hotel.id = :x and c.hotel.deleted=false")
	List<PromoTion> ListAllpromotionByHotel(@Param("x")long id);
	
	@Query("select c from PromoTion c where c.active=true   and c.hotel.id = :x and c.hotel.deleted=false order by tauxPro LIMIT 1")
	public PromoTion promoActiveHotel(@Param("x")long id);

	
	
	@Query("select c from PromoTion c where c.active=true   and SUBSTRING(c.Type, 1, 3)= 'pub' and c.hotel.deleted=false order by tauxPro LIMIT 3")
	List<PromoTion> Topdeuxpromotion();
}
