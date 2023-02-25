package prj.IIA.BD.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prj.IIA.BD.dao.PlaseRepository;
import prj.IIA.BD.entites.PlasesTourist;
@Service
@Transactional
public class PlasesTouristImpMities implements PlacesTouristsMities{

	
	@Autowired
	private PlaseRepository pleserep;
	@Override
	public PlasesTourist save(PlasesTourist p) {
		// TODO Auto-generated method stub
		return pleserep.save(p);
	}

	@Override
	public Page<PlasesTourist> ListPlasesByville(String mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return pleserep.ListPlaseByVille(mc, pageable);
	}

	@Override
	public Page<PlasesTourist> ListPlases(String nomville, Pageable pageable) {
		// TODO Auto-generated method stub
		return pleserep.ListPlase(nomville, pageable);
	}

	@Override
	public Page<PlasesTourist> ListPlasesByIDville(long mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return pleserep.ListPlaseByIDVille(mc, pageable);
	}
	
	@Override
	public int Statistique(int mc) {
		// TODO Auto-generated method stub
		return pleserep.Statistique(mc);
	}

	@Override
	public List<PlasesTourist> ListAllPleses() {
		// TODO Auto-generated method stub
		return pleserep.findAll();
	}

	@Override
	public List<PlasesTourist> ListALLPlasesByIDville(long mc) {
		// TODO Auto-generated method stub
		return pleserep.ListALLPlaseByVille(mc);
	}

	@Override
	public PlasesTourist getByid(long id) {
		// TODO Auto-generated method stub
		return pleserep.findById(id).orElse(null);
	}

}
