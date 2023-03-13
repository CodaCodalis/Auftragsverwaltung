package de.oszimt.lf10aContractMgmt.view;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Employee;
import de.oszimt.lf10aContractMgmt.model.IntEmployeeMgmt;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

// Zurzeit leider nur AbsoluteLayout, wird noch die Tage geändert!!!
// funktional, aber nicht schön

@SuppressWarnings("serial")
public class OverviewEmployeePanel extends JPanel implements IntEmployeeMgmt {
    HaseGmbHManagement driver;
    JComboBox<String> searchBox;
    private JTextField txtSearchField;
    private JButton newEmployeeBtn, editEmployeeBtn, deleteEmployeeBtn, logoutButton;
    private DefaultListModel<String> employeeList;
    private JList<String> list;

    @SuppressWarnings("rawtypes")
    public OverviewEmployeePanel(HaseGmbHManagement driver) {
        this.driver = driver;
        setSize(800, 450);
		/*
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Mitarbeiterübersicht");
		*/
        setLayout(null);

        newEmployeeBtn = new JButton("neuer Mitarbeiter");
        newEmployeeBtn.setBounds(43, 43, 200, 23);
        add(newEmployeeBtn);

        editEmployeeBtn = new JButton("Mitarbeiter bearbeiten");
        editEmployeeBtn.setBounds(43, 80, 200, 23);
        add(editEmployeeBtn);

        deleteEmployeeBtn = new JButton("Mitarbeiter löschen");
        deleteEmployeeBtn.setBounds(43, 114, 200, 23);
        add(deleteEmployeeBtn);

        logoutButton = new JButton("Abmelden");
        logoutButton.setBounds(10, 427, 128, 23);
        add(logoutButton);

        searchBox = new JComboBox<>(new String[]{"ID", "Name", "Handynummer", "E-Mail"});
        searchBox.setBounds(440, 11, 100, 20);
        add(searchBox);

        txtSearchField = new JTextField();
        txtSearchField.setText("Search");
        txtSearchField.setBounds(543, 11, 231, 20);
        add(txtSearchField);
        txtSearchField.setColumns(10);

        createScrollPane();

        searchBox.addActionListener(e -> filterList());

        logoutButton.addActionListener(e -> {
            new LoginView(driver).setVisible(true);
        });


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

        });

        newEmployeeBtn.addActionListener(e -> {
            new NewEmployee(driver).setVisible(true);
        });

        editEmployeeBtn.addActionListener(e -> {
            String selectedEmployee = list.getSelectedValue();
            if(selectedEmployee == null) {
                JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Mitarbeiter aus!");
                return;
            }
            int employeeID = Integer.parseInt(selectedEmployee.substring(0, 5));
            Employee employee = getEmployee(employeeID);
            new UpdateEmployee(driver, employee).setVisible(true);
        });

        deleteEmployeeBtn.addActionListener(e -> deleteEmployee());
    }

    private void filterList() {
        String filter = txtSearchField.getText().toLowerCase();
        Object selectedItem = searchBox.getSelectedItem();
        String selectedFilter = selectedItem != null ? selectedItem.toString() : "";
        ListModel<String> model = list.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            String element = model.getElementAt(i);
            boolean contains;
            if (selectedFilter.equals("ID")) {
                if (element.substring(0, 5).contains(filter)) {
                    list.setSelectedIndex(i);
                    list.scrollRectToVisible(list.getCellBounds(i, i));
                    break;
                }
            } else if (selectedFilter.equals("E-Mail")) {
                contains = element.substring(6, element.length()).contains(filter);
                if (contains) {
                    list.setSelectedIndex(i);
                    list.scrollRectToVisible(list.getCellBounds(i, i));
                    break;
                }
            } else if (selectedFilter.equals("Handynummer")) {
                String[] parts = element.split(" ");
                if (parts.length >= 4 && parts[3].contains(filter)) {
                    list.setSelectedIndex(i);
                    list.scrollRectToVisible(list.getCellBounds(i, i));
                    break;
                }
            } else {
                if (element.contains(filter)) {
                    list.setSelectedIndex(i);
                    list.scrollRectToVisible(list.getCellBounds(i, i));
                    break;
                }
            }
        }
    }

    private void createScrollPane() {
        employeeList = new DefaultListModel<>();
        list = new JList<>(employeeList);
        list.setBounds(604, 43, 170, 407);
        add(list);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        ArrayList<Employee> arrayList = getAllEmployees();
        for (Employee e : arrayList) {
            int employeeID = e.getEmployeeID();
            final String firstName = e.getFirstname();
            final String lastName = e.getLastname();
            final String telephone = e.getTelephone();
            final String email = e.getEmail();
            employeeList.addElement(employeeID + ": " + firstName + " " + lastName + " " + telephone + " " + email);
        }

//		final String[] columns = { "ID", "Vorname", "Nachname", "Telefonummer", "Email" };
//		final List<String[]> employeeDataList = new ArrayList<>();
//		for (final Employee e : getAllEmployees()) {
//			final String[] employeeData = { e.getEmployeeID() + "", e.getFirstname(), e.getLastname(), e.getTelephone(),
//					e.getEmail() };
//			employeeDataList.add(employeeData);
//		}
//
//
//		String[] array = new String[employeeDataList.size()];

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(604, 43, 170, 407);
        add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
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

    @Override
    public boolean addNewEmployee(Employee newEmployee) {
        driver.addNewEmployee(newEmployee);
        return false;
    }

    @Override
    public Employee getEmployee(int employeeID) {
        ArrayList<Employee> employees = getAllEmployees();
        for (Employee e : employees) {
            if (e.getEmployeeID() == employeeID) {
                return e;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Employee> getAllEmployees() {
        return driver.getAllEmployees();
    }

    @Override
    public boolean updateEmployee(Employee anEmployee, Employee updateEmployee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int employeeID) {
        return false;
    }

    /*
     * public static void main(String[] args) { SwingUtilities.invokeLater(new
     * Runnable() {
     *
     * @Override public void run() { new EmployeeOverview().setVisible(true); } });
     * }
     *
     */

}