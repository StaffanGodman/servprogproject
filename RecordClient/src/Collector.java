
public class Collector {

	private int collectorId; // primary key
	private String userName;
	private String email;

	public Collector() {}
	
	public Collector(String userName, String email) {
		this.userName = userName;
		this.email = email;
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
		return "Collector [collectorId=" + collectorId + ", userName=" + userName + ", email=" + email + "]";
	}
	
}
