package se.yrgo.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import se.yrgo.domain.Collector;
import se.yrgo.domain.Record;

@Stateless
@Default
public class RecordDataAccessProductionVersion implements RecordDataAccess {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void insertRecord(Record record) {
		em.persist(record);
		
	}

	@Override
	public void insertCollector(Collector collector) {
		em.persist(collector);
		
	}

	@Override
	public List<Collector> findAllCollectors() {
		Query q = em.createQuery("select collector from Collector collector");
		return q.getResultList();
	}

	@Override
	public Collector findCollectorByUserName(String userName) {
		Query q = em.createQuery("select collector from Collector collector where collector.userName= :username");
		q.setParameter("username", userName);
		return (Collector) q.getSingleResult();
	}

	@Override
	public List<Record> findAllRecords() {
		Query q = em.createQuery("select record from Record record");
		return q.getResultList();
	}

	@Override
	public List<Record> findByGenre(String genre) {
		Query q = em.createQuery("select record from Record record where record.genre= :genre");
		q.setParameter("genre", genre);
		return q.getResultList();
	}

	@Override
	public List<Record> findRecordsByCollector(Collector collector) {
		int id = collector.getCollectorId();
		Query q = em.createQuery("select collector.ownedRecords from Collector collector where collector.collectorId= :id");
		q.setParameter("id", id);
		return q.getResultList();
	}

	@Override
	public void updateCollector(int id, Collector collector) {
		List<Record> records = collector.getOwnedRecords();
		Collector c = (Collector)em.createQuery("from Collector collector where collector.collectorId= :id")
				.setParameter("id", id).getSingleResult();
		c.setOwnedRecords(collector.getOwnedRecords());
		em.flush();		
	}

	@Override
	public Record deleteRecord(int id) {
		Record r = (Record) em.createQuery("select record from Record record where record.recordId = :id")
				.setParameter("id", id).getSingleResult();
		TypedQuery<Collector> query =  em.createQuery("from Collector collector where :record member of"
				+ " collector.ownedRecords", Collector.class).setParameter("record", r);
		List<Collector> collectors = query.getResultList();
		for (Collector c : collectors) {
			c.removeFromOwnedRecords(r);
		}
		em.flush();
		em.remove(r);
		return r;
		
	}
	
}
