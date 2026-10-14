import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws IOException {
		//root node
		WebPage rootPage = new WebPage("http://soslab.nccu.edu.tw/Welcome.html", "Soslab");		
		WebTree tree = new WebTree(rootPage);
		//build childnode
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html","Publication")));
		tree.root.children.get(0).addChild(new WebNode(new WebPage("https://link.springer.com/book/10.1007/978-3-319-68670-7", "Sprinder")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Projects.html","Projects")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Members.html", "MEMBER")));
		tree.root.addChild(new WebNode(new WebPage("https://www3.nccu.edu.tw/~yuf/course.htm","Course")));
		//read 2 Yu 1.2 Fang 1.8 
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextInt()){
			int numOfKeywords = scanner.nextInt(); // 2
			ArrayList<Keyword> keywords = new ArrayList<Keyword>();
			
			for(int i =0;i<numOfKeywords;i++)
			{
				String name = scanner.next(); //Yu
				double weight = scanner.nextDouble(); // 1.2
				Keyword k = new Keyword(name, weight); // store key
				keywords.add(k);
			}
			
			tree.setPostOrderScore(keywords);
			tree.eularPrintTree();
		}
		scanner.close();
	}

}
