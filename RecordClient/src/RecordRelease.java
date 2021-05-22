import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RecordRelease {

		private int releaseId; // primary key
		private String title;
		private String artist;
		private String serialNo; // candidate key
		private String genre;
		private int releaseYear;
		
		public RecordRelease() {}

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
	}

