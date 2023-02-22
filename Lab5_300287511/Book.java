public class Book {

    private String author;
    private String title;
    protected int year;

    // Your variables declaration here

    public Book (String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
        // Your code here
    }

    public String getAuthor() {
        return this.author;
        // Your code here
    }

    public String getTitle() {
        return this.title;
        // Your code here
    }

    public int getYear() {
        return this.year;
        // Your code here  
    }

    public boolean equals(Object other) {
        
        if (other == null || !(other instanceof Book)){ 
            return false;
        }
        Book otherBook = (Book) other;


        if (this.title == null || this.author == null) {

            if (otherBook.getAuthor() == null || otherBook.getTitle() == null) { // both this. and other. are nul;''
                return true; // they are technically the same.
            }
            else {
                return false;
            }
        }
        
        else {
        return this.author.equals(otherBook.getAuthor()) && this.title.equals(otherBook.getTitle()) && this.year == otherBook.getYear();
        }
        
    }
    public String toString() {
        return author + ": " + title + "(" + year + ")";
        // Your code here
    }
}