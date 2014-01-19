package hummingbirdParser;

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
			request = Unirest.get("https://hummingbirdv1.p.mashape.com/anime/fate-zero").header("X-Mashape-Authorization", "teZUDs9Pu1SIUs0yiUsAIvqo41mTinxt").asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Anime fate = new Anime(request.getBody());
		
		System.out.println(fate);
	}

}
