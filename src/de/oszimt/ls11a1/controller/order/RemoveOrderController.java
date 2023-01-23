/*
 * Created on 21.05.2022 by Kay Patzwald (patzwald@oszimt.de)
 */
package de.oszimt.ls11a1.controller.order;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.MainController;

/**
 * @author Kay Patzwald (patzwald@oszimt.de)
 *
 */
public class RemoveOrderController extends BaseController {

	public RemoveOrderController(MainController controller) {
		super("removeOrder","Auftrag löschen",controller);
	}

	@Override
	protected void initController(Object... data) { initView(data);}

	public void removeOrder(int customerID, int orderId){
		getModel().getCustomers().get(customerID).getOrders().remove(getModel().getCustomers().get(customerID).getOrders().get(orderId));
	}

}
