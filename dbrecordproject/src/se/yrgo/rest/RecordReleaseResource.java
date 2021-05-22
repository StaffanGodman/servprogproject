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


import se.yrgo.domain.RecordRelease;
import se.yrgo.service.RecordManagementServiceLocal;

@Stateless
@Path("/recordrelease")
public class RecordReleaseResource {

	@Inject
	public RecordManagementServiceLocal service;
	
	@GET
	@Produces("application/JSON")
	public List<RecordRelease> getAllRecordReleases() {
	       return service.getAllRecordReleases();
	}
	
	@GET
	@Produces("application/JSON")
	@Path("{genre}")
	public List<RecordRelease> getRecordReleaseByGenre(@PathParam("genre")String genre) {
	       return service.searchByGenre(genre);
	}
	
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public RecordRelease createRecord(RecordRelease rr) {
		service.registerRecordRelease(rr);
		return rr;
	}
	
	
}
