package de.oszimt.ls11a1.view.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.customer.AddCompanyController;
import de.oszimt.ls11a1.helper.ConsoleHelper;
import de.oszimt.ls11a1.model.customer.Company;
import de.oszimt.ls11a1.view.IActualView;

public class AddCompanyConsole implements IActualView {

    @Override
    public void init(BaseController controller, Object... data) {
        String name = ConsoleHelper.input("Name");
        String contact = ConsoleHelper.input("Kontaktperson");
        int creditLimit = ConsoleHelper.inputInt("Kreditlimit");
        String email = ConsoleHelper.input("E-Mail");
        String tel = ConsoleHelper.input("Telefon");

        AddCompanyController acc = ((AddCompanyController)controller);
        Company c = acc.addCompany(name, contact, creditLimit, email, tel);
        System.out.printf("Firma %s erstellt: %s\n",c.getId(), c);

        controller.getMainController().setController("viewCustomers");
    }
}
