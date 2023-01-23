import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.customer.Company;
import de.oszimt.ls11a1.view.IView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 * Company test class
 *
 * @author Steffen Trutz
 * @version 4.6.2
 */
class TestModelCompany {

	private static Company getObject() {
		return new Company(1, "name", "contact");
	}

	@Test
	void testConstructor() {
		Company c = getObject();

		assertEquals(1,c.getId());
		assertEquals("name",c.getName());
		assertEquals("contact",c.getContact());
	}

	@Test
	void testConstructorComplex() {
		Company c = new Company(1, "name", "contact", 100, "email", "tel");

		assertEquals(100,c.getCreditLimit());
		assertEquals("email",c.getEmail());
		assertEquals("tel",c.getTel());
	}

	@Test
	void testSet() {
		Company c = getObject();

		c.setId(12);
		assertEquals(12, c.getId());

		c.setName("name1");
		assertEquals("name1",c.getName());

		c.setContact("contact1");
		assertEquals("contact1",c.getContact());

		c.setCreditLimit(100);
		assertEquals(100, c.getCreditLimit());

		c.setEmail("email");
		assertEquals("email",c.getEmail());

		c.setTel("tel");
		assertEquals("tel",c.getTel());
	}

	/**
	 * A4.6
	 */
	@Test
	void addressLabelBasic(){
		Company c = getObject();
		c.getAddresses().add(new Address(0, "street", 111, "town"));

		String erg = c.getAddressLabel();
		assertTrue(erg.contains("street"), "Straße nicht vorhanden");
		assertTrue(erg.contains("town"), "Stadt nicht vorhanden");
		assertTrue(erg.contains("111"), "PLZ nicht vorhanden");
	}

	/**
	 * A4.6
	 */
	@Test
	void addressLabelSpecific(){
		Company c = getObject();
		c.getAddresses().add(new Address(0, "street", 111, "town"));

		String erg = c.getAddressLabel();
		assertTrue(erg.contains("name"), "Firmenname nicht vorhanden");
		assertTrue(erg.contains("contact"), "Kontakt nicht vorhanden");
	}

	@Test
	void checkView(){
		Company c = getObject();

		IView iView = () -> {};
		c.addView(iView);
		c.removeView(iView);
	}

}
