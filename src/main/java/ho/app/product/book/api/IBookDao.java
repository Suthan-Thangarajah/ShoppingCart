/**
 * 
 */
package ho.app.product.book.api;

import java.util.List;

/**
 * @author suthan
 *
 */
public interface IBookDao {
	/**
	 * Get All books
	 * @return
	 */
	public List<IBook> getAllBooks();
	
	/**
	 * Get book by id
	 * @param id
	 * @return
	 */
	public IBook getBookById(int id);
}
