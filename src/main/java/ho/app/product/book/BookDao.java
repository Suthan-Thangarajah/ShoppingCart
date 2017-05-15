/**
 * 
 */
package ho.app.product.book;

import java.util.List;

import com.google.common.collect.ImmutableList;

import ho.app.product.book.api.IBook;
import ho.app.product.book.api.IBookDao;

/**
 * @author suthan
 *
 */
public class BookDao implements IBookDao{
	private final List<IBook> books = ImmutableList.of(
            new Book.BuilderBook().Id(1)
            	.Title("Moby Dick")
            	.Author("Herman Melville")
            	.ISBN("9789583001215")
            	.UnitPrice(4.99).build(),
            
            new Book.BuilderBook().Id(2)
            	.Title("A Christmas Carol")
            	.Author("Charles Dickens")
            	.ISBN("9780141324524")
            	.UnitPrice(5.29).build(),
            
            new Book.BuilderBook().Id(3)
            	.Title("Pride and Prejudice")
            	.Author("Jane Austen")
            	.ISBN("9781936594290")
            	.UnitPrice(6.99).build(),
            
            
            new Book.BuilderBook().Id(4)
	        	.Title("The Fellowship of The Ring")
	        	.Author("J. R. R. Tolkien")
	        	.ISBN("0007171978")
	        	.UnitPrice(8.99).build(),
	        	
   	        new Book.BuilderBook().Id(5)
		    	.Title("Harry Potter")
		    	.Author("J. K. Rowling")
		    	.ISBN("0747532699")
		    	.UnitPrice(10.99).build(),
	    
		    new Book.BuilderBook().Id(6)
		    	.Title("One Hundred Years of Solitude")
		    	.Author("Gabriel Garcia Marquez")
		    	.ISBN("9780060531041")
		    	.UnitPrice(20.99).build()
        
    );
	
	public List<IBook> getAllBooks() {
        return books;
    }

    public IBook getBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

}
