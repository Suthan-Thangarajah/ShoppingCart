package ho.app.cart;

import java.util.List;

import ho.app.cart.exception.ItemNotFoundException;
import ho.app.order.IItemOrder;

public interface IShoppingCart {
	/**
	 * Add item into the basket
	 * @param ItemId
	 * @param quantity
	 * @throws ItemNotFoundException
	 */
	public void addItem(int ItemId, int quantity) throws ItemNotFoundException;
	
	/**
	 * Get the basket total
	 * @return
	 */
	public double getTotalCost();
	
	/**
	 * Get the contents of the basket
	 * 
	 * @return
	 */
	public List<IItemOrder> getItems();
}
