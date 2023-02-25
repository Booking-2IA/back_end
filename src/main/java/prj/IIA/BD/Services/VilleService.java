package prj.IIA.BD.Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import prj.IIA.BD.DTO.UsereDTO;
import prj.IIA.BD.DTO.VilleDTO;
import prj.IIA.BD.entites.ville;
import prj.IIA.BD.metier.VilleMetier;

@RestController
@RequestMapping("/api/ville")
@CrossOrigin("*")
public class VilleService {
	@Autowired
	private VilleMetier metier;
	@PostMapping("/save")
	public ResponseEntity<ville> save(@ModelAttribute ville v,@RequestParam("file") MultipartFile file) throws IOException {
		String Path_Diriction=new ClassPathResource("static/Image").getFile().getAbsolutePath();
		String photo_user=Path_Diriction+File.separator+file.getOriginalFilename();
		
		String photo="http://localhost:8080/Image/"+file.getOriginalFilename();
		Files.copy(file.getInputStream(), Paths.get(photo_user), StandardCopyOption.REPLACE_EXISTING);
		
		
		if(v.getId()!=null) {
			v=metier.getVille(v.getId());
			
		}
		v.setImageville(photo);
		
		 return new ResponseEntity<>( metier.save(v), HttpStatus.CREATED);
			
	}
    @GetMapping("ListPage")
	public ResponseEntity<Page<ville>> ListVille(@RequestParam(name="motCle",defaultValue="") String  mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="3") int size) {
		Page<ville> villes= metier.ListVille("%"+mc+"%",PageRequest.of(page,size));
		return new ResponseEntity<>(villes, HttpStatus.OK);
		
	}
    @GetMapping("List")
   	public ResponseEntity<List<ville>> Lists(@RequestParam(name="motCle",defaultValue="") String  mc) {
   		List<ville> villes= metier.Lists("%"+mc+"%");
   		return new ResponseEntity<>(villes, HttpStatus.OK);
   		
   	}
    @GetMapping("Statistique")
   	public ResponseEntity<List<VilleDTO>> Statistique() {
    	List<VilleDTO> v=new ArrayList<>();
    	metier.Lists("%%").forEach(
    			res->{
    				VilleDTO v1=new VilleDTO();
    				v1.setNomVille(res.getNomVille());
    			v1.setCountHotel(res.getHotels().size());
    			v.add(v1);
    			});
   		
   		return new ResponseEntity<>(v, HttpStatus.OK);
   		
   	}
    @GetMapping("/{id}")
	public  ResponseEntity<ville> getPresH(@PathVariable Long id) {
		ville ville= metier.getVille(id);
		return new ResponseEntity<>(ville, HttpStatus.OK);
		
	}
	
	
	
	
	@GetMapping("counthotel")
	public ResponseEntity<List<VilleDTO>> counthotel(@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="3") int size) {
		//HashMap<ville, Float> villeH = new HashMap<ville, Float>();
		
		return new ResponseEntity<>(metier.contHotelByville(), HttpStatus.OK);
		
	}
	
	  @GetMapping("/StatistiqueByMounts")
	 	public List<VilleDTO> StatistiqueByMounts() {
	 		List<VilleDTO> dto=new ArrayList<>();
	 		for(int i=1;i<=12;i++) {
	 			VilleDTO c=new VilleDTO();
	 			c.setCounts(metier.Statistique(i));
	 			c.setMM(i);
	 			dto.add(c);
	 		}
	 		 return dto;
	 		 
	 	}
	  
	  
	  @PutMapping("/update")
		public ResponseEntity<ville> update(@ModelAttribute ville v,@RequestParam("file") MultipartFile file) throws IOException {
			String Path_Diriction=new ClassPathResource("static/Image").getFile().getAbsolutePath();
			String photo_user=Path_Diriction+File.separator+file.getOriginalFilename();
			
			String photo="http://localhost:8080/Image/"+file.getOriginalFilename();
			Files.copy(file.getInputStream(), Paths.get(photo_user), StandardCopyOption.REPLACE_EXISTING);
			
			
		/*	if(v.getId()!=null) {
				v=metier.getVille(v.getId());
				
			}*/
			v.setImageville(photo);
			
			 return new ResponseEntity<>( metier.save(v), HttpStatus.CREATED);
				
		}
}
