public class Arithmetic extends AbstractSeries {

    // instance variables
	 double sum = 0;
     double i = 0;
    public double next() {
    	sum += Series();
    	
    return sum;
    }
	@Override
	public double Series() {
		i++;
		return i;
	}
    
  
}