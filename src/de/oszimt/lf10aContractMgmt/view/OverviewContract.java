package de.oszimt.lf10aContractMgmt.view;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class OverviewContract extends JFrame implements IntContractMgmt {
	private JTextField txtSearchField;
	private JButton newCustomerBtn, editCustomerBtn, deleteCustomerBtn, overviewBtn;
	private DefaultListModel<String> contractList;
	private JList<String> list;
	private JScrollPane scrollPane;
	private HaseGmbHManagement driver;

	@SuppressWarnings("rawtypes")
	public OverviewContract(HaseGmbHManagement driver) {
		this.driver = driver;
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Auftragsübersicht");
		getContentPane().setLayout(null);

		overviewBtn = new JButton("zurück");
		overviewBtn.setBounds(10, 427, 128, 23);
		getContentPane().add(overviewBtn);

		txtSearchField = new JTextField();
		txtSearchField.setText("Search");
		txtSearchField.setBounds(543, 11, 231, 20);
		getContentPane().add(txtSearchField);
		txtSearchField.setColumns(10);

		createScrollPane();

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
				new OverviewEmployee(driver).setVisible(true);
				dispose();
			}
		});

	}

	private void createScrollPane() {
		contractList = new DefaultListModel<>();
		list = new JList<>(contractList);
		list.setBounds(604, 43, 170, 407);
		getContentPane().add(list);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		ArrayList<Contract> arrayList = getAllContracts();
		for (Contract c : arrayList) {
			int contractID = c.getContractID();
			contractList.addElement(String.valueOf(contractID));
		}
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(543, 43, 231, 407);
		getContentPane().add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}


	@Override
	public boolean addNewContract(Contract newContract) {
		return false;
	}

	@Override
	public Contract getContract(int contractID) {
		return null;
	}

	@Override
	public ArrayList<Contract> getAllContracts() {
		return driver.getAllContracts();
	}

	@Override
	public boolean updateCustomer(Contract aContract) {
		return false;
	}

	@Override
	public boolean addNewWorkingRecord(int contractID, ActivityRecord aRecord) {
		return false;
	}

	@Override
	public boolean deleteContract(int contractID) {
		return false;
	}
}