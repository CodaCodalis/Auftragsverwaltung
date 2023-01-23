package de.oszimt.ls11a1.view;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.helper.ConsoleHelper;

public class MainViewConsole implements IActualView{

    @Override
    public void init(BaseController controller, Object... data) {

        //generate the menu
        String[] menuAry = {"viewCustomers","addCustomer", "addConsumer", "addCompany", "removeCustomer","exit"};

        for (int i = 0; i< menuAry.length;i++) {
            ConsoleHelper.printController(controller, menuAry[i], i);
        }

        int x = ConsoleHelper.inputInt("Was wollen Sie tun?",0,menuAry.length-1);

        controller.getMainController().setController(menuAry[x]);
    }
}
