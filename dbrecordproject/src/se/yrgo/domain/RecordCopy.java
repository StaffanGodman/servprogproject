package se.yrgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecordCopy {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int copyId; // primary key
	private int releaseId; // foreign key
	private int collectorId; // foreign key
	
	public RecordCopy() {}
}
