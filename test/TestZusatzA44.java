import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.base.BaseObject;
import de.oszimt.ls11a1.model.customer.Customer;
import de.oszimt.ls11a1.model.order.Order;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Customer test class
 *
 * @author Steffen Trutz
 * @version 4.4.2
 */
class TestZusatzA44 {

	@Test
	void testConstructor() {
		Class<BaseObject> clazz = BaseObject.class;
		try {
			clazz.getConstructor(int.class);
		} catch (NoSuchMethodException e) {
			fail("Kein passender Konstruktor (int) in BaseObject");
		}
	}

	@Test
	void testAbstract() {
		Class<BaseObject> clazz = BaseObject.class;

		assertTrue(Modifier.isAbstract(clazz.getModifiers()), "Class BaseObject is not abstract");
	}

	@Test
	void customerExtendsBaseObject(){
		assertTrue(BaseObject.class.isAssignableFrom(Customer.class), "Class Customer erbt nicht von BaseObject");
	}

	@Test
	void addressExtendsBaseObject(){
		assertTrue(BaseObject.class.isAssignableFrom(Address.class), "Class Address erbt nicht von BaseObject");
	}

	@Test
	void orderExtendsBaseObject(){
		assertTrue(BaseObject.class.isAssignableFrom(Order.class), "Class Order erbt nicht von BaseObject");
	}

}
