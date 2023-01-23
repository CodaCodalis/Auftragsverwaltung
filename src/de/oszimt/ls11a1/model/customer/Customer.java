/*
 * Created on 01.05.2022 by Kay Patzwald
 */
package de.oszimt.ls11a1.model.customer;

import de.oszimt.ls11a1.model.address.Address;
import de.oszimt.ls11a1.model.address.AddressMgmt;
import de.oszimt.ls11a1.model.base.BaseObject;
import de.oszimt.ls11a1.model.order.OrderMgmt;
import de.oszimt.ls11a1.view.IView;

import java.util.ArrayList;

/**
 * Customer class
 * 
 * @author Kay Patzwald
 */
public abstract class Customer extends BaseObject {
	protected String tel;
	protected String email;
	private OrderMgmt orders;
	private AddressMgmt addresses;

	/**
	 * Constructor of Customer
	 * 
	 * @param id The ID of the customer
	 */
	public Customer(int id) {
		super(id);
		orders = new OrderMgmt();
		addresses = new AddressMgmt();
	}

	/**
	 * Constructor of Customer
	 *
	 * @param id The ID of the customer
	 * @param email      The email of the customer
	 * @param tel        The tel of the customer
	 */

	public Customer(int id, String email, String tel) {
		super(id);
		this.email = email;
		this.tel = tel;
		orders = new OrderMgmt();
		addresses = new AddressMgmt();
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	public OrderMgmt getOrders() {
		return orders;
	}

	public AddressMgmt getAddresses() {
		return addresses;
	}

	public abstract String getAddressLabel();
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Customer{" +
				", customerID=" + getId() +
				", tel='" + tel + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
