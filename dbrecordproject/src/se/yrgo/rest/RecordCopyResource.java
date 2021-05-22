package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import se.yrgo.domain.Collector;
import se.yrgo.domain.RecordCopy;
import se.yrgo.service.RecordManagementServiceLocal;

@Stateless
@Path("/recordcopy")
public class RecordCopyResource {
	
	@Inject
	public RecordManagementServiceLocal service;
	
	@GET
	@Produces("application/JSON")
	public void createRecordCopy(RecordCopy recordCopy) {
		service.registerRecordCopy(recordCopy);
	}
	
	@GET
	@Produces("application/JSON")
	public List<RecordCopy> findRecordCopyByCollector(Collector collector) {
		return service.getCopiesByCollector(collector);
	}
	
	
}
