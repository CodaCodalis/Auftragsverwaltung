package de.oszimt.lf10aContractMgmt.view;
import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Employee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//funktional, aber nicht schön

@SuppressWarnings("serial")
public class Overview extends JFrame {
	private JLabel welcomeLabel;
	private JButton employeeBtn, customerBtn;

	private HaseGmbHManagement driver;

	public Overview(HaseGmbHManagement driver) {
		this.driver = driver;
		//setLayout(new BorderLayout());
		JDialog dialog = new JDialog();
		JPanel panelCustomer = new OverviewCustomerPanel(this.driver);
		JPanel panelEmployee = new OverviewEmployeePanel(this.driver);
		JPanel panelContract = new OverviewContractPanel(this.driver);

		/*
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

		*/

		JTabbedPane tabpane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT );

		tabpane.addTab("Kunden", panelCustomer);
		tabpane.addTab("Mitarbeiter", panelEmployee);
		tabpane.addTab("Aufträge", panelContract);

		dialog.setTitle("Auftragsverwaltung");
		dialog.add(tabpane);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		dialog.setSize(800, 550);
		//dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);

		/*
		employeeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OverviewEmployee(driver).setVisible(true);
				dispose();
			}
		});

		customerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new OverviewCustomer(driver).setVisible(true);
				dispose();
			}
		});

		 */
		
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