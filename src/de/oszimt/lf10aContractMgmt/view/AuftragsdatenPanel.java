package de.oszimt.lf10aContractMgmt.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AuftragsdatenPanel extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	JLabel label;
	JTextField textField;

	public AuftragsdatenPanel() {

		setVisible(true);
		setLayout(createGridBagLayout());

	}

	private GridBagLayout createGridBagLayout() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();

		label = new JLabel();
		textField = new JTextField(15);

//		for (int i = 0; i < x; i++) {
//
//		}

		return gbl;
	}

}
