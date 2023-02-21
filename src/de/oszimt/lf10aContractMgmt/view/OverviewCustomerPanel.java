package de.oszimt.lf10aContractMgmt.view;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Customer;
import de.oszimt.lf10aContractMgmt.model.IntCustomerMgmt;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class OverviewCustomerPanel extends JPanel implements IntCustomerMgmt {
	private JTextField txtSearchField;
	private JButton newCustomerBtn, editCustomerBtn, deleteCustomerBtn, overviewBtn;
	private DefaultListModel<String> customerList;
	private JList<String> list;
	private JScrollPane scrollPane;
	private HaseGmbHManagement driver;

	@SuppressWarnings("rawtypes")
	public OverviewCustomerPanel(HaseGmbHManagement driver) {
		this.driver = driver;
		setSize(800, 450);
		setLayout(null);

		newCustomerBtn = new JButton("neuer Kunde");
		newCustomerBtn.setBounds(43, 43, 200, 23);
		add(newCustomerBtn);

		editCustomerBtn = new JButton("Kunde bearbeiten");
		editCustomerBtn.setBounds(43, 80, 200, 23);
		add(editCustomerBtn);

		deleteCustomerBtn = new JButton("Kunde löschen");
		deleteCustomerBtn.setBounds(43, 114, 200, 23);
		add(deleteCustomerBtn);

		txtSearchField = new JTextField();
		txtSearchField.setText("Search");
		txtSearchField.setBounds(543, 11, 231, 20);
		add(txtSearchField);
		txtSearchField.setColumns(10);

		customerList = new DefaultListModel<>();
		list = new JList<>(customerList);
		list.setBounds(604, 43, 170, 407);
		add(list);

		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		updateCustomerList();
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(543, 43, 231, 407);
		add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		txtSearchField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtSearchField.getText().equals("Search")) {
					txtSearchField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtSearchField.setText("Search");
			}
		});

		txtSearchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				filterList();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				filterList();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				filterList();
			}

			public void filterList() {
				String filter = txtSearchField.getText();
				ListModel<String> model = list.getModel();
				for (int i = 0; i < model.getSize(); i++) {
					String element = model.getElementAt(i);
					if (element.contains(filter)) {
						list.setSelectedIndex(i);
						list.scrollRectToVisible(list.getCellBounds(i, i));
						break;
					}
				}
			}
		});

		newCustomerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewCustomer(driver).setVisible(true);
			}
		});

		editCustomerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedCustomer = list.getSelectedValue();
				int customerID = Integer.parseInt(selectedCustomer.substring(0,7));
				Customer customer = getCustomer(customerID);
				new UpdateCustomer(driver, customer).setVisible(true);
			}
		});

		deleteCustomerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedCustomer = list.getSelectedValue();
				int customerID = Integer.parseInt(selectedCustomer.substring(0,7));
				int confirmDialogOnly = JOptionPane.showConfirmDialog(
						null,
						"Den Kunden " + selectedCustomer + " wirklich löschen?",
						"Bestätigung", JOptionPane.YES_NO_OPTION);
				if (confirmDialogOnly == JOptionPane.YES_OPTION) {
					deleteCustomer(customerID);
				}

			}
		});

	}

	private void updateCustomerList() {
		customerList.removeAllElements();
		ArrayList<Customer> customers = getAllCustomers();
		for (Customer c : customers) {
			int customerID = c.getCustomerID();
			String firstName = c.getFirstname();
			String lastName = c.getLastname();
			customerList.addElement(customerID + ": " + firstName + " " + lastName);
		}
	}

	@Override
	public boolean addNewCustomer(Customer newCustomer) {
		return false;
	}

	@Override
	public Customer getCustomer(int customerID) {
		ArrayList<Customer> customers = getAllCustomers();
		for (Customer c : customers) {
			if (c.getCustomerID() == customerID) {
				return c;
			}
		}
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
		driver.deleteCustomer(customerID);
		updateCustomerList();
		return true;
	}
}