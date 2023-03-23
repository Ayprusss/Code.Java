/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {

	// IMPORTANT: You are *discouraged* from defining any new instance variables in
	// ParkingLot. You are expected to provide a list-based implementation of
	// ParkingLot. Defining new instance variables can take you away from this
	// implementation goal and thus result in the loss of marks.
	/**
	 * List for storing occupancy information in the lot
	 */
	private List<Spot> occupancy;

	/**
	 * The maximum number of cars that the lot can accommodate
	 */
	private int capacity;

	/**
	 * Constructs a parking lot with a given (maximum) capacity
	 * 
	 * @param capacity is the (maximum) capacity of the lot
	 */
	public ParkingLot(int capacity) {

		if (capacity < 0) {
			throw new IllegalArgumentException("capacity value cannot be less than zero! Please enter a value greater than zero.");
			// Hint: throw a suitable exception here.
		}

		this.capacity = capacity;
		this.occupancy = new SinglyLinkedList<Spot>();
	}

	/**
	 * Parks a car (c) in the parking lot.
	 * 
	 * @param c         is the car to be parked
	 * @param timestamp is the (simulated) time when the car gets parked in the lot
	 */
	public void park(Car c, int timestamp) {
		if (c == null) {
			throw new IllegalArgumentException("values cannot be null.");
		}
		Spot carSpot = new Spot(c, timestamp);
		if (occupancy.size() == 0) {
			((SinglyLinkedList<Spot>) occupancy).addFirst(carSpot);
		}
		else {
			occupancy.add(carSpot);
		}
		
	
	}

	/**
	 * Removes the car (spot) parked at list index i in the parking lot
	 * 
	 * @param i is the index of the car to be removed
	 * @return the car (spot) that has been removed
	 */
	public Spot remove(int i) {
		Spot lotToRemove = getSpotAt(i);

		if (i >= occupancy.size()) {
			throw new IllegalArgumentException("index is out of bounds of the list");
		}
		if (lotToRemove.equals(null)) {
			return null; // not possible, cannot remove an element that's already null.
			// potentially throw an error in a later time.
		}
		else if (occupancy.remove(lotToRemove)) {

			return lotToRemove;
		}

		return null;
	
	}

	public boolean attemptParking(Car c, int timestamp) {

		if (c == null) {
			throw new IllegalArgumentException("the Car cannot be null!");
		}
		Boolean canPark = false;
			if(occupancy.size() < capacity) {
				canPark = true;
				park(c, timestamp);
				
			}

			return canPark;
		}

	/**
	 * @return the capacity of the parking lot
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Returns the spot instance at a given position (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the spot instance at a given position (i, j)
	 */

	public Spot getSpotAt(int i) {
		if (occupancy.isEmpty()) {
			throw new IllegalAccessError("List is Empty!");
		}

		if (i > capacity) {
			throw new IllegalArgumentException("index is out of bounds!");
		}
		if (occupancy.get(i).equals(null)) {
			throw new IllegalArgumentException("element at List is null!");
		}

		Spot spotAt = occupancy.get(i);

		return spotAt;
	}

	/**
	 * @return the total number of cars parked in the lot
	 */
	public int getOccupancy() {
			return occupancy.size();
		

	}

	/**
	 * @return String representation of the parking lot
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("Total capacity: " + this.capacity + System.lineSeparator());
		buffer.append("Total occupancy: " + this.occupancy.size() + System.lineSeparator());
		buffer.append("Cars parked in the lot: " + this.occupancy + System.lineSeparator());

		return buffer.toString();
	}
}