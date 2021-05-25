package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
	
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public RecordCopy createRecordCopy(RecordCopy recordCopy) {
		service.registerRecordCopy(recordCopy);
		return recordCopy;
	}
	
	@GET
	@Produces("application/JSON")
	@Path("{collector}")
	public List<RecordCopy> findRecordCopyByCollector(@PathParam("collector") Collector collector) {
		return service.getCopiesByCollector(collector);
	}
	
	
}
