package de.oszimt.lf10aContractMgmt.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class Auftragsview extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Auftragsview() {
		super("Auftrag");

		setVisible(true);
		setPreferredSize(new Dimension(800, 600));
		// setResizable(false);

		setLayout(createBagLayout());

	}

	private GridBagLayout createBagLayout() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		return gbl;
	}

}
