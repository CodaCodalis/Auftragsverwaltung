package de.oszimt.lf10aContractMgmt.view;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoginView extends JFrame {

	private JLabel usernameLabel, passwordLabel, time;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton, forgetPw;
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	private Timer timer;

	// Hardcoded login data
	private String enteredPw = "Test123";
	private String enteredName = "Test";

	public LoginView(HaseGmbHManagement driver) {

		setResizable(false);
		setTitle("Login");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);

		usernameLabel = new JLabel("Username:");
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(usernameLabel, constraints);

		usernameField = new JTextField(10);
		constraints.gridx = 1;
		constraints.gridy = 1;
		usernameField.setText("Test");
		panel.add(usernameField, constraints);

		passwordLabel = new JLabel("Password:");
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel.add(passwordLabel, constraints);

		passwordField = new JPasswordField(10);
		passwordField.setText("Test123");
		constraints.gridx = 1;
		constraints.gridy = 2;
		panel.add(passwordField, constraints);

		loginButton = new JButton("Login");
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(loginButton, constraints);

		forgetPw = new JButton("Passwort vergessen");
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(forgetPw, constraints);

		time = new JLabel();
		time.setHorizontalAlignment(SwingConstants.RIGHT);
		constraints.gridx = 0;
		constraints.gridy = 5;
		panel.add(time, constraints);
		timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time.setText(sdf.format(new Date()));
			}
		});
		timer.start();

		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkLoginInserts()) {
					new Overview(driver).setVisible(true);
					dispose();
				}
			}
		});

		forgetPw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ForgetPwView(driver).setVisible(true);
				dispose();
			}
		});
		add(panel);
		setVisible(true);
	}

	private boolean checkLoginInserts() {
		String passwordValue = String.valueOf(passwordField.getPassword());
		String usernameValue = usernameField.getText();
		if (usernameField.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Benutzername ist leer!", "Fehler", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (passwordField.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Passworteingabefeld ist leer!", "Fehler", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!(passwordValue.equals(enteredPw) && usernameValue.equals(enteredName))) {
			JOptionPane.showMessageDialog(null, "Falsches Passwort oder Benutzername. Bitte versuchen Sie es erneut.",
					"Fehler", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public void updatePassword(String newPassword) {
		enteredPw = newPassword;
		passwordField.setText(enteredPw);

	}
}
