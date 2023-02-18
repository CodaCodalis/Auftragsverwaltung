package de.oszimt.lf10aContractMgmt.view;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

@SuppressWarnings("serial")
public class CustomerOverview extends JFrame {
	private JTextField txtSearchField;
	private JButton newCustomerBtn, editCustomerBtn, deleteCustomerBtn, overviewBtn;
	private DefaultListModel<String> customerList;
	private JList<String> list;

	@SuppressWarnings("rawtypes")
	public CustomerOverview() {
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Kundenübersicht");
		getContentPane().setLayout(null);

		newCustomerBtn = new JButton("neuer Kunde");
		newCustomerBtn.setBounds(43, 43, 200, 23);
		getContentPane().add(newCustomerBtn);

		editCustomerBtn = new JButton("Kunde bearbeiten");
		editCustomerBtn.setBounds(43, 80, 200, 23);
		getContentPane().add(editCustomerBtn);

		deleteCustomerBtn = new JButton("Kunde löschen");
		deleteCustomerBtn.setBounds(43, 114, 200, 23);
		getContentPane().add(deleteCustomerBtn);

		overviewBtn = new JButton("Hauptmenü");
		overviewBtn.setBounds(10, 427, 128, 23);
		getContentPane().add(overviewBtn);

		txtSearchField = new JTextField();
		txtSearchField.setText("Search");
		txtSearchField.setBounds(543, 11, 231, 20);
		getContentPane().add(txtSearchField);
		txtSearchField.setColumns(10);

		customerList = new DefaultListModel<>();
		list = new JList<>(customerList);
		list.setBounds(604, 43, 170, 407);
		getContentPane().add(list);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// Testschleife
		for (int i = 1; i <= 10; i++) {
			customerList.addElement("Kunde" + i);
		}

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(604, 43, 170, 407);
		getContentPane().add(scrollPane);
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

		overviewBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Overview().setVisible(true);
				dispose();
			}
		});

		newCustomerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewCustomer().setVisible(true);
				dispose();
			}
		});

		editCustomerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// go to editEmployeeFrame
			}
		});

		deleteCustomerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteCustomer();
			}
		});

	}

	public void deleteCustomer() {
		int selectedIndex = list.getSelectedIndex();
		int[] selectedIndices = list.getSelectedIndices();
		if (selectedIndex != -1 && (selectedIndices.length == 1)) {
			String selectedCustomer = list.getSelectedValue();
			int confirmDialogOnly1 = JOptionPane.showConfirmDialog(null,
					"Bist du dir sicher, dass du den Kunden " + selectedCustomer + " löschen willst?",
					"Bestätigung", JOptionPane.YES_NO_OPTION);
			if (confirmDialogOnly1 == JOptionPane.YES_OPTION) {
				customerList.removeElementAt(selectedIndex);
			}

		} else if (selectedIndex != -1 && selectedIndices.length > 1) {
			int confirmDialogMoreThan1 = JOptionPane.showConfirmDialog(null,
					"Bist du dir sicher, dass du die Kunden löschen willst?", "Bestätigung",
					JOptionPane.YES_NO_OPTION);
			if (confirmDialogMoreThan1 == JOptionPane.YES_OPTION) {
				for (int i = selectedIndices.length - 1; i >= 0; i--) {
					customerList.remove(selectedIndices[i]);
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Bitte wählen Sie ein Kunden aus, um Ihn zu löschen.", "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CustomerOverview().setVisible(true);
			}
		});
	}

	 */

}