package spittr.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Spitter", uniqueConstraints = {
		@UniqueConstraint(name = "username", columnNames = {"username"}),
		@UniqueConstraint(name = "email", columnNames = {"email"})
})
@AttributeOverride(name = "id", column = @Column(name = "SpitterId"))
public class Spitter extends DateAuditedEntity{
	
	private String fullName;
    private String username;
    private String password;        	
	private String email;		
	private boolean updateByEmail;
	private String role;
				
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
		
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/* for serialization */
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	/* for de-serialization */
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonIgnore
	public String getEmail() {
		return email;
	}

	@JsonProperty
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonIgnore
	public boolean isUpdateByEmail() {
		return updateByEmail;
	}

	public void setUpdateByEmail(boolean updateByEmail) {
		this.updateByEmail = updateByEmail;
	}
}
