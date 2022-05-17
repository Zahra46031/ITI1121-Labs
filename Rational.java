public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	     this.numerator = numerator;
	     this.denominator = 1;
    } 

    public Rational(int numerator, int denominator) {
	     this.numerator = numerator;
	     this.denominator = denominator;
	     this.reduce();
    }

    // getters

    public int getNumerator() {
	     return numerator;
    }

    public int getDenominator() {
	     return denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
    	int cmn = this.denominator * other.denominator;
    	Rational r = new Rational(((this.denominator*other.numerator) + (other.denominator*this.numerator)), cmn);
		return r;
	     // Your code here
    }

    public static Rational plus(Rational a, Rational b) {
    	int cmn = a.denominator * b.denominator;
    	Rational r = new Rational( ((b.denominator*a.numerator) + (a.denominator*b.numerator)),  cmn);
    	return r;
    	// Your code here
    }

    // Transforms this number into its reduced form

    private void reduce() {
      // Your code here
    	int cmd = this.gcd(this.numerator, this.denominator);
    	//System.out.println(cmd);
    	this.numerator = this.numerator / cmd ;
    	this.denominator = this.denominator / cmd;
    	
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen. 
    	
    	while (a != b)
    	    if (a > b) {
    	    	if(b<0) 
    	    		b = b*-1;
    	    	if(a<0) 
    	    		a = a*-1;
    	    	for(int i = b; i>0; i--) {
    	    		if(a % i == 0 && b % i == 0) {
    	    			return i; 
    	    		}		
    	    	}	
    	    } 
    	    else {
    	    	if(a<0) 
    	    		a = a*-1;
    	    	if(b<0) 
    	    		b = b*-1;
    	    	for(int i = a; i>0; i--) {
    	    		if(b % i == 0 && a % i == 0) {
    	    			return i;
    	    		}	
    	    	}	
    	    }
		return 0;
    }

    public int compareTo(Rational other) {
    	if(Double.valueOf(this.numerator)/this.denominator > Double.valueOf(other.numerator)/other.denominator) 
    		return 1;
    	
    	else if (Double.valueOf(this.numerator)/this.denominator < Double.valueOf(other.numerator)/other.denominator)
		return -1;
    	else
    		return 0;
      // Your code here
    }

    public boolean equals(Rational other) {
    	if(other.numerator<0)
    		other.numerator = other.numerator*-1;
    	if(other.denominator<0)
    		other.denominator = other.denominator*-1;
    	if(this.numerator == other.numerator && this.denominator == other.denominator) {
    		return true;
    	}
		return false;
      // Your code here
    }

    public String toString() {
    	String result = null;
    	if (denominator == 1) {
    		result += this.numerator;
    	    // Your code here
    	} else {
    		result += (this.numerator+"/"+this.denominator);
    	    // Your code here
    	}
    	return result;
    }

}