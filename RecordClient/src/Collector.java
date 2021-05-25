import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collector {

	private int collectorId; // primary key
	private String userName;
	private String email;
	private List<Record> ownedRecords;

	public Collector() {
		this.ownedRecords  = new ArrayList<Record>();
	}

	@Override
	public String toString() {
		return "Collector [collectorId=" + collectorId + ", userName=" + userName + ", email=" + email
				+ ", ownedRecords=" + ownedRecords + "]";
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
		return Collections.unmodifiableList(ownedRecords);
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
