import de.oszimt.ls11a1.model.order.Order;
import de.oszimt.ls11a1.model.order.OrderMgmt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Order mgmt test class
 *
 * @author Steffen Trutz
 * @version 3.2.1
 */
class TestModelOrderMgmt {

	OrderMgmt orders;

	@BeforeEach
	void init(){
		orders = new OrderMgmt();

		//testdata
		Order o = new Order(0, "comment", "status");
		orders.add(o);
	}

	@Test
	void testAddSize() {
		int size = orders.size();
		Order o = new Order(orders.getNextFreeID(), "comment", "status");
		orders.add(o);

		assertEquals(size+1, orders.size());
	}

	@Test
	void testAddContent() {
		Order o = new Order(orders.getNextFreeID(), "comment2", "status");
		orders.add(o);

		assertEquals("comment2", orders.get(orders.size()-1).getComment());
	}

	@Test
	void testDelete() {
		int size = orders.size();
		orders.remove(orders.get(0));

		assertEquals(size-1, orders.size());
	}

	@Test
	void testFreeNextID() {
		assertEquals(1, orders.getNextFreeID());
	}

	@Test
	void testGet() {
		assertEquals("comment",orders.get(0).getComment());
	}
}
