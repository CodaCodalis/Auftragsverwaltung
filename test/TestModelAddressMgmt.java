import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.address.AddressMgmt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 * Address mgmt test class
 *
 * @author Steffen Trutz
 * @version 3.3.2
 */
class TestModelAddressMgmt {

	AddressMgmt addresses;

	@BeforeEach
	void init(){
		addresses = new AddressMgmt();

		//testdata
		Address a = new Address(0, "street", 11111,"town");
		addresses.add(a);
	}

	@Test
	void testAddSize() {
		int size = addresses.size();
		Address a = new Address(addresses.getNextFreeID(), "street2", 1,  "town2");
		addresses.add(a);

		assertEquals(size+1,addresses.size());
	}

	@Test
	void testAddContent() {
		Address a = new Address(addresses.getNextFreeID(), "street2", 1,  "town2");
		addresses.add(a);

		assertEquals("street2",addresses.get(addresses.size()-1).getStreet());
	}

	/**
	 * Löschen von mind. 2 Adressen, soll klappen.
	 */
	@Test
	void testDeleteTwo() {
		Address a = new Address(addresses.getNextFreeID(), "street2", 1,  "town2");
		addresses.add(a);
		int size = addresses.size();
		addresses.remove(addresses.get(0));

		assertEquals(size-1,addresses.size());
	}

	/**
	 * Löschen von einer Adresse, soll nicht klappen.
	 */
	@Test
	void testDeleteOne() {
		addresses.remove(addresses.get(0));

		assertEquals(1,addresses.size(),"Letzte Adresse nicht löschen");
	}

	@Test
	void testFreeNextID() {
		assertEquals(1,addresses.getNextFreeID());
	}

	@Test
	void testGet() {
		assertEquals("street",addresses.get(0).getStreet());
	}

	@Test
	void testDefaultAdd() {
		assertEquals("street",addresses.getDefaultAddress().getStreet());
	}

	/**
	 * Beim Entfernen der Standardadresse soll eine andere Adresse Standard werden
	 */
	@Test
	void testDefaultRemove() {
		Address a = new Address(addresses.getNextFreeID(), "street2", 1,  "town2");
		addresses.add(a);
		addresses.remove(addresses.getDefaultAddress());
		assertEquals("street2",addresses.getDefaultAddress().getStreet());
	}

	/**
	 * Setzen einer bekannten Adresse soll klappen
	 */
	@Test
	void testDefaultSet() {
		Address a = new Address(addresses.getNextFreeID(), "street2", 1,  "town2");
		addresses.add(a);
		addresses.setDefaultAddress(a);
		assertEquals("street2",addresses.getDefaultAddress().getStreet());
	}

	/**
	 * Setzen einer null Adresse soll nicht klappen
	 */
	@Test
	void testDefaultSetNull() {
		addresses.setDefaultAddress(null);
		assertNotNull(addresses.getDefaultAddress(),"Nulladresse ist nicht zulässig");
	}

	/**
	 * Setzen einer unbekannten Adresse soll nicht klappen
	 */
	@Test
	void testDefaultUnknown() {
		Address a = new Address(addresses.getNextFreeID(), "street2", 1,  "town2");
		addresses.setDefaultAddress(a);
		assertEquals("street",addresses.getDefaultAddress().getStreet());
	}
}
