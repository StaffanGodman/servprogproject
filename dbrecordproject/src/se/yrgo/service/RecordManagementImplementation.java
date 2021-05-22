package se.yrgo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import se.yrgo.dataaccess.ProductionDao;
import se.yrgo.dataaccess.RecordDataAccess;
import se.yrgo.dataaccess.TestingDao;
import se.yrgo.domain.Collector;
import se.yrgo.domain.RecordCopy;
import se.yrgo.domain.RecordRelease;

@Stateless
public class RecordManagementImplementation implements RecordManagementService, RecordManagementServiceLocal {

	@Inject
	@ProductionDao
	private RecordDataAccess dao;
	
	@Override
	public void registerCollector(Collector collector) {
		dao.insertCollector(collector);
	}

	@Override
	public void registerRecordRelease(RecordRelease recordRelease) {
		dao.insertRecordRelease(recordRelease);
		
	}

	@Override
	public void registerRecordCopy(RecordCopy recordCopy) {
		dao.insertRecordCopy(recordCopy);
		
	}

	@Override
	public List<Collector> getAllCollectors() {
		return dao.findAllCollectors();
	}

	@Override
	public List<RecordRelease> getAllRecordReleases() {
		return dao.findAllRecordReleases();
	}

	@Override
	public List<RecordRelease> searchByGenre(String genre) {
		return dao.findByGenre(genre);
	}

	@Override
	public List<RecordCopy> getCopiesByCollector(Collector collector) {
		return dao.findCopiesByCollector(collector);
	}

	@Override
	public List<Collector> getCollectorByUserName(String userName) {
		return dao.findCollectorByUserName(userName);
	}

}
