package MovieManager.ch.hearc.ig.odi.moviemanager.business;

import java.util.*;

public class Person {

	private Collection<Movie> movies;
	private Long id;
	private String firstName;
	private String lastName;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}