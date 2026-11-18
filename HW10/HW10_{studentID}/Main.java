import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		KeywordList lst = new KeywordList();

		File file = new File("input.txt");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			String operation = scanner.next();

			switch (operation) {
			case "add":
				String name = scanner.next();
				int count = scanner.nextInt();
				lst.add(new Keyword(name, count));
				break;

			case "find":
				String s = scanner.next();
				lst.find(s);
				break;

			default:
				throw new IllegalArgumentException("Unrecognized command: " + operation);
			}
		}
		scanner.close();
	}
}
