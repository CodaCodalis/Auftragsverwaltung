package de.oszimt.lf10aContractMgmt;

import java.awt.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

public class OrderOverview extends JFrame {
    private JPanel contentPane;
    private JTextField orderNumberField;
    private JDateChooser dateField;
    private JComboBox<String> customerComboBox;
    private JComboBox<String> employeeComboBox;
    private JTextField contractTypeField;
    private JComboBox<String> progressComboBox;
    private JDateChooser startDateField;
    private JDateChooser endDateField;
    private JTextArea descriptionField;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton conversationButton;

    public OrderOverview() {
        setTitle("Data Input Module");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Order Number
        JLabel orderNumberLabel = new JLabel("Order Number:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        contentPane.add(orderNumberLabel, c);

        orderNumberField = new JTextField();
        c.gridx = 1;
        c.gridy = 0;
        contentPane.add(orderNumberField, c);

        // Creation Date
        JLabel dateLabel = new JLabel("Creation Date:");
        c.gridx = 0;
        c.gridy = 1;
        contentPane.add(dateLabel, c);

        dateField = new JDateChooser();
        dateField.setDate(new Date());
        c.gridx = 1;
        c.gridy = 1;
        contentPane.add(dateField, c);

        // Customer
        JLabel customerLabel = new JLabel("Customer:");
        c.gridx = 0;
        c.gridy = 2;
        contentPane.add(customerLabel, c);

        customerComboBox = new JComboBox<String>(new String[]{"Customer 1", "Customer 2", "Customer 3"});
        c.gridx = 1;
        c.gridy = 2;
        contentPane.add(customerComboBox, c);

        // Employee
        JLabel employeeLabel = new JLabel("Employee:");
        c.gridx = 0;
        c.gridy = 3;
        contentPane.add(employeeLabel, c);

        employeeComboBox = new JComboBox<String>(new String[]{"Employee 1", "Employee 2", "Employee 3"});
        c.gridx = 1;
        c.gridy = 3;
        contentPane.add(employeeComboBox, c);

        // Contract Type
        JLabel contractTypeLabel = new JLabel("Contract Type:");
        c.gridx = 0;
        c.gridy = 4;
        contentPane.add(contractTypeLabel, c);

        contractTypeField = new JTextField();
        c.gridx = 1;
        c.gridy = 4;
        contentPane.add(contractTypeField, c);

        // Progress
        JLabel progressLabel = new JLabel("Progress:");
        c.gridx = 0;
        c.gridy = 5;
        contentPane.add(progressLabel, c);

        progressComboBox = new JComboBox<String>(new String[]{"Not Started", "In Progress", "Completed"});
        c.gridx = 1;
        c.gridy = 5;
        contentPane.add(progressComboBox, c);

        // Start Date
        JLabel startDateLabel = new JLabel("Start Date:");
        c.gridx = 0;
        c.gridy = 6;
        contentPane.add(startDateLabel, c);

        startDateField = new JDateChooser();
        startDateField.setDate(new Date());
        c.gridx = 1;
        c.gridy = 6;
        contentPane.add(startDateField, c);

        // End Date
        JLabel endDateLabel = new JLabel("End Date:");
        c.gridx = 0;
        c.gridy = 7;
        contentPane.add(endDateLabel, c);

        endDateField = new JDateChooser();
        endDateField.setDate(new Date());
        c.gridx = 1;
        c.gridy = 7;
        contentPane.add(endDateField, c);

        // Description
        JLabel descriptionLabel = new JLabel("Description:");
        c.gridx = 0;
        c.gridy = 8;
        contentPane.add(descriptionLabel, c);

        descriptionField = new JTextArea(5, 20);
        c.gridx = 1;
        c.gridy = 8;
        contentPane.add(new JScrollPane(descriptionField), c);

        // Conversation Button
        conversationButton = new JButton("Conversation");
        c.gridx = 1;
        c.gridy = 9;
        contentPane.add(conversationButton, c);

        // Save and Cancel buttons
        saveButton = new JButton("Save");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 10;
        contentPane.add(saveButton, c);

        cancelButton = new JButton("Cancel");
        c.gridx = 1;
        c.gridy = 10;
        contentPane.add(cancelButton, c);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OrderOverview frame = new OrderOverview();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}