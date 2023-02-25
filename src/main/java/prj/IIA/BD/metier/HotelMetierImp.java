package prj.IIA.BD.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prj.IIA.BD.DTO.HotelDTO;
import prj.IIA.BD.dao.HotelRepository;
import prj.IIA.BD.entites.Hotels;
@Service
@Transactional
public class HotelMetierImp implements HotelMetier{
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotels saveHotel(Hotels h) {
		// TODO Auto-generated method stub
		
		return hotelRepository.save(h);
	}

	@Override
	public Page<Hotels> ListHotels(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return hotelRepository.ListHotels(mc, pageable);
	}

	@Override
	public List<Hotels> getByStar(int star) {
		// TODO Auto-generated method stub
		return hotelRepository.findByStar(star);
	}

	@Override
	public List<Hotels> ListALL(String mc) {
		// TODO Auto-generated method stub
		return hotelRepository.ListALLHotelHome("%"+mc+"%");
	}
	@Override
	public Hotels getHotel(Long id) {
		// TODO Auto-generated method stub
		return hotelRepository.findHotelById(id);
	}

	@Override
	public String nomvilleByHotel(long id) {
		// TODO Auto-generated method stub
		return hotelRepository.HotelByVille(id);
	}

	@Override
	public Page<Hotels> ListHotelByVille(long idv,String AVANTAGE,String LANGUE,int star , Pageable pageable) {
		// TODO Auto-generated method stub
		return hotelRepository.ListHotelByIdVille(idv,AVANTAGE,LANGUE,star, pageable);
	}

	@Override
	public long countHotel() {
		// TODO Auto-generated method stub
		return hotelRepository.count();
	}

	@Override
	public int Statistique(int mc) {
		// TODO Auto-generated method stub
		return hotelRepository.Statistique(mc);
	}

	@Override
	public void deletHotel(long id) {
		// TODO Auto-generated method stub
		 hotelRepository.deleteById(id);  
	}

	@Override
	public List<Hotels> ListALLHotelByVille(long idv) {
		// TODO Auto-generated method stub
		return hotelRepository.ListALLHotelByIdVille(idv);
	}

	@Override
	public long IdvilleByHotel(long id) {
		// TODO Auto-generated method stub
		return hotelRepository.HotelByIdVille(id);
	}

	@Override
	public Hotels delettestHotel(long id) {
		Hotels H=hotelRepository.findHotelById(id);
		H.setDeleted(true);
		return hotelRepository.save(H);
	}

	

	

}
