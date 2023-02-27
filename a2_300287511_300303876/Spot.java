/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 *
 */
public class Spot {
	private Car car;
	private int timestamp;

	public Car getCar() {
		return car;
		// WRITE YOUR CODE HERE!

	}

	public void setCar(Car car) {
		this.car = car;
		// WRITE YOUR CODE HERE!
	}

	public int getTimestamp() {
		return timestamp;
		// WRITE YOUR CODE HERE!
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public Spot(Car car, int timestamp) {
		this.car = car;
		this.timestamp = timestamp;
		// WRITE YOUR CODE HERE!
	}

	/**
	 * Returns a string representation of the spot
	 * This method is complete; you do not need to change it.
	 */
	public String toString() {
		return car + ", timestamp: " + timestamp;
	}
}
