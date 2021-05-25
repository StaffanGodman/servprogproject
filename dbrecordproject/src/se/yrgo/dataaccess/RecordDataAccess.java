package se.yrgo.dataaccess;

import java.util.List;

import javax.ejb.Local;

import se.yrgo.domain.*;

@Local
public interface RecordDataAccess {
	public void insertRecord(Record record);
	public void insertCollector(Collector collector);
	public List<Collector>findAllCollectors();
	public Collector findCollectorByUserName(String userName);
	public List<Record>findAllRecords();
	public List<Record>findByGenre(String genre);
	public List<Record>findRecordsByCollector(Collector collector);
	public void updateCollector(int id, Collector collector);
}
