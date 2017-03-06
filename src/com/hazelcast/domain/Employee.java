package com.hazelcast.domain;

import java.io.Serializable;

/**
 * 
 * @author bhawani.singh
 *
 */
public class Employee implements Serializable {

	private Integer id;
	private String name;
	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
