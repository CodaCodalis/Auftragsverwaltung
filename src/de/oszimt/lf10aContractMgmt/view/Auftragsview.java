package de.oszimt.lf10aContractMgmt.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;

public class Auftragsview extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private AuftragsdatenPanel auftragsdatenPanel;
	private AuftragsButtonPanel auftragsButtonPanel;
	private BeschreibungsPanel beschreibungsPanel;

	private HaseGmbHManagement driver;

	public Auftragsview(HaseGmbHManagement driver) {
		super("Auftrag");
		this.driver = driver;
		setLayout(createBagLayout());
		setSize(800, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		add(auftragsdatenPanel);
		add(auftragsButtonPanel);
		add(beschreibungsPanel.getScrollPane());
		add(beschreibungsPanel);

	}

	private GridBagLayout createBagLayout() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		auftragsdatenPanel = new AuftragsdatenPanel();
		auftragsButtonPanel = new AuftragsButtonPanel();
		beschreibungsPanel = new BeschreibungsPanel();

		gbc = makegbc(0, 0, 0, 1);
		gbc.weightx = 0.5;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.WEST;
		gbc.anchor = GridBagConstraints.WEST;
		gbl.setConstraints(auftragsdatenPanel, gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;

		gbl.setConstraints(beschreibungsPanel, gbc);

		return gbl;
	}

	private GridBagConstraints makegbc(int x, int y, int width, int height) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.insets = new Insets(1, 1, 1, 1);
		return gbc;
	}

}
