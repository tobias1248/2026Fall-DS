import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		KeywordHeap heap = new KeywordHeap();

		File file = new File("input.txt");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			String operation = scanner.next();

			switch (operation) {
			case "add":
				String name = scanner.next();
				int count = scanner.nextInt();
				double weight = scanner.nextDouble();
				heap.add(new Keyword(name, count, weight));
				break;

			case "peek":
				heap.peek();
				break;

			case "removeMin":
				heap.removeMin();
				break;

			case "output":
				heap.output();
				break;

			default:
				System.out.println("InvalidOperation");
				break;
			}
		}
		scanner.close();
	}
}
