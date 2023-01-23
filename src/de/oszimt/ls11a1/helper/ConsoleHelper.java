package de.oszimt.ls11a1.helper;

import de.oszimt.ls11a1.controller.BaseController;

import java.util.Scanner;

public class ConsoleHelper {
    public static String input(String txt){
        System.out.printf("%s: ",txt);
        return new Scanner(System.in).nextLine();
    }
    public static int inputInt(String txt){
        System.out.printf("%s: ",txt);
        try {
            return new Scanner(System.in).nextInt();
        } catch (Throwable t){
            System.out.printf("Bitte Zahl eingeben! (%s: %s)",t.getClass().getSimpleName(), t.getLocalizedMessage());
            System.out.println();
            return inputInt(txt);
        }
    }

    public static int inputInt(String txt, int min, int max){
        int erg = inputInt(txt+" ["+min+"-"+max+"]");
        if (erg >= min && erg <= max)
            return erg;
        else {
            System.out.printf("Bitte Zahl zwischen %s und %s eingeben!",min, max);
            System.out.println();
            return inputInt(txt, min, max);
        }
    }

    public static void printController(BaseController controller, String id, int count) {
        printMenu(count, controller.getMainController().getController(id).getTitle());
    }

    public static void printMenu(int count, String txt) {
        System.out.printf("[%2s] %s",count,txt);
        System.out.println();
    }
}
