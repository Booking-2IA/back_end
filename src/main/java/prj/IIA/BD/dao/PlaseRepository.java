package prj.IIA.BD.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import prj.IIA.BD.entites.PlasesTourist;
import prj.IIA.BD.entites.champre;


public interface PlaseRepository extends JpaRepository<PlasesTourist, Long>{

	@Query("select c from PlasesTourist c where c.ville.nomVille like :x")
	public Page<PlasesTourist> ListPlaseByVille(@Param("x") String nomville,Pageable pageable); 

	@Query("select c from PlasesTourist c where c.ville.id like :x")
	public Page<PlasesTourist> ListPlaseByIDVille(@Param("x") long id,Pageable pageable); 

	
	@Query("select c from PlasesTourist c where c.nomPlase like :x")
	public Page<PlasesTourist> ListPlase(@Param("x") String mc,Pageable pageable); 

	@Query("select  count(*) from PlasesTourist where  CAST(to_char(createDateTime, 'MM') AS int) = :x")
	public int Statistique(@Param("x") int mc);

	Optional<PlasesTourist>  findById(Long id);
	
	@Query("select c from PlasesTourist c where c.ville.id like :x")
	public List<PlasesTourist> ListALLPlaseByVille(@Param("x") long id); 

}
