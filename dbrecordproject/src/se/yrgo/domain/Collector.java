package se.yrgo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
public class Collector implements java.io.Serializable{
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 276229924330477340L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int collectorId; // primary key
	private String userName;
	//@Column(unique = true)
	private String email;
	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	private List<Record> ownedRecords;
	
	public Collector() {
		this.ownedRecords  = new ArrayList<Record>();
	}

	public Collector(String userName, String email) {
		this.userName = userName;
		this.email = email;
		this.ownedRecords = new ArrayList<Record>();
	}

	public int getCollectorId() {
		return collectorId;
	}

	public void setCollectorId(int collectorId) {
		this.collectorId = collectorId;
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

	public List<Record> getOwnedRecords() {
		return ownedRecords;
	}

	@Override
	public String toString() {
		return "Collector [collectorId=" + collectorId + ", userName=" + userName + ", email=" + email
				+ ", ownedRecords=" + ownedRecords + "]";
	}

	public void setOwnedRecords(List<Record> ownedRecords) {
		this.ownedRecords = ownedRecords;
	}
	
	public void addRecordToOwnedRecords(Record record) {
		this.ownedRecords.add(record);
	}
	
	public void removeFromOwnedRecords(Record record) {
		this.ownedRecords.remove(record);
	}

}

