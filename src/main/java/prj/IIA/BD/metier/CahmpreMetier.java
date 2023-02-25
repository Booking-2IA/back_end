package prj.IIA.BD.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import prj.IIA.BD.entites.champre;

public interface CahmpreMetier {

	public champre saveChampre(champre c);
	public Page<champre> ListChampre(int mc,Pageable pageable);
	public Page<champre>chercherByNum(int numchampre,Pageable pageable);
	public Page<champre> ListChampreByHotel(Long mc,Pageable pageable);
	public champre getByid(Long id);
	public int countchampreById(Long id);
	public double MinPrixByIdHotel(Long id);
	public double MaxPrixByIdHotel(Long id);
	public List<champre> ListALLchamper();
	public List<champre> ListChamperByHotelAndType(long id,String type);
}
