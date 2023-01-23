package de.oszimt.ls11a1.model.customer;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomerMgmt implements Iterable<Customer>{

    //private final Customer[] customers;
    private ArrayList<Customer> customers;

    public CustomerMgmt(){
        customers = new ArrayList<Customer>();
    }

    public void add(Customer c) {
        customers.add(c);
    }

    public void remove(Customer c) {
        customers.remove(c.getId());
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
    public Customer get(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (id == customers.get(i).getId()) {
                return customers.get(i);
            }
        }
        return customers.get(id);
    }

    public int size() {
        return customers.size();
    }

    /**
     * 1Stern: Gibt die nächste freie ID für einen neuen Kunden zurück, keine ID darf doppelt vorkommen
     * 3Stern: Berücksichtigung von Löschungen. Es sollen zusätzlich zur 1Stern Aufgabe keine ID Lücken entstehen.
     * @return ID
     */
    public int getNextFreeID() {
        //return customers.size();

        for (int i = 0; i < customers.size(); i++) {
            if (i < customers.get(i).getId()) {
                //System.out.println("Next available ID:  " + i);
                // at this point we know this is the next id.
                // we can leave the method and return the next ID.
                return i;
            }
        }
        return customers.size();
    }
    /**
     * Notwendig für Schleifenaufrufe for und foreach
     * @return Iterator
     */
    public Iterator<Customer> iterator() {
        // bei der ArrayList einfach customers.iterator(); verwenden
        return customers.iterator();
    }
}
