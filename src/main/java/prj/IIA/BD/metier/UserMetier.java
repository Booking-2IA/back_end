package prj.IIA.BD.metier;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;

import prj.IIA.BD.DTO.UsereDTO;
import prj.IIA.BD.RequestReponse.AuthenticationRequest;
import prj.IIA.BD.entites.usere;
import prj.IIA.BD.exeption.AccessException;
import prj.IIA.BD.exeption.AuthException;

public interface UserMetier {

	public usere saveclient(usere c);
	public Page<usere> ListUser(String mc,String Role,Pageable pageable);
	public usere getClient(Long id);
	public UsereDTO authenticate(AuthenticationRequest request);
	public UsereDTO register(UsereDTO req);
	public  usere uploadImageClient(String image,Long id);
	public int Statistique(int mc);
	public List<usere> ListUser();
	public usere deletuser(long id);
}
