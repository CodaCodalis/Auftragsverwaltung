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
public class RemoveAddressController extends BaseController {

	public RemoveAddressController(MainController controller) {
		super("removeAddress","Addresse löschen",controller);
	}

	@Override
	protected void initController(Object... data) { initView(data);}

	public void removeAddress(Customer c, Address a){
		c.getAddresses().remove(a);
	}

}
