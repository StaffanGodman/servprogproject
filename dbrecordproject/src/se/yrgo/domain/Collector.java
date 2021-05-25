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
	@OneToMany(mappedBy="collector", cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	private List<RecordCopy> ownedCopies;
	
	public Collector() {
		this.ownedCopies  = new ArrayList<RecordCopy>();
	}

	public Collector(String userName, String email) {
		this.userName = userName;
		this.email = email;
		this.ownedCopies = new ArrayList<RecordCopy>();
	}

	public void setCollectorId(int collectorId) {
		this.collectorId = collectorId;
	}

	public void setOwnedCopies(List<RecordCopy> ownedCopies) {
		this.ownedCopies = ownedCopies;
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

	public List<RecordCopy> getOwnedCopies() {
		return Collections.unmodifiableList(ownedCopies);
	}
	
	public void addOwnedCopy(RecordCopy rc, RecordRelease rr) {
		rc.setCollector(this);
		rc.setRecordRelease(rr);
		this.ownedCopies.add(rc);
		rr.addCopies(rc);	
	}
	
	public void createAndAddOwnedCopy(RecordRelease rr) {
		RecordCopy rc = new RecordCopy();
		this.addOwnedCopy(rc, rr);
	}
}

