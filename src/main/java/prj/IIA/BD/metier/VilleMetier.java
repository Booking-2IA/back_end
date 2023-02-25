package prj.IIA.BD.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import prj.IIA.BD.DTO.VilleDTO;
import prj.IIA.BD.entites.ville;

public interface VilleMetier {

	public ville save(ville v);
	public Page<ville> ListVille(String mc,Pageable pageable);
	
	public ville getVille(Long id);
	public Page<VilleDTO> contHotelByville(Pageable pageable);
	public List<VilleDTO> contHotelByville();
	public List<ville> Lists(String mc);
	public int Statistique(int mc);
}
