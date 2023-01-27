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

	private JTextField txtEmployeeNumber;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JTextField txtEmail;
	private JDateChooser txtBirthday;
	private JRadioButton rbMale;
	private JRadioButton rbFemale;
	private JButton btnSave;
	private JButton btnCancel;

	public NeuerMitarbeiterFrame() {
		setTitle("Employee Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(2000, 1000);
		setVisible(true);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Employee Number:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		txtEmployeeNumber = new JTextField(20);
		panel.add(txtEmployeeNumber, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(new JLabel("First Name:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		txtFirstName = new JTextField(20);
		panel.add(txtFirstName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(new JLabel("Last Name:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		txtLastName = new JTextField(20);
		panel.add(txtLastName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(new JLabel("Address:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		txtAddress = new JTextField(20);
		panel.add(txtAddress, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(new JLabel("Phone Number:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		txtPhoneNumber = new JTextField(20);
		panel.add(txtPhoneNumber, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		panel.add(new JLabel("Email:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		txtEmail = new JTextField(20);
		panel.add(txtEmail, gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(new JLabel("Birthday:"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 6;
		txtBirthday = new JDateChooser();
		txtBirthday.setDateFormatString("yyyy-MM-dd");
		panel.add(txtBirthday, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		panel.add(new JLabel("Gender:"), gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		rbMale = new JRadioButton("Male");
		panel.add(rbMale, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		rbFemale = new JRadioButton("Female");
		panel.add(rbFemale, gbc);

		ButtonGroup group = new ButtonGroup();
		group.add(rbMale);
		group.add(rbFemale);

		gbc.gridx = 0;
		gbc.gridy = 7;
		btnSave = new JButton("Save");
		panel.add(btnSave, gbc);

		gbc.gridx = 1;
		gbc.gridy = 7;
		btnCancel = new JButton("Cancel");
		panel.add(btnCancel, gbc);

		add(panel);
		pack();
	}

	public static void main(String[] args) {
		final NeuerMitarbeiterFrame form = new NeuerMitarbeiterFrame();
	}
}
