package se.yrgo.service;
import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.*;

@Local
public interface RecordManagementServiceLocal {
	public void registerRecord(Record record);
	public void registerCollector(Collector collector);
	public List<Collector>getAllCollectors();
	public Collector getCollectorByUserName(String userName);
	public List<Record>getAllRecords();
	public List<Record>getByGenre(String genre);
	public List<Record>getRecordsByCollector(Collector collector);
	public void updateCollector(int id, Collector collector);
}
