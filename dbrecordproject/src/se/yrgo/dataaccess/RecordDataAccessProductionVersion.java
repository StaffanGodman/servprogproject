package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import se.yrgo.domain.Collector;
import se.yrgo.domain.RecordCopy;
import se.yrgo.domain.RecordRelease;

@Stateless
@Default
@ProductionDao
public class RecordDataAccessProductionVersion implements RecordDataAccess {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insertRecordRelease(RecordRelease recordRelease) {
		em.persist(recordRelease);
		
	}

	@Override
	public void insertCollector(Collector collector) {
		em.persist(collector);
		
	}

	@Override
	public void insertRecordCopy(RecordCopy recordCopy) {
		//em.persist(recordCopy);
		String userName = recordCopy.getCollector().getUserName();
		Collector c = this.findCollectorByUserName(userName);
		
		String serialNo = recordCopy.getRecordRelease().getSerialNo();
		RecordRelease rr = (RecordRelease)em.createQuery("select recordrelease from RecordRelease recordrelease where recordrelease.serialNo= :serialNo")
		.setParameter("serialNo", serialNo);
		em.refresh(rr);
		em.refresh(c);
		c.createAndAddOwnedCopy(rr);
		
	}

	@Override
	public List<Collector> findAllCollectors() {
		Query q = em.createQuery("select collector from Collector collector");
		List<Collector> collectors = q.getResultList();
		return collectors;
	}
	
	@Override
	public Collector findCollectorByUserName(String userName) {
		Query q = em.createQuery("select collector from Collector collector where collector.userName= :username");
		q.setParameter("username", userName);
		return (Collector)q.getSingleResult();
	}

	@Override
	public List<RecordRelease> findAllRecordReleases() {
		Query q = em.createQuery("select recordrelease from RecordRelease recordrelease");
		List<RecordRelease> recordreleases = q.getResultList();
		return recordreleases;
	}

	@Override
	public List<RecordRelease> findByGenre(String genre) {
		Query q = em.createQuery("select recordrelease from RecordRelease recordrelease where recordrelease.genre= :genre");
		q.setParameter("genre", genre);
		List<RecordRelease> recordreleases = q.getResultList();
		return recordreleases;
	}

	@Override
	public List<RecordCopy> findCopiesByCollector(Collector collector) {
		Query q = em.createQuery("select recordcopy from RecordCopy recordcopy where recordcopy.collectorId= :collectorId");
		q.setParameter("collectorId", collector.getCollectorId());
		List<RecordCopy> recordcopies = q.getResultList();
		return recordcopies;
	}

}
