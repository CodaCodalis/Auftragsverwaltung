package de.oszimt.ls11a1.view.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.address.RemoveAddressController;
import de.oszimt.ls11a1.helper.ConsoleHelper;
import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.customer.Customer;
import de.oszimt.ls11a1.view.IActualView;

import java.util.ArrayList;

public class RemoveAddressConsole implements IActualView {

    @Override
    public void init(BaseController controller, Object... data) {
        Customer c = controller.getModel().getCustomers().get((int) data[0]);

        //zwischenspeichern von allen Kunden.
        ArrayList<Address> list = new ArrayList<>();
        c.getAddresses().iterator().forEachRemaining(list::add);

        //alle Kunden ausgeben
        int count = 0;
        for (Address a : list){
            System.out.printf("[%2s] %s\n", count, a);
            count++;
        }

        int size = controller.getModel().getCustomers().size();
        ConsoleHelper.printController(controller, "viewCustomer", size);

        int x = ConsoleHelper.inputInt("Wählen Sie den zu löschende Adresse",0,size);

        //nur löschen, wenn nicht der letzte Menüpunkt gewählt wurde.
        if (x != size){
            RemoveAddressController rcc = (RemoveAddressController)controller;
            rcc.removeAddress(c, list.get(x));
            System.out.printf("Adresse %s von Kunde %s gelöscht: %s\n", x, c.getId(), list.get(x));
        }

        controller.getMainController().setController("viewCustomer", c.getId());
    }
}
