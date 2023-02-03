package de.oszimt.lf10aContractMgmt.view;

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
import de.oszimt.lf10aContractMgmt.model.Customer;

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

	private JLabel vertragsartLabel;
	private JTextField vertragsartFeld;

	private JLabel kundenLabel;
	private JComboBox kundenComboBox;
	private ArrayList<Customer> kundenListe;
	private ArrayList<String> comboBoxListe;

	public AuftragsdatenPanel() {

		setVisible(true);
		setLayout(createGridBagLayout());

		add(auftragsnummerLabel);
		add(auftragsnummerFeld);

		add(erstelldatumLabel);
		add(erstelldatumFeld);

		add(vertragsartLabel);
		add(vertragsartFeld);

		add(kundenLabel);
		add(kundenComboBox);

	}

	private GridBagLayout createGridBagLayout() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		auftragsnummerLabel = new JLabel("Auftragsnummer: ");
		auftragsnummerFeld = new JTextField(15);

		erstelldatumLabel = new JLabel("Erstelldatum: ");
		erstelldatumFeld = new JTextField(15);

		vertragsartLabel = new JLabel("Vetragsart: ");
		vertragsartFeld = new JTextField(15);

		kundenLabel = new JLabel("Kunde: ");
		kundenComboBox = fillCustomerBox();

		gbc = makegbc(0, 0);
		gbl.setConstraints(auftragsnummerLabel, gbc);

		gbc = makegbc(1, 0);
		gbl.setConstraints(auftragsnummerFeld, gbc);

		gbc = makegbc(0, 1);
		gbl.setConstraints(erstelldatumLabel, gbc);

		gbc = makegbc(1, 1);
		gbl.setConstraints(erstelldatumFeld, gbc);

		gbc = makegbc(0, 2);
		gbl.setConstraints(vertragsartLabel, gbc);

		gbc = makegbc(1, 2);
		gbl.setConstraints(vertragsartFeld, gbc);

		gbc = makegbc(0, 3);
		gbl.setConstraints(kundenLabel, gbc);

		gbc = makegbc(1, 3);
		gbl.setConstraints(kundenComboBox, gbc);

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

		HaseGmbHClientSimulation haseGmbHClientSimulation = new HaseGmbHClientSimulation();
		HaseGmbHManagement haseGmbHManagement = new HaseGmbHManagement();
		haseGmbHManagement = haseGmbHClientSimulation.getHaseMgmtDriver();

		kundenComboBox = new JComboBox<Customer>();

		kundenListe = new ArrayList<>();
		kundenListe = haseGmbHManagement.getAllCustomers();

		comboBoxListe = new ArrayList<>();

		for (Customer customer : kundenListe) {
			String kundenString = customer.getLastname() + " , " + customer.getCustomerID();
			comboBoxListe.add(kundenString);
		}

		kundenComboBox.setModel(new DefaultComboBoxModel<String>(comboBoxListe.toArray(new String[0])));

		return kundenComboBox;

	}

}
