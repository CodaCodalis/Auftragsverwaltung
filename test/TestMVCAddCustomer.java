import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class TestMVCAddCustomer {

    /**
     * A4.6
     */
    @Test
    void checkAddCustomerConsoleRemoved(){
        try {
            Class.forName("de.oszimt.ls11a1.view.customer.AddCustomerConsole");
            fail("Class AddCustomerConsole still exist");
        } catch (Exception ignored) {
        }
    }

    /**
     * A4.6
     */
    @Test
    void checkAddCustomerControllerRemoved(){
        try {
            Class.forName("de.oszimt.ls11a1.controller.customer.AddCustomerController");
            fail("Class AddCustomerController still exist");
        } catch (Exception ignored) {
        }
    }
}
