import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;

	
	public WebPage(String url,String name){
		this.url = url;
		this.name = name;
		this.counter = new WordCounter(url);	
	}
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException{
		// YOUR TURN
		// 1. calculate the score of this webPage
		// Note: Main.java can call this multiple times in one run (once per
		// line of keyword input). Make sure you reset score to 0 at the start
		// of this method instead of using += on top of its old value, or the
		// score from a previous query will leak into the next one.
	}
	
}