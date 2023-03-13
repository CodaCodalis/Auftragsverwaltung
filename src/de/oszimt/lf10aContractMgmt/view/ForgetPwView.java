package de.oszimt.lf10aContractMgmt.view;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ForgetPwView extends JFrame {

	private JLabel usernameLabel, passwordLabel, pwInfos;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton saveBtn, cancelBtn;
	String newPw = "<html><div style='text-align: center;'>Das Passwort muss folgende Kriterien erfüllen: <br> - mindestens " +
			"8 Zeichen <br> - mindestens 1 Zahl <br> - mindestens 1 Großbuchstabe <br> - mindestens 1 Sonderzeichen</div></html>\"";
	String passwordValue, usernameValue;

	// Hardcoded login data
	private String enteredPw = "Test123";
	private String enteredName = "Test";

	public ForgetPwView(HaseGmbHManagement driver) {
		setResizable(false);
		setTitle("Passwort vergessen - Auftragsverwaltung");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);

		// Setup labels, fields and buttons
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
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(saveBtn, constraints);

		cancelBtn = new JButton("Cancel");
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(cancelBtn, constraints);

		pwInfos = new JLabel(newPw);
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(pwInfos, constraints);

		//go back to login overview
		cancelBtn.addActionListener(e -> {
			new LoginView(driver).setVisible(true);
			dispose();
		});

		saveBtn.addActionListener(e -> {
			if (checkPwResetInserts() && checkPasswordSecurity(passwordValue)) {
				JOptionPane.showMessageDialog(null,
						"Passwort wurde erfolgreich geändert. Sie werden nun zur Loginübersicht weitergeleitet! Das Passwort wird automatisch aktualisiert!",
						"Erfolgreich", JOptionPane.INFORMATION_MESSAGE);
				newPw = String.valueOf(passwordField.getPassword());
				LoginView loginView = new LoginView(driver);
				loginView.updatePassword(newPw);
				loginView.setVisible(true);
				dispose();
			}
		});

		add(panel);
		setVisible(true);
	}

	private boolean checkPwResetInserts() {
		passwordValue = String.valueOf(passwordField.getPassword());
		usernameValue = usernameField.getText();
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
		return true;
	}

	private boolean checkPasswordSecurity(String password) {
		if (password.length() < 8) {
			JOptionPane.showMessageDialog(null, "Das Passwort muss mindestens 8 Zeichen betragen!", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!password.matches(".*[A-Z].*")) {
			JOptionPane.showMessageDialog(null, "Das Passwort muss mindestens einen Großbuchstaben enhalten!", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!password.matches(".*[a-z].*")) {
			JOptionPane.showMessageDialog(null, "Das Passwort muss mindestens einen Kleinbuchstaben enthalten!",
					"Fehler", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!password.matches(".*\\d.*")) {
			JOptionPane.showMessageDialog(null, "Das Passwort muss mindestens eine Zahl enthalten!", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!password.matches(".*[!@#$%^&*.,()].*")) {
			JOptionPane.showMessageDialog(null, "Das Passwort muss mindestens ein Sonderzeichen enhalten!", "Fehler",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
