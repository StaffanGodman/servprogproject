package se.yrgo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Collector implements java.io.Serializable{
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int collectorId; // primary key
	private String userName;
	@Column(unique = true)
	private String email;
	
	public Collector() {}

	public Collector(String userName, String email) {
		this.userName = userName;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCollectorId() {
		return collectorId;
	}

	@Override
	public String toString() {
		return "Collector [collectorId=" + collectorId + ", userName=" + userName + ", email=" + email + "]";
	}
	
	private static final long serialVersionUID = 1L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	
}
