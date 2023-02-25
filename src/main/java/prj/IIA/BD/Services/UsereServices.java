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
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import prj.IIA.BD.DTO.HotelDTO;
import prj.IIA.BD.DTO.ReservationDTO;
import prj.IIA.BD.DTO.UserDto;
import prj.IIA.BD.DTO.UsereDTO;
import prj.IIA.BD.RequestReponse.AuthenticationRequest;
import prj.IIA.BD.RequestReponse.AuthenticationResponse;
import prj.IIA.BD.configuration.JwtAuthenticationFilter;
import prj.IIA.BD.configuration.JwtService;
import prj.IIA.BD.entites.Hotels;
import prj.IIA.BD.entites.usere;
import prj.IIA.BD.metier.UserMetier;


@RestController
@RequestMapping("/api/User")
@CrossOrigin("*")
public class UsereServices {
    @Autowired
    private JwtService jwtService;
	@Autowired
	private UserMetier  Metier;
	@Autowired
	private JwtAuthenticationFilter authenticationFilter;
	@PostMapping("/edite/{id}")
	public String uploadImageClient(@PathVariable Long id,@RequestParam("file") MultipartFile file) throws IOException {
		
		
		String Path_Diriction=new ClassPathResource("static/Image").getFile().getAbsolutePath();
		String photo_user=Path_Diriction+File.separator+file.getOriginalFilename();
		
		String photo="http://localhost:8080/Image/"+file.getOriginalFilename();
		Files.copy(file.getInputStream(), Paths.get(photo_user), StandardCopyOption.REPLACE_EXISTING);
		
		Metier.uploadImageClient(photo,id);
		return "Secussefil Image is upload";
	}
	@GetMapping("/{id}")
    public ResponseEntity<usere> getClient(@PathVariable Long id) {
		usere client= Metier.getClient(id);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}
    
	//@RequestMapping(value="/saveclient",method=RequestMethod.POST)
    @PostMapping("/register")
	public ResponseEntity<UsereDTO> save(@RequestBody UsereDTO C) {
    	return ResponseEntity.ok(Metier.register(C));
		}
	
    @PutMapping("/editeUser/{id}")
	public ResponseEntity<usere> update(@RequestBody usere C,@PathVariable long id) {
		C.setId(id);
    	return ResponseEntity.ok(Metier.saveclient(C));
	}
	
	@PutMapping("/deletUser/{id}")
    public usere deletUserByid(@PathVariable long id) {
    	
    	return Metier.deletuser(id);
    }
	
	
    //@RequestMapping(value="/clients",method=RequestMethod.GET)
     @GetMapping("/List/{Role}")
	public ResponseEntity<Page<usere>> ListClient(@RequestParam(name="motCle",defaultValue="") String  mc,
			@PathVariable String  Role,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size) {
		Page<usere> users= Metier.ListUser("%"+mc+"%",Role,PageRequest.of(page,size));
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
     
  /*   @GetMapping("/{id}")
 	public ResponseEntity<usere> getUSER(@PathVariable long id) {
 		usere users= Metier.getClient(id);
 		return new ResponseEntity<>(users, HttpStatus.OK);
 	}*/
     @PostMapping("/signIn")
     public ResponseEntity<UsereDTO> authenticate(
         @RequestBody AuthenticationRequest request
     ) {
     return ResponseEntity.ok(Metier.authenticate(request));
    	   
     }
     
     @GetMapping("/Statistique")
 	public List<UsereDTO> Statistique() {
 		List<UsereDTO> dto=new ArrayList<>();
 		for(int i=1;i<=12;i++) {
 			UsereDTO c=new UsereDTO();
 			c.setCouts( Metier.Statistique(i));
 			c.setMM(i);
 			dto.add(c);
 		}
 		 return dto;
 		 
 	}
     
     @GetMapping("/ALLUSERS")
  	public List<usere> ALLUsers() {
  		
  		 return Metier.ListUser();
  		 
  	}
}
