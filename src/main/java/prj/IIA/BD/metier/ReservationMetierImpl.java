package prj.IIA.BD.metier;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import prj.IIA.BD.DTO.ReservationDTO;
import prj.IIA.BD.dao.ChampreRepository;
import prj.IIA.BD.dao.ReservartionRepository;
import prj.IIA.BD.entites.Reservation;
import prj.IIA.BD.entites.champre;
@Service
@Transactional
public class ReservationMetierImpl implements ReservationMetier{
	@Autowired
	private ReservartionRepository reservationrepository;
	@Autowired
	private ChampreRepository champreRepository;
	@Override
	public Reservation saveReservation(@ModelAttribute Reservation R) {
		// TODO Auto-generated method stub
		
		
		return reservationrepository.save(R);
	}

	@Override
	public List<Reservation> ListReservation(Long id) {
		// TODO Auto-generated method stub
		return reservationrepository.ListReservationByClient(id);
	}

	@Override
	public Optional<Reservation> findByIDCLIENT(Long IDCLIENT) {
		// TODO Auto-generated method stub
		return reservationrepository.findByIDCLIENT(IDCLIENT);
	}

	@Override
	public int  Statistique(int mc) {
		// TODO Auto-generated method stub
		return reservationrepository.Statistique(mc);
	}

	@Override
	public Reservation getReservationById(long id) {
		// TODO Auto-generated method stub
		return reservationrepository.findById(id).orElse(null);
	}

	@Override
	public List<Reservation> ListAllReservartion() {
		// TODO Auto-generated method stub
		return reservationrepository.findAll();
	}

	@Override
	public double StatistiqueSumprix(int mc) {
		// TODO Auto-generated method stub
		return reservationrepository.StatistiqueSumprix(mc);
	}

	@Override
	public int StatistiqueChafHotel(int mc,long id) {
		// TODO Auto-generated method stub
		return reservationrepository.Statistique(mc, id);
	}

	

}
