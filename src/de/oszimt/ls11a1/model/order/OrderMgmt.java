package de.oszimt.ls11a1.model.order;

import java.util.ArrayList;
import java.util.Iterator;

public class OrderMgmt implements Iterable<Order>{
    private ArrayList<Order> orders;

    public OrderMgmt(){
        orders = new ArrayList<Order>();
    }

    public void add(Order o) {
        orders.add(o);
    }

    public void remove(Order o) {
        orders.remove(o.getId());
    }

    /**
     * 1Stern: Gibt den Kunden anhand seiner Position im Array zurück
     * 2Stern: Gibt den Kunden anhand seiner ID (getID) zurück.
     * @param id, CustomerID
     * @return Customer
     */
/*
    public Customer get(int id) {
        return customers.get(id);
    }
*/
    public Order get(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (id == orders.get(i).getId()) {
                return orders.get(i);
            }
        }
        return orders.get(id);
    }

    public int size() {
        return orders.size();
    }

    /**
     * 1Stern: Gibt die nächste freie ID für einen neuen Kunden zurück, keine ID darf doppelt vorkommen
     * 3Stern: Berücksichtigung von Löschungen. Es sollen zusätzlich zur 1Stern Aufgabe keine ID Lücken entstehen.
     * @return ID
     */
    public int getNextFreeID() {
        //return customers.size();

        for (int i = 0; i < orders.size(); i++) {
            if (i < orders.get(i).getId()) {
                //System.out.println("Next available ID:  " + i);
                // at this point we know this is the next id.
                // we can leave the method and return the next ID.
                return i;
            }
        }
        return orders.size();
    }
    /**
     * Notwendig für Schleifenaufrufe for und foreach
     * @return Iterator
     */
    public Iterator<Order> iterator() {
        // bei der ArrayList einfach customers.iterator(); verwenden
        return orders.iterator();
    }
}
