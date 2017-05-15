/**
 * 
 */
package ho.app.product;

/**
 * @author suthan
 *
 */
public interface IItem {
	/**
	 * Get Item ID
	 * @return
	 */
	public int getId();
	
	/**
	 * Get Item Title
	 * @return
	 */
	public String getTitle();
	
	/**
	 * Get ISBN number
	 * @return
	 */
	public String getISBN();
	
	/**
	 * Get item unit price
	 * @return
	 */
	public double getUnitPrice();
	
	
}
