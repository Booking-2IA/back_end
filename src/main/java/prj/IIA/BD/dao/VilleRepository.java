package prj.IIA.BD.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.persistence.Id;
import prj.IIA.BD.DTO.VilleDTO;
import prj.IIA.BD.entites.Hotels;
import prj.IIA.BD.entites.ville;

public interface VilleRepository extends JpaRepository<ville, Long>{

	@Query("select c from ville c where c.nomVille like :x")
	public Page<ville> ListVille(@Param("x") String mc,Pageable pageable);

	@Query("select v from ville v where v.id = :x")
	public ville  findvilleById(@Param("x")Long id);
	
	@Query("select v.id,count(h) as countHotel from ville v  LEFT OUTER JOIN Hotels h GROUP BY v.id")
	public Page<VilleDTO>  countHotelInVille(Pageable pageable);

	
	@Query("select v.nomVille from ville v ")
	public List<VilleDTO>  countHotelInVille();

	@Query("select c from ville c where upper(c.nomVille) like upper(:x)")
	public List<ville> Lists(@Param("x") String mc);

	
	//@Query("select v,count(*) as countHotel from ville v group by v.id")
	
	@Query("select  count(*) from ville where  CAST(to_char(createDateTime, 'MM') AS int) = :x")
	public int Statistique(@Param("x") int mc);

}
