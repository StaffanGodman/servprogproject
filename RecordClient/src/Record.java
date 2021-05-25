
public class Record {

	private int recordId; // primary key
	private String title;
	private String artist;
	private String genre;
	
	public int getrecordId() {
		return recordId;
	}
	public void setrecordId(int recordId) {
		this.recordId = recordId;
	}
	@Override
	public String toString() {
		return "Record [recordId=" + recordId + ", title=" + title + ", artist=" + artist + ", genre=" + genre + "]";
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

}
