package de.oszimt.lf10aContractMgmt.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AuftragsDeleteButtonPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JButton deleteButton;
	private JButton cancelButton;

	public AuftragsDeleteButtonPanel() {

		deleteButton = new JButton("Delete");
		cancelButton = new JButton("Cancel");

		setLayout(new FlowLayout(FlowLayout.LEFT, 100, 20));

		add(deleteButton);
		add(cancelButton);

	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

}
