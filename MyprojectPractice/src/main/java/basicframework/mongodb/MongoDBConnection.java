package basicframework.mongodb;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class MongoDBConnection {


	public void mongoConnection(){
		// databases = collections
		// tables = documents
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

		// Creating Credentials 
		MongoCredential credential = MongoCredential.createCredential("sampleUser", "TheDatabaseName", 
				"password".toCharArray()); 
		System.out.println("Connected to the database successfully");  

		MongoDatabase database =mongoClient.getDatabase("TheDatabaseName");


		
		// if we want to create collection
		createCollection(database);

		// if we want fetch ListOfCollection
		ListOfCollection(database);
		// if we want to reterive a collection 
		MongoCollection<Document> collection =reteriveCollection(database);


		//if we want to check all document present inside a collection
		reteriveAllDocument(collection);
		
		// if we want insert document in collection
		insertDocument(collection);

		// if we want to update document
		updateDocument(collection);
		
		// if we want to delete document
		deleteDocument(collection);
		
		// if we want drop collection
		dropCollection(collection);
		// to close mongo db Connection
		mongoClient.close();
	}

	public MongoCollection<Document> reteriveCollection(MongoDatabase database){
		// Retieving a collection
		return  database.getCollection("myCollection"); 
	}

	public void reteriveAllDocument(MongoCollection<Document> collection){
		// Getting the iterable object 
		FindIterable<Document> iterDoc = collection.find(); 
		int i = 1; 

		// Getting the iterator 
		MongoCursor<Document> it = iterDoc.iterator(); 

		while (it.hasNext()) {  
			System.out.println(it.next());  
			i++; 
		}
	}

	public void insertDocument(MongoCollection<Document> collection){
		Document document = new Document("title", "MongoDB") 
				.append("id", 1)
				.append("description", "database") 
				.append("likes", 100) 
				.append("url", "http://www.tutorialspoint.com/mongodb/") 
				.append("by", "tutorials point");  
		collection.insertOne(document); 
		System.out.println("Document inserted successfully");  
	}
	
	public void updateDocument(MongoCollection<Document> collection){
		 collection.updateOne(Filters.eq("id", 1), Updates.set("likes", 150));       
	     System.out.println("Document update successfully...");  
	}
	
	public void deleteDocument(MongoCollection<Document> collection){
		 collection.deleteOne(Filters.eq("id", 1)); 
	      System.out.println("Document deleted successfully...");  
	}
	
	public void dropCollection(MongoCollection<Document> collection){
		 // Dropping a Collection 
	      collection.drop(); 
	}
	
	public void ListOfCollection(MongoDatabase database){
		for (String name : database.listCollectionNames()) { 
	         System.out.println(name); 
	      } 
	}

	public void createCollection(MongoDatabase database){
		//Creating a collection 
		database.createCollection("sampleCollection"); 
		System.out.println("Collection created successfully");
	}
}
