package de.oszimt.ls11a1.view.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.customer.RemoveCustomerController;
import de.oszimt.ls11a1.helper.ConsoleHelper;
import de.oszimt.ls11a1.model.customer.Customer;
import de.oszimt.ls11a1.view.IActualView;

import java.util.ArrayList;

public class RemoveCustomerConsole implements IActualView {

    @Override
    public void init(BaseController controller, Object... data) {

        //zwischenspeichern von allen Kunden.
        ArrayList<Customer> list = new ArrayList<>();
        controller.getModel().getCustomers().iterator().forEachRemaining(list::add);

        //alle Kunden ausgeben
        int count = 0;
        for (Customer c : list){
            System.out.printf("[%2s] %s\n", count, c);
            count++;
        }

        int size = controller.getModel().getCustomers().size();
        ConsoleHelper.printController(controller, "viewMain", size);

        int x = ConsoleHelper.inputInt("Wählen Sie den zu löschenden Kunden",0,size);

        //nur löschen, wenn nicht der letzte Menüpunkt gewählt wurde.
        if (x != size){
            RemoveCustomerController rcc = (RemoveCustomerController)controller;
            rcc.removeCustomer(list.get(x));
            System.out.printf("Kunde %s gelöscht: %s\n", x, list.get(x));
        }

        controller.getMainController().setController("viewMain");
    }
}
