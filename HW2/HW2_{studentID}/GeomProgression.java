public class GeomProgression<T extends Number> extends Progression<T>{

	private T base;
	public GeomProgression(T first, T base) {
		super(first);
		this.base = base;
	}
	
	private T multiply(T a, T b) {
		if(a instanceof Integer){
		    Integer erasedValue = a.intValue() * b.intValue();
		    return (T)erasedValue;
		}
		// 3. Need to fill this method with Double.
//		else if
			
		else{
			return null;
		}		
	}
	
	public T nextValue() {
		curr = multiply(curr, base);
		return curr;
	}
}

