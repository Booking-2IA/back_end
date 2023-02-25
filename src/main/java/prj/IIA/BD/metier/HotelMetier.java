package prj.IIA.BD.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import prj.IIA.BD.entites.Hotels;
import prj.IIA.BD.entites.ville;

public interface HotelMetier {
	public Page<Hotels> ListHotels(String mc,Pageable pageable);
	
	public Page<Hotels> ListHotelByVille(long idv,String AVANTAGE,String LANGUE,int star,Pageable pageable);
	public List<Hotels> ListALLHotelByVille(long idv);
	
	public Hotels saveHotel(Hotels h);
	public List<Hotels> getByStar(int star);
	public Hotels getHotel(Long id);
	public String nomvilleByHotel(long id);
	public long IdvilleByHotel(long id);
	public long countHotel();
	public int Statistique(int mc);
	public List<Hotels> ListALL(String mc);
	public void deletHotel(long id);
	public Hotels delettestHotel(long id);
}
