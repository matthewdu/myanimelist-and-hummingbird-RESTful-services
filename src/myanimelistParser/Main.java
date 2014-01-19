package myanimelistParser;


import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


public class Main {

	public static void main(String[] args) throws ResourceException, IOException, NullPointerException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Enter anime name to be searched: ");
		String search = reader.nextLine();
		search.replaceAll(" ", "+");
		
		//ClientResource resource = new ClientResource("http://cdn.animenewsnetwork.com/encyclopedia/api.xml?anime=49");
		ClientResource resource = new ClientResource("http://myanimelist.net/api/anime/search.xml?q=" + search);
		ChallengeScheme scheme = ChallengeScheme.HTTP_BASIC;
		ChallengeResponse authentication = new ChallengeResponse(scheme,"tabrislance", "racecar");  
		
		resource.setChallengeResponse(authentication);

		String xmlString;
		xmlString = resource.get().getText().toString();
		//xmlString = xmlString.substring(0, 2000)
		System.out.println(xmlString);
//		System.out.println(xmlString.length());

		LinkedList<Anime> list = new LinkedList<Anime>();
		int i = 0;
		
		if(xmlString.lastIndexOf("<entry>") > xmlString.lastIndexOf("</entry>"))
			xmlString = xmlString.substring(0, xmlString.lastIndexOf("</entry>")+9);
		
		
		
		while(xmlString.contains("<entry>")){
			String xmlStringSegments = StringUtils.substringBetween(xmlString, "<entry>", "</entry>");
//			System.out.println(xmlStringSegments);

			Anime temp = new Anime(xmlStringSegments);
			list.add(temp);
			i++;
			xmlString = xmlString.substring(xmlString.indexOf("</entry>")+1);
//			System.out.println(xmlString);
//			System.out.println(i);
		}
		
		for(int n = 0; n < i; n++){
			System.out.println(list.get(n));
		}
		

		xmlString = null;
		list = null;
		reader = null;
		return;
	}
}
	
/*DomRepresentation domRepresentation = resource.get(DomRepresentation.class);
Document document = domRepresentation.getDocument();
String string = document.getTextContent();*/