package com.ripple.trustline.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class OwnerProfile {
	
	@Id
	@NotBlank (message = "username cannot be null or blank")
	private String username;

	@Column(unique=true)
	@NotBlank (message = "password cannot be null or blank")
	private String password;

	
	@Column(unique=true)
	@NotBlank (message = "Name cannot be null or blank")
	private String name;

	@Column(unique=true)
	@NotBlank (message = "Family cannot be null or blank")
	private String family;

	@Column
	@Email(message = "Email should be valid")
	private String email;
	
	@Column
	@Pattern(regexp="(^$|[0-9]{10})", message= "phone should be number size 10")
	private String phone;

	@Column
	private int balance;
	
	@Column
	private String url;

	public OwnerProfile() {
		super();
	}

	public OwnerProfile(@NotBlank(message = "username cannot be null or blank") String username,
			@NotBlank(message = "password cannot be null or blank") String password,
			@NotBlank(message = "Name cannot be null or blank") String name,
			@NotBlank(message = "Family cannot be null or blank") String family,
			@Email(message = "Email should be valid") String email,
			@Pattern(regexp = "(^$|[0-9]{10})", message = "phone should be number size 10") String phone, int balance,
			String url) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.family = family;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "TrustLineOwnerProfile [username=" + username + ", password=" + password + ", name=" + name + ", family="
				+ family + ", email=" + email + ", phone=" + phone + ", balance=" + balance + ", url=" + url + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OwnerProfile other = (OwnerProfile) obj;
		if (balance != other.balance)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	

}
