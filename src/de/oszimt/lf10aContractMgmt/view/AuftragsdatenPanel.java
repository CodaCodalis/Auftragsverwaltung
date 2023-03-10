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

import com.toedter.calendar.JDateChooser;

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
	private JDateChooser erstelldatumFeld;

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
	private JTextField vertragsartFeld;

	private JLabel bearbeitungsstandLabel;
	private JTextField bearbeitungsstandFeld;

	private JLabel startdatumLabel;
	private JDateChooser startdatumKalendar;

	private JLabel enddatumLabel;
	private JDateChooser enddatumKalendar;

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
		add(vertragsartFeld);

		add(bearbeitungsstandLabel);
		add(bearbeitungsstandFeld);

		add(startdatumLabel);
		add(startdatumKalendar);

		add(enddatumLabel);
		add(enddatumKalendar);
	}

//		mitarbeiterComboBox.addActionListener(e -> {
//
//			if (userVertragsEingabenSindValide()) {
//
//				for (Contract vertrag : generateVertragsListe()) {
//
//					int indexOfMitarbeiterString = mitarbeiterComboBox.getSelectedItem().toString().indexOf(",");
//					String mitarbeiterName = mitarbeiterComboBox.getSelectedItem().toString().substring(0,
//							indexOfMitarbeiterString);
//
//					int indexOfKundenString = kundenComboBox.getSelectedItem().toString().indexOf(",");
//					String kundenName = kundenComboBox.getSelectedItem().toString().substring(0, indexOfKundenString);
//
//					if (mitarbeiterName.equals(vertrag.getProjectOwner().getLastname())
//							&& kundenName.equals(vertrag.getCustomer().getLastname())) {
//						vertragsartFeld.setText(generateVertragsart());
//						bearbeitungsstandFeld.setText(generateBearbeitungsstand());
//						break;
//					} else {
//						vertragsartFeld.setText("");
//						bearbeitungsstandFeld.setText("");
//					}
//
//				}
//			}
//
//		});

//		kundenComboBox.addActionListener(e -> {
//			if (userVertragsEingabenSindValide()) {
//
//				for (Contract vertrag : generateVertragsListe()) {
//
//					int indexOfMitarbeiterString = mitarbeiterComboBox.getSelectedItem().toString().indexOf(",");
//					String mitarbeiterName = mitarbeiterComboBox.getSelectedItem().toString().substring(0,
//							indexOfMitarbeiterString);
//
//					int indexOfKundenString = kundenComboBox.getSelectedItem().toString().indexOf(",");
//					String kundenName = kundenComboBox.getSelectedItem().toString().substring(0, indexOfKundenString);
//
//					if (mitarbeiterName.equals(vertrag.getProjectOwner().getLastname())
//							&& kundenName.equals(vertrag.getCustomer().getLastname())) {
//						vertragsartFeld.setText(generateVertragsart());
//						bearbeitungsstandFeld.setText(generateBearbeitungsstand());
//						break;
//					} else {
//						vertragsartFeld.setText("");
//						bearbeitungsstandFeld.setText("");
//					}
//
//				}
//			}
//		});
//
//	}

	private GridBagLayout createGridBagLayout() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		auftragsnummerLabel = new JLabel("Auftragsnummer: ");
		auftragsnummerFeld = new JTextField(15);

		erstelldatumLabel = new JLabel("Erstelldatum: ");
		erstelldatumFeld = new JDateChooser();
		erstelldatumFeld.setPreferredSize(new Dimension(150, 25));

		kundenLabel = new JLabel("Kunde: ");
		kundenComboBox = fillCustomerBox();

		mitarbeiterLabel = new JLabel("Mitarbeiter: ");
		mitarbeiterComboBox = fillEmployeeBox();

		vertragsArtLabel = new JLabel("Vertragsart: ");
		vertragsartFeld = new JTextField(15);

		bearbeitungsstandLabel = new JLabel("Bearbeitungsstand: ");
		bearbeitungsstandFeld = new JTextField(15);

		startdatumLabel = new JLabel("Startdatum: ");
		startdatumKalendar = new JDateChooser();
		startdatumKalendar.setPreferredSize(new Dimension(150, 25));

		enddatumLabel = new JLabel("Enddatum: ");
		enddatumKalendar = new JDateChooser();
		enddatumKalendar.setPreferredSize(new Dimension(150, 25));

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
		gbl.setConstraints(vertragsartFeld, gbc);

		gbc = makegbc(0, 5);
		gbl.setConstraints(bearbeitungsstandLabel, gbc);

		gbc = makegbc(1, 5);
		gbl.setConstraints(bearbeitungsstandFeld, gbc);

		gbc = makegbc(0, 6);
		gbl.setConstraints(startdatumLabel, gbc);

		gbc = makegbc(1, 6);
		gbl.setConstraints(startdatumKalendar, gbc);

		gbc = makegbc(0, 7);
		gbl.setConstraints(enddatumLabel, gbc);

		gbc = makegbc(1, 7);
		gbl.setConstraints(enddatumKalendar, gbc);

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
		comboBoxKundenListe.add(" ");

		for (Customer customer : kundenListe) {
			String kundenString = customer.getLastname() + "," + customer.getCustomerID();
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
		comboBoxMitarbeiterListe.add(" ");

		for (Employee employee : mitarbeiterListe) {
			String mitarbeiterString = employee.getLastname() + "," + employee.getEmployeeID();
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

	public JTextField getAuftragsnummerFeld() {
		return auftragsnummerFeld;
	}

	public void setAuftragsnummerFeld(JTextField auftragsnummerFeld) {
		this.auftragsnummerFeld = auftragsnummerFeld;
	}

	public JDateChooser getErstelldatumFeld() {
		return erstelldatumFeld;
	}

	public void setErstelldatumFeld(JDateChooser erstelldatumFeld) {
		this.erstelldatumFeld = erstelldatumFeld;
	}

	public JComboBox getKundenComboBox() {
		return kundenComboBox;
	}

	public void setKundenComboBox(JComboBox kundenComboBox) {
		this.kundenComboBox = kundenComboBox;
	}

	public ArrayList<String> getComboBoxKundenListe() {
		return comboBoxKundenListe;
	}

	public JComboBox getMitarbeiterComboBox() {
		return mitarbeiterComboBox;
	}

	public JTextField getVertragsartFeld() {
		return vertragsartFeld;
	}

	public JTextField getBearbeitungsstandFeld() {
		return bearbeitungsstandFeld;
	}

	public void setBearbeitungsstandFeld(JTextField bearbeitungsstandFeld) {
		this.bearbeitungsstandFeld = bearbeitungsstandFeld;
	}

	public JDateChooser getStartdatumKalendar() {
		return startdatumKalendar;
	}

	public void setStartdatumKalendar(JDateChooser startdatumKalendar) {
		this.startdatumKalendar = startdatumKalendar;
	}

	public JDateChooser getEnddatumKalendar() {
		return enddatumKalendar;
	}

	public void setEnddatumKalendar(JDateChooser enddatumKalendar) {
		this.enddatumKalendar = enddatumKalendar;
	}

	public ArrayList<String> getComboBoxMitarbeiterListe() {
		return comboBoxMitarbeiterListe;
	}

//	private String generateVertragsart() {
//
//		for (Contract vertrag : generateVertragsListe()) {
//			for (Employee employee : generateEmployeesListe()) {
//				for (Customer customer : generateCustomerListe()) {
//
//					if (istMaUndKundeEinVertragZugewiesen(employee, customer, vertrag)) {
//						String vertragsart = vertrag.getContractType();
//						return vertragsart;
//					}
//				}
//			}
//		}
//
//		return null;
//
//	}
//
//	private boolean istMaUndKundeEinVertragZugewiesen(Employee employee, Customer customer, Contract contract) {
//		if (contract.getProjectOwner().getLastname().equals(employee.getLastname())
//				&& contract.getCustomer().getLastname().equals(customer.getLastname())) {
//			return true;
//		}
//		return false;
//	}
//
//	private String generateBearbeitungsstand() {
//
//		for (Contract vertrag : generateVertragsListe()) {
//			for (Employee employee : generateEmployeesListe()) {
//				for (Customer customer : generateCustomerListe()) {
//
//					if (istMaUndKundeEinVertragZugewiesen(employee, customer, vertrag)) {
//						String bearbeitungsstand = vertrag.getState();
//						return bearbeitungsstand;
//
//					}
//				}
//			}
//		}
//		return null;
//
//	}
//
//	private boolean userVertragsEingabenSindValide() {
//
//		if (mitarbeiterComboBox.getSelectedItem().equals(" ")) {
//			JOptionPane.showMessageDialog(null, "Mitarbeiter ist nicht angegeben");
//			return false;
//		}
//
//		if (kundenComboBox.getSelectedItem().equals(" ")) {
//			JOptionPane.showMessageDialog(null, "Kunde ist nicht angegeben");
//			return false;
//		}
//
//		for (Contract vertrag : generateVertragsListe()) {
//			for (Employee employee : generateEmployeesListe()) {
//				for (Customer customer : generateCustomerListe()) {
//
//					if (istMaUndKundeEinVertragZugewiesen(employee, customer, vertrag)) {
//						return true;
//
//					}
//
//				}
//			}
//		}
//		return false;
//	}
//
//	private void erstelleNeuenActivityRecord() {
//
//	}
//
//	public Contract erstelleNeuenVertrag() {
//
//		BeschreibungsPanel beschreibungsPanel = new BeschreibungsPanel();
//
//		LocalDate erstellDatum = erstelldatumFeld.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//		Address address = new Address("test", "test", "test", "test", "test");
//		Customer customer = (Customer) kundenComboBox.getSelectedItem();
//		Employee employee = (Employee) mitarbeiterComboBox.getSelectedItem();
//		String contractType = vertragsartFeld.getText();
//		String state = bearbeitungsstandFeld.getText();
//		String description = beschreibungsPanel.getBeschreibungsTextarea().getText();
//
//		Contract neuerVertrag = new Contract(erstellDatum, address, customer, employee, contractType, state,
//				description, new ArrayList<>());
//
//		haseGmbHManagement.addNewContract(neuerVertrag);
//		return neuerVertrag;
//
//	}

}
