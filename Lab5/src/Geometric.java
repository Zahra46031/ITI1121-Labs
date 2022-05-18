public class Geometric extends AbstractSeries {

    // instance variables
    double sum = 0;
    int i = 0;
    double n;
    public double next() {
    	sum += Series();
    	
		return sum;

        // implement the method

    }

	@Override
	public double Series() {
		n = (1/ Math.pow(2, i));
		i++;
		return n;
	}
}