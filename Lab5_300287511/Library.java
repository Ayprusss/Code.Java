import java.util.ArrayList;
public class Library extends BookComparator {

    private ArrayList<Book> library = new ArrayList<Book>();

    public Book getBook(int i) {
      return library.get(i);
    }

    public int getSize() {
      return library.size();
    }

    public void addBook (Book b) {
        library.add(b);
        // Your code here
    }

    public void sort() {
        int i, j, argMin;
			Book tmp;
			for (i = 0; i < getSize() - 1; i++) {
				argMin = i;
				for (j = i + 1; j < getSize(); j++) {
                    if (compare(library.get(j), library.get(argMin)) < 0) {
                        argMin = j;
                    }
				}

  			tmp = library.get(argMin);
  			library.set(argMin, library.get(i));
  			library.set(i,tmp);
		  }
        // Your code here
    }

    public void printLibrary() {
        for (int a = 0; a < getSize(); a ++) {
            Book var = getBook(a);
            System.out.println(var.toString());
        }
    }
}
