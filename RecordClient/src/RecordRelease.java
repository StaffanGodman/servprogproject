import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RecordRelease {

		private int releaseId; // primary key
		private String title;
		private String artist;
		private String serialNo; // candidate key
		private String genre;
		private int releaseYear;
		private List<RecordCopy> copies ;
		
		public RecordRelease() {
			this.copies = new ArrayList<RecordCopy>();
		}

		public RecordRelease(String title, String artist, String serialNo, String genre, int releaseYear) {
			super();
			this.title = title;
			this.artist = artist;
			this.serialNo = serialNo;
			this.genre = genre;
			this.releaseYear = releaseYear;
			this.copies  = new ArrayList<RecordCopy>();
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

		public String getSerialNo() {
			return serialNo;
		}

		public void setSerialNo(String serialNo) {
			this.serialNo = serialNo;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public int getReleaseYear() {
			return releaseYear;
		}

		public void setReleaseYear(int releaseYear) {
			this.releaseYear = releaseYear;
		}

		public int getReleaseId() {
			return releaseId;
		}
		public void setReleaseId(int rr) {
			this.releaseId = rr;
		}
		
		public List<RecordCopy> getCopies() {
			return Collections.unmodifiableList(copies);
		}
		public void addCopies(RecordCopy recordcopy) {
			this.copies.add(recordcopy);
		}
	}

