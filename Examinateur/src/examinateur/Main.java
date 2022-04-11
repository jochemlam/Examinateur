package examinateur;

import javax.swing.text.html.Option;

public class Main {

    public static boolean isRunning;

    public static void main(String[] args) {
        Initialize.run();
        run();
    }

    private static void run() {
        ITextMenu menu = new TextMenu();

        menu.add("1", new OptionExamList());
        menu.add("2", new OptionStudentList());
        menu.add("3", new OptionEnlistStudent());
        menu.add("4", new OptionDeleteStudent());
        menu.add("5", new OptionTakeExam());
        menu.add("6", new OptionDidStudentPass());
        menu.add("7", new OptionShowExamsPassedByStudent());
        menu.add("8", new OptionStudentWithMostExamsPassed());

        menu.add("X", new OptionFinish());

        while (Main.isRunning) {
            menu.show();
            menu.doSelection();
        }
    }
}
