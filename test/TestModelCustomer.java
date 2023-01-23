import de.oszimt.ls11a1.model.customer.Customer;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 * Customer test class
 *
 * @author Steffen Trutz
 * @version 4.6.2
 */
class TestModelCustomer {

	@Test
	void testConstructor() {
		Class<Customer> clazz = Customer.class;

		assertTrue(Modifier.isAbstract(clazz.getModifiers()), "Class Customer is not abstract");
	}

	@Test
	void testSet() {
		Class<Customer> clazz = Customer.class;

		try {
			clazz.getMethod("getId");
		} catch (NoSuchMethodException e) {
			fail("Method getId not exist in class customer");
		}

		try {
			clazz.getMethod("setId", int.class);
		} catch (NoSuchMethodException e) {
			fail("Method setId(int) not exist in class customer");
		}

		try {
			clazz.getMethod("getEmail");
		} catch (NoSuchMethodException e) {
			fail("Method getEmail not exist in class customer");
		}

		try {
			clazz.getMethod("setEmail", String.class);
		} catch (NoSuchMethodException e) {
			fail("Method setEmail(String) not exist in class customer");
		}

		try {
			clazz.getMethod("getTel");
		} catch (NoSuchMethodException e) {
			fail("Method getTel not exist in class customer");
		}

		try {
			clazz.getMethod("setTel", String.class);
		} catch (NoSuchMethodException e) {
			fail("Method setTel(String) not exist in class customer");
		}
	}

}
