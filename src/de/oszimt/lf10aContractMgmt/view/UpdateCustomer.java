package de.oszimt.lf10aContractMgmt.view;


import com.toedter.calendar.JDateChooser;
import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Customer;
import de.oszimt.lf10aContractMgmt.model.IntCustomerMgmt;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class UpdateCustomer extends JFrame {

	Customer customer;
	Customer customerUpdate;
	HaseGmbHManagement driver;
	public UpdateCustomer(HaseGmbHManagement driver, Customer customer) {
		this.driver = driver;
		this.customer = customer;
		setTitle("Kunde bearbeiten");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		Address address = customer.getAddress();

		// Customer Number
		JLabel customerNumberLabel = new JLabel("Kundennummer ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		contentPane.add(customerNumberLabel, c);

		JTextField customerNumberField = new JTextField();
		customerNumberField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 0;
		customerNumberField.setEditable(false);
		customerNumberField.setText(String.valueOf(customer.getCustomerID()));
		contentPane.add(customerNumberField, c);

		// Customer First Name
		JLabel customerFirstNameLabel = new JLabel("Vorname ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		contentPane.add(customerFirstNameLabel, c);

		JTextField customerFirstNameField = new JTextField();
		customerFirstNameField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 1;
		customerFirstNameField.setText(customer.getFirstname());
		contentPane.add(customerFirstNameField, c);

		// Customer Last Name
		JLabel customerLastNameLabel = new JLabel("Nachname ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		contentPane.add(customerLastNameLabel, c);

		JTextField customerLastNameField = new JTextField();
		customerLastNameField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 2;
		customerLastNameField.setText(customer.getLastname());
		contentPane.add(customerLastNameField, c);

		// Customer TelNumber
		JLabel customerTelNumberLabel = new JLabel("Telefonnummer ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		contentPane.add(customerTelNumberLabel, c);

		JTextField customerTelNumberField = new JTextField();
		customerTelNumberField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 3;
		customerTelNumberField.setText("");
		contentPane.add(customerTelNumberField, c);

		// Customer Email
		JLabel customerEmailLabel = new JLabel("Email ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		contentPane.add(customerEmailLabel, c);

		JTextField customerEmailField = new JTextField();
		customerEmailField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 4;
		customerEmailField.setText(customer.getEmail());
		contentPane.add(customerEmailField, c);

		// Customer Birth Date
		JLabel customerBirthDateLabel = new JLabel("Geburtsdatum ");
		c.gridx = 0;
		c.gridy = 5;
		contentPane.add(customerBirthDateLabel, c);

		JDateChooser customerBirthDateField = new JDateChooser();
		customerBirthDateField.setPreferredSize(new Dimension(300,20));
		customerBirthDateField.setDate(new Date());
		c.gridx = 1;
		c.gridy = 5;
		LocalDate localBirthDay = customer.getBirthday();
		Date birthDay = Date.from(localBirthDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
		customerBirthDateField.setDate(birthDay);
		contentPane.add(customerBirthDateField, c);

		// Customer Address
		JLabel customerStreetLabel = new JLabel("Straße ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		contentPane.add(customerStreetLabel, c);

		JTextField customerStreetField = new JTextField();
		customerStreetField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 6;
		customerStreetField.setText(address.getStreet());
		contentPane.add(customerStreetField, c);

		JLabel customerHouseLabel = new JLabel("Hausnummer ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 7;
		contentPane.add(customerHouseLabel, c);

		JTextField customerHouseField = new JTextField();
		customerHouseField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 7;
		customerHouseField.setText(address.getHouse());
		contentPane.add(customerHouseField, c);

		JLabel customerPostalLabel = new JLabel("PLZ ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 8;
		contentPane.add(customerPostalLabel, c);

		JTextField customerPostalField = new JTextField();
		customerPostalField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 8;
		customerPostalField.setText(address.getPostalCode());
		contentPane.add(customerPostalField, c);

		JLabel customerCityLabel = new JLabel("Stadt ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 9;
		contentPane.add(customerCityLabel, c);

		JTextField customerCityField = new JTextField();
		customerCityField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 9;
		customerCityField.setText(address.getCity());
		contentPane.add(customerCityField, c);

		JLabel customerCountryLabel = new JLabel("Land ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 10;
		contentPane.add(customerCountryLabel, c);

		JTextField customerCountryField = new JTextField();
		customerCountryField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 10;
		customerCountryField.setText(address.getCountry());
		contentPane.add(customerCountryField, c);

		// Customer Gender
		JLabel genderLabel = new JLabel("Geschlecht ");
		c.gridx = 2;
		c.gridy = 0;
		contentPane.add(genderLabel, c);

		JRadioButton customerGenderMaleBtn = new JRadioButton("Männlich");
		c.gridx = 2;
		c.gridy = 1;
		contentPane.add(customerGenderMaleBtn, c);

		JRadioButton customerGenderFemaleBtn = new JRadioButton("Weiblich");
		c.gridx = 2;
		c.gridy = 2;
		contentPane.add(customerGenderFemaleBtn, c);

		JRadioButton customerGenderDiversBtn = new JRadioButton("Divers");
		c.gridx = 2;
		c.gridy = 2;
		contentPane.add(customerGenderDiversBtn, c);

		ButtonGroup group = new ButtonGroup();
		group.add(customerGenderMaleBtn);
		group.add(customerGenderFemaleBtn);
		group.add(customerGenderDiversBtn);

		// Save and Cancel buttons
		JButton saveButton = new JButton("Save");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 15;
		c.insets = new Insets(10, 10, 0, 0);
		contentPane.add(saveButton, c);

		JButton cancelButton = new JButton("Cancel");
		c.gridx = 2;
		c.gridy = 15;
		c.insets = new Insets(10, 0, 0, 10);
		contentPane.add(cancelButton, c);

		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String firstName = customerFirstNameField.getText();
				String lastName = customerLastNameField.getText();
				Date birthDay = customerBirthDateField.getDate();
				LocalDate localBirthDay = birthDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				String eMail = customerEmailField.getText();
				String telNum = customerTelNumberField.getText();
				String street = customerStreetField.getText();
				String house = customerHouseField.getText();
				String postal = customerPostalField.getText();
				String city = customerCityField.getText();
				String country = customerCountryField.getText();
				Address address = new Address(street, house, postal, city, country);
				customerUpdate = new Customer(firstName, lastName, localBirthDay, eMail, address);

				String updatedCustomer = firstName + " " + lastName;
				int confirmDialogOnly = JOptionPane.showConfirmDialog(
						null,
						"Den Kunden " + updatedCustomer + " wirklich aktualisieren?",
						"Bestätigung", JOptionPane.YES_NO_OPTION);
				if (confirmDialogOnly == JOptionPane.YES_OPTION) {
					//updateCustomer(customer, customerUpdate);
					driver.updateCustomer(customer, customerUpdate);
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OverviewCustomer overviewCustomer = new OverviewCustomer(driver);
				overviewCustomer.setVisible(true);
				dispose();
			}
		});
	}

	/*
	@Override
	public boolean addNewCustomer(Customer newCustomer) {
		return false;
	}

	@Override
	public Customer getCustomer(int customerID) {
		ArrayList<Customer> customers = getAllCustomers();
		Customer customer = null;
		for (Customer c : customers) {
			if (c.getCustomerID() == customerID) {
				customer = c;
				break;
			}
		}
		return customer;
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {
		return driver.getAllCustomers();
	}

	@Override
	public boolean updateCustomer(Customer aCustomer, Customer updateCustomer) {
		driver.updateCustomer(aCustomer, updateCustomer);
		new OverviewCustomer(driver).setVisible(true);
		dispose();
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerID) {
		return false;
	}

	 */

}
