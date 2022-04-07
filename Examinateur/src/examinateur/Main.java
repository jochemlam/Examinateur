package examinateur;

public class Main {

    public static boolean isRunning;

    public static void main(String[] args) {
        Initialize.run();
        update();
    }

    private static void update() {
        Menu menu = new Menu();

        while (isRunning) {
            menu.showMenu();
        }
    }
}
