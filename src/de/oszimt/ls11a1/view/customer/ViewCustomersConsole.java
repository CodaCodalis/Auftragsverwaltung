package de.oszimt.ls11a1.view.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.helper.ConsoleHelper;
import de.oszimt.ls11a1.model.customer.Customer;
import de.oszimt.ls11a1.view.IActualView;

import java.util.ArrayList;

public class ViewCustomersConsole implements IActualView {

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

        int x = ConsoleHelper.inputInt("Wählen Sie den Kunden",0,size);

        if (x == size){
            controller.getMainController().setController("viewMain");
        } else {
            controller.getMainController().setController("viewCustomer", list.get(x).getId());
        }
    }
}
