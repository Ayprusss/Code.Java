public class Constant { // for january 12th, 2023.
    private String name;
    private double value;

    public Constant (String name, double value) {
        this.name = name; // this.asdf = self in python. Helps to refer to the variable and changes it if there are any changes to be made to the variable. 
        this.value = value; //same thing here
    }

    public static void main (String[] args) {
        Constant c = null; 
        c = new Constant("golden ratio", 1.61);         //new is responsible for instantiating values to the new constants.
        System.out.println("I am done with main()!");
    }
}
