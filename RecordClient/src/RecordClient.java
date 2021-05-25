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
      
      Record newRecord = new Record();
      newRecord.setArtist("Apan311");
      newRecord.setTitle("Djungelrock113KUK");
      newRecord.setGenre("Rock");
//      
////      Entity<Record> apanEntity = Entity.entity(newRecord, "application/JSON");
////      response = client.target("http://localhost:8080/RecordManagement/webservice/record").request().buildPost(apanEntity).invoke();
////      System.out.println(response.readEntity(String.class));
////      response.close();
//////      
//      Collector Staffan = new Collector();
//      Staffan.setUserName("Staffan2");
//      Staffan.setEmail("stafffsdfan@mai229.com");
      response = client.target("http://localhost:8080/RecordManagement/webservice/collectors/Staffan2").request().buildGet().invoke();
      Collector Staffan = response.readEntity(Collector.class);
      System.out.println(Staffan.toString());
      int id =Staffan.getCollectorId();
      Staffan.addRecordToOwnedRecords(newRecord);
      Entity<Collector> staffanEntity = Entity.entity(Staffan, "application/JSON");
//      
//      response = client.target("http://localhost:8080/RecordManagement/webservice/collectors").request().buildPost(staffanEntity).invoke();
//      System.out.println(response.readEntity(String.class));
        response = client.target("http://localhost:8080/RecordManagement/webservice/collectors/"+id).request().buildPut(staffanEntity).invoke();
//      response = client.target("http://localhost:8080/RecordManagement/webservice/record/2").request().buildDelete().invoke();      
     response.close();
    

   
//
//      response = client.target("http://localhost:8080/RecordManagement/webservice/collectors").request().buildGet().invoke();
//      List<Collector> collectors = response.readEntity(new GenericType<List<Collector>>() {});
//      for (Collector c : collectors) {
//    	  System.out.println(c);
//      }
//      response.close();
//      

    }
}
