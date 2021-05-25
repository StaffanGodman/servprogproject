package se.yrgo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RecordCopy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -414702750348484864L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int copyId; // primary key
	@ManyToOne
	@JoinColumn(name="COLLECTOR_FK", nullable=false)
	private Collector collector;
	@ManyToOne
	@JoinColumn(name="RECORDRELEASE_FK", nullable=false)
	RecordRelease recordRelease;
	public RecordCopy() {}
	

	public Collector getCollector() {
		return collector;
	}


	public void setCollector(Collector collector) {
		this.collector = collector;
	}


	public RecordRelease getRecordRelease() {
		return recordRelease;
	}


	public void setRecordRelease(RecordRelease recordRelease) {
		this.recordRelease = recordRelease;
	}


	public int getCopyId() {
		return this.copyId;
	}
	
	
}
