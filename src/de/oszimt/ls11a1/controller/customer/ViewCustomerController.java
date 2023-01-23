/*
 * Created on 21.05.2022 by Kay Patzwald (patzwald@oszimt.de)
 */
package de.oszimt.ls11a1.controller.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.MainController;

/**
 * @author Kay Patzwald (patzwald@oszimt.de)
 *
 */
public class ViewCustomerController extends BaseController {

	public ViewCustomerController(MainController controller) {
		super("viewCustomer","Kunde anzeigen",controller);
	}

	@Override
	protected void initController(Object... data) { initView(data); }

}
