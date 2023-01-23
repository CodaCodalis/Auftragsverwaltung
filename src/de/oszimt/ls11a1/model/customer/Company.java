package de.oszimt.ls11a1.model.customer;

import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.address.AddressMgmt;

public class Company extends Customer{
    private int creditLimit;
    private String name;
    private String contact;

    public Company(int id, String name, String contact) {
        super(id);
        this.name = name;
        this.contact = contact;
    }

    public Company(int id, String name, String contact, int creditLimit, String email, String tel) {
        super(id, email, tel);
        this.creditLimit = creditLimit;
        this.name = name;
        this.contact = contact;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddressLabel() {
        AddressMgmt addresses = getAddresses();
        Address address = addresses.getDefaultAddress();
        return getName() + "\n"
                + getContact() + "\n"
                + address.getStreet() + "\n"
                + address.getPlz() + " " + address.getTown();
    }

    @Override
    public String toString() {
        return "Company{" +
                ", customerID=" + getId() +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", creditLimit='" + creditLimit + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
