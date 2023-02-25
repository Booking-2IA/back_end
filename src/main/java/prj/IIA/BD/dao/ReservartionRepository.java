package prj.IIA.BD.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import prj.IIA.BD.DTO.ReservationDTO;
import prj.IIA.BD.entites.Reservation;

public interface ReservartionRepository extends JpaRepository<Reservation, Long>{
	
	@Query("select c from Reservation c where c.IDCLIENT = :x")
	public List<Reservation> ListReservationByClient(@Param("x") Long mc);

	@Query("select count(*) from Reservation c where c.champre.hotel.presedHotel.id = :x")
	public int countReserChaf(@Param("x") Long mc);

	
	@Query("select  count(*) from Reservation where  CAST(to_char(dateIn, 'MM') AS int) = :x")
	public int Statistique(@Param("x") int mc);

	@Query("select  count(*) from Reservation c where  CAST(to_char(c.dateIn, 'MM') AS int) = :x and c.champre.hotel.presedHotel.id = :id")
	public int Statistique(@Param("x") int mc,@Param("id") long id);

	@Query("select  CAST(SUM(R.prix) as double) from Reservation R where  CAST(to_char(R.dateIn, 'MM') AS int) = :x")
	public double StatistiqueSumprix(@Param("x") int mc);

	
	Optional<Reservation> findByIDCLIENT(Long IDCLIENT);
	
}
