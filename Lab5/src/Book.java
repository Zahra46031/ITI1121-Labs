import java.util.Objects;

public class Book {

    // Your variables declaration here
	String author;
	String title;
	int year;

    public Book (String author, String title, int year) {
        // Your code here
    	this.author = author;
    	this.title = title;
    	this.year = year;
    }

    public String getAuthor() {
        // Your code here
    	return this.author;
    }

    public String getTitle() {
        // Your code here
    	return this.title;
    }

    public int getYear() {
        // Your code here
    	return this.year;
    }

    public boolean equals(Object other) {
        // Your code here
    	if(Objects.isNull(other))
    		return false;
    	if(other.getClass() != Book.class) {
    		return false;
    	}
    	Book b = (Book) other;
    	
    	if(this.author == null && b.author == null) {
    		return (this.title.equals(b.title) && this.year == b.year);
    	}
    	if(this.title == null && b.title == null) {
    		return (this.author.equals(b.author) && this.year == b.year);
    	}
    	if(this.author == null || b.author == null || this.title == null || b.title == null)
    		return false;
    	
    	return (this.author.equals(b.author) && this.title.equals(b.title) && this.year == b.year);
    		
    }

    public String toString() {
        // Your code here
    	return this.author + ": " + this.title + " (" + this.year + ")";
    }
}