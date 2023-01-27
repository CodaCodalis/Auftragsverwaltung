package de.oszimt.lf10aContractMgmt.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		panel.add(new JLabel("First Name:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		vornameTextField = new JTextField(20);
		panel.add(vornameTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(new JLabel("Last Name:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		nachnameTextField = new JTextField(20);
		panel.add(nachnameTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(new JLabel("Address:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		adresseTextField = new JTextField(20);
		panel.add(adresseTextField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(new JLabel("Phone Number:"), gbc);

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
		panel.add(new JLabel("Birthday:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		geburtstagKalender = new JDateChooser();
		geburtstagKalender.setDateFormatString("yyyy-MM-dd");
		panel.add(geburtstagKalender, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(new JLabel("Gender:"), gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		maennlichBtn = new JRadioButton("Male");
		panel.add(maennlichBtn, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		weiblichBtn = new JRadioButton("Female");
		panel.add(weiblichBtn, gbc);

		ButtonGroup group = new ButtonGroup();
		group.add(maennlichBtn);
		group.add(weiblichBtn);

		gbc.gridx = 0;
		gbc.gridy = 7;
		saveBtn = new JButton("Save");
		panel.add(saveBtn, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		cancelBtn = new JButton("Cancel");
		panel.add(cancelBtn, gbc);

		add(panel);
		pack();
	}

}
