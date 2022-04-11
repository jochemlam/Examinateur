package examinateur;

// ########################################################################################################
// Creates TextMenu and stores all options in a Treemap
// To implement the Menu we are making use of the Command pattern
// To not create tight coupling we make TextMenu dependent on ITextMenu. (Liskov substitution principle)
// TextMenu is a concrete implementation of the ITextMenu interface
// ########################################################################################################

import java.util.Scanner;
import java.util.TreeMap;

// ===========================================================================================
// Interfaces for TextMenu
// This is to implement the Liskov substitution principle to make ourselves dependent on
// The interface and not the concrete implementation
// ===========================================================================================

interface ITextMenu {
    void add(String selector, ITextMenuItem menuItem);
    void show();
    void doSelection();
}

interface ITextMenuItem {
    void show(String selector);
    void execute();
}

// ==========================================================================================================
// Classes for TextMenu
// Concrete implementation of the interfaces for our project
// TODO: by using treemap the map is sorted. Sorting is alphanumerical and could be adapted
// Instead of using the TreeMap you could also opt for using the LinkedHashMap to keep order of the inserts
// ==========================================================================================================

class TextMenu implements ITextMenu {
    private TreeMap<String, ITextMenuItem> menuItems = new TreeMap<>();

    public void add(String selector, ITextMenuItem menuItem) {
        menuItems.put(selector, menuItem);
    }

    public void show() {
        for (String key : menuItems.keySet())
            menuItems.get(key).show(key);
    }

    public void doSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Please make your choice: ");

        String choice = scanner.next();
        choice = choice.toUpperCase();

        if (menuItems.containsKey(choice))
            menuItems.get(choice).execute();
        else
            System.out.println("This Key doesnt exist");
    }
}

abstract class TextMenuItem implements ITextMenuItem {
    private String title;

    public TextMenuItem(String title) {
        this.title = title;
    }

    public void pressEnterToContinue() {
        System.out.println();
        System.out.println("Klik op enter om door te gaan.");

        Scanner scanner = new Scanner(System.in);
        scanner.reset();
        scanner.nextLine();
        //scanner.close();
    }

    public void show(String selector) {
        System.out.printf("%s: %s\n", selector, this.title);
    }

    abstract public void execute();
}
