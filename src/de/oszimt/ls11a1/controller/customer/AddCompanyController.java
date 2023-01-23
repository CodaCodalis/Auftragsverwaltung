/*
 * Created on 21.05.2022 by Kay Patzwald (patzwald@oszimt.de)
 */
package de.oszimt.ls11a1.controller.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.MainController;
import de.oszimt.ls11a1.model.customer.Company;

/**
 * @author Kay Patzwald (patzwald@oszimt.de)
 *
 */
public class AddCompanyController extends BaseController {

	public AddCompanyController(MainController controller) {
		super("addCompany","Firma hinzufügen",controller);
	}

	@Override
	protected void initController(Object... data) { initView(data);}

	public Company addCompany(String name, String contact, int creditLimit, String email, String tel){
		Company c = new Company(getModel().getCustomers().getNextFreeID(), name, contact, creditLimit, email, tel);
		getModel().getCustomers().add(c);
		return c;
	}

}
