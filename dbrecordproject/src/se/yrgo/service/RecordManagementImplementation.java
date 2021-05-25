package se.yrgo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.yrgo.dataaccess.RecordDataAccess;

import se.yrgo.domain.Collector;
import se.yrgo.domain.Record;

@Stateless
public class RecordManagementImplementation implements RecordManagementService, RecordManagementServiceLocal {

	@Inject
	private RecordDataAccess dao;

	@Override
	public void registerRecord(Record record) {
		dao.insertRecord(record);
		
	}

	@Override
	public void registerCollector(Collector collector) {
		dao.insertCollector(collector);
		
	}

	@Override
	public List<Collector> getAllCollectors() {
		return dao.findAllCollectors();
	
	}

	@Override
	public Collector getCollectorByUserName(String userName) {
		
		return dao.findCollectorByUserName(userName);
	}

	@Override
	public List<Record> getAllRecords() {
		
		return dao.findAllRecords();
	}

	@Override
	public List<Record> getByGenre(String genre) {
		return dao.findByGenre(genre);
	}

	@Override
	public List<Record> getRecordsByCollector(Collector collector) {
		return dao.findRecordsByCollector(collector);
	}

	@Override
	public void updateCollector(int id, Collector collector) {
		dao.updateCollector(id, collector);
		
	}

	@Override
	public Record doDeleteRecord(int id) {
		return dao.deleteRecord(id);
	}

}
