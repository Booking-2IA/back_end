package prj.IIA.BD.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import prj.IIA.BD.DTO.ReviewLikeDiscountDTO;
import prj.IIA.BD.entites.Review;
import prj.IIA.BD.entites.usere;
import prj.IIA.BD.metier.ReviewMitier;
import prj.IIA.BD.metier.UserMetier;
@RestController
@RequestMapping("/api/Review")
@CrossOrigin("*")
public class ReviewService {

	
	@Autowired
	private ReviewMitier mitier;
	@Autowired
	private UserMetier usemitier;
	@GetMapping("/countLikeandDisLink/{id}")
	public ResponseEntity<ReviewLikeDiscountDTO> countLikeandDisLink(@PathVariable long id){
		ReviewLikeDiscountDTO R=new ReviewLikeDiscountDTO();
		R.setCountdislike(mitier.countDisLink(id));
		R.setCountLike(mitier.countLike(id));
		return new ResponseEntity<>(R, HttpStatus.CREATED);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Review> save(@ModelAttribute Review r){
		/*if(r.getClient()!=null) {
			usere c=new usere();
			c=usemitier.saveclient(c);
			r.setClient(c);
		}*/
		//return new ResponseEntity<>(r, HttpStatus.CREATED);
		
		return new ResponseEntity<>(mitier.save(r), HttpStatus.CREATED);
	}
	@PostMapping("/saveLike")
	public ResponseEntity<Review> saveLike(@ModelAttribute Review r){
		Review r1;
		if(mitier.findByidClientandidHotel(r.getClient().getId(), r.getHotel().getId())!=null) {
		 r1=mitier.findByidClientandidHotel(r.getClient().getId(), r.getHotel().getId());
		
		r1.setLink(r.isLink());
		r1.setDisLike(r.isDisLike());}
		r1=r;
		return new ResponseEntity<>(mitier.save(r1), HttpStatus.CREATED);
	}
	
	@GetMapping("/List/{id}")
      public ResponseEntity<Page<Review>> save(@PathVariable long id,
    		  
    		  @RequestParam(name="page",defaultValue="0") int page,
  			@RequestParam(name="size",defaultValue="5") int size){
		
		return new ResponseEntity<>(mitier.ListReviw(id,PageRequest.of(page, size)), HttpStatus.CREATED);
	}
	
}
