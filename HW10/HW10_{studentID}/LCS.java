public class LCS {

	// Returns the length of the Longest Common Subsequence (LCS) of x and y.
	// Comparison is case-sensitive (e.g. 'A' and 'a' do not match).
	public static int length(String x, String y) {
		// YOUR TURN
		// Implement the LCS dynamic-programming algorithm from Lecture 10.
		// Hint: the lecture's table L uses index -1 for an empty prefix,
		// which Java arrays cannot do directly. Instead, build a table of
		// size (x.length()+1) x (y.length()+1), where L[i][j] is the LCS
		// length of x's first i characters and y's first j characters.
		// Row 0 and column 0 (empty prefixes) are then naturally all 0,
		// and the final answer is L[x.length()][y.length()].

		return 0;
	}
}
