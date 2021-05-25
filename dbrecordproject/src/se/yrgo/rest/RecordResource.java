package se.yrgo.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import se.yrgo.domain.Record;
import se.yrgo.service.RecordManagementServiceLocal;

@Stateless
@Path("/record")
public class RecordResource {

	@Inject
	public RecordManagementServiceLocal service;
	
	@GET
	@Produces("application/JSON")
	public List<Record> getAllRecords() {
	       return service.getAllRecords();
	}
	
	@GET
	@Produces("application/JSON")
	@Path("{genre}")
	public List<Record> getRecordByGenre(@PathParam("genre")String genre) {
	       return service.getByGenre(genre);
	}
	
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Record createRecord(Record rr) {
		service.registerRecord(rr);
		return rr;
	}
	
	
}
