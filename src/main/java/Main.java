import Controller.CreditCalculatorController;
import View.ConsoleView;
public class Main {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        CreditCalculatorController controller = new CreditCalculatorController(view);
        controller.start();
    }
}
