package prj.IIA.BD.entites;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Review implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
  
    private boolean link;
    private boolean DisLike;
    private String opinion;
    private String image;
    private Date dateAndTime;
    @ManyToOne
	@JoinColumn(name="CODE_CL")
	private usere client;
    
    @ManyToOne
	@JoinColumn(name="CODE_H")
	private Hotels hotel;
    
    //private Emoji emoji;


    @JsonIgnore
    public Hotels getHotel() {
		return hotel;
	}


	

	@JsonSetter
	public void setHotel(Hotels hotel) {
		this.hotel = hotel;
	}


	public boolean isLink() {
		return link;
	}


	public void setLink(boolean link) {
		this.link = link;
	}


	public boolean isDisLike() {
		return DisLike;
	}


	public void setDisLike(boolean disLike) {
		DisLike = disLike;
	}




    public Review() {
    }


  
    

    

    public void setId(Long id) {
		this.id = id;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}



   
    public String getOpinion() {
        return this.opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDateAndTime() {
        return this.dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }


   
	public usere getClient() {
		return client;
	}


   
	public void setClient(usere client) {
		this.client = client;
	}





	

	public Review(long id, boolean link, boolean disLike, String opinion, String image, Date dateAndTime, usere client,
			Hotels hotel) {
		super();
		this.id = id;
		this.link = link;
		DisLike = disLike;
		this.opinion = opinion;
		this.image = image;
		this.dateAndTime = dateAndTime;
		this.client = client;
		this.hotel = hotel;
	}


	/*public Emoji getEmoji() {
		return emoji;
	}


	public void setEmoji(Emoji emoji) {
		this.emoji = emoji;
	}*/
    

   /* public Map< Emoji, Integer> reactionStatistics(){
        Map< Emoji, Integer> statistics = new HashMap< Emoji, Integer>();
        for( Emoji emoji: Emoji.values()){
            statistics.put( emoji, ReactionDAO.getReviewReactionCount( reviewId, emoji));
        }
        return statistics;
    }

    public int reactionCount(){
        return ReactionDAO.getReviewReactionCount( reviewId);
    }
*/
	
    
}
