package de.oszimt.ls11a1.view;

import de.oszimt.ls11a1.controller.BaseController;
import de.oszimt.ls11a1.controller.MainController;

import javax.swing.*;

/**
 * Interface for the start application
 */
public interface IMainView {

    /**
     * Launch the application  and apply the controller     *
     * @param controller, actual controller
     */
    public void init(MainController controller);

    /**
     * @param id of the view
     * @return Get a special view
     */
    public IActualView getView(String id);
}
