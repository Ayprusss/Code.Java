

public class Test {
    

    // we want the list; [A, B, C, D, E, F, G]
    public static String toString(NewLinkedList<String> list) {
        String prntString = "[";
        for (int i = 0; i < list.size(); i ++) {
            String a = list.get(i);
            prntString = prntString + a+ ", ";

        }
        prntString = prntString + list.get(list.size()) + "]";

        return prntString;
    }

    public static NewLinkedList<String> newList() {
        return new NewLinkedList<String>();
    }
    public static void main(String[] args) {
        
        NewLinkedList<String> list = newList();

        list.addFirst("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("8");
        list.add("F");
        list.add("L");
        list.add("G");

        list.remove("L");
        list.remove("8");

        String Final = toString(list);

        System.out.println(Final);
        System.out.println("testing get and other methods...");
        System.out.println("#######################################");

        String check1 =  list.get(0);
        String check2 =  list.get(4);
        String check3 =  list.get(5);

        System.out.println("Strings are: " + check1 + ", " + check2 + ", " + check3 + ". ");
        System.out.println("answers should be: A, E, F.");
        
    }
    
}
