package de.oszimt.lf10aContractMgmt.view;

import com.toedter.calendar.JDateChooser;
import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Employee;
import de.oszimt.lf10aContractMgmt.model.IntEmployeeMgmt;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class UpdateEmployee extends JFrame implements IntEmployeeMgmt {
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

    public UpdateEmployee(HaseGmbHManagement driver, Employee anEmployee) {
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
        mitarbeiternummerTextField.setText(String.valueOf(anEmployee.getEmployeeID()));
        panel.add(mitarbeiternummerTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Vorname:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        vornameTextField = new JTextField(20);
        vornameTextField.setText(anEmployee.getFirstname());
        panel.add(vornameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Nachname:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        nachnameTextField = new JTextField(20);
        nachnameTextField.setText(anEmployee.getLastname());
        panel.add(nachnameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Straße:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        streetTextField = new JTextField(20);
        streetTextField.setText(anEmployee.getAddress().getStreet());
        panel.add(streetTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Hausnummer:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        houseTextField = new JTextField(20);
        houseTextField.setText(anEmployee.getAddress().getHouse());
        panel.add(houseTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("PLZ:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        postalCodeTextField = new JTextField(20);
        postalCodeTextField.setText(anEmployee.getAddress().getPostalCode());
        panel.add(postalCodeTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Stadt:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        cityTextField = new JTextField(20);
        cityTextField.setText(anEmployee.getAddress().getCity());
        panel.add(cityTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Land:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        countryTextField = new JTextField(20);
        countryTextField.setText(anEmployee.getAddress().getCountry());
        panel.add(countryTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Telefonnummerr:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        telefonnummerTextField = new JTextField(20);
        telefonnummerTextField.setText(anEmployee.getTelephone());
        panel.add(telefonnummerTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        emailTextField = new JTextField(20);
        emailTextField.setText(anEmployee.getEmail());
        panel.add(emailTextField, gbc);

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
                        countryTextField.getText()
                );
                final Employee updateEmployee = new Employee(
                        vornameTextField.getText(),
                        nachnameTextField.getText(),
                        address,
                        emailTextField.getText(),
                        telefonnummerTextField.getText());

                //newEmployee.setEmployeeID(Integer.valueOf(mitarbeiternummerTextField.getText()));

                updateEmployee(anEmployee, updateEmployee);
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
            OverviewEmployee overviewEmployee = new OverviewEmployee(driver);
            overviewEmployee.setVisible(true);
            dispose();
        });

        add(panel);
        // pack();
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

        if (mitarbeiternummerTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Mitarbeiternummer ist nicht angegeben");
            return false;
        }

        if (vornameTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Vorname ist nicht angegeben");
            return false;
        }

        if (nachnameTextField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Nachname ist nicht angegeben");
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
        return false;
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
        driver.updateEmployee(anEmployee, updateEmployee);
        return true;
    }

    @Override
    public boolean deleteEmployee(int employeeID) {
        return false;
    }
}
