public class Keyword{
	public String name;
	public double weight;

	public Keyword(String name, double weight){
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString(){
		return "[" + name + "," + weight + "]";
	}
}
