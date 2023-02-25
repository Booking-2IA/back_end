package prj.IIA.BD.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import prj.IIA.BD.DTO.ReservationDTO;
import prj.IIA.BD.entites.Reservation;

public interface ReservationMetier {

	public Reservation saveReservation(Reservation R);
	public List<Reservation> ListReservation(Long id);
	public Optional<Reservation> findByIDCLIENT(Long IDCLIENT);
	public int Statistique(int mc);
	public int StatistiqueChafHotel(int mc,long id);
	public double StatistiqueSumprix(int mc);
	public Reservation getReservationById(long id);
	public List<Reservation> ListAllReservartion();
}
