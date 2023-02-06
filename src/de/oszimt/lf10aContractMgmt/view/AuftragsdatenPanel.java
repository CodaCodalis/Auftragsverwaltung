package de.oszimt.lf10aContractMgmt.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.oszimt.lf10aContractMgmt.HaseGmbHClientSimulation;
import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Contract;
import de.oszimt.lf10aContractMgmt.model.Customer;
import de.oszimt.lf10aContractMgmt.model.Employee;

public class AuftragsdatenPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private HaseGmbHManagement haseGmbHManagement;

	private JLabel auftragsnummerLabel;
	private JTextField auftragsnummerFeld;

	private JLabel erstelldatumLabel;
	private JTextField erstelldatumFeld;

	private JLabel kundenLabel;
	private JComboBox kundenComboBox;
	private ArrayList<Customer> kundenListe;
	private ArrayList<String> comboBoxKundenListe;

	private JLabel mitarbeiterLabel;
	private JComboBox mitarbeiterComboBox;
	private ArrayList<Employee> mitarbeiterListe;
	private ArrayList<String> comboBoxMitarbeiterListe;

	private JLabel vertragsArtLabel;
	private ArrayList<Contract> vertragsListe;

	private JComboBox<String> vertragsartComboBox;

	public AuftragsdatenPanel() {

		setVisible(true);
		setLayout(createGridBagLayout());

		add(auftragsnummerLabel);
		add(auftragsnummerFeld);

		add(erstelldatumLabel);
		add(erstelldatumFeld);

		add(kundenLabel);
		add(kundenComboBox);

		add(mitarbeiterLabel);
		add(mitarbeiterComboBox);

		add(vertragsArtLabel);
		add(vertragsartComboBox);

		mitarbeiterComboBox.addActionListener(e -> {
			if (mitarbeiterComboBox.getSelectedItem()
					.equals(generateVertragsListe().get(0).getProjectOwner().getLastname())) {
				vertragsartComboBox
						.setModel(new DefaultComboBoxModel<String>(generateVertragsart().toArray(new String[0])));
			} else {
				vertragsartComboBox.setSelectedItem(new String(" - "));
			}
		});

	}

	private GridBagLayout createGridBagLayout() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		auftragsnummerLabel = new JLabel("Auftragsnummer: ");
		auftragsnummerFeld = new JTextField(15);

		erstelldatumLabel = new JLabel("Erstelldatum: ");
		erstelldatumFeld = new JTextField(15);

		kundenLabel = new JLabel("Kunde: ");
		kundenComboBox = fillCustomerBox();

		mitarbeiterLabel = new JLabel("Mitarbeiter: ");
		mitarbeiterComboBox = fillEmployeeBox();

		vertragsArtLabel = new JLabel("Vertragsart: ");
		vertragsartComboBox = new JComboBox<String>();
		vertragsartComboBox.setPreferredSize(new Dimension(150, 25));
		vertragsartComboBox.setModel(new DefaultComboBoxModel<String>(generateVertragsart().toArray(new String[0])));

//		vertragsArtLabel = new JLabel("Vertragsart: ");
//		vertragsartComboBox = new JComboBox<String>();
//		vertragsartComboBox.setPreferredSize(new Dimension(150, 25));
//		vertragsartComboBox.setModel(new DefaultComboBoxModel<String>(generateVertragsart().toArray(new String[0])));

		gbc = makegbc(0, 0);
		gbl.setConstraints(auftragsnummerLabel, gbc);

		gbc = makegbc(1, 0);
		gbl.setConstraints(auftragsnummerFeld, gbc);

		gbc = makegbc(0, 1);
		gbl.setConstraints(erstelldatumLabel, gbc);

		gbc = makegbc(1, 1);
		gbl.setConstraints(erstelldatumFeld, gbc);

		gbc = makegbc(0, 2);
		gbl.setConstraints(kundenLabel, gbc);

		gbc = makegbc(1, 2);
		gbl.setConstraints(kundenComboBox, gbc);

		gbc = makegbc(0, 3);
		gbl.setConstraints(mitarbeiterLabel, gbc);

		gbc = makegbc(1, 3);
		gbl.setConstraints(mitarbeiterComboBox, gbc);

		gbc = makegbc(0, 4);
		gbl.setConstraints(vertragsArtLabel, gbc);

		gbc = makegbc(1, 4);
		gbl.setConstraints(vertragsartComboBox, gbc);

		return gbl;
	}

	private GridBagConstraints makegbc(int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(5, 5, 5, 5);
		return gbc;
	}

	private JComboBox<String> fillCustomerBox() {

		kundenComboBox = new JComboBox<Customer>();
		kundenComboBox.setPreferredSize(new Dimension(150, 25));

		kundenListe = new ArrayList<>();
		kundenListe = generateCustomerListe();

		comboBoxKundenListe = new ArrayList<>();

		for (Customer customer : kundenListe) {
			String kundenString = customer.getLastname() + " , " + customer.getCustomerID();
			comboBoxKundenListe.add(kundenString);
		}

		kundenComboBox.setModel(new DefaultComboBoxModel<String>(comboBoxKundenListe.toArray(new String[0])));

		return kundenComboBox;

	}

	private JComboBox<String> fillEmployeeBox() {

		mitarbeiterComboBox = new JComboBox<Employee>();
		mitarbeiterComboBox.setPreferredSize(new Dimension(150, 25));

		mitarbeiterListe = generateEmployeesListe();
		comboBoxMitarbeiterListe = new ArrayList<>();

		for (Employee employee : mitarbeiterListe) {
			String mitarbeiterString = employee.getLastname() + " , " + employee.getEmployeeID();
			comboBoxMitarbeiterListe.add(mitarbeiterString);
		}

		mitarbeiterComboBox.setModel(new DefaultComboBoxModel<>(comboBoxMitarbeiterListe.toArray(new String[0])));

		return mitarbeiterComboBox;

	}

	private ArrayList<Employee> generateEmployeesListe() {

		HaseGmbHClientSimulation haseGmbHClientSimulation = new HaseGmbHClientSimulation();
		HaseGmbHManagement haseGmbHManagement = new HaseGmbHManagement();
		haseGmbHManagement = haseGmbHClientSimulation.getHaseMgmtDriver();

		mitarbeiterListe = new ArrayList<>();
		mitarbeiterListe = haseGmbHManagement.getAllEmployees();

		return mitarbeiterListe;

	}

	private ArrayList<Customer> generateCustomerListe() {

		HaseGmbHClientSimulation haseGmbHClientSimulation = new HaseGmbHClientSimulation();
		HaseGmbHManagement haseGmbHManagement = new HaseGmbHManagement();
		haseGmbHManagement = haseGmbHClientSimulation.getHaseMgmtDriver();

		kundenListe = new ArrayList<>();
		kundenListe = haseGmbHManagement.getAllCustomers();

		return kundenListe;

	}

	private ArrayList<Contract> generateVertragsListe() {

		HaseGmbHClientSimulation haseGmbHClientSimulation = new HaseGmbHClientSimulation();
		HaseGmbHManagement haseGmbHManagement = new HaseGmbHManagement();
		haseGmbHManagement = haseGmbHClientSimulation.getHaseMgmtDriver();

		vertragsListe = new ArrayList<>();
		vertragsListe = haseGmbHManagement.getAllContracts();

		return vertragsListe;

	}

	private ArrayList<String> generateVertragsart() {

		ArrayList<Contract> contractlist = generateVertragsListe();
		ArrayList<Employee> employeesList = generateEmployeesListe();
		ArrayList<String> vertragsArten = new ArrayList<>();

		for (Contract vertrag : contractlist) {
			for (Employee employee : employeesList) {
				for (Customer customer : kundenListe) {

					if (istMaUndKundeEinVertragZugewiesen(employee, customer, vertrag)) {
						String vertragsart = vertrag.getContractType();
						vertragsArten.add(vertragsart);
					}
				}
			}
		}

		return vertragsArten;

	}

	private boolean istMaUndKundeEinVertragZugewiesen(Employee employee, Customer customer, Contract contract) {
		if (contract.getProjectOwner().getLastname().equals(employee.getLastname())
				&& contract.getCustomer().getLastname().equals(customer.getLastname())) {
			return true;
		}
		return false;
	}

}
