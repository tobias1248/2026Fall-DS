public class Keyword {
	public String name;
	public int count;

	public Keyword(String name, int count) {
		this.name = name;
		this.count = count;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + count + "]";
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}
}
