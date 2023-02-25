package prj.IIA.BD.Services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

import prj.IIA.BD.entites.champre;
import prj.IIA.BD.metier.CahmpreMetier;
import prj.IIA.BD.metier.HotelMetier;

@RestController
@RequestMapping("/champre")
@CrossOrigin("*")
public class ChampreService {

	@Autowired
	private CahmpreMetier cahmpreMetier;
	@Autowired
	private HotelMetier HotMetier;
	
	@GetMapping("/List/{mc}")
	public ResponseEntity<Page<champre>> List(@PathVariable int  mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size) {
		Page<champre> champres= cahmpreMetier.ListChampre(mc,PageRequest.of(page,size));
		return new ResponseEntity<>(champres, HttpStatus.OK);
	}
	
	@GetMapping("/Listchampre/{id}")
	public ResponseEntity<Page<champre>> ListByHotel(@PathVariable Long  id,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size) {
		Page<champre> champres= cahmpreMetier.ListChampreByHotel(id,PageRequest.of(page,size));
		return new ResponseEntity<>(champres, HttpStatus.OK);
	}
	
	@GetMapping("/getByid/{id}")
	public ResponseEntity<champre> getById(@PathVariable Long id){
		return new ResponseEntity<>(cahmpreMetier.getByid(id), HttpStatus.OK);
	}
	@PostMapping("save/{idH}")
	public ResponseEntity<champre> save(@PathVariable long idH,@ModelAttribute champre c) throws IOException{
	/*	if(file!=null) {
		String Path_Diriction=new ClassPathResource("static/Image").getFile().getAbsolutePath();
		String photo_user=Path_Diriction+File.separator+file.getOriginalFilename();
		
		String photo="http://localhost:8080/Image/"+file.getOriginalFilename();
		Files.copy(file.getInputStream(), Paths.get(photo_user), StandardCopyOption.REPLACE_EXISTING);
		c.setPhoto(photo);}*/
		c.setHotel(HotMetier.getHotel(idH));
		return new ResponseEntity<>(cahmpreMetier.saveChampre(c), HttpStatus.OK);
	}
	
	@GetMapping("/ListALL")
	public ResponseEntity<java.util.List<champre>> ListALLchamper(){
		return new ResponseEntity<>(cahmpreMetier.ListALLchamper(), HttpStatus.OK);
	}
	
	@GetMapping("/ListChamperByTypeAndIdH/{id}")
	public ResponseEntity<java.util.List<champre>> ListChamperByTypeAndIdH(@PathVariable long id,String type){
		return new ResponseEntity<>(cahmpreMetier.ListChamperByHotelAndType(id, type), HttpStatus.OK);
	}
}
