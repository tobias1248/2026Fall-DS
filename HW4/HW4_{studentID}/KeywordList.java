
import java.util.*;
public class KeywordList {
	
	private LinkedList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new LinkedList<Keyword>();
		
	}
	public void add(Keyword keyword){
		// 1. add keyword to proper index base on its count . DECENDING SORT BY COUNT AND WEIGHT
		// Smaller count placed in the front. If equal, smaller weight is placed in the front.

		
		
		lst.add(keyword);
	}
	public void outputIndex(int i){ 
		// 2. output keyword at index i
	}
		
	public void outputCount(int c){
		// 3. output all keywords whose keyword is equal to c
	}
	
	public void outputHas(String pattern){
		// 4. output all keywords whose name contains input pattern
	}
	
	public void outputName(String pattern){
		
		// 5. output all keywords whose name is equal to input name
	}
	
	public void outputFirstN(int n){
		// 6. output first n keywords
	}
	
	public void outputScore(){
		double score = 0;
		// 7. output the total score of all keywords
		
		System.out.println(String.format("%.2f", score));
	}
	
	public void deleteIndex(int i){
		// 8. remove keyword at index i
	}

	public void deleteCount(int c){
		// 9. remove nodes that the count is equal to c
		
	}

	public void deleteHas(String pattern){
		// 10. remove nodes that the name contains input name

	}
	
	public void deleteName(String name){
		// 11. remove nodes that the name is equal to input name
		
	}
	
	public void deleteFirstN(int n){
		// 12. remove first n nodes
	

	}
	
	public void deleteAll(){
		// 13. remove all nodes
	}
		
	private void printKeywordList(LinkedList<Keyword> kLst){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < kLst.size(); i++){
			Keyword k = kLst.get(i);
			if(i > 0) sb.append(" ");
			sb.append(k.toString());
		}
		System.out.println(sb.toString());
	}
}



