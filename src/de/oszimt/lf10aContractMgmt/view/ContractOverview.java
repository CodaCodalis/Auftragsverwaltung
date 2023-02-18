package de.oszimt.lf10aContractMgmt.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;

public class ContractOverview extends JFrame {

    HaseGmbHManagement driver;
    public ContractOverview(HaseGmbHManagement driver) {
        this.driver = driver;
        setTitle("Auftragsübersicht");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,500);
        //setBounds(100, 100, 800, 500);
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Order Number
        JLabel orderNumberLabel = new JLabel("Auftragsnummer:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        contentPane.add(orderNumberLabel, c);

        JTextField orderNumberField = new JTextField();
        c.gridx = 1;
        c.gridy = 0;
        contentPane.add(orderNumberField, c);

        // Creation Date
        JLabel dateLabel = new JLabel("Erstelldatum:");
        c.gridx = 0;
        c.gridy = 1;
        contentPane.add(dateLabel, c);

        JDateChooser dateField = new JDateChooser();
        dateField.setDate(new Date());
        c.gridx = 1;
        c.gridy = 1;
        contentPane.add(dateField, c);

        // Customer
        JLabel customerLabel = new JLabel("Kunde:");
        c.gridx = 0;
        c.gridy = 2;
        contentPane.add(customerLabel, c);

        JComboBox<String> customerComboBox = new JComboBox<>(new String[]{"Kunde 1", "Kunde 2", "Kunde 3"});
        c.gridx = 1;
        c.gridy = 2;
        contentPane.add(customerComboBox, c);

        // Employee
        JLabel employeeLabel = new JLabel("Mitarbeiter:");
        c.gridx = 0;
        c.gridy = 3;
        contentPane.add(employeeLabel, c);

        JComboBox<String> employeeComboBox = new JComboBox<>(new String[]{"Mitarb1", "Mitarb2", "Mitarb3"});
        c.gridx = 1;
        c.gridy = 3;
        contentPane.add(employeeComboBox, c);

        // Contract Type
        JLabel contractTypeLabel = new JLabel("Vertragsart:");
        c.gridx = 0;
        c.gridy = 4;
        contentPane.add(contractTypeLabel, c);

        JTextField contractTypeField = new JTextField();
        c.gridx = 1;
        c.gridy = 4;
        contentPane.add(contractTypeField, c);

        // Progress
        JLabel progressLabel = new JLabel("Bearbeitungsstand:");
        c.gridx = 0;
        c.gridy = 5;
        contentPane.add(progressLabel, c);

        JComboBox<String> progressComboBox = new JComboBox<>(new String[]{"Nicht angefangen", "Laufend", "Fertig"});
        c.gridx = 1;
        c.gridy = 5;
        contentPane.add(progressComboBox, c);

        // Start Date
        JLabel startDateLabel = new JLabel("Startdatum:");
        c.gridx = 0;
        c.gridy = 6;
        contentPane.add(startDateLabel, c);

        JDateChooser startDateField = new JDateChooser();
        startDateField.setDate(new Date());
        c.gridx = 1;
        c.gridy = 6;
        contentPane.add(startDateField, c);

        // End Date
        JLabel endDateLabel = new JLabel("Enddatum:");
        c.gridx = 0;
        c.gridy = 7;
        contentPane.add(endDateLabel, c);

        JDateChooser endDateField = new JDateChooser();
        endDateField.setDate(new Date());
        c.gridx = 1;
        c.gridy = 7;
        contentPane.add(endDateField, c);

        // Description
        JLabel descriptionLabel = new JLabel("Beschreibung");
        c.gridx = 2;
        c.gridy = 0;
        contentPane.add(descriptionLabel, c);

        JTextArea descriptionField = new JTextArea(5, 20);
        c.gridx = 2;
        c.gridy = 1;
        c.gridheight = 5;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTHWEST;
        contentPane.add(new JScrollPane(descriptionField), c);

        // Conversation Button
        JButton conversationButton = new JButton("Gesprächsprotokoll");
        c.gridx = 2;
        c.gridy = 6;
        contentPane.add(conversationButton, c);

        // Save and Cancel buttons
        JButton saveButton = new JButton("Save");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 15;
        c.insets = new Insets(10, 10, 0, 0);
        contentPane.add(saveButton, c);

        JButton cancelButton = new JButton("Cancel");
        c.gridx = 2;
        c.gridy = 15;
        c.insets = new Insets(10, 0, 0, 10);
        contentPane.add(cancelButton, c);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeOverview employeeOverview = new EmployeeOverview(driver);
                employeeOverview.setVisible(true);
                dispose();
            }
        });
    }
/*
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContractOverview frame = new ContractOverview();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
*/

}