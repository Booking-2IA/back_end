package prj.IIA.BD.DTO;


public class UserDto{
        Long id;
        String email;
        String mot_passe;
        
		public UserDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		public UserDto(String email, String mot_passe) {
			super();
			this.email = email;
			this.mot_passe = mot_passe;
		}
		public UserDto(Long id, String email, String mot_passe, String token) {
			super();
			this.id = id;
			this.email = email;
			this.mot_passe = mot_passe;
			
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMot_passe() {
			return mot_passe;
		}
		public void setMot_passe(String mot_passe) {
			this.mot_passe = mot_passe;
		}
		
}
