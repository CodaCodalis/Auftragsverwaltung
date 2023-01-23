import de.oszimt.ls11a1.model.customer.Consumer;
import de.oszimt.ls11a1.model.customer.Customer;
import de.oszimt.ls11a1.model.customer.CustomerMgmt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 * CustomerMgmt test class
 *
 * @author Steffen Trutz
 * @version 4.6.2
 */
class TestModelCustomerMgmt {

	CustomerMgmt customers;

	/**
	 * A2.3
	 */
	@BeforeEach
	void init(){
		customers = new CustomerMgmt();

		//testdata
		Customer c = new Consumer(0, "lastname", "firstname", "email", "tel");
		customers.add(c);
	}

	/**
	 * A2.3
	 */
	@Test
	void testAddSize() {
		int size = customers.size();
		Customer c = new Consumer(customers.getNextFreeID(), "lastname", "firstname");
		customers.add(c);

		assertEquals(size+1,customers.size());
	}

	/**
	 * A2.3
	 */
	@Test
	void testAddContent() {
		Customer c = new Consumer(customers.getNextFreeID(), "lastname", "firstname", "email", "tel");
		customers.add(c);

		assertEquals("email",customers.get(customers.size()-1).getEmail());
	}

	/**
	 * A2.3
	 */
	@Test
	void testDelete() {
		int size = customers.size();
		customers.remove(customers.get(0));

		assertEquals(size-1,customers.size());
	}

	/**
	 * A2.3
	 */
	@Test
	void testFreeNextID() {
		assertEquals(1,customers.getNextFreeID());
	}

	/**
	 * A2.3
	 * Dieser Test funktioniert nur, wenn die 3 Sterne Aufgabe erledigt wurde.
	 */
	@Test
	void testFreeNextIDSterne3() {
		Customer c = new Consumer(2, "lastname", "firstname");
		customers.add(c);

		assertEquals(1,customers.getNextFreeID());
	}

	/**
	 * A2.3
	 */
	@Test
	void testGet() {
		assertEquals("tel",customers.get(0).getTel());
	}

	/**
	 * A2.3
	 * Dieser Test funktioniert nur, wenn die 2 Sterne Aufgabe erledigt wurde.
	 */
	@Test
	void testGetSterne2() {
		Customer c = new Consumer(2, "lastname", "firstname", "email2", "tel3");
		customers.add(c);

		assertEquals(2,customers.size());
		assertEquals("tel3",customers.get(2).getTel());
	}
}
