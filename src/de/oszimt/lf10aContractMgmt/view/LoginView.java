package de.oszimt.lf10aContractMgmt.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//funktional, aber nicht schön

@SuppressWarnings("serial")
public class LoginView extends JFrame {

	private JLabel usernameLabel, passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;

	public LoginView() {
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
		constraints.gridy = 0;
		panel.add(usernameLabel, constraints);

		usernameField = new JTextField(10);
		constraints.gridx = 1;
		constraints.gridy = 0;
		usernameField.setText("Test");
		panel.add(usernameField, constraints);

		passwordLabel = new JLabel("Password:");
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(passwordLabel, constraints);

		passwordField = new JPasswordField(10);
		passwordField.setText("Test123");
		constraints.gridx = 1;
		constraints.gridy = 1;
		panel.add(passwordField, constraints);

		loginButton = new JButton("Login");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		panel.add(loginButton, constraints);


		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String passwordValue = String.valueOf(passwordField.getPassword());
				String usernameValue = usernameField.getText();
				String enteredPw = "Test123";
				String enteredName = "Test";
				if (usernameField.getText().isEmpty() || passwordField.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Leere Felder. Bitte versuchen Sie es erneut.", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				} else if (passwordValue.equals(enteredPw) && usernameValue.equals(enteredName)) {
					new Overview().setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Falsches Passwort. Bitte versuchen Sie es erneut.", "Fehler",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		add(panel);
		//pack();
		setVisible(true);
	}
/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new LoginView().setVisible(true);
			}
		});
	}

 */
}
