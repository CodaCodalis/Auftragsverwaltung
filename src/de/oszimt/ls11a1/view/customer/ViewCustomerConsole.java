package de.oszimt.ls11a1.view.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.helper.ConsoleHelper;
import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.customer.Customer;
import de.oszimt.ls11a1.model.order.Order;
import de.oszimt.ls11a1.view.IActualView;

public class ViewCustomerConsole implements IActualView {

    @Override
    public void init(BaseController controller, Object... data) {
        Customer c = controller.getModel().getCustomers().get((int) data[0]);

        System.out.println(c);
        for (Order o: controller.getModel().getCustomers().get((int) data[0]).getOrders()) {
            System.out.println(o);
        }
        for (Address a: controller.getModel().getCustomers().get((int) data[0]).getAddresses()) {
            System.out.println(a);
        }

        //generate the menu
        String[] menuAry = {"addOrder","removeOrder", "addAddress", "removeAddress", "viewCustomers","viewMain"};
        for (int i = 0; i< menuAry.length;i++) {
            ConsoleHelper.printController(controller, menuAry[i], i);
        }

        int x = ConsoleHelper.inputInt("Was wollen Sie tun?",0,menuAry.length-1);

        //controller.getMainController().setController(menuAry[x]);
        if (menuAry[x].equals("addOrder") || menuAry[x].equals("removeOrder") || menuAry[x].equals("addAddress") || menuAry[x].equals("removeAddress")) {
            controller.getMainController().setController(menuAry[x], c.getId());
        } else{
            controller.getMainController().setController(menuAry[x]);
        }
    }
}
