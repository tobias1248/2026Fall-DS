public abstract class Progression<T> {
	protected T first;
	protected T curr;
	
	public Progression(T first) {
		this.first = first;
		this.curr = first;
	}
	
	//reset and return first value
	public T firstValue() {
		curr = first;
		return first;
	}
	
	public abstract T nextValue();
    
    public void printProgression(int n){
    	// 2. Print the first n values (include first value)
		String result = "";
		
		
		System.out.println(result);
    }

}