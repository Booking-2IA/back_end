package prj.IIA.BD.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prj.IIA.BD.entites.PromoTion;
import prj.IIA.BD.metier.PromotionMetier;

@RestController
@RequestMapping("/api/Promotion")
@CrossOrigin("*")
public class PromotionService {

	@Autowired
	private PromotionMetier metier;
	
	@PostMapping("/save")
	public ResponseEntity<PromoTion> save(@ModelAttribute PromoTion P){
		return ResponseEntity.ok(metier.save(P));
	}
	@GetMapping("ListByHotel/{id}")
	public ResponseEntity<List<PromoTion>> ListPromotionByHotel(@PathVariable long id){
		return new ResponseEntity<>(metier.ListByHotel(id), HttpStatus.OK);
	}
	@GetMapping("TopDeuxPromotion")
	public ResponseEntity<List<PromoTion>> TopDeuxPromotion(){
		return new ResponseEntity<>(metier.Topdeuxpromotion(), HttpStatus.OK);
	}
	@GetMapping("PromotionHotel/{id}")
	public ResponseEntity<PromoTion> promotionHotel(@PathVariable long id){
		return new ResponseEntity<>(metier.promotionHotel(id), HttpStatus.OK);
	}
	@GetMapping("ListALL")
	public ResponseEntity<List<PromoTion>> ListPromotionALL(){
		return new ResponseEntity<>(metier.ListPromotion(), HttpStatus.OK);
	}
}
