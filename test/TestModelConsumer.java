import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.customer.Consumer;
import de.oszimt.ls11a1.view.IView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 * Consumer test class
 *
 * @author Steffen Trutz
 * @version 4.6.2
 */
class TestModelConsumer {

	private static Consumer getObject() {
		return new Consumer(1, "last", "first");
	}

	@Test
	void testConstructor() {
		Consumer c = getObject();

		assertEquals(1,c.getId());
		assertEquals("last",c.getLastname());
		assertEquals("first",c.getFirstname());
	}

	@Test
	void testConstructorComplex() {
		Consumer c = new Consumer(1, "last", "first", "email", "tel");

		assertEquals("email",c.getEmail());
		assertEquals("tel",c.getTel());
	}

	@Test
	void testSet() {
		Consumer c = getObject();

		c.setId(12);
		assertEquals(12, c.getId());

		c.setFirstname("first2");
		assertEquals("first2",c.getFirstname());

		c.setLastname("last2");
		assertEquals("last2",c.getLastname());

		c.setEmail("email");
		assertEquals("email",c.getEmail());

		c.setTel("tel");
		assertEquals("tel",c.getTel());
	}

	/**
	 * A4.6
	 */
	@Test
	void addressLabelSpecific(){
		Consumer c = getObject();
		c.getAddresses().add(new Address(0, "street", 111, "town"));

		String erg = c.getAddressLabel();
		assertTrue(erg.contains("last"), "Nachname nicht vorhanden");
		assertTrue(erg.contains("first"), "Vorname nicht vorhanden");
	}

	/**
	 * A4.6
	 */
	@Test
	void addressLabelBasic(){
		Consumer c = getObject();
		c.getAddresses().add(new Address(0, "street", 111, "town"));

		String erg = c.getAddressLabel();
		assertTrue(erg.contains("street"), "Straße nicht vorhanden");
		assertTrue(erg.contains("town"), "Stadt nicht vorhanden");
		assertTrue(erg.contains("111"), "PLZ nicht vorhanden");
	}

	@Test
	void checkView(){
		Consumer c = getObject();

		IView iView = () -> {};
		c.addView(iView);
		c.removeView(iView);
	}

}
