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
	private AuftragsdatenPanel auftragsdatenPanel;

	public AuftragsButtonPanel() {

		auftragsdatenPanel = new AuftragsdatenPanel();

		saveButton = new JButton("Save");
		saveButton.addActionListener(e -> {
			auftragsdatenPanel.erstelleNeuenVertrag();
			System.out.println(auftragsdatenPanel.erstelleNeuenVertrag().toString());
		});
		cancelButton = new JButton("Cancel");
//		 cancelButton.addActionListener(l -> {
//			new OverviewEmployee(null)
//		});

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
