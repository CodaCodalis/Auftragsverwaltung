package de.oszimt.lf10aContractMgmt.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BeschreibungsPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JLabel beschreibungLabel;
	private JTextArea beschreibungsTextarea;
	private JScrollPane scrollPane;

	private JButton gespraechsProtokollButton;

	public BeschreibungsPanel() {

		beschreibungLabel = new JLabel("Beschreibung:");
		beschreibungsTextarea = new JTextArea(15, 25);
		beschreibungsTextarea.setLineWrap(true);
		scrollPane = new JScrollPane(beschreibungsTextarea);

		gespraechsProtokollButton = new JButton("Gesprächsprotokoll");

		setLayout(createGridbagLayout());

		add(beschreibungLabel);
		add(Box.createHorizontalStrut(10));
		add(beschreibungsTextarea);
		add(scrollPane);
		add(gespraechsProtokollButton);

	}

	private GridBagLayout createGridbagLayout() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbl.setConstraints(beschreibungLabel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbl.setConstraints(beschreibungsTextarea, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbl.setConstraints(gespraechsProtokollButton, gbc);

		return gbl;
	}

}
