import de.oszimt.ls11a1.model.order.Order;
import de.oszimt.ls11a1.view.IView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Customer test class
 *
 * @author Steffen Trutz
 * @version 3.2.1
 */
class TestModelOrder {

	@Test
	void testConstructor() {
		Order o = new Order(1, "comment", "status");

		assertEquals(1,o.getId());
		assertEquals("comment",o.getComment());
		assertEquals("status",o.getStatus());
	}

	@Test
	void testConstructorComplex() {
		Order o = new Order(1, "comment", "status", "01.01.22", "00:00");

		assertEquals("01.01.22",o.getDate());
		assertEquals("00:00",o.getTime());
	}

	@Test
	void testSet() {
		Order o = new Order(0, null, null);

		o.setId(12);
		assertEquals(12,o.getId());

		o.setComment("comment");
		assertEquals("comment",o.getComment());

		o.setStatus("status");
		assertEquals("status",o.getStatus());

		o.setDate("01.01.22");
		assertEquals("01.01.22",o.getDate());

		o.setTime("00:00");
		assertEquals("00:00",o.getTime());
	}

	@Test
	void checkView(){
		Order o = new Order(0, null, null);

		IView iView = () -> {};
		o.addView(iView);
		o.removeView(iView);
	}

}
