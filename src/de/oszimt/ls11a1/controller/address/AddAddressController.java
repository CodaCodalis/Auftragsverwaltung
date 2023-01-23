/*
 * Created on 21.05.2022 by Kay Patzwald (patzwald@oszimt.de)
 */
package de.oszimt.ls11a1.controller.address;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.MainController;
import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.address.AddressMgmt;

/**
 * @author Kay Patzwald (patzwald@oszimt.de)
 *
 */
public class AddAddressController extends BaseController {

	public AddAddressController(MainController controller) {
		super("addAddress","Addresse hinzufügen",controller);
	}

	@Override
	protected void initController(Object... data) { initView(data);}

	public Address addAddress(int customerId, String street, int plz, String town){
		AddressMgmt am = getModel().getCustomers().get(customerId).getAddresses();
		Address a = new Address(am.getNextFreeID(), street, plz, town);
		am.add(a);
		return a;
	}

}
