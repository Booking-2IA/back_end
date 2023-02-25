package prj.IIA.BD.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import prj.IIA.BD.entites.Hotels;
import prj.IIA.BD.entites.Role;
import prj.IIA.BD.entites.champre;

public interface ChampreRepository extends JpaRepository<champre, Long>{

	//champre findByNumchampre(int numchampre);
	
	@Query("select c from champre c where c.numchampre like :x")
	public Page<champre> findByNumchampre(@Param("x") int mc,Pageable pageable); 
	
	@Query("select count(*) from champre c where c.hotel.presedHotel.id = :x")
	public int countChamperChafHotel(@Param("x") long id); 
	
	@Query("select count(*) from champre h where h.hotel.id = :x and h.libre=true")
	public int  countChampreByIDHotel(@Param("x")Long id);
	
	@Query("select h from champre h where h.hotel.id = :x and h.libre=true and h.type= :type")
	public List<champre>  ListChamperByHotelAndType(@Param("x")Long id,@Param("type") String type);
	
	@Query("select h from champre h where h.hotel.id = :x and h.libre=true")
	public List<champre>  libreChampre(@Param("x")Long id);
	
	@Query("select min(prix) from champre h where h.hotel.id = :x")
	public double  MinPrixByHotel(@Param("x")Long id);
	
	@Query("select max(prix) from champre h where h.hotel.id = :x")
	public double  MaxPrixByHotel(@Param("x")Long id);
	
	@Query("select c from champre c   where c.hotel.id = :x")
	public Page<champre> findAllchampreByHotel(@Param("x") Long mc,Pageable pageable);
	
	Optional< champre>  findChampreById(Long id);
	
}
