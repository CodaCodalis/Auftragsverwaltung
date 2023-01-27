package de.oszimt.lf10aContractMgmt;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//funktional, aber nicht schön

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JLabel usernameLabel, passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;

	public Login() {
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);

		usernameLabel = new JLabel("Username:");
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(usernameLabel, constraints);

		usernameField = new JTextField(10);
		constraints.gridx = 1;
		constraints.gridy = 0;
		add(usernameField, constraints);

		passwordLabel = new JLabel("Password:");
		constraints.gridx = 0;
		constraints.gridy = 1;
		add(passwordLabel, constraints);

		passwordField = new JPasswordField(10);
		constraints.gridx = 1;
		constraints.gridy = 1;
		add(passwordField, constraints);

		loginButton = new JButton("Login");
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		add(loginButton, constraints);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Login");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

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
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Login().setVisible(true);
			}
		});
	}
}
