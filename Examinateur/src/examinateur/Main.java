package examinateur;

public class Main {

    public static boolean isRunning;

    public static void main(String[] args) {
        ApplicationManager.initialize();
        update();
    }

    private static void update() {
        Menu menu = new Menu();

        while (isRunning) {
            menu.showMenu();
        }
    }
}
