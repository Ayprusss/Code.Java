public class Lol {
 
    private int a;
    public boolean marker() {
    

        if (this.a * 5 > 40) return true; 

        else return false;
    }  


    public Lol(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Lol boop = new Lol(72);

        boolean marker = boop.marker();
        System.out.println(marker);
    }
}
