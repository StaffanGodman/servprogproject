package se.yrgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Record {
	@Override
	public String toString() {
		return "Record [recordId=" + recordId + ", title=" + title + ", artist=" + artist + ", genre=" + genre + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int recordId; // primary key
	private String title;
	private String artist;
	
	public int getrecordId() {
		return recordId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	private String genre;
}
