package prj.IIA.BD.Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import prj.IIA.BD.DTO.HotelDTO;
import prj.IIA.BD.DTO.ListAllHotelDTO;
import prj.IIA.BD.DTO.ReservationDTO;
import prj.IIA.BD.dao.ChampreRepository;
import prj.IIA.BD.entites.Hotels;
import prj.IIA.BD.metier.CahmpreMetier;
import prj.IIA.BD.metier.HotelMetier;
import prj.IIA.BD.metier.UserMetier;
import prj.IIA.BD.metier.VilleMetier;

@RestController
@RequestMapping("/Hotel")
@CrossOrigin("*")
public class HotelService {

	@Autowired
	private HotelMetier hotelMetier;
	@Autowired
	private UserMetier userMetier ;
	@Autowired
	private VilleMetier metier;
	@Autowired
	private CahmpreMetier Champermetier;
	@GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getHotel(@PathVariable Long id) {
    	Hotels res= hotelMetier.getHotel(id);
    	HotelDTO h=new HotelDTO();
		h.setId(res.getId());
		h.setLocalisation(res.getLocalisation());
		h.setDescription(res.getDescription());
		h.setLocalisationlat(res.getLocalisationlat());
		h.setLocalisationlng(res.getLocalisationlng());
		h.setStar(res.getStar());
		h.setCountChamperByHotel(Champermetier.countchampreById(res.getId()));
		h.setAIRPORT(res.getAIRPORT());
		h.setAVANTAGE(res.getAVANTAGE());
		h.setLANGUE(res.getLANGUE());
		h.setLIEU_PROCHE(res.getLIEU_PROCHE());
		h.setSITE_WEB(res.getSITE_WEB());
		h.setTELEPHONE(res.getTELEPHONE());
		h.setIdVille(hotelMetier.IdvilleByHotel(res.getId()));
		h.setNomVille(hotelMetier.nomvilleByHotel(res.getId()));
		h.setNomHotel(res.getNomHotel());
		h.setImage(res.getImage());
		return new ResponseEntity<>(h, HttpStatus.OK);
	}
	@GetMapping("/Star/{star}")
    public ResponseEntity<List<Hotels>> getHotelByStar(@PathVariable int star) {
    	List<Hotels> Hotels= hotelMetier.getByStar(star);
		return new ResponseEntity<>(Hotels, HttpStatus.OK);
	}
    //############
	@PostMapping("/save")
	public ResponseEntity<Hotels> save(@ModelAttribute Hotels H,@RequestParam("file") MultipartFile file) throws IOException {
		
		String Path_Diriction=new ClassPathResource("static/Image").getFile().getAbsolutePath();
		String photo_user=Path_Diriction+File.separator+file.getOriginalFilename();
		
		String photo="http://localhost:8080/Image/"+file.getOriginalFilename();
		Files.copy(file.getInputStream(), Paths.get(photo_user), StandardCopyOption.REPLACE_EXISTING);
		H.setImage(photo);
		
			 return new ResponseEntity<>( hotelMetier.saveHotel(H), HttpStatus.CREATED);
			
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Hotels> update(@ModelAttribute Hotels H,@RequestParam("file") MultipartFile file,@PathVariable long id) throws IOException {
		
		String Path_Diriction=new ClassPathResource("static/Image").getFile().getAbsolutePath();
		String photo_user=Path_Diriction+File.separator+file.getOriginalFilename();
		
		String photo="http://localhost:8080/Image/"+file.getOriginalFilename();
		Files.copy(file.getInputStream(), Paths.get(photo_user), StandardCopyOption.REPLACE_EXISTING);
		H.setImage(photo);
		H.setId(id);
			 return new ResponseEntity<>( hotelMetier.saveHotel(H), HttpStatus.CREATED);
			
	}
	 @GetMapping("/List")
		public ResponseEntity<List<HotelDTO>> List(@RequestParam(name="motCle",defaultValue="") String  mc,
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="10") int size) {
		 Page<Hotels> hotels;
		
			 hotels= hotelMetier.ListHotels("%"+mc+"%",PageRequest.of(page,size));
	
			List<HotelDTO> Hs=new ArrayList();
			hotels.forEach(res->{
				HotelDTO h=new HotelDTO();
				h.setId(res.getId());
				h.setEmailchafhote(res.getPresedHotel().getUsername());
				h.setLocalisation(res.getLocalisation());
				h.setDescription(res.getDescription());
				h.setLocalisationlat(res.getLocalisationlat());
				h.setLocalisationlng(res.getLocalisationlng());
				h.setStar(res.getStar());
				h.setNomHotel(res.getNomHotel());
				h.setCountChamperByHotel(Champermetier.countchampreById(res.getId()));
				/*if(Champermetier.getByid(res.getChampres())!=null) {
				h.setMaxprix(Champermetier.MaxPrixByIdHotel(res.getId()));
			h.setMinprix(Champermetier.MinPrixByIdHotel(res.getId()));}*/
				h.setAIRPORT(res.getAIRPORT());
				h.setAVANTAGE(res.getAVANTAGE());
				h.setLANGUE(res.getLANGUE());
				h.setLIEU_PROCHE(res.getLIEU_PROCHE());
				h.setSITE_WEB(res.getSITE_WEB());
				h.setTELEPHONE(res.getTELEPHONE());
				h.setNomVille(hotelMetier.nomvilleByHotel(res.getId()));
				h.setNombertotalPage(hotels.getTotalPages());
				h.setImage(res.getImage());
				Hs.add(h);
			});
			String s;
			return new ResponseEntity<>(Hs, HttpStatus.OK);
			
		}
	 
	 
	 @GetMapping("/ListALL")
		public ResponseEntity<List<HotelDTO>> ListALL(@RequestParam(name="motCle",defaultValue="") String  mc) {
		 List<Hotels> hotels;
		
			 hotels= hotelMetier.ListALL(mc);
	
			List<HotelDTO> Hs=new ArrayList();
			hotels.forEach(res->{
				HotelDTO h=new HotelDTO();
				h.setId(res.getId());
				h.setDescription(res.getDescription());
				h.setLocalisationlat(res.getLocalisationlat());
				h.setLocalisationlng(res.getLocalisationlng());
				h.setStar(res.getStar());
				h.setLocalisation(res.getLocalisation());
				h.setNomHotel(res.getNomHotel());
				h.setCountChamperByHotel(Champermetier.countchampreById(res.getId()));
				/*if(Champermetier.getByid(res.getChampres())!=null) {
				h.setMaxprix(Champermetier.MaxPrixByIdHotel(res.getId()));
			h.setMinprix(Champermetier.MinPrixByIdHotel(res.getId()));}*/
				h.setNomVille(hotelMetier.nomvilleByHotel(res.getId()));
				h.setAIRPORT(res.getAIRPORT());
				h.setAVANTAGE(res.getAVANTAGE());
				h.setLANGUE(res.getLANGUE());
				h.setLIEU_PROCHE(res.getLIEU_PROCHE());
				h.setSITE_WEB(res.getSITE_WEB());
				h.setTELEPHONE(res.getTELEPHONE());
				h.setImage(res.getImage());
				Hs.add(h);
			});
			String s;
			return new ResponseEntity<>(Hs, HttpStatus.OK);
			
		}

	 
	 @GetMapping("/ListByIdville/{id}")
		public ResponseEntity<List<HotelDTO>> ListByIdville(
				@RequestParam(name="page",defaultValue="0") int page,
				@RequestParam(name="size",defaultValue="4") int size,
				@RequestParam(name="AVANTAGE",defaultValue="") String AVANTAGE,
				@RequestParam(name="LANGUE",defaultValue="") String LANGUE,
				@RequestParam(name="star",defaultValue="0") int star,
				@RequestParam(name="nbChamper",defaultValue="0") int nb
				,@PathVariable long id) {
		 Page<Hotels> hotels;
		
			 hotels= hotelMetier.ListHotelByVille(id,"%"+AVANTAGE+"%","%"+LANGUE+"%",star,PageRequest.of(page,size));
	System.out.println("total page est "+hotels.getTotalPages());
			List<HotelDTO> Hs=new ArrayList();
			hotels.forEach(res->{
				HotelDTO h=new HotelDTO();
				h.setId(res.getId());
				h.setLocalisation(res.getLocalisation());
				h.setDescription(res.getDescription());
				h.setLocalisationlat(res.getLocalisationlat());
				h.setLocalisationlng(res.getLocalisationlng());
				h.setStar(res.getStar());
				h.setNomHotel(res.getNomHotel());
				h.setCountChamperByHotel(Champermetier.countchampreById(res.getId()));
					h.setAIRPORT(res.getAIRPORT());
				h.setAVANTAGE(res.getAVANTAGE());
				h.setLANGUE(res.getLANGUE());
				h.setLIEU_PROCHE(res.getLIEU_PROCHE());
				h.setSITE_WEB(res.getSITE_WEB());
				h.setTELEPHONE(res.getTELEPHONE());
				h.setNomVille(hotelMetier.nomvilleByHotel(res.getId()));
				h.setNombertotalPage(hotels.getTotalPages());
				h.setImage(res.getImage());
				Hs.add(h);
			});
			
			return new ResponseEntity<>(Hs, HttpStatus.OK);
			
		}
	 @GetMapping("/ListALLByIdville/{id}")
		public ResponseEntity<List<HotelDTO>> ListALLByIdville(@PathVariable long id) {
		 List<Hotels> hotels;
		
			 hotels= hotelMetier.ListALLHotelByVille(id);
	
			List<HotelDTO> Hs=new ArrayList();
			hotels.forEach(res->{
				HotelDTO h=new HotelDTO();
				h.setId(res.getId());
				h.setLocalisation(res.getLocalisation());
				h.setDescription(res.getDescription());
				h.setLocalisationlat(res.getLocalisationlat());
				h.setLocalisationlng(res.getLocalisationlng());
				h.setStar(res.getStar());
				h.setNomHotel(res.getNomHotel());
				h.setCountChamperByHotel(Champermetier.countchampreById(res.getId()));
					h.setAIRPORT(res.getAIRPORT());
				h.setAVANTAGE(res.getAVANTAGE());
				h.setLANGUE(res.getLANGUE());
				h.setLIEU_PROCHE(res.getLIEU_PROCHE());
				h.setSITE_WEB(res.getSITE_WEB());
				h.setTELEPHONE(res.getTELEPHONE());
				h.setNomVille(hotelMetier.nomvilleByHotel(res.getId()));
				
				h.setImage(res.getImage());
				Hs.add(h);
			});
			
			return new ResponseEntity<>(Hs, HttpStatus.OK);
			
		}
	 
	 @GetMapping("count")
	 public long countHotel() {
		 return hotelMetier.countHotel();
	 }
	 @GetMapping("/Statistique")
		public List<HotelDTO> Statistique() {
			List<HotelDTO> dto=new ArrayList<>();
			for(int i=1;i<=12;i++) {
				HotelDTO c=new HotelDTO();
				c.setCount(hotelMetier.Statistique(i));
				c.setMM(i);
				dto.add(c);
			}
			 return dto;
			 
		}
	 
    @DeleteMapping("/delet/{id}")
    public void deletByid(@PathVariable long id) {
    	hotelMetier.deletHotel(id);
    }
    @PutMapping("/delettest/{id}")
    public Hotels delettestByid(@PathVariable long id) {
    	
    	return hotelMetier.delettestHotel(id);
    }
    //ListAllHotelDTO
    @GetMapping("/ListHome")
	 public ResponseEntity<List<ListAllHotelDTO>> ListHome(@RequestParam(name="motCle",defaultValue="") String  mc) {
		List<Hotels> Hs= hotelMetier.ListALL(mc);
		List<ListAllHotelDTO> H=new ArrayList();
		Hs.forEach(res->{
			ListAllHotelDTO e=new ListAllHotelDTO();
			e.setDescription(res.getDescription());
			e.setId(res.getId());
			e.setImage(res.getImage());
			e.setNomHotel(res.getNomHotel());
			H.add(e);
		});
		return new ResponseEntity<>(H, HttpStatus.OK);
	 }
}
