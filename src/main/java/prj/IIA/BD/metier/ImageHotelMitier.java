package prj.IIA.BD.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import prj.IIA.BD.DTO.ImageHotelDTO;
import prj.IIA.BD.entites.ListImageHotel;

public interface ImageHotelMitier {

	public ListImageHotel save(ListImageHotel i);
	public Page<ListImageHotel> ListImageByHotel(Long mc,Pageable pageable);
    public ImageHotelDTO ImagePlusNomberImageByHotel(long id);
    public int NomberImageByHotel(long id);
    public List<ListImageHotel> ListAllImageByhotel(long id);
	
}
