public class Circle extends Shape{
	
	// Instance variable
	private double radius;
	
	public double getRadius(){
		return this.radius;
	}
	
	
	public Circle(){
		super();
		radius = 0;
	}
	
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	
	public String toString() {
		return "Located at: (" + x + "," + y + "), with radius " + radius;
	}
	// look at Shape.java to compare the code to
}