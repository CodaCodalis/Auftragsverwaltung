/*
 * Created on 01.05.2022 by Kay Patzwald
 */
package de.oszimt.ls11a1.controller;

import de.oszimt.ls11a1.controller.address.AddAddressController;
import de.oszimt.ls11a1.controller.address.RemoveAddressController;
import de.oszimt.ls11a1.controller.customer.*;
import de.oszimt.ls11a1.controller.order.AddOrderController;
import de.oszimt.ls11a1.controller.order.RemoveOrderController;
import de.oszimt.ls11a1.helper.Log;
import de.oszimt.ls11a1.model.Model;
import de.oszimt.ls11a1.view.IMainView;

import java.util.Hashtable;

/** The MainController of the app
 * @author Kay Patzwald
 */
public class MainController {
	private Model model;
	private final IMainView mainView;
	private BaseController activeController;

	private Hashtable<String, BaseController> controllerTable;

	/** 
	 * Main Controller of the app
	 */
	public MainController(Model model, IMainView mainView) {
		this.mainView = mainView;
		this.model = model;
		init();
	}

	/**
	 * Init the controller.
	 */
	private void init() {
//		model.init();
		mainView.init(this);
		controllerTable = new Hashtable<>();
		addController(new ExitController(this));
		addController(new MainViewController(this));
		addController(new ViewCustomersController(this));
		addController(new ViewCustomerController(this));
		addController(new AddCompanyController(this));
		addController(new AddConsumerController(this));
		addController(new RemoveCustomerController(this));
		addController(new AddOrderController(this));
		addController(new RemoveOrderController(this));
		addController(new AddAddressController(this));
		addController(new RemoveAddressController(this));
		setController("viewMain");
	}

	private void addController(BaseController controller){
		controllerTable.put(controller.getId(), controller);
	}
	
	/**
	 * Neuen Controller festlegen
	 * @param controllerName, ID
	 */
	public void setController(String controllerName) {
		Log.debug("show controller "+controllerName);
		this.activeController = controllerTable.get(controllerName);
		this.activeController.initController();
	}
	
	/**
	 * Neuen Controller festlegen mit Übergabeparameter
	 * @param controllerName, ID
	 * @param data, Übergebene Daten. Müssen noch geparst werden
	 */
	public void setController(String controllerName, Object data) {
		this.activeController = controllerTable.get(controllerName);
		this.activeController.initController(data);
	}

	/**
	 * @return the dao
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @return the mainView
	 */
	public IMainView getMainView() {
		return mainView;
	}

	public BaseController getController(String id){
		if (!controllerTable.containsKey(id)){
			Log.error(new NullPointerException("controllerTable does not contain a controller with the key id"),"Null");
		}

		return controllerTable.get(id);
	}
}
