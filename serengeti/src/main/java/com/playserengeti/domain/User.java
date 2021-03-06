package com.playserengeti.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A Serengeti user (player).
 */
public class User {
	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"MMM dd, yyyy hh:mma");

	private Integer id;
	private String email;
	private String firstName;
	private String lastName;
	private String avatarFileSuffix;
	private Date dateCreated;

	public User() {
	}

	public User(Integer id, String email, String firstName, String lastName,
			Date dateCreated) {
		setId(id);
		setEmail(email);
		setFirstName(firstName);
		setLastName(lastName);
		setDateCreated(dateCreated);
	}

	public User(String email, String firstName, String lastName) {
		this(null, email, firstName, lastName, null);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getAvatarFileSuffix() {
		return avatarFileSuffix;
	}

	public void setAvatarFileSuffix(String avatarFileSuffix) {
		this.avatarFileSuffix = avatarFileSuffix;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * Returns the user as a JSON string with all properties.
	 * Escapes quotations to prevent parse errors.
	 * 
	 * @return
	 */
	public String asJSON() {
		return "{\"id\" : \"" + this.id 
		        + "\", \"email\" : \"" + this.email.replace("\"", "&#34") 
		        + "\", \"name\" : \"" + this.firstName.replace("\"", "&#34") 
		          + " " + this.lastName.replace("\"", "&#34")
				+ "\", \"dateCreated\" : \"" + sdf.format(this.dateCreated) + "\"}";
	}

	/**
	 * Returns the user as a JSON string with minimal information.
	 * Escapes quotations to prevent parse errors.
	 * 
	 * @return
	 */
	public String asMinimalJSON() {
		return "{\"id\" : \"" + this.id 
		        + "\", \"name\" : \"" + this.firstName.replace("\"", "&#34") 
		          + " "	+ this.lastName.replace("\"", "&#34") + "\"}";
	}

	@Override
	public int hashCode() {
		return (id == null) ? 0 : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		User other = (User) obj;
		if (id == null && other.id == null) {
			return true;
		}
		return (id == null) ? false : id.equals(other.id);
	}

}
