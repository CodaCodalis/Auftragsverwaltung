package de.oszimt.lf10aContractMgmt.view;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NeuerMitarbeiterFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public NeuerMitarbeiterFrame() {
		setVisible(true);
		setSize(500, 500);

		final GridBagLayout gridBagLayout = new GridBagLayout();

		final JPanel textFieldPanel = new JPanel(new GridBagLayout());

		final JLabel mitarbeiterNummerLabel = new JLabel("Mitarbeiternummer");
		textFieldPanel.add(mitarbeiterNummerLabel);
		final JTextField mitarbeiterNummerTextField = new JTextField();
		textFieldPanel.add(mitarbeiterNummerTextField);

		add(textFieldPanel);

	}

}
