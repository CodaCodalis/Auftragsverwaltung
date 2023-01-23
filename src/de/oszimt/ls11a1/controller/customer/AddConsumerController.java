/*
 * Created on 21.05.2022 by Kay Patzwald (patzwald@oszimt.de)
 */
package de.oszimt.ls11a1.controller.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.MainController;
import de.oszimt.ls11a1.model.customer.Consumer;

/**
 * @author Kay Patzwald (patzwald@oszimt.de)
 *
 */
public class AddConsumerController extends BaseController {

	public AddConsumerController(MainController controller) {
		super("addConsumer","Privatkunde hinzufügen",controller);
	}

	@Override
	protected void initController(Object... data) { initView(data);}

	public Consumer addConsumer(String lastname, String firstname, String email, String tel){
		Consumer c = new Consumer(getModel().getCustomers().getNextFreeID(), lastname, firstname, email, tel);
		getModel().getCustomers().add(c);
		return c;
	}

}
