package examinateur;

import javax.swing.text.html.Option;

public class Main {

    public static boolean isRunning;

    public static void main(String[] args) {
        Initialize.run();
        run();
    }

    private static void run() {
        TextMenu menu = new TextMenu();

        menu.add(new OptionExamList());
        menu.add(new OptionStudentList());
        menu.add(new OptionEnlistStudent());
        menu.add(new OptionDeleteStudent());
        menu.add(new OptionTakeExam());
        menu.add(new OptionDidStudentPass());
        menu.add(new OptionShowExamsPassedByStudent());
        menu.add(new OptionStudentWithMostExamsPassed());
        menu.add(new OptionTest());

        menu.add(new OptionFinish());

        while (Main.isRunning) {
            menu.show();
            menu.doSelection();
        }
    }
}
