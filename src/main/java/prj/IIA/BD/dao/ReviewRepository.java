package prj.IIA.BD.dao;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import prj.IIA.BD.entites.Hotels;
import prj.IIA.BD.entites.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
      
	/*@Query("select r from Reaction r where r.reviewId =:x")
	ArrayList< Reaction> getReviewReactions(@Param("x") Long reviewId);
	
	
	@Query(" select count( *) as num from Reaction where reviewId = :x and emoji = :y")
	int getReviewReactionCount(@Param("x") int reviewId,@Param("y") Emoji emoji);
 
	@Query(" select count( *) as num from Reaction where reviewId = :x")
	int getReviewReactionCount(@Param("x") Long reviewId);
  */
	/*@Query("select v as num from Review v")
	public Page<Review> ListPage(@Param("x") Long HotelId,Pageable pageable);
	*/
	@Query("select h from Review h  where h.hotel.id = :x")
	public Page<Review> ListReviw(@Param("x") long id,Pageable pageable);
	
	@Query("select count(*) from Review h  where h.link = true")
	public int countLike(@Param("x") long id);
	
	@Query("select count(*) from Review h  where h.DisLike = true and h.hotel.id =:x")
	public int countDisLike(@Param("x") long id);
	
	@Query("select h from Review h  where h.client.id =:x and h.hotel.id =:y")
	public Review findbyidclientandhotel(@Param("x") long idc,@Param("y") long idH);
	
}
