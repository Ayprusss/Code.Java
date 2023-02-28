public class Shape{

	protected double x; // protected is similar to private; but it protects the variable from being 
	protected double y;
	
	// Returns the value of x
	final double getX(){
		return this.x;
	}
	
	// Returns the value of y
	final double getY(){
		return this.y;
	}
	
	// Move the shape to a new location
	final void moveTo(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	// Calculates the area of the shape
	double area(){
		return 0.0;
	}
	
	// Returns a String representation
	public String toString(){
		return "Located at (" + this.x + "," + this.y + ")" ;
	}
	
	
	public Shape(){
		this.x = 0;
		this.y = 0;
	}
	
	public Shape(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	
	// public static void main(String[] args) {
		// Shape s = new Shape (1.0, 2.0);
		// System.out.println(s);
	// }


	//look at Circle.java to understand the child class
}