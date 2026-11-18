import java.util.ArrayList;

public class KeywordList {
	private ArrayList<Keyword> lst;

	public KeywordList() {
		this.lst = new ArrayList<Keyword>();
	}

	public void add(Keyword k) {
		lst.add(k);
	}

	// Find and print the keyword whose name has the longest common
	// subsequence (LCS) with s, among all keywords added so far.
	// - count has no effect on matching; it is only part of the output.
	// - If multiple keywords tie for the longest LCS length, the one that
	//   was added earliest wins.
	// - If no keyword has been added yet, print "InvalidOperation".
	public void find(String s) {
		// YOUR TURN
		// Define find
		// Hint: use LCS.length(k.getName(), s) to score each keyword
		// already in lst, and keep track of the best one seen so far.

	}
}
