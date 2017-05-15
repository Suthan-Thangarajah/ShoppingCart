package ho.app.order;

import ho.app.product.IItem;

public class ItemOrder implements IItemOrder{
	private final IItem item;
	private int quantity;
	
	public ItemOrder(IItem item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	@Override
	public double getPrice() {
		return item.getUnitPrice()*this.quantity;
	}
	
	@Override
	public int getQuantity() {
		return this.quantity;
	}
	
	@Override
	public IItem getItem() {
		return this.item;
	}
	
	@Override
	public void addQuantity(int quantity) {
		this.quantity = this.quantity + quantity;
	}
	
}
