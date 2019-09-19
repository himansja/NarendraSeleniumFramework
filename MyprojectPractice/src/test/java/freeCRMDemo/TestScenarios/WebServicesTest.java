package freeCRMDemo.TestScenarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WebServicesTest {

	public static void main(String[] args) {


		try {
			String jsonMimeType =  "application/json";
			HttpUriRequest request = new HttpGet( "https://api.github.com/events" );
			HttpResponse httpresponse = HttpClientBuilder.create().build().execute( request );

			System.out.println("GET Response Status:: "
					+ httpresponse.getStatusLine().getStatusCode());

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					httpresponse.getEntity().getContent()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			
			// print result
			System.out.println(response.toString());
			//Parse the JSON data present in the string format
			JsonParser parse = new JsonParser();
			//Type caste the parsed json data in json object
			JsonArray jobj = (JsonArray)parse.parse(response.toString());
			
			System.out.println(jobj.size());
			
			for(int i=0;i<jobj.size();i++)
			{
				
				//Get the index of the JSON object and print the values as per the index
				JsonObject jsonobj_1 = (JsonObject)jobj.get(i);
				String id=jsonobj_1.get("id").toString();
				System.out.println(i+"||"+id);
				System.out.println(jsonobj_1.get("actor"));
				JsonObject jobj1 = (JsonObject)parse.parse(jsonobj_1.get("actor").toString());
				System.out.println(jobj1.get("login"));  // this will not work
				System.out.println(jsonobj_1.get("repo"));
				
			}
			
			/*//Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
			JsonArray jsonarr_1 = (JsonArray) jobj.get("results");
			
			//Get data for Results array
			for(int i=0;i<jsonarr_1.size();i++)
			{
				//Store the JSON objects in an array
				//Get the index of the JSON object and print the values as per the index
				JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
				//Store the JSON object in JSON array as objects (For level 2 array element i.e Address Components)
				JSONArray jsonarr_2 = (JSONArray) jsonobj_1.get(“address_components”);
				System.out.println(“Elements under results array”);
				System.out.println(“\nPlace id: ” +jsonobj_1.get(“place_id”));
				System.out.println(“Types: ” +jsonobj_1.get(“types”));
				//Get data for the Address Components array
				System.out.println(“Elements under address_components array”);
				System.out.println(“The long names, short names and types are:”);
				for(int j=0;j<jsonarr_2.size();j++)
				{
					//Same just store the JSON objects in an array
					//Get the index of the JSON objects and print the values as per the index
					JSONObject jsonobj_2 = (JSONObject) jsonarr_2.get(j);
					//Store the data as String objects
					String str_data1 = (String) jsonobj_2.get(“long_name”);
					System.out.println(str_data1);
					String str_data2 = (String) jsonobj_2.get(“short_name”);
					System.out.println(str_data2);
					System.out.println(jsonobj_2.get(“types”));
					System.out.println(“\n”);
				}
			}
*/		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
