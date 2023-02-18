package de.oszimt.lf10aContractMgmt.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// Zurzeit leider nur AbsoluteLayout, wird noch die Tage geändert!!!
// funktional, aber nicht schön

@SuppressWarnings("serial")
public class EmployeeOverview extends JFrame {
	private JTextField txtSearchField;
	private JButton newEmployeeBtn, editEmployeeBtn, deleteEmployeeBtn, newContractBtn, overviewBtn;
	private DefaultListModel<String> employeeList;
	private JList<String> list;

	@SuppressWarnings("rawtypes")
	public EmployeeOverview() {
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Mitarbeiterübersicht");
		getContentPane().setLayout(null);

		newEmployeeBtn = new JButton("neuer Mitarbeiter");
		newEmployeeBtn.setBounds(43, 43, 200, 23);
		getContentPane().add(newEmployeeBtn);

		editEmployeeBtn = new JButton("Mitarbeiter bearbeiten");
		editEmployeeBtn.setBounds(43, 80, 200, 23);
		getContentPane().add(editEmployeeBtn);

		deleteEmployeeBtn = new JButton("Mitarbeiter löschen");
		deleteEmployeeBtn.setBounds(43, 114, 200, 23);
		getContentPane().add(deleteEmployeeBtn);

		newContractBtn = new JButton("neuer Auftrag");
		newContractBtn.setBounds(43, 221, 200, 23);
		getContentPane().add(newContractBtn);

		overviewBtn = new JButton("Hauptmenü");
		overviewBtn.setBounds(10, 427, 128, 23);
		getContentPane().add(overviewBtn);

		txtSearchField = new JTextField();
		txtSearchField.setText("Search");
		txtSearchField.setBounds(543, 11, 231, 20);
		getContentPane().add(txtSearchField);
		txtSearchField.setColumns(10);

		employeeList = new DefaultListModel<>();
		list = new JList<>(employeeList);
		list.setBounds(604, 43, 170, 407);
		getContentPane().add(list);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// Testschleife
		for (int i = 1; i <= 50; i++) {
			employeeList.addElement("Mitarbeiter" + i);
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

		newEmployeeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NewEmployee().setVisible(true);
				dispose();
			}
		});

		editEmployeeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// go to editEmployeeFrame
			}
		});

		deleteEmployeeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteEmployee();
			}
		});

		newContractBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ContractOverview contractOverview = new ContractOverview();
				contractOverview.setVisible(true);
				dispose();
			}

		});

	}

	public void deleteEmployee() {
		int selectedIndex = list.getSelectedIndex();
		int[] selectedIndices = list.getSelectedIndices();
		if (selectedIndex != -1 && (selectedIndices.length == 1)) {
			String selectedEmployee = list.getSelectedValue();
			int confirmDialogOnly1 = JOptionPane.showConfirmDialog(null,
					"Bist du dir sicher, dass du den Mitarbeiter " + selectedEmployee + " löschen willst?",
					"Bestätigung", JOptionPane.YES_NO_OPTION);
			if (confirmDialogOnly1 == JOptionPane.YES_OPTION) {
				employeeList.removeElementAt(selectedIndex);
			}

		} else if (selectedIndex != -1 && selectedIndices.length > 1) {
			int confirmDialogMoreThan1 = JOptionPane.showConfirmDialog(null,
					"Bist du dir sicher, dass du die Mitarbeiter löschen willst?", "Bestätigung",
					JOptionPane.YES_NO_OPTION);
			if (confirmDialogMoreThan1 == JOptionPane.YES_OPTION) {
				for (int i = selectedIndices.length - 1; i >= 0; i--) {
					employeeList.remove(selectedIndices[i]);
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Bitte wählen Sie ein Mitarbeiter aus, um Ihn zu löschen.", "Fehler",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new EmployeeOverview().setVisible(true);
			}
		});
	}

	 */


}