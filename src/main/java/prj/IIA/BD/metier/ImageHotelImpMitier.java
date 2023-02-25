package prj.IIA.BD.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prj.IIA.BD.DTO.ImageHotelDTO;
import prj.IIA.BD.dao.ImageReposetory;
import prj.IIA.BD.entites.ListImageHotel;
@Service
@Transactional
public class ImageHotelImpMitier implements ImageHotelMitier{

	@Autowired
	private ImageReposetory imageReposetory;
	
	@Override
	public ListImageHotel save(ListImageHotel i) {
		// TODO Auto-generated method stub
		return imageReposetory.save(i);
	}

	@Override
	public Page<ListImageHotel> ListImageByHotel(Long mc, Pageable pageable) {
		// TODO Auto-generated method stub
		return imageReposetory.ListImageByHotel(mc, pageable);
	}

	@Override
	public ImageHotelDTO ImagePlusNomberImageByHotel(long id) {
		// TODO Auto-generated method stub
		ImageHotelDTO IDTO=new ImageHotelDTO();
		if(imageReposetory.ListALLImageByHotel(id).size()>0) {
		IDTO.setImage(imageReposetory.ListALLImageByHotel(id).get(0).getImage());}
		else {
			IDTO.setImage("");
		}
		IDTO.setTotalImage(imageReposetory.NomberImageByHotel(id));
		return IDTO;
	}

	@Override
	public int NomberImageByHotel(long id) {
		// TODO Auto-generated method stub
		return imageReposetory.nomberImageByhotel(id);
	}

	@Override
	public List<ListImageHotel> ListAllImageByhotel(long id) {
		// TODO Auto-generated method stub
		return imageReposetory.ListALLImageByHotel(id);
	}

}
