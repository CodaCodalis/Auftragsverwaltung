package de.oszimt.ls11a1.view;

import de.oszimt.ls11a1.controller.MainController;
import de.oszimt.ls11a1.view.customer.*;

import java.util.Hashtable;

public class MainConsole implements IMainView{

    private Hashtable<String, IActualView> viewTable;

    private MainController controller;

    public void init(MainController controller) {
        this.controller = controller;
        initView();
    }

    private void initView() {
        viewTable = new Hashtable<>();
        viewTable.put("viewMain", new MainViewConsole());
        viewTable.put("viewCustomers", new ViewCustomersConsole());
        viewTable.put("viewCustomer", new ViewCustomerConsole());
        viewTable.put("removeCustomer", new RemoveCustomerConsole());
        viewTable.put("addOrder", new AddOrderConsole());
        viewTable.put("removeOrder", new RemoveOrderConsole());
        viewTable.put("addAddress", new AddAddressConsole());
        viewTable.put("removeAddress", new RemoveAddressConsole());

        System.out.println("Willkommen bei der Handwerker Service Eulenstein GmbH");
    }

    @Override
    public IActualView getView(String id) {
        return viewTable.get(id);
    }
}
