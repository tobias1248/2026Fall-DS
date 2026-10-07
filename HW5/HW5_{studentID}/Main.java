import java.io.IOException;
import java.util.Scanner;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()){
			String url = sc.next();
			HtmlMatcher hm = new HtmlMatcher(url);
			hm.match();
			
		}
		
	}

}
