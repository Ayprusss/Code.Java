public class DoorLock {

    // Constant.
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables.
    private Combination combination;
    private boolean open;
    private boolean activated;
    private int numberOfAttempts;

    // Constructor.
    public DoorLock( Combination combination ) {
        this.combination = combination;
        this.open = false;
        this.activated = true;
        this.numberOfAttempts = 0;
    }

    // Access methods.
    public boolean isOpen() {
        return this.open;
    }

    public boolean isActivated() {
        return this.activated;
    }

    public boolean open( Combination combination ) {
        if (this.activated) {
            this.numberOfAttempts ++;
            if (combination.equals(this.combination) == true) {
                this.numberOfAttempts = 0;
                this.open = true;
            }
            else {
                this.numberOfAttempts ++;
                if (combination.equals(this.combination) == false) {
                    if (this.numberOfAttempts >= MAX_NUMBER_OF_ATTEMPTS) {
                        this.numberOfAttempts = 0;
                        this.activated = false; 
                    }
                }
            }
        }
        return activated && open;
    }

    public void activate( Combination c ) {
        if (combination.equals(c) == true) { 
            this.activated = true;
        }
    }
    
}
