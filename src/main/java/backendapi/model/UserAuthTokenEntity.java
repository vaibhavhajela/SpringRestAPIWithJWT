package backendapi.model;

import javax.persistence.*;

@Entity
@Table(name = "userauthtoken")
public class UserAuthTokenEntity {

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Id
	@Column(name = "username")
	private String username;

	@Lob
	@Column(name = "token")
	private String token;

	public UserAuthTokenEntity() {

	}

	public UserAuthTokenEntity(String username, String token) {
		this.username = username;
		this.token = token;
	}




}
