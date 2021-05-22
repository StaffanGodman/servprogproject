package se.yrgo.service;
import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.*;

@Local
public interface RecordManagementServiceLocal {
	public void registerCollector(Collector collector);
	public void registerRecordRelease(RecordRelease recordRelease);
	public void registerRecordCopy(RecordCopy recordCopy);
	public List<Collector>getAllCollectors();
	public List<Collector>getCollectorByUserName(String userName);
	public List<RecordRelease>getAllRecordReleases();
	public List<RecordRelease>searchByGenre(String genre);
	public List<RecordCopy>getCopiesByCollector(Collector collector);
}
