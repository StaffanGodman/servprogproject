package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import se.yrgo.domain.Collector;
import se.yrgo.domain.Record;
import se.yrgo.service.RecordManagementServiceLocal;


@Stateless
@Path("/collectors")
public class CollectorResource {
	@Inject
	public RecordManagementServiceLocal service;
	
	@GET
	@Produces("application/JSON")
	public List<Collector> getAllCollectors() {
	       return service.getAllCollectors();
	}
	
	@GET
	@Produces("application/JSON")
	@Path("{userName}")
	public Collector findCollectorByUserName(@PathParam("userName")String userName) {
		return service.getCollectorByUserName(userName);
	}
	
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Collector createCollector(Collector collector) {
		service.registerCollector(collector);
		return collector;
	}
	@PUT
	@Produces("application/JSON")
	@Consumes("application/JSON")
	@Path("/{collectorID}")
	public Collector addRecordToCollector(@PathParam("collectorID") int id, Collector collector ) {
		service.updateCollector(id, collector);
		return collector;
	}
	
}
