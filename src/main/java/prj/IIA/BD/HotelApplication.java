package prj.IIA.BD;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

import prj.IIA.BD.DTO.ReservationDTO;
import prj.IIA.BD.dao.HotelRepository;
import prj.IIA.BD.dao.UsereRepository;
import prj.IIA.BD.entites.Reservation;
import prj.IIA.BD.entites.Role;
import prj.IIA.BD.entites.usere;




@SpringBootApplication
public class HotelApplication  implements CommandLineRunner{
	 @Autowired
	    private JdbcTemplate jdbcTemplate;

@Autowired
private UsereRepository h;

@Autowired
private  PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

	}

	
}
