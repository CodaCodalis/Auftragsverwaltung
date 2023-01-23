import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.view.IView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Customer test class
 *
 * @author Steffen Trutz
 * @version 3.3.1
 */
class TestModelAddress {

	@Test
	void testConstructor() {
		Address a = new Address(1, "street", 11111,"town");

		assertEquals(1, a.getId());
		assertEquals("street", a.getStreet());
		assertEquals(11111, a.getPlz());
		assertEquals("town", a.getTown());
	}

	@Test
	void testSet() {
		Address a = new Address(0, null, 0, null);

		a.setId(12);
		assertEquals(12, a.getId());

		a.setStreet("s");
		assertEquals("s", a.getStreet());

		a.setPlz(1);
		assertEquals(1,a.getPlz());

		a.setTown("t");
		assertEquals("t", a.getTown());
	}

	@Test
	void checkView(){
		Address a = new Address(0, null, 0, null);

		IView iView = () -> {};
		a.addView(iView);
		a.removeView(iView);
	}

}
