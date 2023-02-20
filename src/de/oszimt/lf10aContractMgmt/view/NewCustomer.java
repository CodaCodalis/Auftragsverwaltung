package de.oszimt.lf10aContractMgmt.view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Customer;
import de.oszimt.lf10aContractMgmt.model.IntCustomerMgmt;
import javax.swing.JRadioButton;

public class NewCustomer extends JFrame implements IntCustomerMgmt {

	private HaseGmbHManagement driver;

	public NewCustomer(HaseGmbHManagement driver) {
		this.driver = driver;
		setTitle("Neuer Kunde");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,500);
		//setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

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
				Customer customer = new Customer(firstName, lastName, localBirthDay, eMail, address);

				String addCustomer = firstName + " " + lastName;
				int confirmDialogOnly = JOptionPane.showConfirmDialog(
						null,
						"Den Kunden " + addCustomer + " wirklich hinzufügen?",
						"Bestätigung", JOptionPane.YES_NO_OPTION);
				if (confirmDialogOnly == JOptionPane.YES_OPTION) {
					addNewCustomer(customer);
					new OverviewCustomer(driver).setVisible(true);
					dispose();
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

	@Override
	public boolean addNewCustomer(Customer newCustomer) {
		driver.addNewCustomer(newCustomer);
		return true;
	}

	@Override
	public Customer getCustomer(int customerID) {
		return null;
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {
		return driver.getAllCustomers();
	}

	@Override
	public boolean updateCustomer(Customer aCustomer, Customer updateCustomer) {
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerID) {
		return false;
	}

}
