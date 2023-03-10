package de.oszimt.lf10aContractMgmt.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.ActivityRecord;
import de.oszimt.lf10aContractMgmt.model.Address;
import de.oszimt.lf10aContractMgmt.model.Contract;
import de.oszimt.lf10aContractMgmt.model.Customer;
import de.oszimt.lf10aContractMgmt.model.Employee;
import de.oszimt.lf10aContractMgmt.model.IntContractMgmt;

public class Auftragsview extends JFrame implements IntContractMgmt {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private AuftragsdatenPanel auftragsdatenPanel;
	private AuftragsButtonPanel auftragsButtonPanel;
	private BeschreibungsPanel beschreibungsPanel;

	private HaseGmbHManagement driver;

	public Auftragsview(HaseGmbHManagement driver) {
		super("Auftrag");
		this.driver = driver;
		setLayout(createBagLayout());
		setSize(800, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		auftragsdatenPanel.getAuftragsnummerFeld().setText(getNextFreeContractID(driver) + "");
		auftragsdatenPanel.getAuftragsnummerFeld().setEditable(false);

		auftragsButtonPanel.getCancelButton().addActionListener(l -> {
			OverviewEmployee overviewEmployee = new OverviewEmployee(driver);
			overviewEmployee.setVisible(true);
			dispose();
		});

		auftragsButtonPanel.getSaveButton().addActionListener(s -> {
			LocalDate erstellDatum = auftragsdatenPanel.getErstelldatumFeld().getDate().toInstant()
					.atZone(ZoneId.systemDefault()).toLocalDate();
			Address address = new Address("test", "test", "test", "test", "test");

			Employee newEmployee = driver.getAllEmployees().get(0);
			Customer newCustomer = driver.getAllCustomers().get(0);

			String contractType = auftragsdatenPanel.getVertragsartFeld().getText();
			String state = auftragsdatenPanel.getBearbeitungsstandFeld().getText();
			String description = beschreibungsPanel.getBeschreibungsTextarea().getText();
			if (userEingabenSindValide()) {
				Contract newContract = new Contract(erstellDatum, address, newCustomer, newEmployee, contractType,
						state, description, new ArrayList<>());

				newContract.setContractID(Integer.valueOf(auftragsdatenPanel.getAuftragsnummerFeld().getText()));
				driver.addNewContract(newContract);
				Auftragsview auftragsview = new Auftragsview(driver);
				auftragsview.setVisible(true);
				dispose();
			}

			for (Contract contract : driver.getAllContracts()) {
				System.out.println(contract.toString());
			}

		});

		add(auftragsdatenPanel);
		add(auftragsButtonPanel);
		add(beschreibungsPanel.getScrollPane());
		add(beschreibungsPanel);

	}

	private GridBagLayout createBagLayout() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		auftragsdatenPanel = new AuftragsdatenPanel();
		auftragsButtonPanel = new AuftragsButtonPanel();
		beschreibungsPanel = new BeschreibungsPanel();

		gbc = makegbc(0, 0, 0, 1);
		gbc.weightx = 0.5;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.WEST;
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(auftragsdatenPanel, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;

		gbl.setConstraints(beschreibungsPanel, gbc);

		return gbl;
	}

	private GridBagConstraints makegbc(int x, int y, int width, int height) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.insets = new Insets(1, 1, 1, 1);
		return gbc;
	}

	private int getNextFreeContractID(HaseGmbHManagement driver) {
		int nextFreeContractID = 0;
		for (Contract contract : driver.getAllContracts()) {
			if (contract.getContractID() > nextFreeContractID) {
				nextFreeContractID = contract.getContractID();
			}
		}

		return nextFreeContractID + 1;

	}

	@Override
	public boolean addNewContract(Contract newContract) {
		driver.addNewContract(newContract);
		return false;
	}

	@Override
	public Contract getContract(int contractID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Contract> getAllContracts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(Contract aContract) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNewWorkingRecord(int contractID, ActivityRecord aRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContract(int contractID) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean userEingabenSindValide() {

		if (auftragsdatenPanel.getVertragsartFeld().getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Die Vertragsart ist nicht angegeben");
			return false;
		}

		if (auftragsdatenPanel.getBearbeitungsstandFeld().getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Der Bearbeitungsstand ist nicht angegeben");
			return false;
		}

		if (auftragsdatenPanel.getErstelldatumFeld().getDate() == null) {
			JOptionPane.showMessageDialog(null, "Das Erstelldatum ist nicht angegeben");
			return false;
		}

		if (auftragsdatenPanel.getStartdatumKalendar().getDate() == null) {
			JOptionPane.showMessageDialog(null, "Das Startdatum für den Vertrag ist nicht angegeben");
			return false;
		}

		if (auftragsdatenPanel.getEnddatumKalendar().getDate() == null) {
			JOptionPane.showMessageDialog(null, "Das Enddatum für den Vertrag ist nicht angegeben");
			return false;
		}

		if (auftragsdatenPanel.getMitarbeiterComboBox().getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Kein Mitarbeiter angegeben");
			return false;
		}

		if (auftragsdatenPanel.getKundenComboBox().getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Kein Kunde angegeben");
			return false;
		}

		return true;

	}

}
