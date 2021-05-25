
public class RecordCopy {
	private int copyId; // primary key
	private Collector collector;
	private RecordRelease recordRelease;

	public Collector getCollector() {
		return collector;
	}


	public RecordRelease getRecordRelease() {
		return recordRelease;
	}


	public void setCollector(Collector collector) {
		this.collector = collector;
	}


	public void setRecordRelease(RecordRelease recordRelease) {
		this.recordRelease = recordRelease;
	}


	public RecordCopy() {}
	

	public int getCopyId() {
		return this.copyId;
	}
	

}
