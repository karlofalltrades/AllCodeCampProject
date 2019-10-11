package com.techprimers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private long id;
    
    @Column(name="firstname")
    private String firstName;

	@Column(name="lastname")
    private String lastName;
    
    @Column(name="occupation")
    private String occupation;
    
    @Column(name="profile_picture")
    private String profile_picture;
    
    public User() {}
    
    public User(String firstName, String lastName, String occupation, String profile_picture) {
    	this.firstName=firstName;
    	this.lastName=lastName;
    	this.occupation=occupation;
    	this.profile_picture=profile_picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}

}
