package de.oszimt.ls11a1.model;

import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.address.AddressMgmt;
import de.oszimt.ls11a1.model.customer.Company;
import de.oszimt.ls11a1.model.customer.Consumer;
import de.oszimt.ls11a1.model.customer.Customer;
import de.oszimt.ls11a1.model.customer.CustomerMgmt;
import de.oszimt.ls11a1.model.order.Order;
import de.oszimt.ls11a1.model.order.OrderMgmt;

public class Model {

    private final CustomerMgmt customers;

    public Model() {
        this.customers = new CustomerMgmt();

        Customer c = new Consumer(0, "Bellenbaum", "Mira", "mira.bellenbaum@gmail.com", "004930123456789");
        OrderMgmt o = c.getOrders();
        o.add(new Order(o.getNextFreeID(), "Entplumpung der Plumpen", "beauftragt","24.12.2021","15:00"));
        o.add(new Order(o.getNextFreeID(), "Sägearbeiten", "angeschnitten","17.06.2022","10:00"));
        o.add(new Order(o.getNextFreeID(), "Baumfällarbeiten", "fertig"));
        AddressMgmt a = c.getAddresses();
        a.add(new Address(a.getNextFreeID(), "Zäher Wille 5", 68305, "Mannheim"));
        a.add(new Address(a.getNextFreeID(), "Auf der Kegelbahn 7", 53925, "Kall"));
        customers.add(c);

        c = new Consumer(1, "Gator", "Ali", "ali.gator@web.de", "004444123435446789");
        o = c.getOrders();
        o.add(new Order(o.getNextFreeID(), "Whirlpool säubern", "Wasserschaden verursacht","15.08.2022","13:00"));
        o.add(new Order(o.getNextFreeID(), "Erweiterung Schwimmbecken", "in Planung","18.08.2022","07:00"));
        o.add(new Order(o.getNextFreeID(), "Entgräten von Fischgräten", "fertig"));
        o.add(new Order(o.getNextFreeID(), "Neuen Wasseranschluss legen", "angefangen","17.08.2022","09:00"));
        a = c.getAddresses();
        a.add(new Address(a.getNextFreeID(), "Zornige Ameise 2", 45134, "Essen"));
        a.add(new Address(a.getNextFreeID(), "Kleines Berg 5a", 16227, "Eberswalde"));
        a.add(new Address(a.getNextFreeID(), "Unter Fettenhennen 11", 50667, "Köln"));
        a.add(new Address(a.getNextFreeID(), "Hölle 6", 25746, "Heide"));
        customers.add(c);

        c = new Consumer(2, "Ghurt", "Jo", "jo.ghurt@mailbox.org", "0049157653465");
        customers.add(c);

        c = new Company(3, "Rost & Söhne", "Frau Nagel", 2000, "nagel@rostundsoehne.de", "04991218923356");
        o = c.getOrders();
        o.add(new Order(o.getNextFreeID(), "Brandenburger Tor entkernen", "Denkmalschutz klärt","01.04.2023","07:30"));
        a = c.getAddresses();
        a.add(new Address(a.getNextFreeID(), "L7, 8", 68165, "Mannheim"));
        a.add(new Address(a.getNextFreeID(), "Spar dir die Müh 4", 38685, "Langelsheim"));
        customers.add(c);

        c = new Company(4, "Fliesenzentrum Peter Platten", "Herr Platten", 5000, "platten@fliesenzentrumplatten.de", "0496994550102");
        o = c.getOrders();
        o.add(new Order(o.getNextFreeID(), "Großen Saal neufliesen", "Material hängt in Russland fest","15.03.2022","08:00"));
        a = c.getAddresses();
        a.add(new Address(a.getNextFreeID(), "Geil 5", 24960, "Munkbrarup"));
        customers.add(c);
    }

    public CustomerMgmt getCustomers() {
        return customers;
    }
}
