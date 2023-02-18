package de.oszimt.lf10aContractMgmt.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;

public class NewCustomer extends JFrame {

	public NewCustomer() {
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

		// Customer Address
		JLabel customerAddressLabel = new JLabel("Adresse ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		contentPane.add(customerAddressLabel, c);

		JTextField customerAddressField = new JTextField();
		customerAddressField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 3;
		contentPane.add(customerAddressField, c);

		// Customer TelNumber
		JLabel customerTelNumberLabel = new JLabel("Telefonnummer ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		contentPane.add(customerTelNumberLabel, c);

		JTextField customerTelNumberField = new JTextField();
		customerTelNumberField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 4;
		contentPane.add(customerTelNumberField, c);

		// Customer Email
		JLabel customerEmailLabel = new JLabel("Email ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		contentPane.add(customerEmailLabel, c);

		JTextField customerEmailField = new JTextField();
		customerEmailField.setPreferredSize(new Dimension(300,20));
		c.gridx = 1;
		c.gridy = 5;
		contentPane.add(customerEmailField, c);

		// Customer Birth Date
		JLabel customerBirthDateLabel = new JLabel("Geburtsdatum ");
		c.gridx = 0;
		c.gridy = 6;
		contentPane.add(customerBirthDateLabel, c);

		JDateChooser customerBirthDateField = new JDateChooser();
		customerBirthDateField.setPreferredSize(new Dimension(300,20));
		customerBirthDateField.setDate(new Date());
		c.gridx = 1;
		c.gridy = 6;
		contentPane.add(customerBirthDateField, c);

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

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerOverview customerOverview = new CustomerOverview();
				customerOverview.setVisible(true);
				dispose();
			}
		});
	}
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCustomer frame = new NewCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

 */


}
