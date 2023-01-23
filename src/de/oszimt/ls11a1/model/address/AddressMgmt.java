package de.oszimt.ls11a1.model.address;

import java.util.ArrayList;
import java.util.Iterator;

public class AddressMgmt implements Iterable<Address>{
    private ArrayList<Address> addresses;
    private Address defaultAddress;

    public AddressMgmt(){
        addresses = new ArrayList<Address>();
    }

    public int size() {
        return addresses.size();
    }

    public void setDefaultAddress(Address defaultAddress) {
        for (Address address : addresses) {
            if (defaultAddress == address) {
                this.defaultAddress = defaultAddress;
                break;
            }
        }
    }

    public Address getDefaultAddress() {
        return defaultAddress;
    }

    public void remove(Address a) {
        if (addresses.size() > 1) {
            addresses.remove(a);
        }
        if (addresses.size() > 0) {
            if (a.getId() == defaultAddress.getId()) {
                defaultAddress = addresses.get(0);
            }
        } else {
            defaultAddress = null;
        }
    }

    /**
     * Notwendig für Schleifenaufrufe for und foreach
     * @return Iterator
     */
    public Iterator<Address> iterator() {
        // bei der ArrayList einfach customers.iterator(); verwenden
        return addresses.iterator();
    }

    public void add(Address a) {
        if (defaultAddress == null) {
            defaultAddress = a;
        }
        addresses.add(a);
    }

    /**
     * 1Stern: Gibt die nächste freie ID für einen neuen Kunden zurück, keine ID darf doppelt vorkommen
     * 3Stern: Berücksichtigung von Löschungen. Es sollen zusätzlich zur 1Stern Aufgabe keine ID Lücken entstehen.
     * @return ID
     */
    public int getNextFreeID() {
        //return customers.size();

        for (int i = 0; i < addresses.size(); i++) {
            if (i < addresses.get(i).getId()) {
                //System.out.println("Next available ID:  " + i);
                // at this point we know this is the next id.
                // we can leave the method and return the next ID.
                return i;
            }
        }
        return addresses.size();
    }
    /**
     * 1Stern: Gibt den Kunden anhand seiner Position im Array zurück
     * 2Stern: Gibt den Kunden anhand seiner ID (getID) zurück.
     * @param id, CustomerID
     * @return Customer
     */

    public Address get(int id) {
        for (int i = 0; i < addresses.size(); i++) {
            if (id == addresses.get(i).getId()) {
                return addresses.get(i);
            }
        }
        return addresses.get(id);
    }
}
