/*
 * Created on 21.05.2022 by Kay Patzwald (patzwald@oszimt.de)
 */
package de.oszimt.ls11a1.controller.address;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.MainController;
import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.customer.Customer;

/**
 * @author Kay Patzwald (patzwald@oszimt.de)
 *
 */
public class DefaultAddressController extends BaseController {

	public DefaultAddressController(MainController controller) {
		super("defaultAddress","Standardaddresse wählen",controller);
	}

	@Override
	protected void initController(Object... data) { initView(data);}

	public void defaultAddress(Customer c, Address a){
		c.getAddresses().setDefaultAddress(a);
	}


}
