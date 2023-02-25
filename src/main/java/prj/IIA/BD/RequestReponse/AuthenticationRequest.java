package prj.IIA.BD.RequestReponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

  private String username;
  String password;
public AuthenticationRequest() {
	super();
	// TODO Auto-generated constructor stub
}


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


public AuthenticationRequest(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}
  
}