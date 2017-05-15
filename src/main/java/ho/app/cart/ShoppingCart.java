package ho.app.cart;

import java.util.ArrayList;
import java.util.List;
import com.google.common.collect.ImmutableList;

import ho.app.cart.exception.ItemNotFoundException;
import ho.app.order.IItemOrder;
import ho.app.order.ItemOrder;
import ho.app.product.IItem;
import ho.app.product.book.BookDao;
import ho.app.product.book.api.IBookDao;


public class ShoppingCart implements IShoppingCart{
	private final List<IItemOrder> items;
	private final IBookDao bookDao;
	
	public ShoppingCart() {
		items = new ArrayList<IItemOrder>();
		bookDao = new BookDao();
	}
	
	@Override
	public List<IItemOrder> getItems() {
		return ImmutableList.copyOf(items);
	}

	@Override
	public void addItem(int ItemId, int quantity) throws ItemNotFoundException {
		
		IItemOrder itemOrder = items.stream()
									.filter(p->p.getItem().getId() == ItemId)
									.findFirst()
									.orElse(null);
		
		if(itemOrder == null) {
			IItem item = bookDao.getBookById(ItemId);
			if(item == null){
				throw new ItemNotFoundException("Invalid Product ID");
			}
			items.add(new ItemOrder(item, quantity));
		} else {
			itemOrder.addQuantity(quantity);
		}	
	}

	@Override
	public double getTotalCost() {
		return items.stream().mapToDouble(p->p.getPrice()).sum();
	}
}
