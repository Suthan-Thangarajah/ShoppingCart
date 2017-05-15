package ho.app;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import ho.app.product.book.BookDao;
import ho.app.product.book.api.IBook;
import ho.app.product.book.api.IBookDao;

@DisplayName("Test Book Dao Service")
@RunWith(JUnitPlatform.class)
public class TestBookDao {
	static IBookDao bookDao;
	
	@BeforeAll
	static void setup() {
		// Initialize connection to file.
		bookDao = new BookDao();
	}
 
	@BeforeEach
	void init() {
		// Insert some sample data before each test
	}
 
	@DisplayName("Test get all books successfully.")
	@Test
	void testGetAllBooks() {
		List<IBook> books = bookDao.getAllBooks();
		Assertions.assertNotNull(books);
		Assertions.assertFalse(books.isEmpty());
	}
 
	@DisplayName("Test get book by Id successfully.")
	@Test
	void testGetBookById() {
		IBook book = bookDao.getBookById(1);
		Assertions.assertAll("Book",
							()->Assertions.assertEquals(book.getId(), 1),
							()->Assertions.assertEquals(book.getTitle(), "Moby Dick")
							);
	}
	
	@DisplayName("Test get book by id with return null")
	@Test
	void testGetBookByIdReturnNull() {
		IBook book = bookDao.getBookById(0);
		Assertions.assertNull(book);
	}
	
  
	@AfterEach
	void tearDown() {
    // Reset the file content.
    
	}
 
  	@AfterAll
  	static void done() {
  	
  	}
	 
}
