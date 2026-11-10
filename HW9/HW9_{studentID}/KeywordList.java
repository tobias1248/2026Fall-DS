import java.util.ArrayList;

public class KeywordList {
	private ArrayList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new ArrayList<Keyword>();
    }
	
	public void add(Keyword keyword){
		lst.add(keyword);
		// System.out.println("Done");
    }
	
	//quick sort
	public void sort(){
		this.lst = doQuickSort(this.lst);
	}
	
	private ArrayList<Keyword> doQuickSort(ArrayList<Keyword> list){
		// TODO: write quick sort logic here...
		ArrayList<Keyword> result = list;

		return result;
	}

	public void output(){
		if(lst.isEmpty()){
			System.out.println("Empty");
			return;
		}

		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<lst.size();i++){
			Keyword k = lst.get(i);
			if(i>0)sb.append(" ");
			sb.append(k.toString());
		}
		
		System.out.println(sb.toString());	
	}
}
