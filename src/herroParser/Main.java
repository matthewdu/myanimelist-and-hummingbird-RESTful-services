package herroParser;

import java.util.Random;

import org.json.JSONException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Main {
	static HttpResponse<JsonNode> request;
	public static void main(String[] args) throws JSONException {
//		Scanner reader = new Scanner(System.in);
//		System.out.print("Enter anime id: ");
//		int id = Integer.parseInt(reader.nextLine());
		Random random = new Random();
		int id = random.nextInt(2000);
		
		try {
			request = Unirest.get("http://api.herro.co/anime/5148d00e83b471715e000cef").asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		System.out.println(request.getBody().getObject().toString());
	}

}
