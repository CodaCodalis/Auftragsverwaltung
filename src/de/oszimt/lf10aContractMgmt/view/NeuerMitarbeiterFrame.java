package de.oszimt.lf10aContractMgmt.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class NeuerMitarbeiterFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField mitarbeiternummerTextField;
	private JTextField vornameTextField;
	private JTextField nachnameTextField;
	private JTextField adresseTextField;
	private JTextField telefonnummerTextField;
	private JTextField emailTextField;
	private JDateChooser geburtstagKalender;
	private JRadioButton maennlichBtn;
	private JRadioButton weiblichBtn;
	private JButton saveBtn;
	private JButton cancelBtn;

	public NeuerMitarbeiterFrame() {
		setTitle("Neuer Mitarbeiter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

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
		panel.add(new JLabel("Addresse:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		adresseTextField = new JTextField(20);
		panel.add(adresseTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(new JLabel("Telefonnummerr:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		telefonnummerTextField = new JTextField(20);
		panel.add(telefonnummerTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(new JLabel("Email:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		emailTextField = new JTextField(20);
		panel.add(emailTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(new JLabel("Geburtsdatum:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		geburtstagKalender = new JDateChooser();
//		geburtstagKalender.setDateFormatString("yyyy-MM-dd");
		geburtstagKalender.setDateFormatString("dd-MM-yyyy");
		panel.add(geburtstagKalender, gbc);

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

		ButtonGroup group = new ButtonGroup();
		group.add(maennlichBtn);
		group.add(weiblichBtn);

		gbc.gridx = 0;
		gbc.gridy = 7;
		saveBtn = new JButton("Save");
		panel.add(saveBtn, gbc);

		saveBtn.addActionListener(whenSaveBtnClicked -> {
			if (userEingabenSindValide()) {
				// Adde den neuen Mitarbeiter in Datenbank oder irgenwo anders
				JOptionPane.showMessageDialog(null, "Die Daten wurden erfolgreich hinzugefügt");
			}
		});

		gbc.gridx = 1;
		gbc.gridy = 7;
		cancelBtn = new JButton("Cancel");
		panel.add(cancelBtn, gbc);

		cancelBtn.addActionListener(whenCancelBtnClicked -> {
			// Springe zurück auf die andere View
			JOptionPane.showMessageDialog(null,
					"Vorgang abgebrochen, [NOCH NICHT IMPLEMENTIERT] sie werden zurück weitergeleitet");
		});

		add(panel);
		pack();
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

		if (adresseTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Adresse ist nicht angegeben");
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

		if (geburtstagKalender.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Geburtsdatum  ist nicht angegeben");
			return false;
		}

		if (!maennlichBtn.isSelected() && !weiblichBtn.isSelected()) {
			JOptionPane.showMessageDialog(null, "Geschlecht  ist nicht angegeben");
			return false;
		}

		return true;

	}

}
