import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
	/**
	 * The delimiter that separates values
	 */
	private static final String SEPARATOR = ",";

	/**
	 * Instance variable for storing the number of rows in a parking lot
	 */
	private int numRows;

	/**
	 * Instance variable for storing the number of spaces per row in a parking lot
	 */
	private int numSpotsPerRow;

	/**
	 * Instance variable (two-dimensional array) for storing the lot design
	 */
	private CarType[][] lotDesign;

	/**
	 * Instance variable (two-dimensional array) for storing occupancy information
	 * for the spots in the lot
	 */
	private Spot[][] occupancy;

	/**
	 * Constructs a parking lot by loading a file
	 * 
	 * @param strFilename is the name of the file
	 */
	public ParkingLot(String strFilename) throws Exception {

		if (strFilename == null) {
			System.out.println("File name cannot be null.");
			return;
		}

		// determine numRows and numSpotsPerRow; you can do so by
		// writing your own code or alternatively completing the 
		// private calculateLotDimensions(...) that I have provided
		calculateLotDimensions(strFilename);

		// instantiate the lotDesign and occupancy variables!
		lotDesign = new CarType[numRows][numSpotsPerRow];
		//System.out.println(" LotDesign numRows =" + numRows + "column = " + numSpotsPerRow); FOR DEBUG PURPOSES;
		occupancy = new Spot[numRows][numSpotsPerRow];

		// populate lotDesign and occupancy; you can do so by
		// writing your own code or alternatively completing the 
		// private populateFromFile(...) that I have provided
		populateDesignFromFile(strFilename);

		// WRITE YOUR CODE HERE!
		
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumSpotsPerRow() {
		return numSpotsPerRow;
	}

	/**
	 * Parks a car (c) at a give location (i, j) within the parking lot.
	 * 
	 * @param i         is the parking row index
	 * @param j         is the index of the spot within row i
	 * @param c         is the car to be parked
	 * @param timestamp is the (simulated) time when the car gets parked in the lot
	 */
	public void park(int i, int j, Car c, int timestamp) {
		Spot tmpCar = new Spot(c, timestamp);
		if (!canParkAt(i, j, tmpCar)) {
			System.out.println("Car " + c + " cannot be parked at " +"(" + i +", " + j +").");
		}
		else {
			occupancy[i][j] = tmpCar;
		}
	}

	/**
	 * Removes the car parked at a given location (i, j) in the parking lot
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the spot removed; the method returns null when either i or j are out
	 *         of range, or when there is no car parked at (i, j)
	 */
	public Spot remove(int i, int j) {
		if (i >= numRows || j >= numSpotsPerRow) { // as the code gives us coordinates in the parameters, we need to make sure the coordinates are within the parking spot's dimensions. 
			System.out.println("The coordinates that were inputted are out of the parking lot's range.");
			return null;
		} else {

		Spot vehicleRemoved = getSpotAt(i,j); // instantiated variable to hold the Spot class at that memory of the array.
		if (vehicleRemoved != null) { // if it isn't null, if statement makes it so it is null.
			occupancy[i][j] = null;
			return vehicleRemoved;	// vehicle is ejected out 
		}
		else {
			System.out.println("There is no car currently parked at " + "(" + i +", " + j + ")."); 
			return null;
		}
		}

	}

	/**
	 * Returns the spot instance at a given position (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the spot instance at position (i, j)
	 */
	public Spot getSpotAt(int i, int j) {
		Spot spotVal = occupancy[i][j];
		return spotVal;

		// WRITE YOUR CODE HERE!
		
	}

	/**
	 * Checks whether a car (which has a certain type) is allowed to park at
	 * location (i, j)
	 *
	 * NOTE: This method is complete; you do not need to change it.
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return true if car c can park at (i, j) and false otherwise
	 */
	public boolean canParkAt(int i, int j, Spot c) {
		Boolean canPark = false; // booleans in order to identify the one conditions; 1) that the parking space is empty. 
		if (i >= numRows || j >= numSpotsPerRow) { // if statement determines whether the coordinates to the parking space is in or out of the parking lot's dimensions.
			return canPark = false; 
		}
		Spot lot = getSpotAt(i, j); // instantiated variable to hold the parking space.
		if (lot != null) { // statement to determine whetehr or not that parking space is empty. if it's not, then the car cannot park there.
			return canPark = false;
		}


		// if statement to determine whether or not the car is able to park in the requested spot. 
		CarType vehicleID = c.getCar().getType();
		CarType parkingSpot = lotDesign[i][j];

		if (vehicleID.equals(CarType.ELECTRIC)) {
			if (parkingSpot.equals(CarType.SMALL) || parkingSpot.equals(CarType.ELECTRIC) || parkingSpot.equals(CarType.REGULAR) || parkingSpot.equals(CarType.LARGE)) { // identifies whether or not the parking spot is a part of any of these types. if so, the car can park there.
				canPark = true;
			}
		}
		else if (vehicleID.equals(CarType.SMALL)) {
			if (parkingSpot.equals(CarType.SMALL) || parkingSpot.equals(CarType.REGULAR) || parkingSpot.equals(CarType.LARGE)) { // identifies whether or not the parking spot is a part of any of these types. if so, the car can park there.
				canPark = true;
			}
		}
		else if (vehicleID.equals(CarType.REGULAR)) {
			if (parkingSpot.equals(CarType.REGULAR) || parkingSpot.equals(CarType.LARGE)) { // identifies whether or not the parking spot is a part of any of these types. if so, the car can park there.
				canPark = true;
			}
		}
		else if (vehicleID.equals(CarType.LARGE)) { 
			if (parkingSpot.equals(CarType.LARGE)) { // identifies whether or not the parking spot is a part of any of these types. if so, the car can park there.
				canPark = true;
			}
		}
		else {
			canPark = false;
		}
		/* 
		if (parkingSpot == CarType.ELECTRIC) { // Electric cars are able to be parked in any spot that's not NA: Electric, small, regular, large.
			if (vehicleID.equals(CarType.SMALL) || vehicleID.equals(CarType.ELECTRIC) || vehicleID.equals(CarType.REGULAR) || vehicleID.equals(CarType.LARGE)) { // identifies whether or not the parking spot is a part of any of these types. if so, the car can park there.
				canPark = true;
			}
		}
		else if (parkingSpot == CarType.SMALL) { // small cars are able to be parked in any spot that's not NA:, small, regular, large.
			if (vehicleID == CarType.SMALL || vehicleID == CarType.REGULAR || vehicleID == CarType.LARGE) {// ''
				canPark = true;
			}
		}
		else if (parkingSpot == CarType.REGULAR) { // regualr cars are able to be park in the spots: Regular and Large
			if (vehicleID == CarType.REGULAR || vehicleID == CarType.LARGE) { // ''
				canPark = true;
			}
		}
		else if (parkingSpot == CarType.LARGE) { // large fcars are able to park in spots: LARGE
			if (vehicleID == CarType.LARGE) {// ''
				canPark = true;
			}
		}
		else {
			canPark = false; // if the parking spot if NA; parking spot is not accessible to anyone.
		}
		*/
		return canPark;
		
		// WRITE YOUR CODE HERE!
		
	}

	/**
	 * Attempts to park a car in the lot. Parking is successful if a suitable parking spot
	 * is available in the lot. If some suitable spot is found (anywhere in the lot), the car
	 * is parked at that spot with the indicated timestamp and the method returns "true".
	 * If no suitable spot is found, no parking action is taken and the method simply returns
	 * "false"
	 * 
	 * @param c is the car to be parked
	 * @param timestamp is the simulation time at which parking is attempted for car c 
	 * @return true if c is successfully parked somwhere in the lot, and false otherwise
	 */
	public boolean attemptParking(Car c, int timestamp) {
		Boolean canPark = false;
		Spot carToPark = new Spot(c, timestamp);
		for (int a = 0; a < numRows; a ++) {
			for (int b = 0; b < numSpotsPerRow; b ++) {
				
				if (canParkAt(a,b, carToPark)){ // checks that the car is the same car type and if the car can be parked at that spot.
						canPark = true;
						park(a,b, c, timestamp);
						break;
				}
				}
			if (canPark) {
					break;
				}
			}
			
			return canPark;
		}

		
		// WRITE YOUR CODE HERE!

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {

		int totalCapacity = 0; // instantiated variable
		for (int a = 0; a < numRows; a ++) {
			for (int b = 0; b < numSpotsPerRow; b ++) {
				CarType vehicleID = lotDesign[a][b]; // instantiation of variable to be indentified as every spot in the parking lot itself. 
				if (vehicleID != CarType.NA &&( (vehicleID == CarType.LARGE || vehicleID == CarType.REGULAR || vehicleID == CarType.SMALL || vehicleID == CarType.ELECTRIC))) { // statement to determine whether or not the lot is a part of the Car class and is not NA. if it is not, the counter for the car slots goes up.
					totalCapacity ++;
				}
			}
		}
		return totalCapacity;

		// WRITE YOUR CODE HERE!
	
	}

	/**
	 * @return the total occupancy of the parking lot
	 */
	public int getTotalOccupancy() {

		// WRITE YOUR CODE HERE!
		
		int totalOccupancy = 0; // instantiated variable to count for how many cars are in the parking lot itself.
		for (int a = 0; a < numRows; a ++) {
			for (int b = 0; b < numSpotsPerRow; b ++) {
				if (occupancy[a][b] != null) { // determines if the parking lot if not empty and if the type of the car is defined. Counter goes up.
					totalOccupancy ++;
				}
			}
		}
		return totalOccupancy;

	}

	private void calculateLotDimensions(String strFilename) throws Exception {
		Scanner scanner = new Scanner(new File(strFilename));
		int rows = 0; // instantiated variable to determine how many rows are in the parking lot.

		while (scanner.hasNext()) { // while loop to go through input file.
			String str = scanner.nextLine();
			if (str.isEmpty()) { // if the line is empty, then nothing is done to the line itself. 
				break;

			}else {
				rows ++; // number of rows is determined. for every time the while loop goes into this else statement, the counter goes up.
				String [] columnVar = str.split(SEPARATOR); // string that was called for by the scanner gets split. the splitting of the string is identified by the SEPERATOR (","), helps to put the whole string into an array.
				numSpotsPerRow = columnVar.length; // numSpotsPerRow, or the number of columns in the space, is equivalent to that array's length. 
				}
			}
			numRows = rows; // declaration of numRows to counter variable.
			scanner.close(); // closing of scanner.
		// WRITE YOUR CODE HERE!

	}

	private void populateDesignFromFile(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));
		// YOU MAY NEED TO DEFINE SOME LOCAL VARIABLES HERE!
		// while loop for reading the lot design
		int counter= 0; // instantiating variable to identify the row that the scanner is on; this is used for later. 
		
		while (scanner.hasNext()) {
			
			String str = scanner.nextLine();
			//System.out.println("String of input file: " + str); FOR DEBUG PURPOSES
			//System.out.println("row length = " + str.length()); FOR DEBUG PURPOSES
			if (str.isEmpty()) {
				break;
			}
			else if (str.trim().length() > 0) { // checks whether or not the line (that is trimmed, meaning that the space in between the lines are removed) is greater than zero; this checks whether or not the line is empty. 
				String[] row = str.split(SEPARATOR); // seperation of a string into a string array.
				//System.out.println("row length = " + row.length); FOR DEBUG PURPOSES;
				for (int b = 0; b < row.length; b ++) {  // for loop to append all carTypes into the lotDesign array. 
					String character = row[b].trim(); //additional trim to the string (potentiall unecessary)
					lotDesign[counter][b] = Util.getCarTypeByLabel(character); // using the Util class' method of conversion from string to cartype.
					//System.out.println(" lotDesign = " + lotDesign[counter][b] + " value = " +  character + " row Number" + counter +" column = " + b ); FOR DEBUG PURPOSES
					
				}
			counter ++; // after the end of every while loop, the counter goes up to signify that the scanner is moving on to the next line, and hence, the next row.
			//System.out.println("#####################" + "\n"); FOR DEBUG PURPOSES;
			}
		}
	}

		// WRITE YOUR CODE HERE!


	/**
	 * NOTE: This method is complete; you do not need to change it.
	 * @return String containing the parking lot information
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("==== Lot Design ====").append(System.lineSeparator());

		for (int i = 0; i < lotDesign.length; i++) {
			for (int j = 0; j < lotDesign[0].length; j++) {
				buffer.append((lotDesign[i][j] != null) ? Util.getLabelByCarType(lotDesign[i][j])
						: Util.getLabelByCarType(CarType.NA));
				if (j < numSpotsPerRow - 1) {
					buffer.append(", ");
				}
			}
			buffer.append(System.lineSeparator());
		}

		buffer.append(System.lineSeparator()).append("==== Parking Occupancy ====").append(System.lineSeparator());

		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[0].length; j++) {
				buffer.append(
						"(" + i + ", " + j + "): " + ((occupancy[i][j] != null) ? occupancy[i][j] : "Unoccupied"));
				buffer.append(System.lineSeparator());
			}

		}
		return buffer.toString();
	}

	public static void main(String args[]) throws Exception {

		StudentInfo.display();

		System.out.print("Please enter the name of the file to process: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		ParkingLot lot = new ParkingLot(strFilename);

		System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());

		System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());

		System.out.println("number of Rows: "+ lot.numRows + "; Number of collumns: " + lot.getNumSpotsPerRow());
		System.out.print(lot);


		scanner.close();
	}
	
}