public abstract class AbstractSeries implements Series {

    public double[] take(int k) {
    	double array [] = new double[k];
    
    	for(int i = 0; i < k; i++) {
    		array[i] = next();
    	
    	}
		return array;

        // implement the method
        
    }

	protected abstract double next();
 
}