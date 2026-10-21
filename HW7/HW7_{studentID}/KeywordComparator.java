import java.util.Comparator;

public class KeywordComparator implements Comparator<Keyword> {
	@Override
	public int compare(Keyword o1, Keyword o2) {
		if (o1 == null || o2 == null) {
			throw new NullPointerException();
		}
		// YOUR TURN
		// 1. compare count
		// Hint: If o1 is less than o2 return negative integer, o1 greater than o2
		// return positive integer, equal return zero
		// Hint: If count is equal, break the tie by comparing name in
		// ascending order, case-sensitive (String.compareTo).

	}
}
