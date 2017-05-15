package ho.app.order;

import ho.app.product.IItem;

public interface IItemOrder {
	/**
	 * Get price of total quantity
	 * 
	 * @return
	 */
	public double getPrice();
	
	/**
	 * Get quantity
	 * 
	 * @return
	 */
	public int getQuantity();
	
	/**
	 * Get Item object
	 * @return
	 */
	public IItem getItem();
	
	/**
	 * Add with an existing quantity
	 * 
	 * @param quantity
	 */
	public void addQuantity(int quantity);
}
