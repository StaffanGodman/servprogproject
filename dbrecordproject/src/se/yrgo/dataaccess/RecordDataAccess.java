package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.*;

@Local
public interface RecordDataAccess {
	public void insertRecordRelease(RecordRelease recordRelease);
	public void insertCollector(Collector collector);
	public void insertRecordCopy(RecordCopy recordCopy);
	public List<Collector>findAllCollectors();
	public List<Collector> findCollectorByUserName(String userName);
	public List<RecordRelease>findAllRecordReleases();
	public List<RecordRelease>findByGenre(String genre);
	public List<RecordCopy>findCopiesByCollector(Collector collector);
}
