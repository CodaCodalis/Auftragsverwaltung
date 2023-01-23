package de.oszimt.ls11a1.model.address;

import de.oszimt.ls11a1.model.base.BaseObject;
import de.oszimt.ls11a1.view.IView;

import java.util.ArrayList;

public class Address extends BaseObject {
    private int plz;
    private String street;
    private String town;

    private AddressMgmt addresses;

    public Address(int id, String street, int plz, String town) {
        super(id);
        this.street = street;
        this.plz = plz;
        this.town = town;
        addresses = new AddressMgmt();
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", plz='" + plz + '\'' +
                ", addressID=" + getId() +
                ", town='" + town + '\'' +
                '}';
    }
}
