package prj.IIA.BD.dao;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import prj.IIA.BD.entites.ListImageHotel;

public interface ImageReposetory extends JpaRepository<ListImageHotel, Long>{

	@Query("select I from ListImageHotel I where I.hotel.id = :x")
	public Page<ListImageHotel> ListImageByHotel(@Param("x") Long mc,Pageable pageable); 
	
	@Query("select count(*) from ListImageHotel I where I.hotel.id = :x")
	public int nomberImageByhotel(@Param("x") Long id); 
	
	@Query("select I from ListImageHotel I where I.hotel.id = :x")
	public List<ListImageHotel> ListALLImageByHotel(@Param("x") Long mc); 
	
	@Query("select count(*) from ListImageHotel I where I.hotel.id = :x")
	public int NomberImageByHotel(@Param("x") Long mc); 
	
}
