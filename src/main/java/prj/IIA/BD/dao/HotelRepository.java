package prj.IIA.BD.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import prj.IIA.BD.entites.Hotels;

public interface HotelRepository extends JpaRepository<Hotels, Long>{
	@Query("select h from Hotels h  where h.nomHotel like :x")
	public Page<Hotels> ListHotels(@Param("x") String mc,Pageable pageable);
	
	@Query("select h from Hotels h  where h.id = :x")
	public Hotels  findHotelById(@Param("x")Long id);
	
	@Query("select count(*) from Hotels h  where h.presedHotel.id = :x")
	public int  countHotelChafHotel(@Param("x")Long id);
	
	@Query("select v.villes.nomVille  from Hotels v where v.id = :x")
	public String  HotelByVille(@Param("x") long id);
	
	@Query("select v.villes.id  from Hotels v where v.id = :x")
	public long  HotelByIdVille(@Param("x") long id);
	
	
	@Query("select v  from Hotels v where v.villes.id = :x and upper(v.AVANTAGE) like upper(:AV) and upper(v.LANGUE) like upper(:LANGUE) and v.star>= :Star    order by v.star")
	public Page<Hotels>  ListHotelByIdVille(@Param("x") long id,@Param("AV")String AVANTAGE,@Param("LANGUE")String LANGUE,@Param("Star")int Star,Pageable pageable);

	@Query("select v  from Hotels v where v.villes.id = :x")
	public List<Hotels>  ListALLHotelByIdVille(@Param("x") long id);

	@Query("select v  from Hotels v where upper(v.nomHotel) like upper(:mc)")
	public List<Hotels>  ListALLHotelHome(@Param("mc")String mc);

	
	@Query("select h from Hotels h where h.star = :x")
	List<Hotels> findByStar(@Param("x") int star);
	
	@Query("select  count(*) from Hotels c where  CAST(to_char(c.createDateTime, 'MM') AS int) = :x")
	public int Statistique(@Param("x") int mc);

}
