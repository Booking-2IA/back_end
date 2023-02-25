package prj.IIA.BD.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import prj.IIA.BD.entites.usere;

public interface UsereRepository extends JpaRepository<usere, Long>{

	@Query("select c from usere c where c.nom like :x and c.role like :y")
	public Page<usere> ListUser(@Param("x") String mc,@Param("y") prj.IIA.BD.entites.Role Role,Pageable pageable);

	@Query("select c from usere c ")
	public Page<usere> List(Pageable pageable);

	Optional<usere> findByUsername( String username);
	
	@Query("select c from usere c where c.id like :x ")
	usere findByIDUSER(@Param("x") long id);
	
	@Query("select  count(*) from usere where  CAST(to_char(createDateTime, 'MM') AS int) = :x")
	public int Statistique(@Param("x") int mc);

	@Query("select  count(*) from usere c where c.role like 'Client' ")
	public int NomberTotalClient();
  
	@Query("select  count(*) from usere c where c.role like 'CHafHotel' ")
	public int NomberTotalCHafHotel();

	@Query("select  count(*) from usere c  where c.role like 'Admin' ")
	public int NomberTotalAdmin();



	
}
