import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collector {

	private int collectorId; // primary key
	private String userName;
	private String email;
	private List<RecordCopy> ownedCopies;

	public Collector() {
		this.ownedCopies  = new ArrayList<RecordCopy>();
	}
	
	public Collector(String userName, String email) {
		this.userName = userName;
		this.email = email;
		this.ownedCopies  = new ArrayList<RecordCopy>();
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

	public int getCollectorId() {
		return collectorId;
	}

	
	
	@Override
	public String toString() {
		return "Collector [collectorId=" + collectorId + ", userName=" + userName + ", email=" + email
				+ ", ownedCopies=" + ownedCopies + "]";
	}

	public void addOwnedCopy(RecordCopy rc , RecordRelease rr) {
		rc.setCollector(this);
		rc.setRecordRelease(rr);
		this.ownedCopies.add(rc);
		rr.addCopies(rc);
	}
	
	public void createAndAddOwnedCopy(RecordRelease rr) {
		RecordCopy rc = new RecordCopy();
		this.addOwnedCopy(rc, rr);
	}
	
	public List<RecordCopy> getOwnedCopies() {
		return Collections.unmodifiableList(ownedCopies);
	}
	
}
