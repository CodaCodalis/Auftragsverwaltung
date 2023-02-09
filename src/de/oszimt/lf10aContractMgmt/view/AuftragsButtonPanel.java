package de.oszimt.lf10aContractMgmt.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AuftragsButtonPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private JButton saveButton;
	private JButton cancelButton;

	public AuftragsButtonPanel() {

		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");

		setLayout(new FlowLayout(FlowLayout.LEFT, 100, 20));

		add(saveButton);
		add(cancelButton);

	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

}
