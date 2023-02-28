import java.io.File;
import java.util.Scanner;

 //LOOK OVER CONSTRUCTORS; THIS.VARIABLE AND OTHER. VARIABLE
 // USE TRIM() TO GET RID OF EMPTY SPACES IN ANY CODE.
/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
	/**
	 * The delimiter that separates values
	 */
	private static final String SEPARATOR = ",";

	/**
	 * The delimiter that separates the parking lot design section from the parked
	 * car data section
	 */
	private static final String SECTIONER = "###";

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
	private Car[][] occupancy;

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
		occupancy = new Car[numRows][numSpotsPerRow];

		// populate lotDesign and occupancy; you can do so by
		// writing your own code or alternatively completing the 
		// private populateFromFile(...) that I have provided
		populateFromFile(strFilename);
	}

	/**
	 * Parks a car (c) at a give location (i, j) within the parking lot. c == driver's license.
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @param c is the car to be parked
	 */
	public void park(int i, int j, Car c) {
		// WRITE YOUR CODE HERE!
		if (canParkAt(i,j, c) == false) {
			System.out.println("Car " + c + " cannot be parked at " +"(" + i +", " + j +").");
		}
		else {
			occupancy[i][j] = c;
		}
	}
	

	/**
	 * Removes the car parked at a given location (i, j) in the parking lot
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the car removed; the method returns null when either i or j are out
	 *         of range, or when there is no car parked at (i, j)
	 */
	public Car remove(int i, int j) {
		// WRITE YOUR CODE HERE!
		if (i >= numRows || j >= numSpotsPerRow) { // as the code gives us coordinates in the parameters, we need to make sure the coordinates are within the parking spot's dimensions. 
			System.out.println("The coordinates that were inputted are out of the parking lot's range.");
			return null;
		} else {

		Car vehicleRemoved = occupancy[i][j]; // instantiated variable to hold the Car class at that memory of the array.
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
	 * Checks whether a car (which has a certain type) is allowed to park at
	 * location (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return true if car c can park at (i, j) and false otherwise
	 */
	public boolean canParkAt(int i, int j, Car c) {
		// WRITE YOUR CODE HERE!
		Boolean canPark = false; // booleans in order to identify the one conditions; 1) that the parking space is empty. 
		if (i >= numRows || j >= numSpotsPerRow) { // if statement determines whether the coordinates to the parking space is in or out of the parking lot's dimensions.
			return canPark = false; 
		}
		Car lot = occupancy[i][j]; // instantiated variable to hold the parking space.
		if (lot != null) { // statement to determine whetehr or not that parking space is empty. if it's not, then the car cannot park there.
			return canPark = false;
		}


		// if statement to determine whether or not the car is able to park in the requested spot. 
		CarType vehicleID = c.getType();
		CarType parkingSpot = lotDesign[i][j];
		if (parkingSpot== CarType.ELECTRIC) { // Electric cars are able to be parked in any spot that's not NA: Electric, small, regular, large.
			if (vehicleID== CarType.SMALL || vehicleID == CarType.ELECTRIC || vehicleID == CarType.SMALL || vehicleID == CarType.LARGE) { // identifies whether or not the parking spot is a part of any of these types. if so, the car can park there.
				canPark = true;
			}
		}
		else if (parkingSpot == CarType.SMALL) { // small cars are able to be parked in any spot that's not NA:, small, regular, large.
			if (vehicleID == CarType.SMALL || vehicleID == CarType.ELECTRIC || vehicleID == CarType.SMALL || vehicleID == CarType.LARGE) {// ''
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

		return canPark;
	}
		 

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {
		// WRITE YOUR CODE HERE!
		int totalCapacity = 0; // instantiated variable
		for (int a = 0; a < numRows; a ++) {
			for (int b = 0; b < numSpotsPerRow; b ++) {
				CarType vehicleID = lotDesign[a][b]; // instantiation of variable to be indentified as every spot in the parking lot itself. 
				if (vehicleID != CarType.NA || (vehicleID == CarType.LARGE || vehicleID == CarType.REGULAR || vehicleID == CarType.SMALL || vehicleID == CarType.ELECTRIC)) { // statement to determine whether or not the lot is a part of the Car class and is not NA. if it is not, the counter for the car slots goes up.
					totalCapacity ++;
				}
			}
		}
		return totalCapacity;

	}

	/**
	 * @return the total occupancy of the parking lot (i.e., the total number of
	 *         cars parked in the lot)
	 */
	public int getTotalOccupancy() { // CHANGE THIS. OCCUPANCY MIGHT BE DIFFERENT. GET THIS RIGHT AND LOOK OVER TABLES.
		// WRITE YOUR CODE HERE!
		int totalOccupancy = 0; // instantiated variable to count for how many cars are in the parking lot itself.
		for (int a = 0; a < numRows; a ++) {
			for (int b = 0; b < numSpotsPerRow; b ++) {
				if (occupancy[a][b] != null && occupancy[a][b].getType() != CarType.NA) { // determines if the parking lot if not empty and if the type of the car is defined. Counter goes up.
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
			if (str.equals(SECTIONER)) { // if the line is equal to the break-off point (###), then the loop breaks
				break;
			}
			else if (str.isEmpty()) { // if the line is empty, then nothing is done to the line itself. 

			}else {
				rows ++; // number of rows is determined. for every time the while loop goes into this else statement, the counter goes up.
				String [] columnVar = str.split(SEPARATOR); // string that was called for by the scanner gets split. the splitting of the string is identified by the SEPERATOR (","), helps to put the whole string into an array.
				numSpotsPerRow = columnVar.length; // numSpotsPerRow, or the number of columns in the space, is equivalent to that array's length. 
				}
			}
			numRows = rows; // declaration of numRows to counter variable.
			scanner.close(); // closing of scanner. 
		}

	private void populateFromFile(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));
		// YOU MAY NEED TO DEFINE SOME LOCAL VARIABLES HERE!
		// while loop for reading the lot design
		int counter= 0; // instantiating variable to identify the row that the scanner is on; this is used for later. 
		
		while (scanner.hasNext()) {
			
			String str = scanner.nextLine();
			//System.out.println("String of input file: " + str); FOR DEBUG PURPOSES
			//System.out.println("row length = " + str.length()); FOR DEBUG PURPOSES
			if (str.equals(SECTIONER)) {
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


		// while loop for reading occupancy data

		while (scanner.hasNext()) { // while loop to read past the SECTIONER (###) to read the occupancy data.
			String str = scanner.nextLine(); // instantiation of the next line of the input file 
			
			if (str != null && str.length() > 0) { // for loop to identify 
				String[] occupancyInfo = str.split(SEPARATOR); // breaks down 0, 1, S, ABC into array containing [0, 1, S, ABC] - 0 and 1; coordinates, S is the Car, and ABC is the license plate
				int xCoord = Integer.parseInt(occupancyInfo[0].trim()); // x-coordinate of the parking lot
				int yCoord = Integer.parseInt(occupancyInfo[1].trim()); // y- coordinate of the parking lot.

				String typeS = occupancyInfo[2].trim(); // String of the type of car to be converted to CarType.
				CarType carClass = Util.getCarTypeByLabel(typeS); // conversion from string of carType.
				String licensePLate = occupancyInfo[3].trim(); // string to identify the car's license plate. 

				Car carSlot = new Car(carClass, licensePLate); // instantiation of new reference type data to be inputted into the parkinglot. A car has now parked.

				park(xCoord, yCoord, carSlot);  // method to park a car in the specific
				}
			}
			scanner.close();
			}

	

	/**
	 * Produce string representation of the parking lot
	 * 
	 * @return String containing the parking lot information
	 */
	public String toString() {
		// NOTE: The implementation of this method is complete. You do NOT need to
		// change it for the assignment.
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

	/**
	 * <b>main</b> of the application. The method first reads from the standard
	 * input the name of the file to process. Next, it creates an instance of
	 * ParkingLot. Finally, it prints to the standard output information about the
	 * instance of the ParkingLot just created.
	 * 
	 * @param args command lines parameters (not used in the body of the method)
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {

		StudentInfo.display();

		System.out.print("Please enter the name of the file to process: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		ParkingLot lot = new ParkingLot(strFilename);

		System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());

		System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());

		System.out.print(lot);


		scanner.close();
	}
}