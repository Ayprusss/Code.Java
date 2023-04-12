public class Q2 {

    public static void main(String[] args) {

	StudentInfo.display();
	LinkedList<String> alphabet;
	alphabet = new LinkedList<String>();

	alphabet.add("alpha");
	alphabet.add("bravo");
	alphabet.add("charlie");
	alphabet.add("delta");
	alphabet.add("echo");

	Iterator<String> i;
	i = alphabet.iterator();

	System.out.println("----- TEST for 2.1 -----");

	while (i.hasNext()) {
	    System.out.println(i.nextIndex());
	    System.out.println(i.next());
	}
	System.out.println(i.nextIndex());
	
	System.out.println("----- TEST for 2.2 -----");
	Iterator<String> i2 = alphabet.iterator(2);

	while (i2.hasNext()) {
	    System.out.println(i2.nextIndex());
	    System.out.println(i2.next());
	}
	System.out.println(i2.nextIndex());

	System.out.println("----- TEST for 2.3 -----");
	Iterator<String> i3 = alphabet.iterator(4);
	Iterator<String> i4 = alphabet.iterator(i3);

	while (i4.hasNext()) {
	    System.out.println(i4.nextIndex());
	    System.out.println(i4.next());
	}
	System.out.println(i4.nextIndex());	
	
    }

}
