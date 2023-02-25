package prj.IIA.BD.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prj.IIA.BD.dao.ChampreRepository;
import prj.IIA.BD.entites.champre;
@Service
@Transactional
public class ChampreMetierImp implements CahmpreMetier{
	@Autowired
	private ChampreRepository champreRepository;
	@Override
	public champre saveChampre(champre c) {
		// TODO Auto-generated method stub
		return champreRepository.save(c);
	}

	@Override
	public Page<champre> ListChampre(int mc,Pageable pageable) {
		// TODO Auto-generated method stub
		return champreRepository.findByNumchampre(mc, pageable);
	}

	@Override
	public Page<champre> chercherByNum(int mc,Pageable p) {
		// TODO Auto-generated method stub
		return champreRepository.findByNumchampre(mc,p);
	}

	@Override
	public Page<champre> ListChampreByHotel(Long mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return champreRepository.findAllchampreByHotel(mc, pageable);
	}

	@Override
	public champre getByid(Long id) {
		// TODO Auto-generated method stub
		return champreRepository.findChampreById(id).orElseThrow(null);
	}

	@Override
	public int countchampreById(Long id) {
		// TODO Auto-generated method stub
		return champreRepository.countChampreByIDHotel(id);
	}

	@Override
	public double MinPrixByIdHotel(Long id) {
		// TODO Auto-generated method stub
		return champreRepository.MinPrixByHotel(id);
	}

	@Override
	public double MaxPrixByIdHotel(Long id) {
		// TODO Auto-generated method stub
		return champreRepository.MaxPrixByHotel(id);
	}

	@Override
	public List<champre> ListALLchamper() {
		// TODO Auto-generated method stub
		return champreRepository.findAll();
	}

	@Override
	public List<champre> ListChamperByHotelAndType(long id, String type) {
		// TODO Auto-generated method stub
		return champreRepository.ListChamperByHotelAndType(id, type);
	}
	

}
