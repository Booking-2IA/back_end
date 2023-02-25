package prj.IIA.BD.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import prj.IIA.BD.DTO.VilleDTO;
import prj.IIA.BD.dao.VilleRepository;
import prj.IIA.BD.entites.ville;
@Service
public class ViileMetierImpl implements VilleMetier{
	@Autowired
	private VilleRepository villerepository;
	@Override
	public ville save(ville v) {
		// TODO Auto-generated method stub
		return villerepository.save(v);
	}
	@Override
	public Page<ville> ListVille(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return villerepository.ListVille(mc, pageable);
	}
	@Override
	public ville getVille(Long id) {
		// TODO Auto-generated method stub
		return villerepository.findvilleById(id);
	
	}
	@Override
	public Page<VilleDTO> contHotelByville(Pageable pageable) {
		// TODO Auto-generated method stub
		return villerepository.countHotelInVille(pageable);
	}
	@Override
	public List<VilleDTO> contHotelByville() {
		// TODO Auto-generated method stub
		return villerepository.countHotelInVille();
	}
	@Override
	public List<ville> Lists(String mc) {
		// TODO Auto-generated method stub
		return villerepository.Lists(mc);
	}

	@Override
	public int Statistique(int mc) {
		// TODO Auto-generated method stub
		return villerepository.Statistique(mc);
	}

}
