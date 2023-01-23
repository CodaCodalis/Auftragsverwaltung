package de.oszimt.ls11a1.view.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.customer.AddConsumerController;
import de.oszimt.ls11a1.helper.ConsoleHelper;
import de.oszimt.ls11a1.model.customer.Customer;
import de.oszimt.ls11a1.view.IActualView;

public class AddConsumerConsole implements IActualView {

    @Override
    public void init(BaseController controller, Object... data) {
        String firstName = ConsoleHelper.input("Vorname");
        String lastName = ConsoleHelper.input("Nachname");
        String email = ConsoleHelper.input("E-Mail");
        String tel = ConsoleHelper.input("Telefon");

        AddConsumerController acc = ((AddConsumerController)controller);
        Customer c = acc.addConsumer(lastName, firstName, email, tel);
        System.out.printf("Privatkunde %s erstellt: %s\n",c.getId(), c);

        controller.getMainController().setController("viewCustomers");

    }
}
