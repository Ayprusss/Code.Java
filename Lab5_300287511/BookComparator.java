import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book a, Book b) {
        int marker = 0;
        if ((a.getAuthor()).equals(b.getAuthor())) { // authors are the same:
            if ((a.getTitle() != b.getTitle()) && (a.getYear() == b.getYear()))  {
                marker = a.getTitle().compareTo(b.getTitle());
            }
            if ((a.getYear() != b.getYear() && (a.getTitle().equals(b.getTitle()))))  {
                if (a.getYear() > b.getYear()) {
                    marker = 1;
                }
                else if (a.getYear() < b.getYear()) {
                    marker = -1;
                }
                }
            if ((a.getYear() != b.getYear()) && (a.getTitle() != b.getTitle())) {
                if (a.getYear() > b.getYear()) {
                    marker = 1;
                }
                else if (a.getYear() < b.getYear()) {
                    marker = -1;
                }
                
                marker = marker + (a.getTitle().compareTo(b.getTitle()));
            }
        }  
        if (!(a.getAuthor()).equals(b.getAuthor())) {
            marker = a.getAuthor().compareTo(b.getAuthor());
        }
        return marker;
        // need to compare the following conditions: 
        // if the authors are different; if there the same. if the names are different or same and if the year is the same or different.    
    }
    // Implement the comparator method for books.

}
