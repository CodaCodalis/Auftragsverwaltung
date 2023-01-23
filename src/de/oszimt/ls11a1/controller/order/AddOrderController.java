/*
 * Created on 21.05.2022 by Kay Patzwald (patzwald@oszimt.de)
 */
package de.oszimt.ls11a1.controller.order;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.MainController;
import de.oszimt.ls11a1.model.order.Order;
import de.oszimt.ls11a1.model.order.OrderMgmt;

/**
 * @author Kay Patzwald (patzwald@oszimt.de)
 *
 */
public class AddOrderController extends BaseController {

	public AddOrderController(MainController controller) {
		super("addOrder","Auftrag hinzufügen",controller);
	}

	@Override
	protected void initController(Object... data) { initView(data);}

	public Order addOrder(int customerId, String comment, String status, String date, String time){
		OrderMgmt om = getModel().getCustomers().get(customerId).getOrders();
		Order o = new Order(om.getNextFreeID(), comment, status, date, time);
		om.add(o);
		return o;
	}

}
