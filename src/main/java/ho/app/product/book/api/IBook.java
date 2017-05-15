/**
 * 
 */
package ho.app.product.book.api;

import ho.app.product.IItem;

/**
 * @author suthan
 *
 */
public interface IBook extends IItem{
	public String getAuthor();
	
	public String getVolume();
}
