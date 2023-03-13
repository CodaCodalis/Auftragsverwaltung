package de.oszimt.lf10aContractMgmt.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Employee;
import de.oszimt.lf10aContractMgmt.model.IntEmployeeMgmt;

public class NewEmployee extends JFrame implements IntEmployeeMgmt {

	private static final long serialVersionUID = 1L;

	private JTextField mitarbeiternummerTextField;
	private JTextField vornameTextField;
	private JTextField nachnameTextField;
	private JTextField streetTextField;
	private JTextField houseTextField;
	private JTextField postalCodeTextField;
	private JTextField cityTextField;
	private JTextField countryTextField;
	private JTextField telefonnummerTextField;
	private JTextField emailTextField;
	private JRadioButton maennlichBtn;
	private JRadioButton weiblichBtn;
	private JRadioButton diverseBtn;
	private JButton saveBtn;
	private JButton cancelBtn;

	private HaseGmbHManagement driver;

	public NewEmployee(HaseGmbHManagement driver) {
		this.driver = driver;
		setResizable(false);
		setTitle("Neuer Mitarbeiter");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Mitarbeiternummer:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		mitarbeiternummerTextField = new JTextField(20);
		mitarbeiternummerTextField.setText(getNextFreeEmployeeId(driver) + "");
		mitarbeiternummerTextField.setEditable(false);
		panel.add(mitarbeiternummerTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(new JLabel("Vorname:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		vornameTextField = new JTextField(20);
		panel.add(vornameTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(new JLabel("Nachname:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		nachnameTextField = new JTextField(20);
		panel.add(nachnameTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(new JLabel("Straße:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		streetTextField = new JTextField(20);
		panel.add(streetTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(new JLabel("Hausnummer:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		houseTextField = new JTextField(20);
		panel.add(houseTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(new JLabel("PLZ:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		postalCodeTextField = new JTextField(20);
		panel.add(postalCodeTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(new JLabel("Stadt:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		cityTextField = new JTextField(20);
		panel.add(cityTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 7;
		panel.add(new JLabel("Land:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		countryTextField = new JTextField(20);
		panel.add(countryTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 8;
		panel.add(new JLabel("Email:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 8;
		emailTextField = new JTextField(20);
		panel.add(emailTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 9;
		panel.add(new JLabel("Telefonnummer:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 9;
		telefonnummerTextField = new JTextField(20);
		panel.add(telefonnummerTextField, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(new JLabel("Geschlecht:"), gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		maennlichBtn = new JRadioButton("Maennlich");
		panel.add(maennlichBtn, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		weiblichBtn = new JRadioButton("Weiblich");
		panel.add(weiblichBtn, gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		diverseBtn = new JRadioButton("Divers");
		panel.add(diverseBtn, gbc);

		ButtonGroup group = new ButtonGroup();
		group.add(maennlichBtn);
		group.add(weiblichBtn);
		group.add(diverseBtn);

		gbc.gridx = 0;
		gbc.gridy = 10;
		saveBtn = new JButton("Save");
		panel.add(saveBtn, gbc);

		saveBtn.addActionListener(whenSaveBtnClicked -> {
			if (userEingabenSindValide()) {
				Address address = new Address(
						streetTextField.getText(),
						houseTextField.getText(),
						postalCodeTextField.getText(),
						cityTextField.getText(),
						countryTextField.getText());
				Employee newEmployee = new Employee(
						vornameTextField.getText(),
						nachnameTextField.getText(),
						address,
						emailTextField.getText(),
						telefonnummerTextField.getText());
				//newEmployee.setEmployeeID(Integer.valueOf(mitarbeiternummerTextField.getText()));
				addNewEmployee(newEmployee);
				OverviewEmployee overviewEmployee = new OverviewEmployee(driver);
				overviewEmployee.setVisible(true);
				dispose();

			}
		});

		gbc.gridx = 1;
		gbc.gridy = 10;
		cancelBtn = new JButton("Cancel");
		panel.add(cancelBtn, gbc);

		cancelBtn.addActionListener(whenCancelBtnClicked -> {
			dispose();
		});

		add(panel);
		setVisible(true);
	}

	private int getNextFreeEmployeeId(HaseGmbHManagement driver) {
		int nextFreeId = 0;
		for (Employee e : driver.getAllEmployees()) {
			if (e.getEmployeeID() > nextFreeId) {
				nextFreeId = e.getEmployeeID();
			}
		}
		return nextFreeId + 1;
	}

	private boolean userEingabenSindValide() {
		if (vornameTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Vorname ist nicht angegeben");
			return false;
		}

		if (nachnameTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Nachname ist nicht angegeben");
			return false;
		}

		if (streetTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Straße ist nicht angegeben");
			return false;
		}

		if (houseTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Hausnummer ist nicht angegeben");
			return false;
		}

		if (postalCodeTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "PLZ ist nicht angegeben");
			return false;
		}

		if (cityTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Stadt ist nicht angegeben");
			return false;
		}

		if (countryTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Land ist nicht angegeben");
			return false;
		}

		if (telefonnummerTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Telefonnummer ist nicht angegeben");
			return false;
		}

		if (emailTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Email ist nicht angegeben");
			return false;
		}

		return true;

	}



	@Override
	public boolean addNewEmployee(Employee newEmployee) {
		driver.addNewEmployee(newEmployee);
		return true;
	}

	@Override
	public Employee getEmployee(int employeeID) {
		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmployees() {
		return null;
	}

	@Override
	public boolean updateEmployee(Employee anEmployee, Employee updateEmployee) {
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeID) {
		return false;
	}
}
