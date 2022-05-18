import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class JUnit {
	int grade = 0;
	 @Test
	    public void testExtendsAbstractSeries() {
	      Arithmetic s = new Arithmetic();
	      assertTrue("Arithmetic must extend AbstractSeries", s instanceof AbstractSeries);

	      grade += 0.25;
	    }

	    @Test
	    public void testImplementsSeries() {
	      Arithmetic s = new Arithmetic();
	      assertTrue("class Arithmetic must extend AstractSeries which must implement Series", s instanceof Series);

	      grade += 0.25;
	    }

	    @Test
	    public void testArithmeticSeriesNextFourth() {
	      Arithmetic arithmetic = new Arithmetic();
	      arithmetic.next();
	      arithmetic.next();
	      arithmetic.next();
	      double fourth = arithmetic.next();
	      double expected = 10;

	      assertEquals("Arithmetic fourth element", expected, fourth, 0.0001);

	      grade += 0.25;
	    }

	    @Test
	    public void testArithmeticSeriesNextTenth() {
	      Arithmetic s = new Arithmetic();
	      for(int i = 0; i < 9; i++){
	        s.next();
	      }
	      double tenth = s.next();
	      double expected = 55;

	      assertEquals("Arithmetic tenth element", expected, tenth, 0.0001);

	      grade += 0.25;
	    }

	    @Test
	    public void testArithmeticSeriesValuesTake3() {
	      Arithmetic s = new Arithmetic();
	      double[] actual = s.take(3);
	      double[] expected = new double[]{1, 3, 6};

	      assertTrue("Arithmetic: take(3), expected: [1, 3, 6], actual: " + Arrays.toString(actual), Arrays.equals(expected, actual));

	      grade += 0.5;
	    }

	    @Test
	    public void testArithmeticSeriesValuesTake12() {
	      Arithmetic s = new Arithmetic();
	      double[] actual = s.take(12);
	      double[] expected = new double[]{1.0, 3.0, 6.0, 10.0, 15.0, 21.0, 28.0, 36.0, 45.0, 55.0, 66.0, 78.0};

	      assertTrue("Arithmetic: take(12), expected: [1.0, 3.0, 6.0, 10.0, 15.0, 21.0, 28.0, 36.0, 45.0, 55.0, 66.0, 78.0], actual: " + Arrays.toString(actual), Arrays.equals(expected, actual));

	      grade += 0.5;
	    }
	    @Test
	    public void testConstructor() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);

	      assertEquals("Shakespeare", myBook.getAuthor());
	      assertEquals("Hamlet", myBook.getTitle());
	      assertEquals(1600, myBook.getYear());

	      grade += 0.25;
	    }

	    @Test
	    public void testEqualBooks() {
	      String a1 = new String("Shakespeare");
	      String a2 = new String("Shakespeare");
	      String t1 = new String("Hamlet");
	      String t2 = new String("Hamlet");

	      Book myBook = new Book(a1, t1, 1600);
	      assertTrue("Basic equality, should work even with wrong reference comparison",
	          myBook.equals(myBook));
	      Book myBook2 = new Book(a2, t2, 1600);
	      assertTrue("Compared references with .equals", myBook.equals(myBook2));

	      grade += 0.25;
	    }

	    @Test
	    public void testNotEqualBooksDifferentTitle() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book("Shakespeare", "Macbeth", 1600);
	      assertFalse("Book.equals: Different titles", myBook.equals(myBook2));

	      grade += 0.10;
	    }

	    @Test
	    public void testNotEqualBooksDifferentYears() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book("Shakespeare", "Hamlet", 1601);
	      assertFalse("Book.equals: Different years", myBook.equals(myBook2));

	      grade += 0.10;
	    }

	    @Test
	    public void testNotEqualBooksDifferentAuthor() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book("Shakespeared", "Hamlet", 1600);
	      assertFalse("Book.equals: Different authors", myBook.equals(myBook2));

	      grade += 0.10;
	    }


	    @Test
	    public void testNotEqualNullBooks() {
	      try{
	        Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	        assertFalse("Book.equals: null parameter", myBook.equals(null));

	        grade += 0.50;
	      } catch(NullPointerException e) {
	        fail("Book.equals: NullPointerException with null parameter");
	      }
	    }

	    @Test
	    public void testNotEqualNullAuthorParameter() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book(null, "Macbeth", 1600);
	      assertFalse("Book.equals: null author parameter", myBook.equals(myBook2));

	      grade += 0.10;
	    }

	    @Test
	    public void testNotEqualNullAuthorInstance() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book(null, "Macbeth", 1600);
	      assertFalse("Book.equals: null author instance", myBook2.equals(myBook));

	      grade += 0.10;
	    }

	    @Test
	    public void testEqualNullAuthors() {
	      Book myBook = new Book(null, "Macbeth", 1600);
	      Book myBook2 = new Book(null, "Macbeth", 1600);
	      assertTrue("Book.equals: both null authors", myBook.equals(myBook2));

	      grade += 0.20;
	    }

	    @Test
	    public void testNotEqualNullTitleParameter() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book("Shakespeare", null, 1600);
	      assertFalse("Book.equals: null title parameter", myBook.equals(myBook2));

	      grade += 0.10;
	    }

	    @Test
	    public void testNotEqualNullTitleInstance() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book("Shakespeare", null, 1600);
	      assertFalse("Book.equals: null title instance", myBook2.equals(myBook));

	      grade += 0.10;
	    }

	    @Test
	    public void testEqualNullAuthor() {
	      Book myBook = new Book(null, "Hamlet", 1600);
	      Book myBook2 = new Book(null, "Hamlet", 1600);
	      assertTrue("Book.equals: both null author", myBook.equals(myBook2));

	      grade += 0.10;
	    }

	    @Test
	    public void testEqualNullTitle() {
	      Book myBook = new Book("Shakespeare", null, 1600);
	      Book myBook2 = new Book("Shakespeare", null, 1600);
	      assertTrue("Book.equals: both null title", myBook.equals(myBook2));

	      grade += 0.25;
	    }

	    @Test
	    public void testEqualWrongType() {
	      Book myBook = new Book("Shakespeare", null, 1600);
	      Integer myInt = Integer.valueOf(5);
	      assertFalse("Book.equals: called with Integer", myBook.equals(myInt));

	      grade += 0.25;
	    }

	    @Test
	    public void testEqualNotOveritten() {
	      Book myBook = new Book("Shakespeare", null, 1600);
	      Book myBook2 = new Book("Shakespeare", null, 1600);
	      assertTrue("Book.equals: method was overloaded and not overwritten", 
	        myBook.equals((Object)myBook2));

	      grade += 1.0;
	    }
	    @Test
	    public void testImplementsSeries11() {
	      Geometric s = new Geometric();
	      assertTrue("class Geometric must extend AstractSeries which must implement Series", s instanceof Series);

	      grade += 0.25;
	    }

	    @Test
	    public void testExtendsAbstractSeries1() {
	      Geometric s= new Geometric();
	      assertTrue("class Geometric must extend AbstractSeries", s instanceof AbstractSeries);

	      grade += 0.25;
	    }

	    @Test
	    public void testGeometricSeriesNextFourth() {
	      Geometric geometric = new Geometric();
	      geometric.next();
	      geometric.next();
	      geometric.next();
	      double fourth = geometric.next();
	      double expected = 1.875;

	      assertEquals("Geometric fourth element", expected, fourth, 0.0001);

	      grade += 0.25;
	    }

	    @Test
	    public void testGeometricSeriesNextTenth() {
	      Geometric geometric = new Geometric();
	      for(int i = 0; i < 9; i++){
	        geometric.next();
	      }
	      double tenth = geometric.next();
	      double expected = 1.998046875;

	      assertEquals("Geometric tenth element", expected, tenth, 0.0001);

	      grade += 0.25;
	    }

	    @Test
	    public void testGeometricSeriesValuesTake3() {
	      Geometric s = new Geometric();
	      double[] actual = s.take(3);
	      double[] expected = new double[]{1, 1.5, 1.75};

	      assertTrue("Geometric: take(3), expected: [1, 1.5, 1.75], actual: " + Arrays.toString(actual), Arrays.equals(expected, actual));

	      grade += 0.5;
	    }

	    @Test
	    public void testGeometricSeriesValuesTake12() {
	      Geometric s = new Geometric();
	      double[] actual = s.take(12);
	      double[] expected = new double[]{1.0, 1.5, 1.75, 1.875, 1.9375, 1.96875, 1.984375, 1.9921875, 1.99609375, 1.998046875, 1.9990234375, 1.99951171875};

	      assertTrue("Geometric: take(12), expected: [1.0, 1.5, 1.75, 1.875, 1.9375, 1.96875, 1.984375, 1.9921875, 1.99609375, 1.998046875, 1.9990234375, 1.99951171875], actual: " + Arrays.toString(actual), Arrays.equals(expected, actual));

	      grade += 0.5;
	    }
	    @Test
	    public void testAddBook() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Library myLibrary = new Library();
	      myLibrary.addBook(myBook);

	      assertEquals(myBook, myLibrary.getBook(0));

	      grade += 0.25;
	    }


	    @Test
	    public void testSortByAuthor() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book("Ienaga", "The Pacific War", 1968);
	      Library myLibrary = new Library();
	      myLibrary.addBook(myBook);
	      myLibrary.addBook(myBook2);
	      myLibrary.sort();

	      assertEquals("Library: sorting by author, first", myBook2, myLibrary.getBook(0));
	      assertEquals("Library: sorting by author, second", myBook, myLibrary.getBook(1));

	      grade += 0.25;
	    }

	    @Test
	    public void testSortByAuthorSameTitleAndYear() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book("Author", "Hamlet", 1600);
	      Library myLibrary = new Library();
	      myLibrary.addBook(myBook);
	      myLibrary.addBook(myBook2);
	      myLibrary.sort();

	      assertEquals("Library: sort by author, same title, same year, first", myBook2, myLibrary.getBook(0));
	      assertEquals("Library: sort by author, same title, same year, second", myBook, myLibrary.getBook(1));

	      grade += 0.25;
	    }

	    @Test
	    public void testSortByTitleSameAuthorAndYear() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book("Shakespeare", "A Midsummer Night's Dream", 1600);
	      Library myLibrary = new Library();
	      myLibrary.addBook(myBook);
	      myLibrary.addBook(myBook2);
	      myLibrary.sort();

	      assertEquals("Library: sort by title, same author, same year, first", myBook2, myLibrary.getBook(0));
	      assertEquals("Library: sort by title, same author, same year, second", myBook, myLibrary.getBook(1));

	      grade += 0.25;
	    }

	    @Test
	    public void testSortByTitleInitialRightOrder() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book("Shakespeare", "A Midsummer Night's Dream", 1600);
	      Library myLibrary = new Library();
	      myLibrary.addBook(myBook2);
	      myLibrary.addBook(myBook);
	      myLibrary.sort();

	      assertEquals("Library: sort by title, same author, same year, first", myBook2, myLibrary.getBook(0));
	      assertEquals("Library: sort by title, same author, same year, second", myBook, myLibrary.getBook(1));

	      grade += 0.25;
	    }

	    @Test
	    public void testSortByYear() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book("Shakespeare", "Hamlet", 1599);
	      Library myLibrary = new Library();
	      myLibrary.addBook(myBook);
	      myLibrary.addBook(myBook2);
	      myLibrary.sort();

	      assertEquals("Library: sort by year, same author, same title, first", myBook2, myLibrary.getBook(0));
	      assertEquals("Library: sort by year, same author, same title, second", myBook, myLibrary.getBook(1));

	      grade += 0.25;
	    }

	    @Test
	    public void testSortNineBooks() {
	      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
	      Book myBook2 = new Book("Shakespeare", "A Midsummer Night's Dream", 1600);
	      Book myBook3 = new Book("Shakespeare", "Hamlet", 1599);
	      Book myBook4 = new Book("Ienaga", "The Pacific War", 1968);
	      Book myBook5 = new Book("Coutu", "Le québécois en 10 leçons", 2014);

	      Library myLibrary = new Library();
	      myLibrary.addBook(myBook);
	      myLibrary.addBook(myBook2);
	      myLibrary.addBook(myBook3);
	      myLibrary.addBook(myBook4);
	      myLibrary.addBook(myBook5);

	      myLibrary.sort();

	      assertEquals("Library: sort by author first", myBook5, myLibrary.getBook(0));
	      assertEquals("Library: sort by author", myBook4, myLibrary.getBook(1));
	      assertEquals("Library: sort by title", myBook2, myLibrary.getBook(2));
	      assertEquals("Library: sort by year", myBook3, myLibrary.getBook(3));
	      assertEquals("Library: sort last element", myBook, myLibrary.getBook(4));

	      grade += 1.0;
	    }



}
