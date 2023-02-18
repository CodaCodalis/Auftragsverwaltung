package de.oszimt.lf10aContractMgmt.view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//funktional, aber nicht schön

@SuppressWarnings("serial")
public class Overview extends JFrame {
	private JLabel welcomeLabel;
	private JButton employeeBtn, customerBtn;

	public Overview() {
		setLayout(new BorderLayout());

		JPanel northPanel = new JPanel();
		welcomeLabel = new JLabel("Willkommen");
		northPanel.add(welcomeLabel);
		add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(5, 5, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.CENTER;
		employeeBtn = new JButton("Mitarbeiter");
		centerPanel.add(employeeBtn, constraints);
		constraints.gridy = 1;
		customerBtn = new JButton("Kunde");
		centerPanel.add(customerBtn, constraints);
		add(centerPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setResizable(false);

		setTitle("Overview Auftragsverwaltung");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		employeeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new EmployeeOverview().setVisible(true);
				dispose();
			}
		});

		customerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CustomerOverview().setVisible(true);
				dispose();
			}
		});
		
	}
/*
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Overview().setVisible(true);

			}
		});
	}

 */
}