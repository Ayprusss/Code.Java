public class CapacityOptimizer {
	private static final int NUM_RUNS = 10;

	private static final double THRESHOLD = 5.0d;

	public static int getOptimalNumberOfSpots(int hourlyRate) {
		
		
		int n = 1;
		
		while (n < 10000000) {

			System.out.println("==== Setting lot capacity to: "+ n + " ====" );
			
			double averageQueue = 0;
			long start, end, runTime;
			for (int i = 0; i < NUM_RUNS; i ++) {

				ParkingLot lot = new ParkingLot(n);
				Simulator parkingSim = new Simulator(lot, hourlyRate, 86400); // Some simulation duration.

				start = System.currentTimeMillis();
				
				parkingSim.simulate();
				
				end = System.currentTimeMillis();

				runTime = end - start;
				
				System.out.println("Simulation run "+ (i + 1) + " (" + runTime + "ms); Queue length at the end of simulation run: " + parkingSim.getIncomingQueueSize());
				averageQueue += parkingSim.getIncomingQueueSize();
			}
			if ( (averageQueue/ NUM_RUNS) <= THRESHOLD) {
				return n;
			}
			
			n += 1;
		}	
		return n;
	}
	public static void main(String args[]) {
	
		StudentInfo.display();

		long mainStart = System.currentTimeMillis();

		if (args.length < 1) {
			System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
			System.out.println("Example: java CapacityOptimizer 11");
			return;
		}

		if (!args[0].matches("\\d+")) {
			System.out.println("The hourly rate of arrival should be a positive integer!");
			return;
		}

		int hourlyRate = Integer.parseInt(args[0]);

		int lotSize = getOptimalNumberOfSpots(hourlyRate);

		System.out.println();
		System.out.println("SIMULATION IS COMPLETE!");
		System.out.println("The smallest number of parking spots required: " + lotSize);

		long mainEnd = System.currentTimeMillis();

		System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");

	}
}