package de.oszimt.ls11a1.model.customer;

import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.address.AddressMgmt;

public class Consumer extends Customer{
    private String lastname;
    private String firstname;

    public Consumer(int id, String lastname, String firstname) {
        super(id, lastname, firstname);
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Consumer(int id, String lastname, String firstname, String email, String tel) {
        super(id, email, tel);
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String getAddressLabel() {
        AddressMgmt addresses = getAddresses();
        Address address = addresses.getDefaultAddress();
        return getFirstname() + " " + getLastname() + "\n"
                + address.getStreet() + "\n"
                + address.getPlz() + " " + address.getTown();
    }

    @Override
    public String toString() {
        return "Consumer{" +
                ", customerID=" + getId() +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
