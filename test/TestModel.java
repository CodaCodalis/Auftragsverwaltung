import de.oszimt.ls11a1.model.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Model test class
 *
 * @author Steffen Trutz
 * @version 4.3
 */
class TestModel {

	Model model;

	@BeforeEach
	void init(){
		model = new Model();
	}

	/**
	 * A2.3
	 */
	@Test
	void testCustomerMgmt() {
		assertEquals("004930123456789",model.getCustomers().get(0).getTel());
	}

	/**
	 * A3.2
	 */
	@Test
	void testOrderMgmt() {
		assertEquals("24.12.2021",model.getCustomers().get(0).getOrders().get(0).getDate());
	}

	/**
	 * A3.3
	 */
	@Test
	void testAddressMgmt() {
		assertEquals("Mannheim",model.getCustomers().get(0).getAddresses().get(0).getTown());
	}

}
