package myanimelistParser;

import org.apache.commons.lang3.StringUtils;

public class Anime {
	public int id;
	public String title;
	public int episodes;
	public double score;
	public String type;
	public String start_date;
	public String end_date;
	public String synopsis;
	public String image;
	
	public String toString(){
		return title + "\n"
			+	"Episodes: " + episodes + "\n"
			+	"Score: " + score + "\n"
			+	"Type: " + type + "\n"
			+	"Start Date: " + start_date + "\n"
			+	"End Date: " + end_date + "\n"
			+	"Synopsis: " + synopsis + "\n";
	}
	
	public Anime(int id, String title, int episodes, double score, String type, String start_date, String end_date, String synopsis, String image){
		this.id = id;
		this.title = title;
		this.episodes = episodes;
		this.score = score;
		this.type = type;
		this.start_date = start_date;
		this.end_date = end_date;
		this.synopsis = synopsis;
		this.image = image;
	}
	
	public Anime (String data){
		data = data.replaceAll("&lt;br /&gt;", "").replaceAll("&mdash", "").replaceAll("&quot;", "");
		while(data.contains("\n"))
			data = data.replaceAll("\n", " ");
		while(data.contains("  "))
			data = data.replaceAll("  ", " ");
		int id = Integer.parseInt(StringUtils.substringBetween(data, "<id>", "</id>"));
		String title = StringUtils.substringBetween(data, "<title>", "</title>");
		int episodes = Integer.parseInt(StringUtils.substringBetween(data, "<episodes>", "</episodes>"));
		double score = Double.parseDouble(StringUtils.substringBetween(data, "<score>", "</score>"));
		String type = StringUtils.substringBetween(data, "<type>", "</type>");
		String start_date = StringUtils.substringBetween(data, "<start_date>", "</start_date>");
		String end_date = StringUtils.substringBetween(data, "<end_date>", "</end_date>");
		String synopsis = StringUtils.substringBetween(data, "<synopsis>", "</synopsis>");
		String image = StringUtils.substringBetween(data, "<image>", "</image>");
		this.id = id;
		this.title = title;
		this.episodes = episodes;
		this.score = score;
		this.type = type;
		this.start_date = start_date;
		this.end_date = end_date;
		this.synopsis = synopsis;
		this.image = image;
	}
}
