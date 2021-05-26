import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

public class RecordClient {

    public static void main(String[] args) {
	Client client = ClientBuilder.newClient();
	Response response;
////-------------- Run this code to show all collectors ----------------------------
//	response = client.target("http://localhost:8080/RecordManagement/webservice/collectors").request().buildGet().invoke();
//	System.out.println("All collectors in the database:");
//	List<Collector> allCollectors = response.readEntity(new GenericType<List<Collector>>() {});
//  for (Collector c : allCollectors) {
//	  System.out.println(c);
//	  }
//      response.close();
////--------------- Show all records ---------------------------------------------
//	System.out.println("All records in the database");
//	response = client.target("http://localhost:8080/RecordManagement/webservice/records").request().buildGet().invoke();
//	List<Record> allRecords = response.readEntity(new GenericType<List<Record>>() {});
//  for (Record r : allRecords) {
//	  System.out.println(r);
//	  }
//      response.close();
////-------------	Run this code once to insert example data into the database ------------------
//      List<Record> exampleRecords = new ArrayList<>(); 
//      exampleRecords.add(createExampleRecord("Vangelis", "Albedo 0.39", "Elektroniskt"));
//      exampleRecords.add(createExampleRecord("The Byrds", "Sweetheart of the rodeo", "Country"));
//      exampleRecords.add(createExampleRecord("Blue Oyster cult", "Spectres", "Rock"));
//      exampleRecords.add(createExampleRecord("Fleetwood Mac", "Rumours", "Pop"));
//      addExampleCollector("Staffan", "staffan@mail.com", exampleRecords);
//      exampleRecords.clear();
//      exampleRecords.add(createExampleRecord("Beach Boys", "Pet Sounds", "Pop"));
//      exampleRecords.add(createExampleRecord("Neil Young", "Trans", "Rock"));
//      exampleRecords.add(createExampleRecord("Smokey Robinson & The Miracles", "Going To A Gogo", "Soul"));
//      exampleRecords.add(createExampleRecord("N.W.A.", "Straight Outta Compton ", "Hip-Hop"));
//      addExampleCollector("Björn", "bjorn@mail.com", exampleRecords);
//      exampleRecords.clear();
//      exampleRecords.add(createExampleRecord("Enigma", "The cross of changes", "New age"));
//      exampleRecords.add(createExampleRecord("Fugees", "The Score", "Hip-Hop"));
//      exampleRecords.add(createExampleRecord("The Cure", "Disintegration", "Pop"));
//      exampleRecords.add(createExampleRecord("Brian Eno", "Tubular Bells", "Ambient"));
//      addExampleCollector("Adrian", "adrian@mail.com", exampleRecords);
//      exampleRecords.clear();
//      exampleRecords.add(createExampleRecord("Pink Floyd", "Pulse", "Rock"));
//      exampleRecords.add(createExampleRecord("New Order", "Brotherhood", "Pop"));
//      exampleRecords.add(createExampleRecord("The Cure", "Love Cats", "Pop"));
//      exampleRecords.add(createExampleRecord("Kraftwerk", "Autobahn", "Elektroniskt"));
//      addExampleCollector("Nahid", "nahid@mail.com", exampleRecords);
//      exampleRecords.clear();
// ------------------------------Find all pop records---------------     
      response = client.target("http://localhost:8080/RecordManagement/webservice/record/Pop").request().buildGet().invoke();
    	List<Record> popRecords = response.readEntity(new GenericType<List<Record>>() {});
      for (Record c : popRecords) {
  	  System.out.println(c);
    }
    response.close();
//// ------------------------------Find all rock records---------------     
//      response = client.target("http://localhost:8080/RecordManagement/webservice/records/Rock").request().buildGet().invoke();
//    	List<Record> rockRecords = response.readEntity(new GenericType<List<Record>>() {});
//      System.out.println("All rock records in the collection:");
//    	for (Record r : rockRecords) {
//  	  System.out.println(r);
//    }
//    response.close();
////------------------------- Add record to collector-------------------------------------
//	System.out.println("Adding record to Nahid");
//	 response = client.target("http://localhost:8080/RecordManagement/webservice/collectors/Nahid").request().buildGet().invoke();
//	 Collector putCollector = response.readEntity(Collector.class);
//	 System.out.println(putCollector.toString());
//	 response.close();
//	 int putId = putCollector.getCollectorId();
//	 Record putRecord = new Record();
//	 putRecord.setArtist("Stelly Dan");
//	 putRecord.setTitle("Reelin' in the years");
//	 putRecord.setGenre("Rock");
//	 putCollector.addRecordToOwnedRecords(putRecord);
//	 Entity<Collector> nahidEntity = Entity.entity(putCollector, "application/JSON");
//	 response = client.target("http://localhost:8080/RecordManagement/webservice/collectors/"+putId).request().buildPut(nahidEntity).invoke();
//	 response.close();
//	 response = client.target("http://localhost:8080/RecordManagement/webservice/collectors/Nahid").request().buildGet().invoke();
//	 putCollector = response.readEntity(Collector.class);
//	 System.out.println(putCollector.toString());
//	 response.close();
//--------------------------- Delete a record from database --------------------
//	 System.out.println("Deleting record from database");
//	 response = client.target("http://localhost:8080/RecordManagement/webservice/records/31").request().buildDelete().invoke();
//	 response.close();
//	 response = client.target("http://localhost:8080/RecordManagement/webservice/collectors/Nahid").request().buildGet().invoke();
//	 Collector putCollector = response.readEntity(Collector.class);
//	 System.out.println(putCollector.toString());
//	 response.close();
////

    
    	public static void addExampleCollector(String userName, String email, List<Record> ownedRecords) {
    	Collector newCollector = new Collector();
        newCollector.setUserName(userName);
        newCollector.setEmail(email);
        newCollector.setOwnedRecords(ownedRecords);
        Client client = ClientBuilder.newClient();
    	WebTarget target = client.target("http://localhost:8080/RecordManagement/webservice/collectors");
    	Invocation invocation = target.request().buildGet();
        //Response response = invocation.invoke();
        Entity<Collector> newCollectorEntity = Entity.entity(newCollector, "application/JSON");
        Response response = client.target("http://localhost:8080/RecordManagement/webservice/collectors").request().buildPost(newCollectorEntity).invoke();
//        System.out.println("Added user: " + response.readEntity(Collector.class).getUserName() + 
//        		" with email " + response.readEntity(Collector.class).getUserName() + "to Collector"); 
        response.close();
    }
    	
    	public static Record createExampleRecord(String artist, String title, String genre) {
    		 Record newRecord = new Record();
    	      newRecord.setTitle(title);
    	      newRecord.setArtist(artist);
    	      newRecord.setGenre(genre);
    	      return newRecord;
    	}
}
