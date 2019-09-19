/**
 * 
 *//*
package basicframework.mongodb;

import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

*//**
 * @author Narendra
 *
 *//*
public class mongoConnectionDriver {

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		String IpAddress="103.9.75.111";
		String cluster= "Cluster0";
		String userName="narsoni";
		String password="narsoni";
		//String connectionString="mongodb+srv://narsoni:@cluster0-rqcob.mongodb.net/admin";
		String connectionString="mongodb+srv://narsoni:<PASSWORD>@cluster0-rqcob.mongodb.net/test?retryWrites=true";
		String dbName="SoniSeleniumDB";
		String collectionName="Batch1";
		try{
			
		      MongoClientURI uri = new MongoClientURI(
					    "mongodb://narsoni:narsoni@cluster0.mongodb.net/test?retryWrites=true");

				MongoClient mongoClient = new MongoClient(uri);
		      // Accessing the database 
		      MongoDatabase database = mongoClient.getDatabase("SoniSeleniumDB"); 

		      // Retieving a collection
		      //MongoCollection<Document> collection = database.getCollection(mongo.getSampleCollection()); 
		      System.out.println("Collection myCollection selected successfully");
		      
		   
		      Document document = new Document("title", "MongoDB") 
		    	      .append("id", 1)
		    	      .append("description", "database") 
		    	      .append("likes", 100) 
		    	      .append("url", "http://www.tutorialspoint.com/mongodb/") 
		    	      .append("by", "tutorials point");  
		    	      collection.insertOne(document); 
		    	      System.out.println("Document inserted successfully");
		      
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void findAll(){
		
	}

}
*/