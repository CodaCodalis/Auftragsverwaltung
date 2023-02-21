package de.oszimt.lf10aContractMgmt.view;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

@SuppressWarnings("serial")
public class ForgetPwView extends JFrame {

	private JLabel usernameLabel, passwordLabel, time;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton saveBtn, cancelBtn;

	// Hardcoded login data
	private String enteredPw = "Test123";
	private String enteredName = "Test";

	public ForgetPwView(HaseGmbHManagement driver) {
		setResizable(false);
		setTitle("Login");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);

		usernameLabel = new JLabel("aktuellen Benutzernamen eingeben:");
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(usernameLabel, constraints);

		usernameField = new JTextField(10);
		constraints.gridx = 0;
		constraints.gridy = 1;
		usernameField.setText("Test");
		panel.add(usernameField, constraints);

		passwordLabel = new JLabel("neues Passwort eingeben:");
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(passwordLabel, constraints);

		passwordLabel = new JLabel("neues Passwort eingeben:");
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(passwordLabel, constraints);

		passwordField = new JPasswordField(10);
		passwordField.setText("");
		constraints.gridx = 0;
		constraints.gridy = 3;
		panel.add(passwordField, constraints);

		saveBtn = new JButton("Save");
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(saveBtn, constraints);

		cancelBtn = new JButton("Cancel");
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(cancelBtn, constraints);

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginView(driver).setVisible(true);
				dispose();
			}
		});

		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkPwResetInserts()) {
					newPw = String.valueOf(passwordField.getPassword());
					new LoginView(driver).setVisible(true);
					dispose();
				}
			}
		});

		add(panel);
		setVisible(true);
	}

	private boolean checkPwResetInserts() {
		String passwordValue = String.valueOf(passwordField.getPassword());
		String usernameValue = usernameField.getText();
		if (usernameField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Benutzername ist leer!", "Fehler", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (passwordField.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Passwordfeld ist leer!", "Fehler", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (passwordValue.equals(enteredPw)) {
			JOptionPane.showMessageDialog(null, "Das Passwort ähnelt dem vorherigem Passwort!", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!(usernameValue.equals(enteredName))) {
			JOptionPane.showMessageDialog(null, "Benutzername ist nicht korrekt!", "Fehler", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(null, "Passwort wurde erfolgreich geändert. Sie werden nun zur Loginübersicht weitergeleitet!", "Erfolgreich",
				JOptionPane.INFORMATION_MESSAGE);
		return true;
	}
}
