package prj.IIA.BD.metier;


import java.util.List;
import java.util.Optional;
import prj.IIA.BD.exeption.AuthException;
import prj.IIA.BD.exeption.AuthException.ErrorCode;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import prj.IIA.BD.DTO.UserDto;
import prj.IIA.BD.DTO.UsereDTO;
import prj.IIA.BD.RequestReponse.AuthenticationRequest;
import prj.IIA.BD.RequestReponse.AuthenticationResponse;
import prj.IIA.BD.configuration.JwtService;
import prj.IIA.BD.dao.UsereRepository;
import prj.IIA.BD.entites.Hotels;
import prj.IIA.BD.entites.Role;
import prj.IIA.BD.entites.usere;
import prj.IIA.BD.exeption.AccessException;
import prj.IIA.BD.exeption.AccessException.AcccessError;

@Service
@Transactional
public class UserMetierImpl implements UserMetier{
	@Autowired
	private  AuthenticationManager authenticationManager;
	@Autowired
	private UsereRepository userRepository;
	@Autowired
	private JwtService jwtService;
	@Autowired
	 private  PasswordEncoder passwordEncoder;
	   
	@Override
	public usere saveclient(usere c)  {
          
        	c.setPassword( c.getPassword());
        	return userRepository.save(c);
       
    }
	

	@Override
	public Page<usere> ListUser(String mc,String r,Pageable pageable) {
		// TODO Auto-generated method stub
		Role role;
		if(r==Role.Admin.toString()) {
			role=Role.Admin;
		}else {
		if(r==Role.CHafHotel.toString())
			role=Role.CHafHotel;
		else
			role=Role.Client;
		}
		return userRepository.ListUser(mc,role,pageable);
	}

	@Override
	public usere getClient(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findByIDUSER(id);
	}

	@Override
	public int Statistique(int mc) {
		// TODO Auto-generated method stub
		return userRepository.Statistique(mc);
	}

	
	
	    
	  


	 

	 
	
		@Override
		 public UsereDTO register(UsereDTO user) {
			usere a=new usere();

			     a.setPassword(passwordEncoder.encode(user.getPassword()));
			     a.setAdress(user.getAdress());
				   
				     a.setNom(user.getNom());
				     a.setCNI(user.getCNI());
				     a.setDateNaissance(user.getDateNaissance());
				     a.setNationalite(user.getNationalite());
				     a.setPhoto_user(a.getPhoto_user());
				     a.setPrenom(user.getPrenom());
				     a.setSexe(user.getSexe());
				     a.setUsername(user.getUsername());
				   if(user.getRole()=="Admin") { 
				     a.setRole(Role.Admin);}else {
				   if(user.getRole()=="CHafHotel")
					     a.setRole(Role.CHafHotel);
				   else {
					     a.setRole(Role.Client);
					     user.setRole("Client");
				   }
				   }
			    userRepository.save(a);
			    user.setPassword(null);
			    user.setId(a.getId());
			    var jwtToken = jwtService.generateToken(a);
			   user.setToken(jwtToken);
			    return user;
			  }

			  public UsereDTO authenticate(AuthenticationRequest request) {
			    authenticationManager.authenticate(
			        new UsernamePasswordAuthenticationToken(
			            request.getUsername(),
			            request.getPassword()
			        )
			    );
			  
			    var user = userRepository.findByUsername(request.getUsername())
			            .orElseThrow();
			    var jwtToken = jwtService.generateToken(user);
			     UsereDTO a=new UsereDTO();
			     a.setAdress(user.getAdress());
			    a.setId(user.getId());
			     a.setNom(user.getNom());
			     a.setCNI(user.getCNI());
			     a.setDateNaissance(user.getDateNaissance());
			     a.setNationalite(user.getNationalite());
			     a.setPhoto_user(a.getPhoto_user());
			     a.setPrenom(user.getPrenom());
			     a.setSexe(user.getSexe());
			     a.setUsername(user.getUsername());
			     a.setToken(jwtToken);
			     
			     a.setRole(user.getRole().name());
			     return a;
			  }

			@Override
			public usere uploadImageClient(String image, Long id) {
				// TODO Auto-generated method stub
				usere user=new usere();
				user=userRepository.findByIDUSER(id);
				user.setPhoto_user(image);
				return userRepository.save(user);
			}


			@Override
			public List<usere> ListUser() {
				// TODO Auto-generated method stub
				return userRepository.findAll();
			}

			

			@Override
			public usere deletuser(long id) {
				usere H=userRepository.findById(id).orElse(null);
				H.setDeleted(true);
				 
				return userRepository.save(H);
			}
			}


