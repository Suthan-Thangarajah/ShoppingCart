package ho.app;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import ho.app.cart.IShoppingCart;
import ho.app.cart.ShoppingCart;
import ho.app.cart.exception.ItemNotFoundException;
import ho.app.order.IItemOrder;

@DisplayName("Test Shopping Cart operations")
@RunWith(JUnitPlatform.class)
public class TestShoppingCart {
	static IShoppingCart cart;
	
	@DisplayName("Test create empty shopping cart successfully")
	@Test
	void testCreateEmptyShoppingCart() {
		cart = new ShoppingCart();
		Assertions.assertTrue(cart.getItems().isEmpty());
		Assertions.assertEquals(cart.getTotalCost(), 0.00);
	}
	
	@DisplayName("Test add single item to shopping cart successfully")
	@Test
	void testAddSingleItemToShoppingCart() throws ItemNotFoundException {
		cart.addItem(2, 3);
		Assertions.assertEquals(cart.getItems().size(), 1);
	}
	
	@DisplayName("Test add different item to shopping cart successfully")
	@Test
	void testAddDifferentItemToShoppingCart() throws ItemNotFoundException {
		cart.addItem(4, 2);
		Assertions.assertEquals(cart.getItems().size(), 2);
	}
	
	@DisplayName("Test add same item multiple times to shopping cart successfully")
	@Test
	@RepeatedTest(4)
	void testAddSameItemMultipleTimesToShoppingCart() throws ItemNotFoundException {
		cart.addItem(3, 2);
		Assertions.assertEquals(cart.getItems().size(), 3);
	}
	
	@DisplayName("Test add multiple items to shopping cart successfully")
	@ParameterizedTest
	@CsvSource({"1, 1","6, 1"})
	void testAddMultipleItemsToShoppingCart(int itemId, int quantity) throws ItemNotFoundException {
		cart.addItem(itemId, quantity);
	}
	
	@DisplayName("Test add item not found to shopping cart exception")
	@Test
	void testAddItemNotFoundToShoppingCart() {
		Assertions.assertThrows(ItemNotFoundException.class, ()->cart.addItem(0, 2));
	}
	
	@DisplayName("Test get item(s) from shopping cart successfully")
	@Test
	void testGetItemFromShoppingCart() {
		List<IItemOrder> orders = cart.getItems();
		System.out.println("******************************************************************");
		
		orders.forEach(p->{
			System.out.format("ID: %d Title: %s UnitPrice: %f Qty: %d Price:%f.%n", 
							  p.getItem().getId(), p.getItem().getTitle(), p.getItem().getUnitPrice(),
							  p.getQuantity(), p.getPrice());
		});
		
		System.out.println("******************************************************************");
		
	}
	
	@DisplayName("Test get total cost for shopping cart successfully")
	@Test
	void testGetTotalCostForShoppingCart() {
		System.out.println("******************************************************************");
		System.out.format("Total Cost: %f.%n", cart.getTotalCost());
		System.out.println("******************************************************************");
	}
}
