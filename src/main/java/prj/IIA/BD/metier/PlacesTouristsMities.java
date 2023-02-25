package prj.IIA.BD.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import prj.IIA.BD.entites.PlasesTourist;

public interface PlacesTouristsMities {

	public PlasesTourist save(PlasesTourist p);
	public Page<PlasesTourist> ListPlasesByville(String mc,Pageable pageable);
	public Page<PlasesTourist> ListPlasesByIDville(long mc,Pageable pageable);
	public List<PlasesTourist> ListALLPlasesByIDville(long mc);
	public PlasesTourist getByid(long id);

	public Page<PlasesTourist> ListPlases(String nomville,Pageable pageable);
	public int Statistique(int mc);
    public List<PlasesTourist> ListAllPleses();
}
