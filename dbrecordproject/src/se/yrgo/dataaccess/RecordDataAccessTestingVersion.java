package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import se.yrgo.domain.Collector;
import se.yrgo.domain.RecordCopy;
import se.yrgo.domain.RecordRelease;

@Stateless
// @Alternative
@TestingDao
public class RecordDataAccessTestingVersion implements RecordDataAccess {

	@Override
	public void insertRecordRelease(RecordRelease recordRelease) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertCollector(Collector collector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertRecordCopy(RecordCopy recordCopy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Collector> findAllCollectors() {
		Collector col1 = new Collector("Staffan", "staffan@mail.com");
		Collector col2 = new Collector("Adrian", "adde@mail.com");
		Collector col3 = new Collector("Björn", "bjorn@mail.com");
		List<Collector>collectors = new ArrayList<>();
		collectors.add(col1);
		collectors.add(col2);
		collectors.add(col3);
		return collectors;
	}

	@Override
	public List<RecordRelease> findAllRecordReleases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordRelease> findByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordCopy> findCopiesByCollector(Collector collector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Collector> findCollectorByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
