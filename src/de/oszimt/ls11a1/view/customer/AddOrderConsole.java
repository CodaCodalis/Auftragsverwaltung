package de.oszimt.ls11a1.view.customer;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.order.AddOrderController;
import de.oszimt.ls11a1.helper.ConsoleHelper;
import de.oszimt.ls11a1.model.order.Order;
import de.oszimt.ls11a1.view.IActualView;

/**
 * View for {@link de.oszimt.ls11a1.controller.order.AddOrderController}
 */
public class AddOrderConsole implements IActualView {

    @Override
    public void init(BaseController controller, Object... data) {
        String comment = ConsoleHelper.input("Kommentar");
        String status = ConsoleHelper.input("Status");
        String date = ConsoleHelper.input("Datum");
        String time = ConsoleHelper.input("Zeit");

        AddOrderController aoc = ((AddOrderController)controller);
        Order o = aoc.addOrder((int) data[0], comment, status, date, time);
        System.out.printf("Auftrag %s erstellt: %s\n",o.getId(), o);

        controller.getMainController().setController("viewCustomer", data[0]);

    }
}
