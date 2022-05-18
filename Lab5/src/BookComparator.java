import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		int a = book1.getAuthor().compareTo(book2.getAuthor());
		if(a == 0) {
			int b = book1.getTitle().compareTo(book2.getTitle());
			if(b == 0) {
				if(book1.getYear() < book2.getYear()) {
					return -1;
				}
				else if(book1.getYear() > book2.getYear()) {
					return 1;
				}
				else return 0;
			}
			return b;
		}
		return a;
		
	}

    // Implement the comparator method for books.

}