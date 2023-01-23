/*
 * Created on 21.05.2022 by Kay Patzwald (patzwald@oszimt.de)
 */
package de.oszimt.ls11a1;

import de.oszimt.ls11a1.controller.MainController;
import de.oszimt.ls11a1.model.Model;
import de.oszimt.ls11a1.view.MainConsole;

/**
 * @author Kay Patzwald (patzwald@oszimt.de)
 */
public class App {

	/**
	 * @param args, default
	 */
	public static void main(String[] args) {
		// Assemble all the pieces of the MVC
		MainConsole mainConsole = new MainConsole();
		Model model = new Model();
		new MainController(model, mainConsole);
	}
}
