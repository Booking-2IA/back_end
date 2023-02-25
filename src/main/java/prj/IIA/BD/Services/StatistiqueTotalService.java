package prj.IIA.BD.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prj.IIA.BD.DTO.StatistiqueTotalDTO;
import prj.IIA.BD.DTO.VilleDTO;
import prj.IIA.BD.dao.ChampreRepository;
import prj.IIA.BD.dao.HotelRepository;
import prj.IIA.BD.dao.PlaseRepository;
import prj.IIA.BD.dao.ReservartionRepository;
import prj.IIA.BD.dao.UsereRepository;
import prj.IIA.BD.dao.VilleRepository;

@RestController
@RequestMapping("/api/Statistique")
@CrossOrigin("*")
public class StatistiqueTotalService {

	@Autowired
	private UsereRepository usererepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private ChampreRepository champreRepository;
	
	@Autowired
	private VilleRepository Villerepository;
	
	@Autowired
	private ReservartionRepository reservationrepository;
	@Autowired
	private PlaseRepository plaseRepository;
	
	@GetMapping("/total")
	public StatistiqueTotalDTO StatistiqueTotal(){
		StatistiqueTotalDTO dto=new StatistiqueTotalDTO();
		dto.setCountAdmin(usererepository.NomberTotalAdmin());
		dto.setCountChafHotel(usererepository.NomberTotalCHafHotel());
		dto.setCountClient(usererepository.NomberTotalClient());
		dto.setCountChampre((int)champreRepository.count());
		dto.setCountHotels((int)hotelRepository.count());
		dto.setCountPlasesTourist((int)plaseRepository.count());
		dto.setCountVilles((int)Villerepository.count());
		dto.setCountReservation((int)reservationrepository.count());
		return dto;
		
	}
	
	@GetMapping("/totalChafHotel/{id}")
	public StatistiqueTotalDTO StatistiqueTotalChafHotel(@PathVariable long id){
		StatistiqueTotalDTO dto=new StatistiqueTotalDTO();
     	dto.setCountChampre((int)champreRepository.countChamperChafHotel(id));
		dto.setCountHotels((int)hotelRepository.countHotelChafHotel(id));
		dto.setCountReservation((int)reservationrepository.countReserChaf(id));
		return dto;
		
	}
}
