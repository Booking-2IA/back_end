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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import prj.IIA.BD.DTO.PlacesTouristsDTO;
import prj.IIA.BD.DTO.VilleDTO;
import prj.IIA.BD.entites.ListImageHotel;
import prj.IIA.BD.entites.PlasesTourist;
import prj.IIA.BD.entites.ville;
import prj.IIA.BD.metier.PlacesTouristsMities;

@RestController
@RequestMapping("/api/Places")
@CrossOrigin("*")
public class PlasesService {

	@Autowired
	private PlacesTouristsMities mities;
	
	@PostMapping("/save")
	public ResponseEntity<PlasesTourist> save(@ModelAttribute PlasesTourist p,@RequestParam("file") MultipartFile file) throws IOException{
		String Path_Diriction=new ClassPathResource("static/Image").getFile().getAbsolutePath();
		String photo_user=Path_Diriction+File.separator+file.getOriginalFilename();
		
		String photo="http://localhost:8080/Image/"+file.getOriginalFilename();
		Files.copy(file.getInputStream(), Paths.get(photo_user), StandardCopyOption.REPLACE_EXISTING);
		
		
		p.setImage(photo);
		
		return ResponseEntity.ok(mities.save(p));
	}
	
	@GetMapping("ListByville")
	public ResponseEntity<Page<PlasesTourist>> ListPlasesByVille(@RequestParam(name="nomville",defaultValue="") String  mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="6") int size) {
		Page<PlasesTourist> villes= mities.ListPlasesByville("%"+mc+"%",PageRequest.of(page,size));
		return new ResponseEntity<>(villes, HttpStatus.OK);
		
	}
	
	@GetMapping("getByid/{id}")
	public ResponseEntity<PlasesTourist> getById(@PathVariable long id) {
		PlasesTourist place= mities.getByid(id);
		return new ResponseEntity<>(place, HttpStatus.OK);
		
	}
	@GetMapping("ListByIDville/{id}")
	public ResponseEntity<Page<PlasesTourist>> ListPlasesByIDVille(@RequestParam(name="nomville",defaultValue="") String  mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="6") int size,@PathVariable  long id) {
		Page<PlasesTourist> villes= mities.ListPlasesByIDville(id,PageRequest.of(page,size));
		return new ResponseEntity<>(villes, HttpStatus.OK);
		
	}
	@GetMapping("ListALLByIDville/{id}")
	public ResponseEntity<List<PlasesTourist>> ListALLPlasesByIDVille(@PathVariable  long id) {
		List<PlasesTourist> villes= mities.ListALLPlasesByIDville(id);
		return new ResponseEntity<>(villes, HttpStatus.OK);
		
	}
	@GetMapping("List")
	public ResponseEntity<Page<PlasesTourist>> ListPlases(@RequestParam(name="nomville",defaultValue="") String  mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="6") int size) {
		Page<PlasesTourist> villes= mities.ListPlases("%"+mc+"%",PageRequest.of(page,size));
		return new ResponseEntity<>(villes, HttpStatus.OK);
		
	}
	
	  @GetMapping("/StatistiqueByMounts")
	 	public List<PlacesTouristsDTO> StatistiqueByMounts() {
	 		List<PlacesTouristsDTO> dto=new ArrayList<>();
	 		for(int i=1;i<=12;i++) {
	 			PlacesTouristsDTO c=new PlacesTouristsDTO();
	 			c.setCounts(mities.Statistique(i));
	 			c.setMM(i);
	 			dto.add(c);
	 		}
	 		 return dto;
	 		 
	 	}
	  
	  @GetMapping("ListALLPleses")
		public ResponseEntity<List<PlasesTourist>> ListALLPlases() {
			return new ResponseEntity<>(mities.ListAllPleses(), HttpStatus.OK);
			
		}
	
}
