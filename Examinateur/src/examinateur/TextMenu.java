// Creates TextMenu and stores all options in a Treemap
// To implement the Menu we are making use of the Command pattern
// To not create tight coupling we make TextMenu dependent on ITextMenu. (Liskov substitution principle)
// TextMenu is a concrete implementation of the ITextMenu interface
// TODO: by using treemap the map is sorted. Sorting is alphanumerical and could be adapted

package examinateur;

import java.util.Scanner;
import java.util.TreeMap;

class TextMenu {
    private TreeMap<String, ITextMenuItem> menuItems = new TreeMap<>();

    public void add(ITextMenuItem menuItem) {
        menuItems.put(menuItem.getSelector(), menuItem);
    }

    public void show() {
        for (String key : menuItems.keySet())
            menuItems.get(key).show();
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

//This is to implement the Liskov substitution principle
interface ITextMenuItem {
    String getSelector();
    void show();
    void execute();
}

abstract class TextMenuItem implements ITextMenuItem {
    private String selector;
    private String title;

    public TextMenuItem(String selector, String title) {
        this.selector = selector;
        this.title = title;
    }

    public String getSelector() {
        return this.selector;
    }

    public void pressEnterToContinue() {
        System.out.println();
        System.out.println("Klik op enter om door te gaan.");

        Scanner scanner = new Scanner(System.in);
        scanner.reset();
        scanner.nextLine();
        //scanner.close();
    }

    public void show() {
        System.out.printf("%s: %s\n", this.selector, this.title);
    }

    abstract public void execute();
}
