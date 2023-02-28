

public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
      this.numerator = numerator;
      this.denominator = 1;
	     // Your code here
    }

    public Rational(int numerator, int denominator) {
      this.numerator = numerator;
      this.denominator = denominator; 

      reduce();
	     // Your code here
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
      int numerator = (this.numerator * other.denominator) + (other.numerator*this.denominator);
      int denominator = (this.denominator * other.denominator);
      return new Rational(numerator, denominator);
	     // Your code here
    }

    public static Rational plus(Rational a, Rational b) {
    	
      int numerator = (a.numerator * b.denominator) + (b.numerator * a.denominator);
      int denominator = a.denominator * b.denominator;

      return new Rational(numerator, denominator);
    }

    // Transforms this number into its reduced form

    private void reduce() {
      
      int divisor = gcd(this.numerator, this.denominator);

      this.numerator = this.numerator/divisor;
      this.denominator = this.denominator/divisor;
      // Your code here
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.

      if (a < 0 ) {
        a = a * (-1);
      }
      else if (b < 0) {
        b = b *(-1);
      }

    	while (a != b) {
    	    if (a > b) {
    		     a = a - b; 
          }
    	    else {
    		     b = b - a;
             }
            }

    	return a;
    }

    public int compareTo(Rational other) {
      int difference = 0;
      double fraction1 = (this.numerator) / this.denominator; 
      double fraction2 = (other.numerator)/ other.denominator;

      if (fraction1 > fraction2) {
        difference = 1;
      }
      else if (fraction1 == fraction2) {
        difference = 0;
      }
      else if (fraction1 < fraction2) {
        difference = -1;
      }

      return difference;
    }

    public boolean equals(Rational other) {
      if (this.numerator == other.numerator && this.denominator == other.denominator) {
        return true;
      }
      else {
        return false;
      }
      // Your code here
    }

    public String toString() {
    	String result;
    	if (denominator == 1) {
        result = "" + this.numerator;
    	    // Your code here
    	} else {
        result = this.numerator + " / " + this.denominator;
    	    // Your code here
    	}
    	return result;
    }

}
