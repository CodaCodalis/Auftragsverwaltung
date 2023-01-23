/*
 * Created on 21.05.2022 by Kay Patzwald (patzwald@oszimt.de)
 */
package de.oszimt.ls11a1.controller;

/**
 * @author Kay Patzwald (patzwald@oszimt.de)
 *
 */
public class MainViewController extends BaseController {

	public MainViewController(MainController controller) {
		super("viewMain","Hauptmenü",controller);
	}

	@Override
	protected void initController(Object... data) { initView(data); }

}
