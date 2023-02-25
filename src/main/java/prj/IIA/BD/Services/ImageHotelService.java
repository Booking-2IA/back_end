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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import prj.IIA.BD.DTO.ImageHotelDTO;
import prj.IIA.BD.entites.Hotels;
import prj.IIA.BD.entites.ListImageHotel;
import prj.IIA.BD.metier.HotelMetier;
import prj.IIA.BD.metier.ImageHotelMitier;

@RestController
@RequestMapping("/api/ImageHotel")
@CrossOrigin("*")
public class ImageHotelService {

	@Autowired
	private ImageHotelMitier ImagehotelMitier;
	@Autowired
	private HotelMetier hotelMetier;
	@PostMapping("/save/{id}")
	public ResponseEntity<ListImageHotel> saveImage(@RequestParam("file") MultipartFile file,@PathVariable Long id) throws IOException {
		String Path_Diriction=new ClassPathResource("static/Image").getFile().getAbsolutePath();
		String photo_user=Path_Diriction+File.separator+file.getOriginalFilename();
		
		String photo="http://localhost:8080/Image/"+file.getOriginalFilename();
		Files.copy(file.getInputStream(), Paths.get(photo_user), StandardCopyOption.REPLACE_EXISTING);
		ListImageHotel image=new ListImageHotel();
		
		image.setHotel(hotelMetier.getHotel(id));
		image.setImage(photo);
		
		
		 return new ResponseEntity<>( ImagehotelMitier.save(image), HttpStatus.CREATED);
			}
	
	@GetMapping("/List/{id}")
	
	public ResponseEntity<Page<ListImageHotel>> List(@PathVariable Long  id,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="6") int size) { 
		return  new ResponseEntity<>(ImagehotelMitier.ListImageByHotel(id, PageRequest.of(page, size)), HttpStatus.OK);
	}
	
   @GetMapping("/ImagePlusNomberT/{id}")
	
	public ResponseEntity<ImageHotelDTO> ImagePlusNomberTotal(@PathVariable Long  id) { 
		return  new ResponseEntity<>(ImagehotelMitier.ImagePlusNomberImageByHotel(id), HttpStatus.OK);
	}
   
   @GetMapping("/ListALLImageByHotel/{id}")
	
  	public ResponseEntity<java.util.List<ListImageHotel>> ListALLImageByHotel(@PathVariable Long  id) { 
  		
	   return  new ResponseEntity<>(ImagehotelMitier.ListAllImageByhotel(id), HttpStatus.OK);
  	}
   
   
}
