package de.oszimt.ls11a1.view.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.address.AddAddressController;
import de.oszimt.ls11a1.controller.order.AddOrderController;
import de.oszimt.ls11a1.helper.ConsoleHelper;
import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.view.IActualView;

/**
 * View for {@link AddOrderController}
 */
public class AddAddressConsole implements IActualView {

    @Override
    public void init(BaseController controller, Object... data) {
        String street = ConsoleHelper.input("Straße");
        int plz = ConsoleHelper.inputInt("PLZ", 0,99999);
        String town = ConsoleHelper.input("Stadt");

        AddAddressController aac = ((AddAddressController)controller);
        Address a = aac.addAddress((int) data[0], street, plz, town);
        System.out.printf("Adresse %s erstellt: %s\n",a.getId(), a);

        controller.getMainController().setController("viewCustomer", data[0]);

    }
}
