/*
 * Created on 21.05.2022 by Kay Patzwald (patzwald@oszimt.de)
 */
package de.oszimt.ls11a1.controller;

import de.oszimt.ls11a1.model.Model;
import de.oszimt.ls11a1.view.IActualView;

/**
 * @author Kay Patzwald (patzwald@oszimt.de)
 *
 */
public abstract class BaseController {

	protected MainController controller;
	protected IActualView view;
	protected final String id;
	protected String title;

	public BaseController(String id, String title, MainController controller) {
		super();
		this.controller = controller;
		this.id = id;
		this.title = title;
	}

	protected void initView(Object... data) {
		view = controller.getMainView().getView(id);
		view.init(this, data);
	}
	
	protected abstract void initController(Object... data);
	
	public MainController getMainController() {
		return controller;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Model getModel(){
		return getMainController().getModel();
	}
}