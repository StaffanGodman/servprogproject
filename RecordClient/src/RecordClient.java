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
	WebTarget target = client.target("http://localhost:8080/RecordManagement/webservice/collectors");
	Invocation invocation = target.request().buildGet();
      Response response = invocation.invoke();
      System.out.println(response.readEntity(String.class));
      
      RecordRelease rr = new RecordRelease();
      rr.setArtist("apan");
      rr.setGenre("aprock");
      rr.setReleaseYear(2017);
      rr.setSerialNo("25454-try-31sdf1");
      rr.setTitle("djungle boogie");
      Collector Staffan = new Collector();
      Staffan.setUserName("Staffan2");
      Staffan.setEmail("stafffsdfan@mai229.com");
     
      
      
      
      Entity<RecordRelease> apanEntity = Entity.entity(rr, "application/JSON");
      
      response = client.target("http://localhost:8080/RecordManagement/webservice/recordrelease").request().buildPost(apanEntity).invoke();
      
      System.out.println(response.readEntity(RecordRelease.class).getArtist());
      response.close();
      
      Entity<Collector> staffanEntity = Entity.entity(Staffan, "application/JSON");
      
      response = client.target("http://localhost:8080/RecordManagement/webservice/collectors").request().buildPost(staffanEntity).invoke();
      System.out.println(response.readEntity(Collector.class).getUserName());
      response.close();
    
      //Staffan.createAndAddOwnedCopy(rr);
      
     
      RecordCopy rc = new RecordCopy();
      rc.setCollector(Staffan);
      rc.setRecordRelease(rr);
      Entity<RecordCopy> copyEntity = Entity.entity(rc, "application/JSON");
      response = client.target("http://localhost:8080/RecordManagement/webservice/recordcopy").request().buildPost(copyEntity).invoke();
      response.close();
      /*
        * 
        */

      response = client.target("http://localhost:8080/RecordManagement/webservice/collectors").request().buildGet().invoke();
      List<Collector> collectors = response.readEntity(new GenericType<List<Collector>>() {});
      for (Collector c : collectors) {
    	  System.out.println(c);
      }
      response.close();
      response = client.target("http://localhost:8080/RecordManagement/webservice/recordreleases").request().buildGet().invoke();
      List<RecordRelease> releases = response.readEntity(new GenericType<List<RecordRelease>>() {});
      for (RecordRelease c : releases) {
    	  System.out.println(c);
      }
      response.close();
		
   }
}
