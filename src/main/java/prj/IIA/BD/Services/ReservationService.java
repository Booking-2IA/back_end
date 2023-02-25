package prj.IIA.BD.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import prj.IIA.BD.DTO.PrintReservationDTO;
import prj.IIA.BD.DTO.ReservationDTO;
import prj.IIA.BD.entites.Reservation;
import prj.IIA.BD.metier.CahmpreMetier;
import prj.IIA.BD.metier.HotelMetier;
import prj.IIA.BD.metier.ReservationMetier;
import prj.IIA.BD.metier.UserMetier;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ReservationService {

	@Autowired
	private ReservationMetier metier;
	@Autowired 
	private UserMetier usermitier;
	@Autowired 
	private CahmpreMetier champerMiter;
	@Autowired
	private HotelMetier HotelMitier;
	 
	@PostMapping("/Reservation")
	public Reservation saveReservation(@ModelAttribute Reservation R) {
		//
		
		return metier.saveReservation(R);
	}

	@GetMapping("/ListReservation/{id}")
	public List<Reservation> ListReservation(@PathVariable Long id) {
		
		return metier.ListReservation(id);
	}
	@GetMapping("/Reservation/Statistique")
	public List<ReservationDTO> Statistique() {
		List<ReservationDTO> dto=new ArrayList<>();
		for(int i=1;i<=12;i++) {
			ReservationDTO c=new ReservationDTO();
			c.setCounts( metier.Statistique(i));
			c.setMM(i);
			//c.setSumprix(metier.StatistiqueSumprix(i));
			dto.add(c);
		}
		 return dto;
		 
	}
	@GetMapping("{id}")
	public List<ReservationDTO> StatistiqueChafHotel(@PathVariable long id) {
		List<ReservationDTO> dto=new ArrayList<>();
		for(int i=1;i<=12;i++) {
			ReservationDTO c=new ReservationDTO();
			c.setCounts( metier.StatistiqueChafHotel(i,id));
			c.setMM(i);
			//c.setSumprix(metier.StatistiqueSumprix(i));
			dto.add(c);
		}
		 return dto;
		 
	}
	public Optional<Reservation> findByIDCLIENT(Long IDCLIENT) {
		return metier.findByIDCLIENT(IDCLIENT);
	}

	@GetMapping("ListAllReservartion")
	public List<Reservation>  ListAllReservartion(){
		return metier.ListAllReservartion();
	}
	@GetMapping("reservation/{id}")
	public PrintReservationDTO getById(@PathVariable long id) {
		Reservation R= metier.getReservationById(id);
		PrintReservationDTO PR=new PrintReservationDTO();
		PR.setNumberChamper(R.getChampre().getNumchampre());
		PR.setTypeChamper(R.getChampre().getType());
		PR.setDescriptionHotel(R.getChampre().getHotel().getDescription());
		PR.setLocalisationHotel(R.getChampre().getHotel().getLocalisation());
		PR.setNomHotel(R.getChampre().getHotel().getNomHotel());
		PR.setSit_WebHotel(R.getChampre().getHotel().getSITE_WEB());
		PR.setStarHoetl(R.getChampre().getHotel().getStar());
		PR.setTelephonHotel(R.getChampre().getHotel().getTELEPHONE());
		PR.setNomVille(R.getChampre().getHotel().getVilles().getNomVille());
		PR.setDateIn(R.getDateIn());
		PR.setDateOut(R.getDateOut());
		PR.setPrix(R.getPrix());
		PR.setAdress_user(usermitier.getClient(R.getIDCLIENT()).getAdress());
		PR.setCNI_User(usermitier.getClient(R.getIDCLIENT()).getCNI());
		PR.setDateNaissance(usermitier.getClient(R.getIDCLIENT()).getDateNaissance());
		PR.setNationaliteUser(usermitier.getClient(R.getIDCLIENT()).getNationalite());
		PR.setNomUser(usermitier.getClient(R.getIDCLIENT()).getNom());
		PR.setPhoto_User(usermitier.getClient(R.getIDCLIENT()).getPhoto_user());
		PR.setPrenomUser(usermitier.getClient(R.getIDCLIENT()).getPrenom());
		PR.setSexUser(usermitier.getClient(R.getIDCLIENT()).getSexe());
		
		
       
		return  PR;
	}

	
	
	
	
}
