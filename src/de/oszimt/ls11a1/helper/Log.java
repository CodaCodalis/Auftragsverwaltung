package de.oszimt.ls11a1.helper;

import javax.swing.*;
import java.awt.*;

/**
 * @author Steffen Trutz (trutz@oszimt.de)
 *
 */
public class Log {

    /**
     * Log messages
     * @param mess, Message
     */
    public static void debug(String mess) {
        // StackTraceElement pos = new Throwable().getStackTrace()[1];
        // System.out.printf("%s %s", pos, mess);
        // System.out.println();
    }

    /**
     * Display errors
     * @param t, Throwable
     * @param mess, Message
     */
    public static void error(Throwable t, String mess) {
        StackTraceElement pos = t.getStackTrace()[0];
        System.err.printf("%s %s", pos, mess);
        System.err.println();
        t.printStackTrace();
        EventQueue.invokeLater(() -> JOptionPane.showMessageDialog(null, t+System.getProperty("line.separator")+pos.toString(), mess, JOptionPane.ERROR_MESSAGE));
    }
}
