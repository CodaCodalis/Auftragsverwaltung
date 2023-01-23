package de.oszimt.ls11a1.view.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.order.RemoveOrderController;
import de.oszimt.ls11a1.helper.ConsoleHelper;
import de.oszimt.ls11a1.model.customer.Customer;
import de.oszimt.ls11a1.model.order.Order;
import de.oszimt.ls11a1.model.order.OrderMgmt;
import de.oszimt.ls11a1.view.IActualView;

public class RemoveOrderConsole implements IActualView {

    @Override
    public void init(BaseController controller, Object... data) {
        Customer c = controller.getModel().getCustomers().get((int) data[0]);
        OrderMgmt om = c.getOrders();
        int size = om.size();

        for(int i=0; i<size; i++) {
            Order o = om.get(i);
            System.out.printf("[%2s] %s\n",i, o);
        }

        ConsoleHelper.printController(controller, "viewCustomer", size);

        int x = ConsoleHelper.inputInt("Wählen Sie den zu löschenen Auftrag",0,size);

        //nur löschen, wenn nicht der letzte Menüpunkt gewählt wurde.
        if (x != size){
            RemoveOrderController roc = (RemoveOrderController)controller;
            roc.removeOrder(c.getId(), x);
            System.out.printf("Auftrag %s gelöscht.\n",x);
        }

        controller.getMainController().setController("viewCustomer", c.getId());
    }
}
